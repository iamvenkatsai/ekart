package com.ekart.demo.controller;

import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.demo.config.RootEndPoints;
import com.ekart.demo.domain.User;
import com.ekart.demo.dto.ResponseDTO;
import com.ekart.demo.dto.UserDTO;
import com.ekart.demo.repository.UserRepository;


@RestController
public class UserController {

	public static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private UserRepository userRepository;
	

	@RequestMapping(value=RootEndPoints.GREET , method=RequestMethod.GET)
	public ResponseEntity<String> greeting(@RequestParam String name)
	{
		if(name==null)
		{
			return new ResponseEntity<String>(HttpStatus.BAD_REQUEST);

		}

		return new ResponseEntity<String>("hello "+name+"!",HttpStatus.OK);
	}

	@RequestMapping(value=RootEndPoints.USERS,method=RequestMethod.POST)
	public ResponseEntity<ResponseDTO<UserDTO>> addUser(@RequestBody UserDTO userDTO,BindingResult bindingResult)
	{
		ResponseDTO<UserDTO> response;
		LOGGER.info("Got Request"+userDTO);
		if(bindingResult.hasErrors())
		{
			response=new ResponseDTO.ResponseDTOBuilder<UserDTO>(false, new ResponseDTO.Message("Binding Failed","Invalid Request JSON \n "+bindingResult),null).build();
			return new ResponseEntity<>(response,HttpStatus.BAD_REQUEST);
		}

		User user=userRepository.findByUsername(userDTO.getUsername());

		if(user!=null)
		{
			response=new ResponseDTO.ResponseDTOBuilder<UserDTO>(false, new ResponseDTO.Message("Error", "User already exits"+userDTO.getUsername()+"with the user name"), null).build();
			return new ResponseEntity<>(response,HttpStatus.CONFLICT);
		}

		user=new User();
		user.setName(userDTO.getName());
		user.setUsername(userDTO.getUsername());
		user.setPassword(userDTO.getPassword());
		user.setPhoneNumber(userDTO.getPassword());
		user.setProfileImage(userDTO.getProfileImage());
		user.setCreatedAt(new Date());
		userRepository.save(user);

		userDTO = new UserDTO.UserDTOBuilder(user).build();

		LOGGER.info("saving user"+userDTO);

		response=new ResponseDTO.ResponseDTOBuilder<UserDTO>(true,null,userDTO).build();

		return new ResponseEntity<>(response,HttpStatus.OK);

	}
	
	@RequestMapping(value=RootEndPoints.USER,method=RequestMethod.GET)
	public ResponseEntity<ResponseDTO<UserDTO>> getUser(@PathVariable("uid") Integer uid)
			{
			
		      ResponseDTO<UserDTO> response;
		      
		      LOGGER.info("user with id : "+uid);
		      
		      User user=userRepository.findById(uid);
		      
		      LOGGER.info("found user "+user);
		      
		      if(user==null)
		      {
		    	  throw new com.ekart.demo.exception.ForbiddenException("Not found");
		      }
		      
		      LOGGER.info("Getting user response");
		      
		      UserDTO userDTO = new UserDTO.UserDTOBuilder(user).build();
		      
		      LOGGER.info("userDTO "+userDTO);
		      
		      response = new ResponseDTO.ResponseDTOBuilder<UserDTO>(true,null,userDTO).build();
		      
		      return new ResponseEntity<>(response,HttpStatus.OK);
		     
		     
			}


}
