package com.pxp.springbootmongodbmysql.entity;

import java.util.Date;

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
@Table(name = "creditcard")
public class Creditcard {
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int creditcardid;
		
	@Column(name="cctype")
    private String ccType;
    
	@Column(name="ccnumber")
    private String ccNumber;
	
	@Column(name="expirydate")
    private Date expiryDate;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer.custid")
    private Customer customer;
	
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

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
