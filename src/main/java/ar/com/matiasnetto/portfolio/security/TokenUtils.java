package ar.com.matiasnetto.portfolio.security;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TokenUtils {


    public static final String ACCESS_TOKEN_SECRET = "qwertyuiopqwertyuiopqwertyuiopasdf";
    public static final Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    @Autowired
    SecurityUserDetailsService securityUserDetailsService;

    public static String createToken(String username ) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000L;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setExpiration(expirationDate)
                .setSubject(username)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static String getUsername(String token) {
        Claims claims = Jwts.parserBuilder().setSigningKey(ACCESS_TOKEN_SECRET.getBytes()).build().parseClaimsJws(token).getBody();
        return claims.getSubject();
    }


}
