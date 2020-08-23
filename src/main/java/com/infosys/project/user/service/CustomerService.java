package com.infosys.project.user.service;



import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.infosys.project.user.dto.LoginDTO;
import com.infosys.project.user.dto.LoginDTO1;
import com.infosys.project.user.dto.RegisterDTO;
import com.infosys.project.user.dto.SellerRegisterDTO;
import com.infosys.project.user.entity.CustomerEntity;
import com.infosys.project.user.entity.SellerEntity;
import com.infosys.project.user.repository.CustomerRepository;
import com.infosys.project.user.repository.SellerRepository;
import com.infosys.project.user.validator.CustomerValidator;
import com.infosys.project.user.validator.SellerValidator;

@Service
public class CustomerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CustomerRepository customerRepo;
	

	
	
	public boolean loginbymail(LoginDTO loginDTO) throws Exception {
		logger.info("Login request for customer {} with password {}", loginDTO.getEmail(), loginDTO.getPassword());
		try {
		CustomerValidator.emailid(loginDTO.getEmail());
		
		CustomerEntity customer = customerRepo.findByEmail(loginDTO.getEmail());
		
		if (customer.getPassword().equals(loginDTO.getPassword())){
			return true;
			}else {
				throw new Exception("Invalid password!");}
			}
		
		catch(Exception e) {
			throw e;
		}
		}
	
	
			
	
	public boolean loginbyphonenumber(LoginDTO1 loginDTO) throws Exception {
		logger.info("Login request for customer {} with password {}", loginDTO.getPhonenumber(), loginDTO.getPassword());
		
		try {
		CustomerValidator.number(loginDTO.getPhonenumber());
		
		CustomerEntity customer1 = customerRepo.findByphoneNumber(loginDTO.getPhonenumber());
		if (customer1.getPassword().equals(loginDTO.getPassword())) {
			
			return true;
		}else {
			throw new Exception("Invalid password!");}
		}
		catch(Exception e) {
		throw e;
	}
	}
		
	
		

	public String registerCustomer(RegisterDTO registerDTO) throws Exception {
		
		 {
		logger.info("Registration request for user {}", registerDTO);
		CustomerEntity customer=customerRepo.findByEmail(registerDTO.getEmail());
		CustomerEntity number=customerRepo.findByphoneNumber(registerDTO.getPhoneNumber());
		if(customer==null) {
			if(number==null) {
			CustomerEntity cust=registerDTO.createEntity();
			CustomerValidator.number(registerDTO.getPhoneNumber());
			CustomerValidator.emailid(registerDTO.getEmail()); 
			customerRepo.save(cust);
			return("new user new created, with id:"+ cust.getCustomerid());
		}else {
			return("PhoneNumber already present");
		}
			}
		
		else {
			return("email already present");
		}
		 }
		
}
	
	
	
	
	
	
	
	
	


	public RegisterDTO view(Integer customerid) {
		CustomerEntity customer=customerRepo.findBycustomerid(customerid);
		RegisterDTO dto=RegisterDTO.valueOf(customer);
		return dto;
		
	}




	
	}
		
	
