package it.tdgroup.eroi.security;

import it.tdgroup.eroi.util.JwtUtility;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

@Component
public class JwtAuthenticationProvider implements AuthenticationProvider {

    /**
     * Log applicativo.
     */
    private Log LOG = LogFactory.getLog(JwtAuthenticationProvider.class);


    @Override
    public Authentication authenticate(final Authentication authentication) throws AuthenticationException {
        try {
            LOG.info("JwtAuthenticationProvider -- authenticate -- START -- " + authentication);

            final JwtAuthenticationToken jwtAuthToken = (JwtAuthenticationToken) authentication;
            Assert.notNull(jwtAuthToken.getJwtToken(), "Token Jwt non valorizzato");
            Assert.notNull(JwtUtility.extractCf(jwtAuthToken.getJwtToken()), "Token JWT non contiene CF utente");
            // TODO => qui é possibile recuperare l'utente chiamante e inserirlo in sessione
            Authentication auth = new JwtAuthenticationToken(jwtAuthToken.getJwtToken());

            auth.setAuthenticated(true);
            SecurityContextHolder.getContext().setAuthentication(auth);

            LOG.info("JwtAuthenticationProvider -- authenticate -- END -- " + auth);
            return auth;

        } catch (Exception ex) {
            LOG.error("Errore durante autenticazione: " + ex.getMessage(), ex);
            throw new AuthenticationServiceException("Errore durante autenticazione : " + ex.getMessage(), ex);
        }

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return true;
    }
}
