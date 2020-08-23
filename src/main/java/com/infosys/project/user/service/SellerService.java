package com.infosys.project.user.service;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.infosys.project.user.dto.LoginDTO;
import com.infosys.project.user.dto.LoginDTO1;
import com.infosys.project.user.dto.SellerRegisterDTO;
import com.infosys.project.user.entity.CustomerEntity;
import com.infosys.project.user.entity.SellerEntity;
import com.infosys.project.user.repository.SellerRepository;
import com.infosys.project.user.validator.CustomerValidator;
import com.infosys.project.user.validator.SellerValidator;

@Service
public class SellerService {
	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	SellerRepository sellerRepo;

	 public String registerSeller(SellerRegisterDTO registerDTO) throws Exception {
			
		 {
			 logger.info("Registration request for seller {}", registerDTO);
		SellerEntity seller=sellerRepo.findByEmail(registerDTO.getEmail());
		SellerEntity number=sellerRepo.findByphoneNumber(registerDTO.getPhoneNumber());
		if(seller==null) {
			if(number==null) {
			SellerEntity cust=registerDTO.createEntity();
			SellerValidator.number(registerDTO.getPhoneNumber());
			SellerValidator.emailid(registerDTO.getEmail()); 
			sellerRepo.save(cust);
			return("new user new created, with id:"+ cust.getSellerid());
		}else {
			return("PhoneNumber already present");
		}
			}
		
		else {
			return("email already present");
		}
		 }
		
}
		 public boolean sellerLoginByMail(LoginDTO loginDTO) throws Exception {
			 logger.info("Login request for seller {} with password {}", loginDTO.getEmail(), loginDTO.getPassword());
				try {
				SellerValidator.emailid(loginDTO.getEmail());
				
				SellerEntity seller = sellerRepo.findByEmail(loginDTO.getEmail());
				
				if (seller.getPassword().equals(loginDTO.getPassword())){
					return true;
					}else {
						throw new Exception("Invalid password!");}
					}
				
				catch(Exception e) {
					throw e;
				}
				}
		public boolean sellerLoginByPhonenumber(LoginDTO1 loginDTO) throws Exception {
			logger.info("Login request for seller {} with password {}", loginDTO.getPhonenumber(), loginDTO.getPassword());
			
			try {
			SellerValidator.number(loginDTO.getPhonenumber());
			
			SellerEntity seller = sellerRepo.findByphoneNumber(loginDTO.getPhonenumber());
			if (seller.getPassword().equals(loginDTO.getPassword())) {
				
				return true;
			}else {
				throw new Exception("Invalid password!");}
			}
			catch(Exception e) {
			throw e;
		}
		}
}
			
			




