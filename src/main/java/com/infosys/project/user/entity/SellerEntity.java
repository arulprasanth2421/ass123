package com.infosys.project.user.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.infosys.project.user.dto.AddressDTO;

@Entity
@Table(name="seller")
public class SellerEntity {
	@Id
	@SequenceGenerator(name="pattern", initialValue=101, allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="pattern")
	@Column(name="SELLERID")
	private int sellerid;
	@Column(name="RESTAURANTNAME")
	private String restaurantname;
	@Column(name="EMAIL")
	private String email;
	@Column(name="PHONENUMBER")
	private String phoneNumber;
	@Column(name="PASSWORD")
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
	

}
