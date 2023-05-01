package ar.com.matiasnetto.portfolio.security;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.Date;

public class TokenUtils {

    public static final String ACCESS_TOKEN_SECRET = "qwertyuiopqwertyuiopqwertyuiopasdf";
    public static final Long ACCESS_TOKEN_VALIDITY_SECONDS = 2_592_000L;

    public static String createToken(String username ) {
        long expirationTime = ACCESS_TOKEN_VALIDITY_SECONDS * 1_000L;
        Date expirationDate = new Date(System.currentTimeMillis() + expirationTime);

        return Jwts.builder()
                .setExpiration(expirationDate)
                .setSubject(username)
                .signWith(Keys.hmacShaKeyFor(ACCESS_TOKEN_SECRET.getBytes()))
                .compact();
    }

    public static UsernamePasswordAuthenticationToken getAuthentication(String token) {
        try {

            Claims claims = Jwts.parserBuilder().setSigningKey(ACCESS_TOKEN_SECRET.getBytes()).build().parseClaimsJws(token).getBody();

            String username = claims.getSubject();

            //SE puede  convertir esta clase en un servicio e injectarle el repo de user y pedir la lista de authorities , que se yo

            return new UsernamePasswordAuthenticationToken(username,null, Collections.emptyList());
        } catch (JwtException e) {
            System.out.println(e);
            return null;
        }
    }

}
