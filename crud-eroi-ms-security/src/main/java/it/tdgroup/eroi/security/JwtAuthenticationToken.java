package it.tdgroup.eroi.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;

public class JwtAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = -1949976839333453197L;
    private final String jwtToken;

    public JwtAuthenticationToken(String jwtToken) {
        super(null);
        this.jwtToken = jwtToken;
    }

    @Override
    public Object getCredentials() {

        return null;
    }

    @Override
    public Object getPrincipal() {
        return null;
    }

    public String getJwtToken() {
        return jwtToken;
    }


    @Override
    public String toString() {
        return "RestAuthenticationToken{" +
                "jwtToken='" + jwtToken + '\'' +
                '}';
    }
}
