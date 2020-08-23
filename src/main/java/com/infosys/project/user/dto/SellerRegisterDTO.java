package com.infosys.project.user.dto;

import com.infosys.project.user.entity.CustomerEntity;
import com.infosys.project.user.entity.SellerEntity;

public class SellerRegisterDTO {
	private int sellerid;
	private String restaurantname;
	private String email;
	private String phoneNumber;
	private String password;
	public int getSellerid() {
		return sellerid;
	}
	public void setSellerid(int sellerid) {
		this.sellerid = sellerid;
	}
	public String getRestaurantname() {
		return restaurantname;
	}
	public void setRestaurantname(String restaurantname) {
		this.restaurantname = restaurantname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public SellerEntity createEntity() {

		SellerEntity entity=new SellerEntity();
		entity.setSellerid(this.getSellerid());
		entity.setEmail(this.getEmail());
		entity.setRestaurantname(this.getRestaurantname());
		entity.setPhoneNumber(this.getPhoneNumber());
		entity.setPassword(this.getPassword());
		return entity;
	}
	
	

}
