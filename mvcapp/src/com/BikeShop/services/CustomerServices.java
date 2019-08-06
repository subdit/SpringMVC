package com.BikeShop.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.BikeShop.DAOI.CustomerDAOI;
import com.BikeShop.entities.Customer;
import com.BikeShop.entities.Products;

public class CustomerServices implements CustomerDAOI {


	@Override
	public List<Customer> getAllCustomers() {
		List<Customer> customerList = new ArrayList<>();

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {
			Query query = entitymanager.createNamedQuery("queryAllCustomers");
			customerList = query.getResultList();

		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}

		return customerList;
	}

	@Override
	public Customer getCustomerByEmail(String sEmail) {
		Customer customerFound = null;

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {
			customerFound = entitymanager.find(Customer.class, sEmail);
		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		return customerFound;

	}
	
	// To Validate Customer by email and cPass
	@Override
	public boolean validateCustomer(String email, String cPass) 
	{
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		
		Customer c = entityManager.find(Customer.class, email);

		entityManager.close();
		entityManagerFactory.close();
		
		
		if(c != null && cPass.equals(c.getcPass())){
			
			return true;
		}
		else
		{
			return false;
		}

	}


	@Override
	public boolean registerCustomerToProducts(String cEmail, int pId) {
		
		List<Products> productsList = null;

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {
			entitymanager.getTransaction().begin();

			Customer customerFound = entitymanager.find(Customer.class, cEmail);
			Products productsFound = entitymanager.find(Products.class, pId);
			
			List<Products> plist = customerFound.getcProducts();
			plist.add(productsFound);
			customerFound.setcProducts(plist);

			entitymanager.getTransaction().commit();

		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}

		return true;

	}
	@Override
//	public boolean removeProductsFromCart(String cEmail, int pId) {
	public boolean removeProductsFromCart(Customer customer, int pId) {
		//List<Products> productsList = null;
		boolean result = true;
		
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {
			entitymanager.getTransaction().begin();

			Customer customerFound = entitymanager.find(Customer.class, customer.getcEmail());
			Products productsFound = entitymanager.find(Products.class, pId);
			
			List<Products> plist = customerFound.getcProducts();
			
//			List<Products> clist = customer.getcProducts();
			//clist.remove(productsFound);
			
			plist.remove(productsFound);
			//clist.remove(productsFound);
			customerFound.setcProducts(plist);
			customer.setcProducts(plist);

			entitymanager.getTransaction().commit();

		} catch (PersistenceException e) {
			e.getMessage();
			result = false;
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}

		return result;

	}



	@Override
	public List<Products> getCustomerProducts(String sEmail) {

		List<Products> productsList = null;

		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();

		try {

			Customer customerFound = entitymanager.find(Customer.class, sEmail);
			productsList = customerFound.getcProducts();

			if (productsList == null) {
				System.out.println("No Products found for you ...");
			} else {
				System.out.println("#      Product NAME      NAME \n");
				for (Products c : productsList) {
					System.out.println(c.toString());
				}
			}

		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		return productsList;

	}

	@Override
	public boolean insertCustomer(Customer customer) {
		boolean result = true;
		EntityManagerFactory entitymanagerfactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entitymanager = entitymanagerfactory.createEntityManager();
		try {

			entitymanager.getTransaction().begin();
			entitymanager.persist(customer);
			entitymanager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.getMessage();
			result = false;
		} finally {
			entitymanager.close();
			entitymanagerfactory.close();
		}
		return result;
	}
}
