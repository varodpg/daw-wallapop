package controller;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;


public class CategoryController {
	
	
	
	@RequestMapping("/")
	public String index() {	
		return "index";
	}

}
