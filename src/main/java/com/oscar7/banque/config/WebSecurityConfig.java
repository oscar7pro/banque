package com.oscar7.banque.config;

import com.oscar7.banque.entities.RoleEnum;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;


@Configuration
@EnableWebSecurity
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    private static final String SELECT_USERNAME_PASSWORD_ENABLED_FROM_USERS_WHERE_USERNAME = "select username,password, enabled from users where username = ?";
    private static final String QUERY = "select u.username, r.role from users u, roles r where u.username=? and u.id_user = r.id_user";
    @Autowired
    DataSource dataSource;
    private static final String ADMIN_ROLE = String.valueOf(RoleEnum.ADMIN);
    private static final String USER_ROLE = String.valueOf(RoleEnum.USER);

    //String adminRole = RoleEnum.ADMIN.name();

    UserDetailsService userDetailsService;

    @Autowired
    public WebSecurityConfig(DataSource dataSource, UserDetailsService userDetailsService) {
        this.dataSource = dataSource;
        this.userDetailsService = userDetailsService;
    }

    @Bean(name = "passWordEncoder")
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Autowired
    public void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder());

        auth.jdbcAuthentication().dataSource(dataSource).passwordEncoder(passwordEncoder())
                .usersByUsernameQuery(
                        SELECT_USERNAME_PASSWORD_ENABLED_FROM_USERS_WHERE_USERNAME
                )
                .authoritiesByUsernameQuery(QUERY);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.exceptionHandling().accessDeniedPage("/403");
        http.authorizeRequests()
                .antMatchers("/enregistrerOperation").hasAnyAuthority(ADMIN_ROLE)
                .antMatchers("/operations", "/consulterCompte").hasAnyAuthority(ADMIN_ROLE, USER_ROLE)
                .and()
                .formLogin().loginPage("/login").permitAll();
        http.csrf().disable();
    }


}
