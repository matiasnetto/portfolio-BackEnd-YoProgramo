package ar.com.matiasnetto.portfolio.security;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;

import java.util.Collection;

@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class AuthCredentialsIn {
    private String username;
    private String password;
}
