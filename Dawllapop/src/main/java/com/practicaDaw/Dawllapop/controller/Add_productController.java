package com.practicaDaw.Dawllapop.controller;


import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.ImageManager.Image;
import com.practicaDaw.Dawllapop.Repository.ProductRepository;
import com.practicaDaw.Dawllapop.services.ProductServices;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.ui.Model;


@Controller
public class Add_productController {

	private static final Path FILES_FOLDER = Paths.get(System.getProperty("user.dir"), "ImgFiles");

	private AtomicInteger imageId = new AtomicInteger();
	private Map<String, Image> images = new ConcurrentHashMap<>();
	
	@Autowired
	private ProductServices prs;
	
	@Autowired
    private ProductRepository repository;
	
	@RequestMapping("/add_product")
	public String addProduct() {	
		return "add_product";
	}

	@RequestMapping(value = "/add-new-product",method = RequestMethod.POST)
	public String add_new_product(Model model, @RequestParam("name") String name,
			@RequestParam("description") String description, 
			@RequestParam("price") double price,
			@RequestParam("files") MultipartFile[] files){
		
		
		Product product = new Product(name, description, price);
		
		for(MultipartFile file: files) {
		String fileName = "image-" + imageId.getAndIncrement() + ".jpg";
		String imageTitle = file.getName(); //the title is the name of the uploaded image
		if (!file.isEmpty()) {
			try {

				File uploadedFile = new File(FILES_FOLDER.toFile(), fileName);
				file.transferTo(uploadedFile);

				images.put(fileName, new Image(imageTitle, fileName));
				product.addImage(fileName);
				continue;

			} catch (Exception e) {

				model.addAttribute("fileName", fileName);
				model.addAttribute("error", e.getClass().getName() + ":" + e.getMessage());

				continue;
			}
		} else {
			

			return "error file " + file.getName() + " is empty";
		}
		}

			

		product.setState("on_sale");
		repository.save(product);
		return "dashboard";
	}
	
	@RequestMapping("/edit_single_product/{id}")
	public String editSingleProduct(Model model, @PathVariable long id) {	
		Product product = prs.findOne(id);
		model.addAttribute(product);		
		return "edit_single_product";
	}
	
	@RequestMapping("/edit_product_db/{id}")
	public String editProductDb(Model model, Product product, @PathVariable long id) {
		product.setId(id);	
		repository.saveAndFlush(product);		
		return "/";
	}
	
	@RequestMapping("/deleteProduct/{id}")
	public String deleteProduct(Model model, @PathVariable long id) {
		Product product = prs.findOne(id);
		repository.delete(product);
		return "/";
	}
	
}
