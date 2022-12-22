package com.example.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Customer")
public class Customer {
	@Id
	@Column(name = "Customer_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer customerID;
	
	@Column(name="Customer_Name",nullable=false)
	@Size(min = 3, max = 100)
	private String customerName;
	@Column(name="Customer_Email",nullable=false)
	@Size(min = 3, max = 100)
	private String customerEmail;
	@Column(name="Customer_Password",nullable=false)
	@Size(min = 3, max = 100)
	private String customerPassword;
	@Column(name="Customer_Address",nullable=false)
	@Size(min = 3, max = 100)
	private String customerAddress;
	@Column(name="Customer_PhoneNo",nullable=false)
	private Long customerNumber;
	
	public Customer() {
		super();
	}

	public Customer(Integer customerID, String customerName, String customerEmail, String customerPassword,String customerAddress, Long customerNumber) {
		super();
		this.customerID = customerID;
		this.customerName = customerName;
		this.customerEmail = customerEmail;
		this.customerPassword = customerPassword;
		this.customerAddress = customerAddress;
		this.customerNumber = customerNumber;
	}

	public Integer getCustomerID() {
		return customerID;
	}

	public void setCustomerID(Integer customerID) {
		this.customerID = customerID;
	}

	public String getCustomerName() {
		return customerName;
	}

	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getCustomerEmail() {
		return customerEmail;
	}

	public void setCustomerEmail(String customerEmail) {
		this.customerEmail = customerEmail;
	}

	public String getCustomerPassword() {
		return customerPassword;
	}

	public void setCustomerPassword(String customerPassword) {
		this.customerPassword = customerPassword;
	}

	public String getCustomerAddress() {
		return customerAddress;
	}

	public void setCustomerAddress(String customerAddress) {
		this.customerAddress = customerAddress;
	}

	public Long getCustomerNumber() {
		return customerNumber;
	}

	public void setCustomerNumber(Long customerNumber) {
		this.customerNumber = customerNumber;
	}
	
}
