package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.OfferEnum;
import com.practicaDaw.Dawllapop.Entities.Product;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

import javax.annotation.PostConstruct;

@Controller

public class SingleController {

	@Autowired
	private OfferRepository repository;

	@PostConstruct
	public void init() {
		OfferEnum offerEnum = null;
		Offer o = new Offer(60, "Quiero este precio", offerEnum.Acepted);
		repository.save(o);
		Offer o2 = new Offer(700, "Te ofrezco", offerEnum.Cancel);
		repository.save(o2);
		Offer o3 = new Offer(650, "toma esto, no subo mas", offerEnum.Pending);
		repository.save(o3);

	}

	@RequestMapping("/single")
	public String Categorias(Model model) {

		return "single";
	}

}
