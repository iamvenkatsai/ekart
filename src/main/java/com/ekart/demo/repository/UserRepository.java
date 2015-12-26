package com.ekart.demo.repository;



import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.ekart.demo.domain.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	
	User findById(Integer id);
	User findByUsername(String name);
	User findByName(String name);
	
	

}
