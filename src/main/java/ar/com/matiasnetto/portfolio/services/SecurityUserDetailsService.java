package ar.com.matiasnetto.portfolio.services;

import ar.com.matiasnetto.portfolio.models.User;
import ar.com.matiasnetto.portfolio.repository.UserRepository;
import ar.com.matiasnetto.portfolio.security.SecurityUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

    private final UserRepository repository;

    public SecurityUserDetailsService(UserRepository repository) {
        this.repository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> optUser = this.repository.findById(1);

        if (optUser.isPresent()) {
            return new SecurityUser(optUser.get());
        }

        throw new UsernameNotFoundException("User not found: " + username);
    }
}
