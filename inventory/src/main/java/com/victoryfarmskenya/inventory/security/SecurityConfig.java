package com.victoryfarmskenya.inventory.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.victoryfarmskenya.inventory.services.MyUserDetailsService;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	MyUserDetailsService myuserDetailsService;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(myuserDetailsService);
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable().authorizeRequests().antMatchers("/assets","/auth/**","/**").permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement()
		.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.cors();
	}
	@Bean
	public AuthenticationManager authmanager() throws Exception {
		return super.authenticationManagerBean();
	}
	@Bean
	public PasswordEncoder getPasswordEncoder() { 
		return NoOpPasswordEncoder.getInstance();
	}
}
