package com.ekart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.demo.domain.Order;

import com.ekart.demo.domain.User;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {
	
	Order findByOrderId(Integer orderId);
	
	List<Order> findByUser(User user);
	
	

}
