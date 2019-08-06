package com.BikeShop.main;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.BikeShop.services.ProductsServices;
import com.BikeShop.services.CustomerServices;
import com.BikeShop.entities.Customer;
import com.BikeShop.entities.Products;


public class BikeShopApp {
	

	
	
	
	static Scanner reader = new Scanner(System.in);
	static CustomerServices customerServices = new CustomerServices();
	static ProductsServices productsServices = new ProductsServices();

	
	public static void main(String[] args) {
		
	//public Products(int pId, String pName, String string, String pDescription, Double pPrice)	
		
//		System.out.println("--- addProducts() ---");
//		Products Products1 = new Products(4, "Kid's Bike");
//		addProducts(Products1);
//		addProducts(new Products());
//		addProducts(new Products(1, "Road Bike"));
//		addProducts(new Products(2, "Mountain Bike"));
//		addProducts(new Products(3, "Hybrid Bike"));
//		System.out.println("----------------------------\n");



//		System.out.println("--- addCustomer() ---");
//		List<Products> cProducts = new ArrayList<>();
//
//		Customer Customer1 = new Customer("a", "Customer1", "a");
//
//		addCustomer(Customer1);
//		addCustomer(new Customer("sbowden1@yellowbook.com", "Sonnnie Bowden", "SJc4aWSU"));
//		addCustomer(new Customer("qllorens2@howstuffworks.com", "Quillan Llorens", "W6rJuxd"));
//		addCustomer(new Customer("cstartin3@flickr.com", "Clem Startin", "XYHzJ1S"));
//		addCustomer(new Customer("tattwool4@biglobe.ne.jp", "Thornie Attwool", "Hjt0SoVmuBz"));
//		addCustomer(new Customer("hguerre5@deviantart.com", "Harcourt Guerre", "OzcxzD1PGs"));
//		addCustomer(new Customer("htaffley6@columbia.edu", "Holmes Taffley", "xowtOQ"));
//		addCustomer(new Customer("aiannitti7@is.gd", "Alexandra Iannitti", "TWP4hf5j"));
//		addCustomer(new Customer("ljiroudek8@sitemeter.com", "Laryssa Jiroudek", "bXRoLUP"));
//		addCustomer(new Customer("cjaulme9@bing.com", "Cahra Jaulme", "FnVklVgC6r6"));
//		System.out.println("----------------------------\n");
		
		
		
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
		EntityManager entityManager = entityManagerFactory.createEntityManager();
		
		entityManager.close();
		entityManagerFactory.close();
		
		
//			int choice = 0;
//			
//			while (choice != 2) {
//				System.out.println("\nWelcome to BikeShop");
//				System.out.println("\nHow can I help you");
//				System.out.println("\nDo you want to shop with us, please register");
//				System.out.println("\nAre you a(n):");
//				System.out.println("1. Customer");
//				System.out.println("2. Quit");
//				System.out.println("Please, enter 1 or 2.");
//				System.out.println("\n");
//				
//				try {
//					choice = reader.nextInt();
//					
//					switch (choice) {
//					case 1:
//						// try to get input from the users console
//					System.out.println("\nPlease Enter your Email:\n");
//					String cEmail = reader.next();  // LoginEmail
//					
//					System.out.println("\nPlease Enter Your Password:\n");
//					String cPass = reader.next();   // LoginPassword.
//					
//					// Check the valid credential
//					boolean validCustomer = customerServices.validateCustomer(cEmail, cPass);
//
//					
//					if (validCustomer) {
//						System.out.println("Login Successed!");
//						Customer customer = customerServices.getCustomerByEmail(cEmail);
//						
//						if(customer.getcProducts() != null) {
//							System.out.println("Your Shopping Cart: \n ");
//							customer.getcProducts().toString();
//							
//						} else {
//							System.out.println("Your Shopping Cart is empty!");
//						}
//					}else {
//						break;
//					}
//			
//					System.out.println("\n");
//					System.out.println("1. Buy A Bike ");
//					System.out.println("2. Logout");
//					System.out.println("Please, enter 1 or 2");
//					System.out.println("\n");
//					int option = reader.nextInt();
//					while (choice != 2) { 
//					switch (option){
//					
//					case 1:
//						
//						System.out.println("Listing all available Products: ");
//						System.out.println("----------------------------");
//						productsServices.getAllProducts();
//						
//
//						System.out.println("\nWhich Product do you want?");
//						int chooseProduct = reader.nextInt();
//						
//
//						
//						Products product = productsServices.getProductsById(chooseProduct);
//						System.out.println("You've Chosen: " + product);
//						
//						customerServices.registerCustomerToProducts(cEmail, chooseProduct);
//						System.out.println("\nYour Shopping Cart contains: ");
//
//						customerServices.getCustomerProducts(cEmail);
//						break;
//
//				
//						
//					}
//					}
//
//					}
//				} finally {
//					//end try
//					System.out.println("done");
//				}
//			
//				
//			}//end while
	}	
	
