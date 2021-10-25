package com.pxp.springbootmongodbmysql.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "account")
public class Account {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int accountid;
		
	@Column(name="accountnumber")
    private String accountNumber;
    
	@Column(name="accountbalance")
    private Double accountBalance;
	
	@Column(name="accountcurrency")
    private String accountCurrency;
	
	@Column(name="accounttype")
    private String accountType;
        
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer.custid")
    private Customer customer;
    
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

	public void setAccountBalance(double d) {
		this.accountBalance = d;
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
    

}
