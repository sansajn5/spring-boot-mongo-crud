package it.tdgroup.eroi.security;

import it.tdgroup.eroi.util.JwtUtility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class JwtAuthenticationFilter extends OncePerRequestFilter {

    private static final Log LOG = LogFactory.getLog(JwtAuthenticationFilter.class);

    public static final String AUTHORIZATION_HEADER = "Authorization";

    public static final String TOKEN_TYPE = "Bearer";


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        LOG.info("JwtAuthenticationFilter -- START");

        String jwtToken = request.getHeader(AUTHORIZATION_HEADER);
        String cf = null;
        if (!StringUtils.isEmpty(jwtToken)) {
            jwtToken = jwtToken.replace(TOKEN_TYPE, "").trim();
            try {
                cf = JwtUtility.extractCf(jwtToken);
            } catch (Exception ex) {
                LOG.error("Errore parse jwt: impossibile estrarre cf");
            }
        } else {
            cf = request.getHeader("X_rtsysid");
        }

        LOG.info("JwtToken : " + jwtToken);
        // se token valido e contiene cf utente creo Header X_RTSYSID per compatibilità
        MutableHttpServletRequest mutableRequest = new MutableHttpServletRequest(request);
        if (cf != null) {
            mutableRequest.putHeader("X_RTSYSID", cf);
            mutableRequest.putHeader("X_rtsysid", cf);
        }

        if(!StringUtils.isEmpty(request.getHeader("X_RTSYSID_APP"))) {
            mutableRequest.putHeader("X_rtsysid_app", request.getHeader("X_RTSYSID_APP"));
        }
        LOG.info("Request URI:" + request.getRequestURI());
        JwtAuthenticationToken auth = new JwtAuthenticationToken(jwtToken);
        SecurityContextHolder.getContext().setAuthentication(auth);
        LOG.info("JwtAuthenticationFilter -- END");
        filterChain.doFilter(mutableRequest, response);
    }

}
