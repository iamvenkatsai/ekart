package com.ekart.demo.dto;

import java.util.ArrayList;
import java.util.List;

import com.ekart.demo.domain.Category;
import com.ekart.demo.domain.Product;

public class CategoryDTO 
    {
	private Integer categoryId;
	
	private String categoryName;
	
	private String categoryType;
	
	private List<ProductDTO> productDTOs;
	
	public CategoryDTO() 
	{
		super();
	}

	public CategoryDTO(CategoryDTOBuilder categoryDTOBuilder) 
	{
		this.categoryId=categoryDTOBuilder.categoryId;
		this.categoryName=categoryDTOBuilder.categoryName;
		this.categoryType=categoryDTOBuilder.categoryType;
		
		this.productDTOs = new ArrayList<>();
		
		/*for(Product product :categoryDTOBuilder.getProduct())
		{
			this.productDTOs.add(new ProductDTO.ProductDTOBuilder(product.g).build());
		}
*/	}
	 
	public static class CategoryDTOBuilder
	{
	    private Integer categoryId;
		private String categoryName;
		private String categoryType;
		private List<Product> product;
		
		public CategoryDTOBuilder(Category category) 
		{
			this.categoryId=category.getCategoryId();
			this.categoryName=category.getCategoryName();
			this.categoryType=category.getCategoryType();
		}

		public CategoryDTOBuilder() {
			super();
		}
		
		
		
		public Integer getCategoryId() {
			return categoryId;
		}

		public void setCategoryId(Integer categoryId) {
			this.categoryId = categoryId;
		}

		public String getCategoryName() {
			return categoryName;
		}

		public void setCategoryName(String categoryName) {
			this.categoryName = categoryName;
		}

		public String getCategoryType() {
			return categoryType;
		}

		public void setCategoryType(String categoryType) {
			this.categoryType = categoryType;
		}

		

		public List<Product> getProduct() {
			return product;
		}

		public void setProduct(List<Product> product) {
			this.product = product;
		}

		public CategoryDTOBuilder categoryId(Integer categoryId)
		{
			this.categoryId=categoryId;
			return this;
			
		}
		
        public CategoryDTOBuilder categoryName(String categoryName)
        {
        	this.categoryName=categoryName;
        	return this;
        	
        }
		
        public CategoryDTOBuilder categoryType(String categoryType)
        {
        	this.categoryType=categoryType;
        	return this;
        }
        
        public CategoryDTO build()
        {
        	return new CategoryDTO(this);
        }
		
		
	}

	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getCategoryType() {
		return categoryType;
	}

	public void setCategoryType(String categoryType) {
		this.categoryType = categoryType;
	}
	
	
	

}
