package com.practicaDaw.Dawllapop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SecurityConfigurer extends WebSecurityConfigurerAdapter {

	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		// Public pages
		//http.authorizeRequests().antMatchers("/**").permitAll();

		// Public Resources
		//http.authorizeRequests().antMatchers("/css/**", "/img/**", "/js/**", "/lib/**").permitAll();

		// Private pages (all other pages)
		//http.authorizeRequests().anyRequest().authenticated();
		
       
		
		// Login form
		http.formLogin().loginPage("/login");
		http.formLogin().usernameParameter("username");
		http.formLogin().passwordParameter("password");
		http.formLogin().defaultSuccessUrl("/dashboard");
		http.formLogin().failureUrl("/loginerror");

		// Logout
		http.logout().logoutUrl("/logout");
		http.logout().logoutSuccessUrl("/");

		//Test with h2-database
		http.headers().frameOptions().disable();
		http.csrf().disable();
		// Do not redirect when logout
		http.logout().logoutSuccessHandler((rq,rs,a) -> {});
		
		 http.authorizeRequests().antMatchers("/dashboard").hasAnyRole("USER");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Database authentication provider
		auth.authenticationProvider(authenticationProvider);
	}

}
