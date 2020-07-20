/*

package com.oscar7.banque.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class OLDSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    DataSource dataSource;

    @Override
    protected void configure(final AuthenticationManagerBuilder authManagerBuilder) throws Exception {
        authManagerBuilder.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select username as principal, password as cridentials, active from user where username=?")
                .authoritiesByUsernameQuery("select username as principal, role as role from user_role where username=?")
                .rolePrefix("ROLE_").passwordEncoder(new BCryptPasswordEncoder());

        */
/*authManagerBuilder.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER");
        authManagerBuilder.inMemoryAuthentication().withUser("admin").password("{noop}1234").roles("ADMIN", "USER");*//*

        authManagerBuilder.inMemoryAuthentication().withUser("user").password("{noop}1234").roles("USER")
                .and()
        .withUser("admin").password("{noop}1234").roles("ADMIN", "USER");
    }

    @Override
    protected void configure(final HttpSecurity http) throws Exception {
        http.formLogin().loginPage("/login");
        http.exceptionHandling().accessDeniedPage("/403");
       // http.formLogin();
      //  http.authorizeRequests().antMatchers("/operations", "/consulterCompte").hasRole("USER");
       // http.authorizeRequests().antMatchers("/enregistrerOperation").hasRole("ADMIN");
    }

  */
/*  @Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }*//*


}
*/
