package com.kovbel.agency;

import com.kovbel.agency.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    UserService userService;

    //    @Override
//    protected void configure(final AuthenticationManagerBuilder auth) throws Exception {
//
//        auth.inMemoryAuthentication()
//                .withUser("user").password(passwordEncoder().encode("mama78")).roles("USER")
//                .and()
//                .withUser("admin").password(passwordEncoder().encode("mama78")).roles("ADMIN")
//                .and()
//                .withUser("superAdmin").password(passwordEncoder().encode("mama78")).roles("SUPER_ADMIN");
//        // @formatter:on
//    }


    @Override
    protected void configure(final HttpSecurity http) throws Exception {


        http
                .authorizeRequests()
                .antMatchers("/registration").not().fullyAuthenticated()
                .antMatchers("/", "/view", "/get-country").hasAnyRole("USER", "ADMIN", "SUPER_ADMIN")
                .antMatchers("/edit", "editsave").hasAnyRole("ADMIN", "SUPER_ADMIN")
                .antMatchers("/edit", "editsave", "/form", "/admin").hasRole("ADMIN")
                .antMatchers("/login*", "/css/loginforma.css", "/registration*", "/css/registration.css").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login").permitAll()
                .loginProcessingUrl("/login")
                .defaultSuccessUrl("/", true)
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/login");


    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Autowired
    protected void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userService).passwordEncoder(bCryptPasswordEncoder());
    }
}
