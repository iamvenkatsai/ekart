package com.ekart.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.demo.domain.SpecialOffer;

@Repository
public interface SpecialOfferRepository extends JpaRepository<SpecialOffer, Integer>{

	SpecialOffer findBySpecialOfferId(Integer specialOfferId);
	
	
	
}
