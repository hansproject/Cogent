package com.springboot.demo;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

	public WebSecurityConfig() {super();}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception{
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception{
//		http.antMatcher("/courses").authorizeRequests().anyRequest().permitAll();
	//	http.antMatcher("/blogs").authorizeRequests().anyRequest().permitAll();
        http.csrf().disable();
	}
}
