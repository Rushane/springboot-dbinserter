package com.pxp.springbootmongodbmysql.document;

import org.springframework.data.mongodb.core.mapping.Document;

import com.pxp.springbootmongodbmysql.entity.Account;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Document(collection = "customer")
public class CustomerDocument {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;
    private String firstName;
    
    private String lastName;
    
    private String email;
    
    private String phoneNumber;

	public String getCustid() {
		return id;
	}

	public void setCustid(String custid) {
		this.id = custid;
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

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
    

    
    


}
