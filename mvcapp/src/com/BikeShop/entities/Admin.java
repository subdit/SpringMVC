package com.BikeShop.entities;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table

public class Admin {

	@Id
	@Column
	private String aEmail;
	@Column
	private String aPass;
	
	@OneToMany
	private List<Products> Products;
	@OneToMany
	private List<Customer> Customer;
	
}
