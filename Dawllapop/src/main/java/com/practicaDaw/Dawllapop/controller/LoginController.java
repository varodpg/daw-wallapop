package com.practicaDaw.Dawllapop.controller;





import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.practicaDaw.Dawllapop.Entities.User;
import com.practicaDaw.Dawllapop.security.UserComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
public class LoginController {
	
	@Autowired
	private UserComponent userComponent;
	
	private static final Logger log = LoggerFactory.getLogger(LoginController.class);

	@RequestMapping("/login")
	
		public ResponseEntity<User> logIn(){
			if (!userComponent.isLoggedUser()) {
				log.info("Not user logged");
				return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
			} else {
				User loggedUser = userComponent.getLoggedUser();
				log.info("Logged as " + loggedUser.getName());
				return new ResponseEntity<>(loggedUser, HttpStatus.OK);
			}
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
