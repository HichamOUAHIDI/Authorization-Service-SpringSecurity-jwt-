package org.sid.SecurityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter
{
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.formLogin();
        /*vous dite a spring security tien vous n'ete pas besoin d'utilisé les session 
         * dans ce cas l'authentification basé sur le token jwt */
        
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.authorizeRequests().antMatchers("/categries/**").hasAuthority("ADMIN");
        http.authorizeRequests().antMatchers("/products/***").hasAuthority("USER");
        // tt les requete nécessite une authentification 
        http.authorizeRequests().anyRequest().authenticated();
        // un filtre qui vas etre placé au premier plan 
        http.addFilterBefore(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class);
    }
}
