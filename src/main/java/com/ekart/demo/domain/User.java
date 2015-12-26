package com.ekart.demo.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;



@Entity
@Table(name="ekart_users")
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
	
	@Id
	@Column(name="id" , nullable=false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="username",nullable=false)
	private String username;
	
	@Column(name="name",nullable=false)
	private String name;
	
	@Column(name="password",nullable=false)
	private String password;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;
	
    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "profile_image", columnDefinition = "text")
    private String profileImage;
    
    @OneToMany(mappedBy = "user", fetch = FetchType.EAGER, cascade=CascadeType.ALL)
    @JsonIgnore
    private List<Order> listOfOrders = new ArrayList<Order>();
    
    @OneToMany(mappedBy="userOrdered",cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    private List<OrderedKart> listOfOrderedKart = new ArrayList<OrderedKart>();
    
   
	public Integer getId() {
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

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
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

	public List<Order> getListOfOrders() {
		return listOfOrders;
	}

	public void setListOfOrders(List<Order> listOfOrders) {
		this.listOfOrders = listOfOrders;
	}

	
	

}
