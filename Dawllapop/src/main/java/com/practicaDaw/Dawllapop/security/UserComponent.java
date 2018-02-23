package com.practicaDaw.Dawllapop.security;

import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import com.practicaDaw.Dawllapop.Entities.User;



@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class UserComponent {

	private User user;

	public User getLoggedUser() {
		return user;
	}

	public void setLoggedUser(User user, HttpSession session) {
		this.user = user;
		session.setAttribute("user", user);
		
	}

	public boolean isLoggedUser() {
		return this.user != null;
	}

}