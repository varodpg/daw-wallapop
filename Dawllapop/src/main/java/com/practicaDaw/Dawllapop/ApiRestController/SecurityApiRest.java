package com.practicaDaw.Dawllapop.ApiRestController;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpMethod;
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
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/assessments/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/assessments/user/{id}/");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/users/{id}/");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/users/{id}/");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/users/");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/products/{id}/");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/products/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/offers/{id}/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/offers/user/{id}/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/offers/product/{id}/");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/offers/");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/friendRequest/accept/{id}/");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/friendRequest/refuse/{id}/");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/friendRequest/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/friendRequest/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/friends/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/dashboard/{id}/selling/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/dashboard/{id}/sold/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/dashboard/{id}/assessment/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/dashboard/{id}/withoffers/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/dashboard/{id}/buyed/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/dashboard/{id}/friendsRequests/");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/dashboard/{id}");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/dashboard/{id}");
		http.authorizeRequests().antMatchers(HttpMethod.DELETE, "/api/dashboard/{id}");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/dashboard/{id}/acceptoffer/{offer_id}");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/dashboard/{id}/canceltoffer/{offer_id}/");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/dashboard/{id}/declineFriendRequest/{friend_id}/");
		http.authorizeRequests().antMatchers(HttpMethod.PUT, "/api/dashboard/{id}/acceptFriendRequest/{friend_id}/");
		http.authorizeRequests().antMatchers(HttpMethod.GET, "/api/dashboard/{id}/getFriends/");
		http.authorizeRequests().antMatchers(HttpMethod.POST, "/api/dashboard/{id}/addAssessment/{id_to}/");
		
		
		
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
