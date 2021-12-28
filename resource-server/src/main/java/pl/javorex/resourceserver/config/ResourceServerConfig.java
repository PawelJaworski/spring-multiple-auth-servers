package pl.javorex.resourceserver.config;

import org.springframework.context.annotation.Bean;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

import static org.springframework.security.config.Customizer.withDefaults;

@EnableWebSecurity
public class ResourceServerConfig {

    @Bean
    @Order(1)
    SecurityFilterChain securityFilterChain1(HttpSecurity http) throws Exception {
        http
                .authorizeRequests(authorizeRequests ->
                        authorizeRequests
                                .mvcMatchers("/secured/**").authenticated()
                                .anyRequest().permitAll()
                ).oauth2Login();
        return http.build();
    }
}
