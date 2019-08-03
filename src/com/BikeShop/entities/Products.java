package com.BikeShop.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;


@Entity
@Table
@NamedQuery (query="SELECT p FROM Products p", name="getAllProducts")
public class Products {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private int pId;
	@Column
	private String pName;
	@Column
	private String pImage;
	@Column
	private String pDescription;
	@Column
	private int pQuantity;
	@Column
	private Double pPrice;
	@Column 
	private String pOption;
	
	
	
	
	
	
	public Products() {
		super();
		// TODO Auto-generated constructor stub
	}
	

public Products(int pId, String pName) {
	super();
	this.pId = pId;
	this.pName = pName;
}

	
	public Products(String pName, String pImage, String pDescription, int pQuantity, Double pPrice,
			String pOption) {
		super();
		this.pName = pName;
		this.pImage = pImage;
		this.pDescription = pDescription;
		this.pQuantity = pQuantity;
		this.pPrice = pPrice;
		this.pOption = pOption;
	}


	public int getpId() {
		return pId;
	}
	public void setpId(int pId) {
		this.pId = pId;
	}
	public String getpName() {
		return pName;
	}
	public void setpName(String pName) {
		this.pName = pName;
	}
	public String getpImage() {
		return pImage;
	}
	public void setpImage(String pImage) {
		this.pImage = pImage;
	}
	public String getpDescription() {
		return pDescription;
	}
	public int getpQuantity() {
		return pQuantity;
	}


	public void setpQuantity(int pQuantity) {
		this.pQuantity = pQuantity;
	}
	public void setpDescription(String pDescription) {
		this.pDescription = pDescription;
	}
	public Double getpPrice() {
		return pPrice;
	}
	public void setpPrice(Double pPrice) {
		this.pPrice = pPrice;
	}
	
	
	public String getpOption() {
		return pOption;
	}


	public void setpOption(String pOption) {
		this.pOption = pOption;
	}


	@Override
	public String toString() {
		return "Products [pId=" + pId + ", pName=" + pName + ", pImage=" + pImage + ", pDescription=" + pDescription
				+ ", pQuantity=" + pQuantity + ", pPrice=" + pPrice + "]";
	}
	

	
}
