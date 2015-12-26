package com.ekart.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="ekart_specialoffer")
public class SpecialOffer {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="special_offerid")
	private Integer specialOfferId;
	
	@OneToMany(mappedBy="order",fetch=FetchType.EAGER)
	private Product product;
	
	private float discount;

	public Integer getSpecialOfferId() {
		return specialOfferId;
	}

	public void setSpecialOfferId(Integer specialOfferId) {
		this.specialOfferId = specialOfferId;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public float getDiscount() {
		return discount;
	}

	public void setDiscount(float discount) {
		this.discount = discount;
	}
	
	
	

}
