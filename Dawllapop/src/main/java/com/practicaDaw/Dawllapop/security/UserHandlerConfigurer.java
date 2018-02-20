package com.practicaDaw.Dawllapop.security;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.practicaDaw.Dawllapop.security.UserComponent;

@Configuration
public class UserHandlerConfigurer extends WebMvcConfigurerAdapter {
	@Bean
	public UserHandlerInterceptor userHandlerInterceptor() {
		return new UserHandlerInterceptor();
	}

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(userHandlerInterceptor());
	}
}

class UserHandlerInterceptor extends HandlerInterceptorAdapter {
	@Autowired
	private UserComponent userComponent;

	@Override
	public void postHandle(final HttpServletRequest request, final HttpServletResponse response, final Object handler,
			final ModelAndView modelAndView) throws Exception {
		if (modelAndView != null) {
			if (userComponent.isLoggedUser()) {
				modelAndView.addObject("userLogged", userComponent.getLoggedUser());
			}
		}
	}
}