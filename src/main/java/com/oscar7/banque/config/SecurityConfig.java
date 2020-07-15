package com.oscar7.banque.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(AuthenticationManagerBuilder authManagerBuilder) throws Exception{
        authManagerBuilder.inMemoryAuthentication()
                .withUser("admin").password("{noop}1234").roles("ADMIN", "USER");
                authManagerBuilder.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception{
        http.formLogin().loginPage("/login");
        http.exceptionHandling().accessDeniedPage("/403");
        http.formLogin();
        http.authorizeRequests()
                .antMatchers("/operations", "/consulterCompte").hasRole("USER");
        http.authorizeRequests()
                .antMatchers("/enregistrerOperation").hasRole("ADMIN");
    }
}
