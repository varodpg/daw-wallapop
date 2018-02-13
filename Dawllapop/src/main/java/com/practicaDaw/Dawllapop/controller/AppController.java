package com.practicaDaw.Dawllapop.controller;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ej4.video2.AnunciosRepository;
import com.ej4.video2.model.Anuncio;
import com.ej4.video2.model.Comentario;

@Controller
public class AppController {
	
	//Si se abre la URL http://127.0.0.1:8080/h2-console y se configura
		//la URL JDBC con el valor jdbc:h2:mem:testdb se puede acceder a la 
		//base de datos de la aplicación
		
		@Autowired
		private ProductRepository repository;

		@PostConstruct
		public void init() {
			Producto p = new Product();
			repository.save(p);
		}
	
	
	@RequestMapping("/")
	public String index() {	
		return "index";
	}

}
