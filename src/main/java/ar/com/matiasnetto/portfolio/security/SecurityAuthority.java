package ar.com.matiasnetto.portfolio.security;

import ar.com.matiasnetto.portfolio.models.Authority;
import lombok.AllArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

@AllArgsConstructor
public class SecurityAuthority implements GrantedAuthority {
    private final Authority authority;

    @Override
    public String getAuthority() {
        return authority.getName().toString();
    }
}
