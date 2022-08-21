package br.edu.ifms.clientcrud.model;

import java.util.Date;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Client {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	
	@NotNull
	@Size(min = 3, message = "Your fist name needs to be between 3 and 30 characters long")
	private String firstName;
	
	@NotNull
	@Size(min = 3, message = "Your last name needs to be between 3 and 30 characters long")
	private String lastName;
	
	@Email(message = "Invalid email")
	@Size(min = 5, message = "Your email needs to be between 5 and 30 characters long")
	private String email;
	
	@Size(min = 9, max = 11 ,message = "Your phone needs to be between 9 and 11 characters long")
	private String phone;
	
	@OneToOne(cascade = CascadeType.ALL, mappedBy = "client", 
			  fetch = FetchType.EAGER)
	@Valid
	private IdentityDocument identityDocument;

	public IdentityDocument getIdentityDocument() {
		return identityDocument;
	}

	public void setIdentityDocument(IdentityDocument identityDocument) {
		this.identityDocument = identityDocument;
	}

	public Long getIdClient() {
		return idClient;
	}

	public void setIdClient(Long idClient) {
		this.idClient = idClient;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	

}
