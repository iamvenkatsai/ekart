package com.ekart.demo.dto;

import com.ekart.demo.domain.Product;

public class ProductDTO 
  {
	
	private Integer productId ;
	private String productName;
	private Integer productPrice;
	private String productImage;
	
	public ProductDTO() {
		super();
	}
	
	public ProductDTO(ProductDTOBuilder productDTOBuilder)
	{
		this.productId=productDTOBuilder.productId;
		this.productName=productDTOBuilder.productName;
		this.productPrice=productDTOBuilder.productPrice;
		this.productImage=productDTOBuilder.productImage;
		
	}
	
	public static class ProductDTOBuilder
	{
		private Integer productId ;
		private String productName;
		private Integer productPrice;
		private String productImage;
		
		
		
		public ProductDTOBuilder() {
			super();
		}



		public ProductDTOBuilder(Product product) 
		{
			this.productId=product.getProductId();
			this.productName=product.getProductName();
			this.productPrice=product.getProductPrice();
			this.productImage=product.getProductImage();
		}
		
		
		public ProductDTOBuilder productId(Integer productId)
		{
			this.productId=productId;
			return this;
		}
		
		public ProductDTOBuilder productName(String productName)
		{
			this.productName=productName;
			return this;
		}
		
		public ProductDTOBuilder productPrice(Integer productPrice)
		{
			this.productPrice=productPrice;
			return this;
		}
		
		public ProductDTOBuilder productImage(String productImage)
		{
			this.productImage=productImage;
			return this;
		}
		
		public ProductDTO build()
		{
			return new ProductDTO(this);
		}
	}

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
	
	
}