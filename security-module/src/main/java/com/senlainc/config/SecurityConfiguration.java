package com.senlainc.config;

import com.senlainc.jwt.JwtAuthenticationEntryPoint;
import com.senlainc.jwt.filter.JwtAuthenticationFilter;
import com.senlainc.routes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.*;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@Import(AdditionalConfiguration.class)
@PropertySource("classpath:token.properties")
@ComponentScan("com.senlainc")
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Autowired
    private AuthenticationProvider authenticationProvider;

    @Autowired
    private JwtAuthenticationEntryPoint unauthorizedHandler;

    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

    @Override
    public void configure(AuthenticationManagerBuilder auth) {
        auth.authenticationProvider(authenticationProvider);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic();
        http.csrf().disable()
        .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
        http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);

        http.authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers(PrivilegeRoutes.PRIVILEGE + "/*",PrivilegeRoutes.PRIVILEGE,
                        PrivilegeRoutes.ROLE + "/*", PrivilegeRoutes.ROLE)
                    .hasAnyAuthority("create", "delete")
                .mvcMatchers(HttpMethod.POST, UserRoutes.USER).hasAuthority("create")
                .mvcMatchers(UserRoutes.USER_FRIEND).hasAnyAuthority("create", "update","delete")
                .mvcMatchers(ProductRoutes.PRODUCT + "/**")
                    .hasAnyAuthority("create", "update", "delete")
                .mvcMatchers(PostRoutes.POST + "/**").hasAnyAuthority("create","delete", "update")
                .mvcMatchers(HttpMethod.POST, PostRoutes.POST).hasAuthority("create")
                .mvcMatchers(MessageRoutes.MESSAGE, MessageRoutes.MESSAGE_BY_PARAMS)
                    .hasAnyAuthority("create", "read")
                .mvcMatchers(InviteRoutes.INVITE + "/**").hasAnyAuthority("create", "read")
                .mvcMatchers("/group/user/*").hasAnyAuthority("create", "delete")
                .mvcMatchers(GroupRoutes.GROUP, GroupRoutes.GROUP + "/**")
                    .hasAnyAuthority("delete", "update")
                .mvcMatchers(CommentRoutes.COMMENT + "/*")
                    .hasAnyAuthority("create", "delete", "update")
        .anyRequest().authenticated()
        .and()
        .logout().invalidateHttpSession(true).deleteCookies("JSESSIONID");
    }

}