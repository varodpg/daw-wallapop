package com.practicaDaw.Dawllapop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Repository.OfferRepository;;

@Service
public class OfferServices {
	@Autowired
	private OfferRepository OfferRepository;

	public List<Offer> getAllOffer() {
		return OfferRepository.findAll();
	}

}
