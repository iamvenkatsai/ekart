package com.ekart.demo.dto;

import java.util.Date;

import com.ekart.demo.domain.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class UserDTO {
	
	
	private Integer id;
	private String username;
    private String name;
    private String password;
    private Long createdAt;
    private String phoneNumber;
    private String profileImage;
	
    public UserDTO() {
		super();
	}

	public UserDTO(UserDTOBuilder userDTOBuilder) {
		
		this.id=userDTOBuilder.id;
		this.name=userDTOBuilder.name;
		this.password=userDTOBuilder.password;
		this.username=userDTOBuilder.username;
		this.profileImage=userDTOBuilder.profileImage;
		this.phoneNumber=userDTOBuilder.phoneNumber;
		this.createdAt=userDTOBuilder.createdAt;
	}
    
    public static class UserDTOBuilder
    {
    	
    	private Integer id;
    	private String username;
        private String name;
        private String password;
        private Long createdAt;
        private String phoneNumber;
        private String profileImage;
		
        
        public UserDTOBuilder(User user) {
			
        	this.id=user.getId();
			this.username=user.getUsername();
			this.name=user.getName();
			this.password=user.getPassword();
			this.createdAt=(long) 11111;
			this.phoneNumber=user.getPhoneNumber();
			this.profileImage=user.getProfileImage();
			
			
		}


		public UserDTOBuilder() {
			super();
		}
		
		public UserDTOBuilder id(Integer id)
		{
			this.id=id;
			return this;
		}
		
		public UserDTOBuilder username(String username)
		{
			this.username=username;
			return this;
			
		}
		
		public UserDTOBuilder name(String name)
		{
			this.name=name;
		    return this;
		}
        
		public UserDTOBuilder password(String password)
		{
			this.password=password;
			return this;
		}
        
		public UserDTOBuilder createdAt(Long createdAt)
		{
			this.createdAt=createdAt;
			return this;
		}
		
		public UserDTOBuilder phoneNumber(String phoneNumber)
		{
			this.phoneNumber=phoneNumber;
			return this;
		}
		
		public UserDTOBuilder profileImage(String profileImage)
		{
			this.profileImage=profileImage;
			return this;
			
		}
		
		public UserDTO build()
		{
			return new UserDTO(this);
		}
		
    }

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Long createdAt) {
		this.createdAt = createdAt;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getProfileImage() {
		return profileImage;
	}

	public void setProfileImage(String profileImage) {
		this.profileImage = profileImage;
	}
    
	@Override
    public String toString() {
        try {
            return new ObjectMapper().writeValueAsString(this);
        } catch (JsonProcessingException e) {
            throw new IllegalStateException(e);
        }
    }

    

}
