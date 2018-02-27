package com.practicaDaw.Dawllapop.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.practicaDaw.Dawllapop.Entities.Assessment;
import com.practicaDaw.Dawllapop.Entities.Friend_request;
import com.practicaDaw.Dawllapop.Entities.Offer;
import com.practicaDaw.Dawllapop.Entities.User;

public interface OfferRepository extends JpaRepository<Offer,Long>{
	List<Offer> findAll();

	@Query(value = "SELECT * FROM offer WHERE SELLER_ID = :user AND OFFER_ENUM = '0'", nativeQuery = true)
	List<Offer> getOfferRequests(@Param("user") User user);

}
