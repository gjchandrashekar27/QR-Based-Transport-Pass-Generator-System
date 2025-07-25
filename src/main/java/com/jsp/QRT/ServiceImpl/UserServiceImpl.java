package com.jsp.QRT.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jsp.QRT.Model.User;
import com.jsp.QRT.Repository.UserRepository;
import com.jsp.QRT.Service.UserService;

import jakarta.validation.Valid;

@Service
public class UserServiceImpl  implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public void registerUser(@Valid User user) {
	    boolean existsByAadhaar = userRepository.existsByAadhaarNumber(user.getAadhaarNumber());
	    boolean existsByEmail = userRepository.existsByEmail(user.getEmail());

	    if (existsByAadhaar || existsByEmail) {
	        throw new RuntimeException("User already registered with Aadhaar or Email.");
	    }

	    
	    userRepository.save(user);
		
	}

	@Override
	public boolean existsByAadhaar(String aadhaarNumber) {
	    return userRepository.existsByAadhaarNumber(aadhaarNumber);
	}

	@Override
	public boolean existsByPhone(String phone) {
	    return userRepository.existsByPhone(phone);
	}

	@Override
	public boolean existsByEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public User loginUser(String aadhaarNumber, String email) {
	    return userRepository.findByAadhaarNumberAndEmail(aadhaarNumber, email);
	}

}
