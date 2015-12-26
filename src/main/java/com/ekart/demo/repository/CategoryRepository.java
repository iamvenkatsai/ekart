package com.ekart.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ekart.demo.domain.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Integer>
{

	Category findByCategoryId(Integer categoryId);
	
}
