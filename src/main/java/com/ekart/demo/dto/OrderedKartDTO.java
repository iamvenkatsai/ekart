package com.ekart.demo.dto;

import java.util.Date;

import com.ekart.demo.domain.Order;
import com.ekart.demo.domain.OrderedKart;
import com.ekart.demo.domain.User;

public class OrderedKartDTO {

    private Integer orderId;
	private Long dateOfOrder;
	private User userOrdered;
	private Order order;
	
	public OrderedKartDTO() {
		super();
	}

	public OrderedKartDTO(OrderedKartDTOBuilder orderedKartDTOBuilder) {
		
		super();
		this.orderId=orderedKartDTOBuilder.orderId;
		this.order=orderedKartDTOBuilder.order;
		this.userOrdered=orderedKartDTOBuilder.userOrdered;
		this.dateOfOrder=orderedKartDTOBuilder.dateOfOrder;
	}
	
	public static class OrderedKartDTOBuilder
	{
		private Integer orderId;
		private Long dateOfOrder;
		private User userOrdered;
		private Order order;
		
		public OrderedKartDTOBuilder() {
			super();
		}

		public OrderedKartDTOBuilder(OrderedKart orderedKart) {
			super();
			this.orderId=orderedKart.getOrderId();
			this.dateOfOrder=new Date().getTime();
			this.order=orderedKart.getOrder();
			this.userOrdered=orderedKart.getUserOrdered();
		}
		
		public OrderedKartDTOBuilder orderId(Integer orderId)
		{
			this.orderId=orderId;
			return this;
		}
		
		public OrderedKartDTOBuilder dateOfOrder(Long dateOfOrder)
		{
			this.dateOfOrder=dateOfOrder;
			return this;
			
		}
		
		public OrderedKartDTOBuilder userOrdered(User userOrdered)
		{
			this.userOrdered=userOrdered;
			return this;
		}
		
		public OrderedKartDTOBuilder order(Order order)
		{
			this.order=order;
			return this;
			
		}
		
		public OrderedKartDTO build()
		{
			return new OrderedKartDTO(this);
		}
		
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Long getDateOfOrder() {
		return dateOfOrder;
	}

	public void setDateOfOrder(Long dateOfOrder) {
		this.dateOfOrder = dateOfOrder;
	}

	public User getUserOrdered() {
		return userOrdered;
	}

	public void setUserOrdered(User userOrdered) {
		this.userOrdered = userOrdered;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}
	
	
}
