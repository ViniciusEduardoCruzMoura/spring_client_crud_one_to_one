package br.edu.ifms.clientcrud.model;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class IdentityDocument {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idIdentityDocument;
	
	@NotNull
	@Size(min = 3, message = "Your father name needs to be between 3 and 30 characters long")
	private String fatherName;
	
	@NotNull
	@Size(min = 3, message = "Your mother name needs to be between 3 and 30 characters long")
	private String motherName;
	
	@NotNull
	@Size(min = 3, message = "Your nationality needs to be between 3 and 30 characters long")
	private String nationality;
	
	@NotNull
	@Size(min = 3, message = "Your hometown needs to be between 3 and 30 characters long")
	private String hometown;
	
	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "client_id")
	private Client client;
	
	public Long getIdIdentityDocument() {
		return idIdentityDocument;
	}

	public void setIdIdentityDocument(Long idIdentityDocument) {
		this.idIdentityDocument = idIdentityDocument;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getHometown() {
		return hometown;
	}

	public void setHometown(String hometown) {
		this.hometown = hometown;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

}
