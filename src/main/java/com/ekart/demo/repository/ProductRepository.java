package com.ekart.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.demo.domain.Category;
import com.ekart.demo.domain.Order;
import com.ekart.demo.domain.Product;
import com.ekart.demo.domain.SpecialOffer;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> 
{
	Product findByProductId(int productId);
	
	Product findByProductName(String productName);

	List<Product> findByCategory(Category category);
	
	List<Product> findByOrder(Order order);
	
	List<SpecialOffer> findBySpecialOffer(SpecialOffer specialOffer);
}
