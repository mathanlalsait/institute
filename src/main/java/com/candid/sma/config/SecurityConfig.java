package com.candid.sma.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	@Qualifier("userDetailsService")
	UserDetailsService userDetailsService;

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		System.out.println("*********** 3333 I");
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
		System.out.println("*********** 3333 II");
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		System.out.println("************ 2");
		PasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

	/**
	 * This code snippet configures that �/admin/**� page is 
	 * accessible by �ADMIN� role only and .�/user/**� is accessible by �ADMIN� & "USER" roles both.
	 * 
	 * By default it receives POST request and control finally goes from Spring Security
	 * to Controller with GET request
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		System.out.println("***************** 44444 I");
		http.authorizeRequests().antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')");

		http.formLogin().loginPage("/login").failureUrl("/login?error").defaultSuccessUrl("/admin")
				.usernameParameter("username").passwordParameter("password");

		http.logout().logoutUrl("/logout").logoutSuccessUrl("/login?logout")

				.and().csrf().and().exceptionHandling().accessDeniedPage("/403");

		http.authorizeRequests().antMatchers("/user/**").access("hasRole('ROLE_ADMIN,USER')");

		http.authorizeRequests().anyRequest().permitAll();
		
		System.out.println("******** 44444 II");

	}

}