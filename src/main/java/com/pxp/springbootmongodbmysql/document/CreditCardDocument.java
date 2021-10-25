package com.pxp.springbootmongodbmysql.document;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "creditcard")
public class CreditCardDocument {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int creditcardid;
		
    private String ccType;

    private String ccNumber;

    private Date expiryDate;
    
    @DBRef
    private CustomerDocument customerDocument;

	public int getCreditcardid() {
		return creditcardid;
	}

	public void setCreditcardid(int creditcardid) {
		this.creditcardid = creditcardid;
	}

	public String getCcType() {
		return ccType;
	}

	public void setCcType(String ccType) {
		this.ccType = ccType;
	}

	public String getCcNumber() {
		return ccNumber;
	}

	public void setCcNumber(String ccNumber) {
		this.ccNumber = ccNumber;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	public CustomerDocument getCustomerDocument() {
		return customerDocument;
	}

	public void setCustomerDocument(CustomerDocument customerDocument) {
		this.customerDocument = customerDocument;
	}
    
    

}
