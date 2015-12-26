package com.ekart.demo.config;

public class RootEndPoints {
	//user end points
	public static final String GREET = "api/v1/greet";
	public static final String USERS="api/v1/users";
	public static final String USER="api/v1/user/{uid}";
	
	//category end points
	public static final String CATEGORYS="api/v1/category";
	public static final String CATEGORY="api/v1/category/{categoryId}";
	
	//product end points
	public static final String PRODUCTS="api/v1/products/{cid}";
	public static final String PRODUCT = "api/v1/product/{productId}";
	public static final String PRODUCTBYOID = "api/v1/product/{oid}";
	public static final String PRODUCTBYUID = "api/v1/product/{oid}";
	//order end points
	public static final String ORDERS="api/v1/order/{uid}";
	public static final String ORDER="api/v1/order/{uid}/{oid}";
}
