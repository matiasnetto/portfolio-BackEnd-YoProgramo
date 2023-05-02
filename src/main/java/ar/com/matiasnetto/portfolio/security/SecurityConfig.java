package ar.com.matiasnetto.portfolio.security;

import ar.com.matiasnetto.portfolio.utils.AuthorityName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity @EnableMethodSecurity
public class SecurityConfig {

    @Autowired
    SecurityUserDetailsService secUserService;
    @Autowired
    JWTAuthorizationFilter jwtAuthorizationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http, AuthenticationManager authenticationManager) throws Exception {
        JWTAuthenticationFilter jwtAuthenticationFilter = new JWTAuthenticationFilter();

        jwtAuthenticationFilter.setAuthenticationManager(authenticationManager);
        jwtAuthenticationFilter.setFilterProcessesUrl("/api/login");

//        return http
//                .csrf().disable()
//                .httpBasic()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(jwtAuthenticationFilter)
//                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();

        return http
                .csrf().disable()
                .httpBasic()
                .and().authorizeHttpRequests()
                .requestMatchers("/api/*").permitAll()
                .requestMatchers("/api/*/*").permitAll()
                .and().build();

//        return http
//                .csrf().disable()
//                .httpBasic()
//                .and().authorizeHttpRequests()
//                .requestMatchers(HttpMethod.GET,"/api/skills").permitAll()
//                .requestMatchers(HttpMethod.GET,"/api/contacts").permitAll()
//                .requestMatchers(HttpMethod.POST,"/api/contacts").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.PUT,"/api/contacts/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.DELETE,"/api/contacts/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.POST,"/api/skills").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.PUT,"/api/skills/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.DELETE,"/api/skills/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.GET,"/api/persons/*").permitAll()
//                .requestMatchers(HttpMethod.PUT,"/api/persons/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.GET,"/api/education").permitAll()
//                .requestMatchers(HttpMethod.POST,"/api/education").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.PUT,"/api/education/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.DELETE,"/api/education/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.GET,"/api/projects").permitAll()
//                .requestMatchers(HttpMethod.POST,"/api/projects").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.PUT,"/api/projects/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.DELETE,"/api/projects/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.GET,"/api/experience").permitAll()
//                .requestMatchers(HttpMethod.POST,"/api/experience").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.PUT,"/api/experience/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.DELETE,"/api/experience/*").hasAuthority(AuthorityName.ADMIN.toString())
//                .requestMatchers(HttpMethod.POST,"/api/login").permitAll()
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .addFilter(jwtAuthenticationFilter)
//                .addFilterBefore(jwtAuthorizationFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
////        var admin = User.withUsername("admin").password(passwordEncoder().encode("123")).authorities("write").roles("ADMIN").build();
//        var manager = new InMemoryUserDetailsManager();
////        manager.
//        manager.createUser(User.withUsername("admin").password("password").authorities(AuthorityName.ADMIN.toString()).build());
//        return manager;
////        return this.secUserService;
//    }

    @Bean
    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
        return NoOpPasswordEncoder.getInstance();
    }



    @Bean
    public AuthenticationManager authenticationManager(HttpSecurity http, PasswordEncoder passwordEncoder) throws Exception {
        return http
                .getSharedObject(AuthenticationManagerBuilder.class)
                .userDetailsService(this.secUserService)
                .passwordEncoder(passwordEncoder())
                .and().build();
    }

//    @Bean
//    public WebSecurityCustomizer webSecurityCustomizer() {
//        return (web) -> web.ignoring().requestMatchers("/*").requestMatchers().;
//        return  (web) -> web.
//    }
}
