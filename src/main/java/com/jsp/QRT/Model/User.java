package com.jsp.QRT.Model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
	
	
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;

	    @NotBlank(message = "Full name is required")
	    private String fullName;

	    @NotBlank(message = "Aadhaar number is required")
	    @Pattern(regexp = "\\d{12}", message = "Aadhaar number must be 12 digits")
	    @Column(unique = true)
	    private String aadhaarNumber;

	    @NotBlank(message = "Occupation is required")
	    private String occupation;

	    @NotBlank(message = "Email is required")
	    @Pattern(
	        regexp = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$",
	        message = "Invalid email format"
	    )
	    @Column(unique = true)
	    private String email;

	    @Pattern(
	        regexp = "\\d{10}",
	        message = "Phone number must be 10 digits"
	    )
	    private String phone;

	    @NotBlank(message = "From location is required")
	    private String fromLocation;

	    @NotBlank(message = "To location is required")
	    private String toLocation;

	    @NotBlank(message = "Pass type is required")
	    @Pattern(
	        regexp = "DAILY|WEEKLY|MONTHLY",
	        message = "Pass type must be DAILY, WEEKLY, or MONTHLY"
	    )
	    private String passType;
}
