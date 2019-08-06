package com.BikeShop.DAOI;

import java.util.List;

import com.BikeShop.entities.Customer;
import com.BikeShop.entities.Products;

public interface CustomerDAOI {

	List<Customer> getAllCustomers();

	Customer getCustomerByEmail(String sEmail);

	boolean validateCustomer(String email, String cPass);

	boolean registerCustomerToProducts(String sEmail, int cId);

	boolean insertCustomer(Customer customer);

	List<Products> getCustomerProducts(String sEmail);

	//boolean removeProductsFromCart(String cEmail, int pId);

	boolean removeProductsFromCart(Customer customer, int pId);


}
