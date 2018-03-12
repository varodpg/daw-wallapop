package com.practicaDaw.Dawllapop.ApiRestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import com.practicaDaw.Dawllapop.security.UserRepositoryAuthenticationProvider;

@Configuration
@Order(1)
public class SecurityApiRest extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.antMatcher("/api/**");

		// here urls need authentication
		
		
		// urls not need authentication
		http.authorizeRequests().anyRequest().permitAll();

		// disable csrf
		http.csrf().disable();

		http.httpBasic();
		
		//do not redirect when logout
		http.logout().logoutSuccessHandler((rq, rs, a) -> {
		});

	}

	@Override
	protected void configure(AuthenticationManagerBuilder authenticationManager) throws Exception {
		authenticationManager.authenticationProvider(authenticationProvider);
	}

}
