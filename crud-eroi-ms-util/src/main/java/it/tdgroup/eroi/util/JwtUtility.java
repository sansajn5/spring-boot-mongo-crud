package it.tdgroup.eroi.util;

import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;

public class JwtUtility {

    public static final String JWT_CLAIM_CF = "USER_CF";

    public static String extractCf(String token) {
        return JwtUtility.extractClaim(token, JWT_CLAIM_CF);
    }

    public static String extractClaim(String token, String claim) {
        JwtParser parser = Jwts.parser();
        String[] tokenArray = token.split("\\.");
        return parser.parseClaimsJwt(tokenArray[0] + "." + tokenArray[1] + ".").getBody().get(claim, String.class);
    }
}
