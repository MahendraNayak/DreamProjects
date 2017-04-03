
package com.litrum.webproject.config;

import com.litrum.webproject.redirect.SucessAuthenticationHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


@Configuration
@EnableWebSecurity
@Import(com.litrum.webproject.config.SpringSecurityInitializer.class)
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserDetailsService userDetailsService;

    @Bean
    BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    SucessAuthenticationHandler sucessAuthenticationHandler() {
        return new SucessAuthenticationHandler();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/resources/**").permitAll()
                .antMatchers("/register/**").permitAll()
                .antMatchers("/companyType/**").permitAll()
                .antMatchers("/endUserRole/list/**").permitAll()
                .antMatchers(" /**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .usernameParameter("uname")
                .passwordParameter("password")
                .loginProcessingUrl("/j_spring_security_check")
                .failureUrl("/login?login_error=t")
                .successHandler(sucessAuthenticationHandler())
                .loginPage("/")
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .deleteCookies("JSESSIONID")
                .invalidateHttpSession(true)
                .and()
                .csrf()
                .disable();
    }

    @Override
    protected void configure(final AuthenticationManagerBuilder auth)
            throws Exception {
        //TODO use bcrypt password encoder.
        auth.userDetailsService(userDetailsService);
    }
}

