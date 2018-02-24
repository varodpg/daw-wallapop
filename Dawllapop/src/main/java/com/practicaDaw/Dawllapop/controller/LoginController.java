package com.practicaDaw.Dawllapop.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.CookieClearingLogoutHandler;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.security.web.authentication.rememberme.AbstractRememberMeServices;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@RequestMapping("/login")
	public String login() {
		return "login";
	}
//	@RequestMapping("/loginerror")
//	public String loginerror() {
//		return "loginerror";
//	}
	
//	@RequestMapping("/dashboard")
//	public String home(Model model, HttpServletRequest request) {
//		
//		model.addAttribute("admin", request.isUserInRole("ADMIN"));
//	
//		return "dashboard";
//	}
//	@RequestMapping("/logout")
//	public void logout (HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
//	    response.setContentType("text/html");
//	   
//	    request.getRequestDispatcher("/").include(request, response);
//	    
//	    HttpSession session=request.getSession();
//	    session.invalidate();
//	    System.out.println("cerrado sesion");
//	    String url = request.getContextPath()+ "/";
//	    response.setStatus(HttpStatus.OK.value());
//	    response.sendRedirect(url);
//	    
//	    
	    //You can redirect wherever you want, but generally it's a good practice to show login screen again.
	//}
}