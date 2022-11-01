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

@Entity

public class Agent {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="agent_id")
    private Long id;

    @Size(min=1, max=50, message="Your name '${ValidatedValue}' must be between {min} and {max} chars long")
	@NotNull(message="Please provide your name")
	@Column(length=50, nullable = false)  
    private String firstName;

    @Size(min=1, max=50, message="Your lastname '${ValidatedValue}' must be between {min} and {max} chars long")
	@NotNull(message="Please provide your lastname")
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

}