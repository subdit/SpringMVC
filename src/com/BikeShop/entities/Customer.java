package com.BikeShop.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table
@NamedQuery(query="select c from Customer c", name="queryAllCustomers")
public class Customer {
	
	@Id
	@Column
	private String cEmail;
	@Column
	private String cName;
	@Column
	private String cPass;
	
	
	@OneToMany
	private List<Products> cProducts;
	
	public Customer() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	public Customer(String cEmail, String cName, String cPass) {
		super();
		this.cEmail = cEmail;
		this.cName = cName;
		this.cPass = cPass;
	}


	public String getcEmail() {
		return cEmail;
	}
	public void setcEmail(String cEmail) {
		this.cEmail = cEmail;
	}
	public String getcName() {
		return cName;
	}
	public void setcName(String cName) {
		this.cName = cName;
	}
	public String getcPass() {
		return cPass;
	}
	public void setcPass(String cPass) {
		this.cPass = cPass;
	}


	public List<Products> getcProducts() {
		return cProducts;
	}


	public void setcProducts(List<Products> cProducts) {
		this.cProducts = cProducts;
	}


	@Override
	public String toString() {
		return "Customer [cEmail=" + cEmail + ", cName=" + cName + ", cPass=" + cPass + "]";
	}
	

}
