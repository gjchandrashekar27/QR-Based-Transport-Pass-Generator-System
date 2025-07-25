package com.jsp.QRT.Service;

import com.jsp.QRT.Model.User;

import jakarta.validation.Valid;

public interface UserService {

	void registerUser(@Valid User user);

	boolean existsByAadhaar(String aadhaarNumber);

	boolean existsByPhone(String phone);

	boolean existsByEmail(String email);

	User loginUser(String aadhaarNumber, String email);

}
