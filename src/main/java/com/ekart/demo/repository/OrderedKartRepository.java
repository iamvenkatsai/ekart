package com.ekart.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.demo.domain.OrderedKart;


@Repository
public interface OrderedKartRepository extends JpaRepository<OrderedKart, Integer>{
	
	/*OrderedKart findByOrderedId(Integer orderId);
	
	List<OrderedKart> findByUser(User user);
	*/
	

}
