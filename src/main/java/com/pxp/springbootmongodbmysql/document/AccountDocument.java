package com.pxp.springbootmongodbmysql.document;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import com.pxp.springbootmongodbmysql.entity.Customer;

@Document(collection = "account")
public class AccountDocument {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountid;
		
    private String accountNumber;

    private Double accountBalance;

    private String accountCurrency;
	

    private String accountType;
    
    @DBRef
    private CustomerDocument customerDocument;


	public CustomerDocument getCustomer() {
		return customerDocument;
	}


	public void setCustomer(CustomerDocument customerDocument) {
		this.customerDocument = customerDocument;
	}


	public int getAccountid() {
		return accountid;
	}


	public void setAccountid(int accountid) {
		this.accountid = accountid;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Double getAccountBalance() {
		return accountBalance;
	}


	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}


	public String getAccountCurrency() {
		return accountCurrency;
	}


	public void setAccountCurrency(String accountCurrency) {
		this.accountCurrency = accountCurrency;
	}


	public String getAccountType() {
		return accountType;
	}


	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
    
    

}
