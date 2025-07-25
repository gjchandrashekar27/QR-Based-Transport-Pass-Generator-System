package com.jsp.QRT.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.QRT.Model.User;

public interface UserRepository  extends JpaRepository<User, Long>{

	boolean existsByAadhaarNumber(String aadhaarNumber);

	boolean existsByEmail(String email);

	boolean existsByPhone(String phone);

	User findByAadhaarNumberAndEmail(String aadhaarNumber, String email);


}
