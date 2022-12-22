package com.example.demo.model;



import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="Seller")
public class Seller {
	@Id
	@Column(name = "Seller_ID")
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator = "id_Sequence")
	@SequenceGenerator(name = "id_Sequence", sequenceName = "ID_SEQ")
	private Integer sellerID;
	
	@Column(name="Seller_Name",nullable=false)
	@Size(min = 3, max = 100)
	private String sellerName;
	@Column(name="Seller_Email",nullable=false)
	@Size(min = 3, max = 100)
	private String sellerEmail;
	@Column(name="Seller_Address",nullable=false)
	@Size(min = 3, max = 100)
	private String sellerAddress;
	@Column(name="Seller_PhoneNo",nullable=false)
	private Long sellerNumber;
	@Column(name = "Product_ID")
	private Integer productID;
	@Column(name="Product_Name")
	@Size(min = 3, max = 100)
	private String productName;
	@Column(name="Product_Description")
	@Size(min = 3, max = 100)
	private String productDescription;
	@Column(name="Product_StartBiddingAmt")
	private Double productStartamt;
	@Column(name="Product_Price")
	private Double productPrice;
	@Column(name="Product_BiddingDate")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-mm-dd")
	private Date productBiddingdate;
	@Column(name="Product_Category")
	private String productCategory;
	@Column(name="Bidded_By")
	private String biddedBy;
	
	public Seller() {
		super();
	}

	public Seller(Integer sellerID, String sellerName, String sellerEmail, String sellerAddress, Long sellerNumber,
			String productName, String productDescription, Double productStartamt, Double productPrice,
			Date productBiddingdate, String productCategory, String biddedBy) {
		super();
		this.sellerID = sellerID;
		this.sellerName = sellerName;
		this.sellerEmail = sellerEmail;
		this.sellerAddress = sellerAddress;
		this.sellerNumber = sellerNumber;
		this.productName = productName;
		this.productDescription = productDescription;
		this.productStartamt = productStartamt;
		this.productPrice = productPrice;
		this.productBiddingdate = productBiddingdate;
		this.productCategory = productCategory;
		this.biddedBy =  biddedBy;
	}

	public String getBiddedBy() {
		return biddedBy;
	}

	public void setBiddedBy(String biddedBy) {
		this.biddedBy = biddedBy;
	}

	public Integer getSellerID() {
		return sellerID;
	}

	public void setSellerID(Integer sellerID) {
		this.sellerID = sellerID;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
	}

	public String getSellerEmail() {
		return sellerEmail;
	}

	public void setSellerEmail(String sellerEmail) {
		this.sellerEmail = sellerEmail;
	}

	public String getSellerAddress() {
		return sellerAddress;
	}

	public void setSellerAddress(String sellerAddress) {
		this.sellerAddress = sellerAddress;
	}

	public Long getSellerNumber() {
		return sellerNumber;
	}

	public void setSellerNumber(Long sellerNumber) {
		this.sellerNumber = sellerNumber;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public Double getProductStartamt() {
		return productStartamt;
	}

	public void setProductStartamt(Double productStartamt) {
		this.productStartamt = productStartamt;
	}

	public Double getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(Double productPrice) {
		this.productPrice = productPrice;
	}

	public Date getProductBiddingdate() {
		return productBiddingdate;
	}

	public void setProductBiddingdate(Date productBiddingdate) {
		this.productBiddingdate = productBiddingdate;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	
	
}
