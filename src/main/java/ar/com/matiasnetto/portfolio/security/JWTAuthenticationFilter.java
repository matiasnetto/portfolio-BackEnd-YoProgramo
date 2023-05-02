package ar.com.matiasnetto.portfolio.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class JWTAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

   @Override

   public Authentication attemptAuthentication(HttpServletRequest request,
                                               HttpServletResponse response) throws AuthenticationException {

       AuthCredentialsIn authCredentials = new AuthCredentialsIn();

        try {
            authCredentials = new ObjectMapper().readValue(request.getReader(),AuthCredentialsIn.class);
        } catch (IOException e) {
        }

       UsernamePasswordAuthenticationToken usernamePAT = new UsernamePasswordAuthenticationToken(
               authCredentials.getUsername(),
               authCredentials.getPassword(),
               Collections.emptyList())
               ;


        return getAuthenticationManager().authenticate(usernamePAT);
   }

    @Override
    protected void successfulAuthentication(HttpServletRequest request,
                                            HttpServletResponse response,
                                            FilterChain chain,
                                            Authentication authResult) throws IOException, ServletException {

       SecurityUser user = (SecurityUser) authResult.getPrincipal();

        System.out.println("AUthorities: ");
       user.getAuthorities().forEach(au -> System.out.println(au.getAuthority()));

       String bearerToken = "Bearer " +TokenUtils.createToken(user.getUsername());
       response.addHeader("Authorization", bearerToken);

        Map<String, String> res = new HashMap<>();
        res.put("token",bearerToken);

        ObjectMapper objectMapper = new ObjectMapper();

       response.getWriter().write(objectMapper.writeValueAsString(res));
    }
}
