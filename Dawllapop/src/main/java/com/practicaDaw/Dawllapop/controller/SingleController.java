package com.practicaDaw.Dawllapop.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import javax.annotation.PostConstruct;

@Controller

public class SingleController {

	
	
	@PostConstruct
	public void init() {
		

	}

	@RequestMapping("/single")
	public String Categorias(Model model) {

		return "single";
	}

}
