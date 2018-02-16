package com.practicaDaw.Dawllapop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Dashboard_publicController {
	
	
	
	@RequestMapping("/dashboard-public")
	public String dashBoardPublic() {	
		return "dashboard-public";
	}

}
