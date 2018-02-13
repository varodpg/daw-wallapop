package com.practicaDaw.Dawllapop.controller;

import com.practicaDaw.Dawllapop.Entities.Category;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Repository.CategoryRepository;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.PostConstruct;
@Controller
@RequestMapping("/single")

public class SingleController {


		@Autowired
		private OfferRepository repository;

		@PostConstruct
		public void init() {

			Offer o= new Offer(60,"Quiero este precio");
			repository.save(o);

		}




}
