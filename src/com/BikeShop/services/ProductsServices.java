package com.BikeShop.services;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;

import com.BikeShop.entities.Products;
import com.BikeShop.services.ProductsServices;



public class ProductsServices {
	
	public List<Products> getAllProducts() {
		List<Products> productsList = new ArrayList<>();

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			Query query = entityManager.createNamedQuery("getAllProducts");
			productsList = query.getResultList();
			
//			for(Products p : productsList) {
//				System.out.println(p.toString());
//			}
			
		}catch(PersistenceException e) {
			e.getMessage();
		}
		finally {
			entityManager.close();
			entityManagerFactory.close();
		}
		return productsList; 
	}
	
	
	public Products getProductsById(int pId) {
		Products product = null;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		try {
			product = entityManager.find(Products.class, pId);
		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}


		return product;
	}


	
	public Products getProductsByName(String pName) {
		Products product = null;

		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		Query query = entityManager.createNamedQuery("getProductsByName");
		query.setParameter("pName", pName);
		
				
		try {
			product = entityManager.find(Products.class, pName);
		} catch (PersistenceException e) {
			e.getMessage();
		} finally {
			entityManager.close();
			entityManagerFactory.close();
		}

		
		
		return product;
	}
	
	public boolean insertProduct(Products product) {
		boolean result = true;
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entitymanager = entityManagerFactory.createEntityManager();
		
		try {
			entitymanager.getTransaction().begin();
			entitymanager.persist(product);
			entitymanager.getTransaction().commit();
			
		} catch(PersistenceException e) {
			e.printStackTrace();
			result = false;
		}
		finally {
			entitymanager.close();
			entityManagerFactory.close();
		}
		return result;
	}
	public boolean addProducts(Products product) {
		boolean result = true;
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			// 
			entityManager.getTransaction().begin();
			entityManager.persist(product);
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		}
		entityManager.close();
		entityManagerFactory.close();
				
		return result;
	}

	//update Products here???
	public boolean updateProducts(Products product) {
		
		boolean result = true;
				
			
			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
			EntityManager entityManager = entityManagerFactory.createEntityManager();
			try {
				entityManager.getTransaction().begin();
				
				Products foundProducts = entityManager.find(Products.class, getAllProducts());
				foundProducts.setpId(product.getpId());
				foundProducts.setpName(product.getpName());
				foundProducts.setpImage(product.getpImage());
				foundProducts.setpDescription(product.getpDescription());
				foundProducts.setpPrice(product.getpPrice());
				
				entityManager.getTransaction().commit();
				
			} catch (PersistenceException e) {
				e.printStackTrace();
				result = false;
			}
			entityManager.close();
			entityManagerFactory.close();
			
			return result;
		
	}
	// Remove product
	public boolean removeProducts(int productId) {
		boolean result = true;
		
		//delete product here???
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		try {
			entityManager.getTransaction().begin();
			
			Products foundProducts = entityManager.find(Products.class, productId);
			entityManager.remove(foundProducts);
			
			entityManager.getTransaction().commit();
		} catch (PersistenceException e) {
			e.printStackTrace();
			result = false;
		}
		entityManager.close();
		entityManagerFactory.close();
		
		return result;
	}
	
}