	// Used to upload data for testing
	private static void addProducts(Products product) {
		ProductsServices productServices = new ProductsServices();

		boolean result = productServices.insertProduct(product);

		if (result) {
			System.out.println("Products saved, Product ID:" + product.getpId());
		} else {
			System.out.println("Product NOT saved, Product ID: " + product.getpId());
		}
	}

	// Used to upload data for testing
	private static void addCustomer(Customer customer) {
		CustomerServices customerServices = new CustomerServices();
		boolean result = customerServices.insertCustomer(customer);
		if (result) {
			System.out.println("Student saved, Student Email:" + customer.getcEmail());
		} else {
			System.out.println("Student NOT saved, Student Email: " + customer.getcEmail());
		}
	}

	
}
		

					
//					int pickNum = reader.nextInt();
//					switch (pickNum) {
//					case 1:
//						
//						System.out.println("Listing all available Courses: ");
//						System.out.println("----------------------------");
//
//						Products producdtsServices = new Products();
//						List<Products> productsList = productsServices.getAllProducts();
//						for (Products p : ProductsList) {
//							System.out.println(p.toString());
//					}
//					
//						System.out.println("\nWhich course do you want?");
//						int chooseClass = reader.nextInt();
//						
//						Course course = courseServices.getCourseById(chooseClass);
//						System.out.println("You've Chosen: " + course);
//						
//						customerServices.registerCustomerToSystem(cEmail, chooseProducts);
//						customerServices.getCustomerProducts(cEmail);
//						break;
//					}
//					case 2:
//						System.out.println("\n\n");
//						System.out.println("You have been signed out.\n");
//						choice = 2;
//
//						break;
//					}
//				}
//					catch (Exception e) {
//						System.out.println(e.getMessage());
//						e.printStackTrace();
//						reader.nextLine();
//					}
//				}
//				reader.close();
//			}
//		
//
//		private static void createDB() 
//		{
//			EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("mvcapp");
//			EntityManager entityManager = entityManagerFactory.createEntityManager();
//			entityManager.close();
//			entityManagerFactory.close();
//		}
//		
//		
//		
//		// Show All Student	
//		private static void getAllProducts() 
//		{
//			ProductsServices productsServices = new ProductsServices();
//			productsServices.getAllProducts();
//			
//		}
//		//	Method call to getProductsByEmail through ProductsServices.
//		
//		private static void getProductsById(int pId) {
//			ProductsServices ProductsServices = new ProductsServices();
//			productsServices.getProductById(pId);
//		}
//		
//		private static void getProductsByName(String pName) {
//			ProductsServices ProductsServices = new ProductsServices();
//			productsServices.getProductByName(pName);
//		}
//		
//		private static void validateCustomer(String cEmail, String cPass) {
//			CustomerServices customerServices = new CustomerServices();
//			boolean result = customerServices.validateCustomer(cEmail, cPass);
//			
//
//		}	
//		private static final String ProductsList = null;
//		private static Products productsServices;
//		private static Customer cEmail, cPass;
//		
//		private static void registerStudentToCourse(String Email, int cId) {
//			StudentServices studentServices = new StudentServices();
//			studentServices.registerStudentToCourse(Email, cId);
//			
//			
//		}
//		
//		private static void getStudentCourses() {
//			
//			StudentServices studentServices = new StudentServices();
//			studentServices.getStudentCourses(null);
//			
//		}
//		private static void getAllCourses() {
//			CourseServices courseServices = new CourseServices();
//			courseServices.getAllCourses();		
//		
//		}
//		
//		}
//		
		
	


