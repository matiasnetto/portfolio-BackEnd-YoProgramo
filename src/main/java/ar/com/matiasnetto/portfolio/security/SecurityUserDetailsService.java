package ar.com.matiasnetto.portfolio.security;

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

    @Autowired
    private UserRepository repository;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        System.out.println("SEC USER DETAILS!");
        Optional<User> optUser = this.repository.findByUsername(username);

        if (optUser.isEmpty()) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new SecurityUser(optUser.get()); }
}
