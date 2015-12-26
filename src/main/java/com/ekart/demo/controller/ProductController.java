package com.ekart.demo.controller;

import java.util.ArrayList;
import java.util.List;

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
import com.ekart.demo.domain.Order;
import com.ekart.demo.domain.Product;
import com.ekart.demo.domain.User;
import com.ekart.demo.dto.ProductDTO;
import com.ekart.demo.dto.ResponseDTO;
import com.ekart.demo.exception.NotFoundException;
import com.ekart.demo.repository.CategoryRepository;
import com.ekart.demo.repository.OrderRepository;
import com.ekart.demo.repository.ProductRepository;
import com.ekart.demo.repository.UserRepository;


@RestController
public class ProductController {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private OrderRepository orderRepository;
	
	@Autowired
	private UserRepository userRepository;

	public static final Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@RequestMapping(value=RootEndPoints.PRODUCTS,method=RequestMethod.POST)
	public ResponseEntity<ResponseDTO<ProductDTO>> createProduct(@PathVariable("categoryId") Integer categoryId,@RequestBody ProductDTO productDTO,BindingResult bindingResult)
	{
		ResponseDTO<ProductDTO> response;
		
		LOGGER.info("got product");
		
		if(categoryId==null||bindingResult==null)
		{
			response=new ResponseDTO.ResponseDTOBuilder<ProductDTO>(false, new ResponseDTO.Message("productId or binding error", "error in product or binding"), null).build();
		    return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		Category category = categoryRepository.findByCategoryId(categoryId);
		
		if(category==null)
		{
			LOGGER.info("error category not found");
			throw new NotFoundException("no category or invalid");
		}
		
		LOGGER.info("creating product");
		
	    Product product = new Product();
	    
	    product.setProductId(1000);
	    product.setProductName(productDTO.getProductName());
	    product.setProductPrice(productDTO.getProductPrice());
	    product.setProductImage(productDTO.getProductImage());
	    product.setCategory(category);
	    
	    LOGGER.info("saving product");
	    
	    product=productRepository.save(product);
	    
	     productDTO = new ProductDTO.ProductDTOBuilder(product).build();
	     
	     response = new ResponseDTO.ResponseDTOBuilder<ProductDTO>(true, new ResponseDTO.Message("success", "created product successfully"), productDTO).build();
         
	     return new ResponseEntity<>(response,HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value=RootEndPoints.PRODUCT,method=RequestMethod.GET)
	public ResponseEntity<ResponseDTO<ProductDTO>> getProduct(@PathVariable("productId") Integer productId) {
		
		ResponseDTO<ProductDTO> response;
		LOGGER.info("got productId request");
		
		if(productId==null)
		{
			response = new ResponseDTO.ResponseDTOBuilder<ProductDTO>(false, new ResponseDTO.Message("error in productId", "invalid request"), null).build();
		    return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}
		
		LOGGER.info("getting product info");
		
		Product product=productRepository.findByProductId(productId);
		
		if(product==null)
		{
			throw new NotFoundException("invalid product request or it doesn't exits");
		}
		
		ProductDTO productDTO = new ProductDTO.ProductDTOBuilder(product).build();
		
		response = new ResponseDTO.ResponseDTOBuilder<ProductDTO>(true, new ResponseDTO.Message("success", "sending product info"), productDTO).build(); 
		
		return new ResponseEntity<>(response,HttpStatus.OK);
		
	}
	
	@RequestMapping(value=RootEndPoints.PRODUCTS,method=RequestMethod.GET)
	public ResponseEntity<ResponseDTO<List<ProductDTO>>> getAllProducts(@PathVariable("cid") Integer cid)
	{
		ResponseDTO<List<ProductDTO>> response;
		
		LOGGER.info("got request for products of category "+cid);
		
		LOGGER.info("getting all products of that category \n :)");
		
		Category category = categoryRepository.findByCategoryId(cid);
		
		if(category==null)
		{
			throw new NotFoundException("invalid category or category doesn't exits");
		}
		
		List<Product> productList = productRepository.findByCategory(category);
		
		List<ProductDTO> responseList = new ArrayList<>();
		
		for(Product product : productList)
		{
			ProductDTO productDTO = new ProductDTO.ProductDTOBuilder(product).build();
			responseList.add(productDTO);		
		}
		
		LOGGER.info("got all products "+productList.size()+" of category"+category);
		
		response= new ResponseDTO.ResponseDTOBuilder<List<ProductDTO>>(true, new ResponseDTO.Message("success", " got all products"), responseList).build();
		
		return new ResponseEntity<ResponseDTO<List<ProductDTO>>>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value=RootEndPoints.PRODUCTBYOID,method=RequestMethod.GET)
	public ResponseEntity<ResponseDTO<List<ProductDTO>>> getAllProductsByoid(@PathVariable("oid") Integer oid)
	{
	
		ResponseDTO<List<ProductDTO>> response;
		
		LOGGER.info("got request for all products"+oid);
		
		Order order = orderRepository.findByOrderId(oid);
		
		if(order == null)
		{
			throw new NotFoundException("order can't be null or order doesn't exits");
		}
		
		List<Product> productList = productRepository.findByOrder(order);
		
		List<ProductDTO> responseList = new ArrayList<ProductDTO>();
		
		for(Product product : productList)
		{
			ProductDTO productDTO = new ProductDTO.ProductDTOBuilder(product).build();
			responseList.add(productDTO);
		}
		
		LOGGER.info("geting all products of order");
		
		response = new ResponseDTO.ResponseDTOBuilder<List<ProductDTO>>(true, null, responseList).build();
		
		return new ResponseEntity<>(response,HttpStatus.OK);
	}
	
	@RequestMapping(value=RootEndPoints.PRODUCTBYUID,method=RequestMethod.GET)
	public ResponseEntity<ResponseDTO<List<ProductDTO>>> getAllProductsByuid(@PathVariable("uid") Integer uid,@PathVariable("oid") Integer oid)
	{
	
	ResponseDTO<List<ProductDTO>> response;
	
	if(uid == null || oid == null)
	{
		response = new ResponseDTO.ResponseDTOBuilder<List<ProductDTO>>(false, new ResponseDTO.Message("oid can't be null", "uid can't be null"), null).build();
		return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		
	}
	
	User user = userRepository.findById(uid);
	
	if(user == null)
	{
		throw new NotFoundException("user is null or not found");
	}
	
	List<Order> orderList = orderRepository.findByUser(user);
	
	List<ProductDTO> responseList = new ArrayList<ProductDTO>();
	for(Order order : orderList)
	{
		List<Product> productList = productRepository.findByOrder(order);
		
		for(Product product : productList)
		{
			ProductDTO productDTO = new ProductDTO.ProductDTOBuilder(product).build();
			responseList.add(productDTO);
		}
	}
	
	response = new ResponseDTO.ResponseDTOBuilder<List<ProductDTO>>(true, null, responseList).build();
	
	return new ResponseEntity<>(response,HttpStatus.OK); 
	
	
	}
}
