/*
package com.oscar7.banque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sun.security.util.SecurityProperties;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class OldSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource source;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

*/
/*    @Override
    public void configure(final AuthenticationManagerBuilder authenticationManagerBuilder) throws Exception{
      *//*
*/
/*  authenticationManagerBuilder.inMemoryAuthentication().withUser("user").password(passwordEncoder().encode("{noop}password")).roles("USER");
        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource).withDefaultSchema()
                .withUser("user").password(passwordEncoder().encode("{noop}password")).roles("USER")
                .and()
                .withUser("admin").password(passwordEncoder().encode("{noop}password")).roles("USER", "ADMIN");*//*
*/
/*

        authenticationManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as cridentials, active from user where username=?")
                .authoritiesByUsernameQuery("select username as principal, role as role from user_role where username=?")
                .rolePrefix("ROLE_").passwordEncoder(passwordEncoder());
    }*//*

@Override
protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    auth.jdbcAuthentication().dataSource(source).passwordEncoder(passwordEncoder());
}

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //http.formLogin().loginPage("/login");
       // http.authorizeRequests().anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll();
        http.authorizeRequests()
                .anyRequest()
                .fullyAuthenticated()
                .and()
                
                .formLogin()
                .loginPage("/login")
                .failureUrl("/login?error")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login?logout")
                .permitAll()
                .and()
                .csrf();
        http.exceptionHandling().accessDeniedPage("/403");

        // http.authorizeRequests().antMatchers("/operations", "/consulterCompte").access(" hasRole('USER')").antMatchers("/").hasRole("ADMIN").and().formLogin();
       //http.authorizeRequests().antMatchers("/operations", "/consulterCompte").access("hasRole('USER')").antMatchers("/").hasRole("ADMIN").and().formLogin();
      // http.authorizeRequests().antMatchers("/enregistrerOperation").hasRole("ADMIN").and().formLogin();


    }

*/
/*
    @Override
    protected void configure(final AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as cridentials, active from user where username=?")
                .authoritiesByUsernameQuery("select username as principal, role as role from user_role where username=?")
                .rolePrefix("ROLE_").passwordEncoder(new BCryptPasswordEncoder());

        authManagerBuilder.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
        authManagerBuilder.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN", "USER");
        authManagerBuilder.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER")
                .and()
        .withUser("admin").password("{noop}1234").roles("ADMIN", "USER");
    }
*//*






}
*/
