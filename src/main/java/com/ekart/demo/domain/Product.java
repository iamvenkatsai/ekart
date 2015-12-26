package com.ekart.demo.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="ekart_product")
@JsonIgnoreProperties(ignoreUnknown = true)
public class Product {

	@Id
	@Column(name="product_id",nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer productId ;
	
	@Column(name="product_name",nullable=false)
	private String productName;
	
	
	@ManyToOne(optional=false)
	@JoinColumn(name="category_id")
	private Category category;
	
	@Column(name="product_price",nullable=false)
	private Integer productPrice;
	
	@Column(name="product_image",columnDefinition = "text")
	private String productImage;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="order_id")
	private Order order;
	
	@ManyToOne(optional=false)
	@JoinColumn(name="offer_id")
	private SpecialOffer specialOffer;
	
	private String deliveryTime;

	public int getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public int getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Integer productPrice) {
		this.productPrice = productPrice;
	}

	public String getProductImage() {
		return productImage;
	}

	public void setProductImage(String productImage) {
		this.productImage = productImage;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public String getDeliveryTime() {
		return deliveryTime;
	}

	public void setDeliveryTime(String deliveryTime) {
		this.deliveryTime = deliveryTime;
	}

	
	
	
}
