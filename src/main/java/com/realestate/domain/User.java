package com.realestate.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter 
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_Id")
     private Long id;

    @Size(min=1, max=50, message="Your name '${ValidatedValue}' must be between {min} and {max} chars long")
   	@NotNull(message="Please provide your name")
   	@Column(length=50, nullable = false) 
     private String firstName;

    @Size(min=1, max=50, message="Your lastName '${ValidatedValue}' must be between {min} and {max} chars long")
   	@NotNull(message="Please provide your lastName")
   	@Column(length=50, nullable = false) 
     private String lastName;

    @NotNull(message = "PhoneNumber can not be null")
    @NotBlank(message = "PhoneNumber can not be white space")
    @Size(min = 10,max = 20,message = "PhoneNumber '${validatedValue}' must be between {min} and {max} long")
    @Column(name="phoneNumber",length = 20, nullable = true)
     private String phoneNumber;

    @Email(message="Provide valid email")
	@Column(length=50,nullable = false)
     private String email;

    @Size(min=1, max=50, message="Your userName '${ValidatedValue}' must be between {min} and {max} chars long")
   	@NotNull(message="Please provide your userName")
   	@Column(length=50, nullable = false) 
     private String userName;

    @NotNull(message = "Password can not be null")
    @NotBlank(message = "Password can not be white space")
    @Size(min =4,max = 255,message = "Password '${validatedValue}' must be between {min} and {max} long")
    @Column(name="password",length = 255, nullable = false)
     private String password;


}