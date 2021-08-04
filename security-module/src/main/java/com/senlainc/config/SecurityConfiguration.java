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
        http.httpBasic()
                .and()
                .authorizeRequests()
                    .mvcMatchers(HttpMethod.POST, "/user/new").hasAuthority("create")
                    .mvcMatchers("/user/role/**").hasAuthority("update")
                    .mvcMatchers("/user/friend/*").hasAnyRole("create", "delete", "read")
                    .mvcMatchers(HttpMethod.POST, "/product/add").hasAuthority("create")
                    .mvcMatchers("/product/**").hasAnyAuthority("create", "update")
                    .mvcMatchers("/privileges").hasAnyAuthority("create", "delete")
                    .antMatchers("/post/*", "/post/category/**")
                        .hasAnyAuthority("create", "update", "delete")
                    .mvcMatchers(HttpMethod.POST, "/message/*").hasAnyAuthority("create", "read")
                    .mvcMatchers("/invite/**").hasAnyAuthority("create", "read")
                    .antMatchers("/group/*", "/group/user/**")
                        .hasAnyAuthority("create", "update", "delete")
                    .mvcMatchers("/comment/*").hasAnyAuthority("create", "update", "delete")
                .anyRequest().authenticated()
                .and().logout().invalidateHttpSession(true).deleteCookies("JSESSIONID")
                .and().csrf().disable();
    }
}