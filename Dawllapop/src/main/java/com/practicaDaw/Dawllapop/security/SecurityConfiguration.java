package com.practicaDaw.Dawllapop.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	public UserRepositoryAuthenticationProvider authenticationProvider;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Public pages
		http.authorizeRequests().antMatchers("/index").permitAll();
		http.authorizeRequests().antMatchers("/login").permitAll();
		http.authorizeRequests().antMatchers("/logout").permitAll();
		http.authorizeRequests().antMatchers("/categorias").permitAll();
		
		// Private pages (all other pages)
		http.authorizeRequests().antMatchers("/perfil").hasAnyRole("USER");
		http.authorizeRequests().antMatchers("/editarPerfil").permitAll();
		http.authorizeRequests().antMatchers("/admin").permitAll("ADMIN");
		
	}
}
