package com.practicaDaw.Dawllapop.controller;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.SearchStrategy;
import org.springframework.boot.autoconfigure.web.DefaultErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.ImageManager.Image;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;

@Controller

public class IndexController {
	// Si se abre la URL http://127.0.0.1:8080/h2-console y se configura
	// la URL JDBC con el valor jdbc:h2:mem:testdb se puede acceder a la
	// base de datos de la aplicación

	@Autowired
	private ProductRepository repository;
	@Autowired
	private ProductServices prs;

	@PostConstruct
	public void init() {
		ArrayList<String[]> especificaciones = new ArrayList<>();
		
		ArrayList<String> tags = new ArrayList<>();
		String[] a = new String[2];
		a[0] = "CPU";
		a[1] = "4,1GHZ";
		especificaciones.add(a);
		tags.add("tag1");
		ArrayList<String> images = new ArrayList();
		String img1 = "image-0.jpg";
		String img2 = "image-1.jpg";
//
		images.add(img1);
		images.add(img2);
//		
		Product p1 = new Product("Macbook Pro 2017", "Es mas rapido y potente que antes, pero mas fino y ligero que nunca. Tiene la pantalla con mas color y brillo jamas vista en un portatil Mac. Y viene con la Touch Bar.", especificaciones, tags, 300,images);
		repository.save(p1);
//		Product p2 = new Product("Escritorio", "Escritorio de mesa con gran capacidad de\r\n" + 
//				"								espacio", especificaciones, tags, 300);
//		repository.save(p2);
//		Product p3 = new Product("Escritorio Pequeño", "Escritorio de mesa para habitaciones\r\n" + 
//				"								pequeñas", especificaciones, tags, 300);
//		repository.save(p3);
//		Product p4 = new Product("Nokia 8998", "Nunca se Rompe", especificaciones, tags, 300);
//		repository.save(p4);
//		Product p5 = new Product("Mack", "es la leche", especificaciones, tags, 300);
//		repository.save(p5);
//		Product p6 = new Product("Mack", "es la leche", especificaciones, tags, 300);
//		repository.save(p6);
//		Product p7 = new Product("Mack", "es la leche", especificaciones, tags, 300);
//		repository.save(p7);
//		Product p8 = new Product("Mack", "es la leche", especificaciones, tags, 300);
//		repository.save(p8);
//		Product p9 = new Product("Mack", "es la leche", especificaciones, tags, 300);
//		repository.save(p9);
//		Product p10 = new Product("Escritorio", "Escritorio de mesa con gran capacidad de\r\n" + 
//				"								espacio", especificaciones, tags, 300);
//		repository.save(p10);
//		Product p11 = new Product("Escritorio Pequeño", "Escritorio de mesa para habitaciones\r\n" + 
//				"								pequeñas", especificaciones, tags, 300);
//		repository.save(p11);
	}

	@RequestMapping("/")
	public String Categorias(Model model) {

		List<Product> products = prs.getAllProducts();

		model.addAttribute("products", products);

		return "index";
	}

}
