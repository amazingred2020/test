package com.senlainc.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
@ComponentScan("com.senlainc")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.authorizeRequests()
                .antMatchers("/privilege/*", "/privilege", "/role/*", "/role").hasAnyAuthority("create", "delete")
                .mvcMatchers(HttpMethod.POST,"/user/new").hasAuthority("create")
                .mvcMatchers("/user/friend/add").hasAnyAuthority("create", "update")
                .mvcMatchers("/user/friend/delete").hasAuthority("delete")
                .mvcMatchers("/product", "/product/*").hasAnyAuthority("create", "update", "delete")
                .mvcMatchers("/post/**").hasAnyAuthority("create","delete", "update")
                .mvcMatchers(HttpMethod.POST,"/post").hasAuthority("create")
                .mvcMatchers("/message", "/message/*").hasAnyAuthority("create", "read")
                .mvcMatchers("/invite/**").hasAnyAuthority("create", "read")
                .mvcMatchers("/group/user/*").hasAnyAuthority("create", "delete")
                .mvcMatchers("/group","/group/*").hasAnyAuthority("delete", "update")
                .mvcMatchers("/comment/*").hasAnyAuthority("create", "delete", "update")
        .anyRequest().authenticated()
        .and()
        .logout().invalidateHttpSession(true).deleteCookies("JSESSIONID")
        .and().csrf().disable();
    }
}