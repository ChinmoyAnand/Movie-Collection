package com.collection.movie;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
            .passwordEncoder(new BCryptPasswordEncoder())
                .withUser("user")
                .password("$2a$10$QL9CQQtphqHImK4PWT23Nu5Khi8T.svYQI1cfPwKt0z511gEAq28C")
                .roles("USER")
            .and()
                .withUser("admin")
                .password("$2a$10$BxUaNWDQpCEjOZlsNFunaubIqXwzheU3yHmSkdnjtXRqDlbrhW1AK")
                .roles("ADMIN")
            ;
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
//    	http.authorizeRequests()
//		.antMatchers("/").permitAll()
//		.antMatchers("/addup").hasAnyRole("USER", "ADMIN")
//		.antMatchers("/edit/*", "/delete/*").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.httpBasic()
//		.and()
//		.exceptionHandling().accessDeniedPage("/403");
    	
    	http.authorizeRequests()
        .anyRequest().authenticated()
        .and()
        .httpBasic();
    }  

}
