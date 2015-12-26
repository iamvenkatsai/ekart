package com.ekart.demo.controller;

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
import com.ekart.demo.domain.Category;
import com.ekart.demo.dto.CategoryDTO;
import com.ekart.demo.dto.ResponseDTO;
import com.ekart.demo.exception.NotFoundException;
import com.ekart.demo.repository.CategoryRepository;

@RestController
public class CategoryController {

	public static final Logger LOGGER = LoggerFactory.getLogger(Category.class);
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@RequestMapping(value=RootEndPoints.CATEGORYS,method=RequestMethod.POST)
	public ResponseEntity<ResponseDTO<CategoryDTO>> createCategory(@RequestBody CategoryDTO categoryDTO,BindingResult bindingResult)
	{
		ResponseDTO<CategoryDTO> response;
		
		LOGGER.info("got product request"+categoryDTO);
		
		if(bindingResult.hasErrors())
		{
		response=new ResponseDTO.ResponseDTOBuilder<CategoryDTO>(false, new ResponseDTO.Message("error in bindng","Invalid request"+bindingResult), null)
				.build();
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		LOGGER.info("creating category");
		
		Category category = new Category();
		
		category.setCategoryName(categoryDTO.getCategoryName());
		category.setCategoryType(categoryDTO.getCategoryType());
		
		category=categoryRepository.save(category);
		
		categoryDTO=new CategoryDTO.CategoryDTOBuilder(category).build();
		
		response=new ResponseDTO.ResponseDTOBuilder<CategoryDTO>(true, null, categoryDTO).build();
		
		return new ResponseEntity<>(response,HttpStatus.CREATED);
	}
	
    @RequestMapping(value=RootEndPoints.CATEGORY,method=RequestMethod.GET )
	public ResponseEntity<ResponseDTO<CategoryDTO>> getCategoryDetails(@PathVariable("categoryId") Integer categoryId)
	{
		
    	ResponseDTO<CategoryDTO> response;
    	
    	LOGGER.info("got category id : "+categoryId);
    	
    	if(categoryId==null)
    	{
    	 response=new ResponseDTO.ResponseDTOBuilder<CategoryDTO>(false, new ResponseDTO.Message("Invalid Request","categoryId cannot be null"+categoryId), null).build();	
         return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);    	
    	}
    	
    	LOGGER.info("getting category ");
    	
    	Category category = categoryRepository.findByCategoryId(categoryId);
    	
    	if(category==null)
    	{
    		LOGGER.info("category is empty");
    		throw new NotFoundException("category is null");
    	}
    	
    	CategoryDTO categoryDTO = new CategoryDTO.CategoryDTOBuilder(category).build();
    	
    	response = new ResponseDTO.ResponseDTOBuilder<CategoryDTO>(true,new ResponseDTO.Message("got category", "about to print"),categoryDTO).build();
	
	    return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
}
