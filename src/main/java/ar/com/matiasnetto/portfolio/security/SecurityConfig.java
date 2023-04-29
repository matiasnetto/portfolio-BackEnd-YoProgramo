package ar.com.matiasnetto.portfolio.security;

import ar.com.matiasnetto.portfolio.services.SecurityUserDetailsService;
import ar.com.matiasnetto.portfolio.utils.AuthorityName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity @EnableMethodSecurity
public class SecurityConfig {

    SecurityUserDetailsService secUserService;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http
                .httpBasic()
                .and().authorizeHttpRequests()
                .requestMatchers(HttpMethod.GET,"/api/skills").permitAll()
                .requestMatchers(HttpMethod.GET,"/api/contacts").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/contacts").hasAuthority(AuthorityName.ADMIN.toString())
                .requestMatchers(HttpMethod.PUT,"/api/contacts/*").hasAuthority(AuthorityName.ADMIN.toString())
                .requestMatchers(HttpMethod.DELETE,"/api/contacts/*").hasAuthority(AuthorityName.ADMIN.toString())
                .requestMatchers(HttpMethod.POST,"/api/skills").hasAuthority(AuthorityName.ADMIN.toString())
                .requestMatchers(HttpMethod.PUT,"/api/skills/*").hasAuthority(AuthorityName.ADMIN.toString())
                .requestMatchers(HttpMethod.DELETE,"/api/skills/*").hasAuthority(AuthorityName.ADMIN.toString())
                .requestMatchers(HttpMethod.GET,"/api/persons/*").permitAll()
                .requestMatchers(HttpMethod.PUT,"/api/persons/*").hasAuthority(AuthorityName.ADMIN.toString())
                .requestMatchers(HttpMethod.GET,"/api/education").permitAll()
                .requestMatchers(HttpMethod.POST,"/api/education").hasAuthority(AuthorityName.ADMIN.toString())
                .requestMatchers(HttpMethod.PUT,"/api/education/*").hasAuthority(AuthorityName.ADMIN.toString())
                .requestMatchers(HttpMethod.DELETE,"/api/education/*").hasAuthority(AuthorityName.ADMIN.toString())
                .and().csrf().disable().build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
////        var admin = User.withUsername("admin").password(passwordEncoder().encode("123")).authorities("write").roles("ADMIN").build();
////        var result = new InMemoryUserDetailsManager();
////        result.createUser(admin);
//        return this.secUserService.loadUserByUsername("anshe");
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return NoOpPasswordEncoder.getInstance();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/*").requestMatchers().;
//        return  (web) -> web.
//    }
}
