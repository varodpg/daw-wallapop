package com.practicaDaw.Dawllapop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Offer;

public interface OfferRepository extends JpaRepository<Offer,Long>{
	List<Offer> findAll();
}
