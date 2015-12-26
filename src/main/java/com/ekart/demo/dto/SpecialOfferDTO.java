package com.ekart.demo.dto;

import com.ekart.demo.domain.Product;
import com.ekart.demo.domain.SpecialOffer;

public class SpecialOfferDTO {

	private Integer specialOfferId;
	private Product product;
	private float discount;
	
	public SpecialOfferDTO() {
		super();
	}

	public SpecialOfferDTO(SpecialDTOBuilder specialDTOBuilder) {
		super();
		this.specialOfferId=specialDTOBuilder.specialOfferId;
		this.product=specialDTOBuilder.product;
		this.discount=specialDTOBuilder.discount;
	}
	
	public static class SpecialDTOBuilder {
		
		private Integer specialOfferId;
		private Product product;
		private float discount;
		
		public SpecialDTOBuilder() {
			super();
		}

		public SpecialDTOBuilder(SpecialOffer specialOffer) {
			super();
			this.specialOfferId=specialOffer.getSpecialOfferId();
			this.product=specialOffer.getProduct();
			this.discount=specialOffer.getDiscount();
		}
		
		public SpecialDTOBuilder specialOfferId(Integer specialOfferId)
		{
			this.specialOfferId=specialOfferId;
			return this;
		}
		
		public SpecialDTOBuilder product(Product product)
		{
			this.product=product;
			return this;
		}
		
		public SpecialDTOBuilder discount(float discount)
		{
			this.discount=discount;
			return this;
		}
		
		public SpecialOfferDTO build()
		{
			return new SpecialOfferDTO(this);
		}
	}

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
