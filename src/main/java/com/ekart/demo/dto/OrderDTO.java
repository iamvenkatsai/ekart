package com.ekart.demo.dto;

import java.util.Date;
import java.util.List;

import com.ekart.demo.domain.Order;
import com.ekart.demo.domain.OrderedKart;
import com.ekart.demo.domain.Product;
import com.ekart.demo.domain.User;

public class OrderDTO {

	private Integer orderId;
	private Long orderDate;
	private List<Product> listOfProducts;
	private User user;
    private OrderedKart orderedKart;
	private Boolean isDelivered;
	private Integer deliveryDate;
	
	public OrderDTO() {
		super();
	}
	
	public OrderDTO(OrderDTOBuilder orderDTOBuilder)
	{
		this.orderId=orderDTOBuilder.orderId;
		this.deliveryDate=orderDTOBuilder.deliveryDate;
		this.isDelivered=orderDTOBuilder.isDelivered;
		this.listOfProducts=orderDTOBuilder.listOfProducts;
		this.orderedKart=orderDTOBuilder.orderedKart;
		this.orderDate=orderDTOBuilder.orderDate;
		this.user=orderDTOBuilder.user;
	}
	
public static class OrderDTOBuilder
{
	private Integer orderId;
	private Long orderDate;
	private List<Product> listOfProducts;
	private User user;
    private OrderedKart orderedKart;
	private Boolean isDelivered;
	private Integer deliveryDate;
	
	public OrderDTOBuilder() {
		super();
	}

	@SuppressWarnings("deprecation")
	public OrderDTOBuilder(Order order) {
		super();
		
		this.orderId=order.getOrderId();
		this.user=order.getUser();
		this.orderDate=new Date().getTime();
		this.isDelivered=order.getIsDelivered();
		this.deliveryDate= new Date().getDay()+2;
		this.listOfProducts=order.getListOfProducts();
		this.orderedKart=order.getOrderedKart();
		
	}
	
	public OrderDTOBuilder orderId(Integer orderId)
	{
		this.orderId=orderId;
		return this;
	}
	
	public OrderDTOBuilder orderDate(Long orderDate)
	{
		this.orderDate=orderDate;
		return this;
	}
	
	public OrderDTOBuilder user(User user)
	{
		this.user=user;
		return this;
	}
	
	public OrderDTOBuilder isDelivered(Boolean isDelivered)
	{
		this.isDelivered=isDelivered;
		return this;
		
	}
	
	public OrderDTOBuilder deliveryDate(Integer deliveryDate)
	{
		this.deliveryDate=deliveryDate;
		return this;
	}
	
	public OrderDTOBuilder orderedKart(OrderedKart orderedKart)
	{
		this.orderedKart=orderedKart;
		return this;
	}
	
	public OrderDTOBuilder listOfProducts(List<Product> listOfProducts)
	{
		this.listOfProducts=listOfProducts;
		return this;
	}
	
	public OrderDTO build()
	{
		return new OrderDTO(this);
	}
	
}

public Integer getOrderId() {
	return orderId;
}

public void setOrderId(Integer orderId) {
	this.orderId = orderId;
}

public Long getOrderDate() {
	return orderDate;
}

public void setOrderDate(Long orderDate) {
	this.orderDate = orderDate;
}

public List<Product> getListOfProducts() {
	return listOfProducts;
}

public void setListOfProducts(List<Product> listOfProducts) {
	this.listOfProducts = listOfProducts;
}

public User getUser() {
	return user;
}

public void setUser(User user) {
	this.user = user;
}

public OrderedKart getOrderedKart() {
	return orderedKart;
}

public void setOrderedKart(OrderedKart orderedKart) {
	this.orderedKart = orderedKart;
}

public Boolean getIsDelivered() {
	return isDelivered;
}

public void setIsDelivered(Boolean isDelivered) {
	this.isDelivered = isDelivered;
}

public Integer getDeliveryDate() {
	return deliveryDate;
}

public void setDeliveryDate(Integer deliveryDate) {
	this.deliveryDate = deliveryDate;
}


}