package com.cg.configurations;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
	@Override
	protected void configure(HttpSecurity http) throws Exception
	{

		http.authorizeRequests().antMatchers("/Role/**").hasAuthority("ADMIN").antMatchers("/cart/**")
				.hasAuthority("USER").antMatchers("/**").permitAll().anyRequest().authenticated().and().formLogin()
				.loginPage("/login").failureUrl("/login?error=true").defaultSuccessUrl("/")
				.usernameParameter("username").passwordParameter("password").and().exceptionHandling()
				.accessDeniedPage("/access-denied");
	}
}
