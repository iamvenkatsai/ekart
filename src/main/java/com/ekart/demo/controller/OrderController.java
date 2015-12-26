package com.ekart.demo.controller;

import java.util.Date;

import org.joda.time.LocalDate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.demo.config.RootEndPoints;
import com.ekart.demo.domain.Order;
import com.ekart.demo.domain.User;
import com.ekart.demo.dto.OrderDTO;
import com.ekart.demo.dto.ResponseDTO;
import com.ekart.demo.exception.NotFoundException;
import com.ekart.demo.repository.OrderRepository;
import com.ekart.demo.repository.UserRepository;

@RestController
public class OrderController {

	@Autowired
	private OrderRepository orderRepository;
	
	private UserRepository userRepository;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(OrderController.class);
	
	@RequestMapping(value=RootEndPoints.ORDERS,method=RequestMethod.POST)
	public ResponseEntity<ResponseDTO<OrderDTO>> createOrder(@PathVariable("uid") Integer uid,@RequestBody OrderDTO orderDTO,BindingResult bindingResult)
	{
		ResponseDTO<OrderDTO> response ;
		
		LOGGER.info("got order dto request");
		
		if(uid==null || bindingResult.hasErrors())
		{
			response = new ResponseDTO.ResponseDTOBuilder<OrderDTO>(false, new ResponseDTO.Message("error in request", "user id or orderdto error"), null).build();
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		LOGGER.info("getting user");
		
		User user = userRepository.findById(uid);
		
		if(user==null)
		{
			LOGGER.info("user is null or not found");
			throw new NotFoundException("user is null ");
		}
		
		LOGGER.info("creating new order");
		
		Order order = new Order();
		
		Date deliveryDate=(new LocalDate()).plusDays(2).toDate();
		
		order.setOrderDate(new Date());
		order.setDeliveryDate(deliveryDate);
		order.setUser(user);
		order.setListOfProducts(orderDTO.getListOfProducts());
		order.setIsDelivered(false);
		
		order=orderRepository.save(order);
		
		orderDTO = new OrderDTO.OrderDTOBuilder(order).build();
		
		response = new ResponseDTO.ResponseDTOBuilder<OrderDTO>(true, null, orderDTO).build();
				
		return new ResponseEntity<>(response,HttpStatus.CREATED);
		
		
	}
@RequestMapping(value=RootEndPoints.ORDER,method=RequestMethod.GET)
public ResponseEntity<ResponseDTO<OrderDTO>> getOrder(@PathVariable("oid") Integer oid)
{
	ResponseDTO<OrderDTO> response;
	
	LOGGER.info("got request "+oid);
	if(oid==null)
	{
		response = new ResponseDTO.ResponseDTOBuilder<OrderDTO>(true, new ResponseDTO.Message("error in oid", "oid can't be null"), null).build();
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
	}
	
	LOGGER.info("getting order details");
	
	Order order = orderRepository.findByOrderId(oid);
	
	if(order==null)
	{
		throw new NotFoundException("order not found");
	}
	
	OrderDTO orderDTO = new OrderDTO.OrderDTOBuilder(order).build();
	
	response = new ResponseDTO.ResponseDTOBuilder<OrderDTO>(true, null, orderDTO).build();
	
	return new ResponseEntity<>(response,HttpStatus.OK);
	
	
	
	/* check for git*/
}


	
}
