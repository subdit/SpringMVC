package com.mvcapp.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.BikeShop.entities.Customer;
import com.BikeShop.services.CustomerServices;
import com.BikeShop.entities.Products;
import com.BikeShop.services.ProductsServices;





@SessionAttributes("customerLogin") // declare in the class level
@Controller
public class MainController {
	
				//	@RequestMapping("/")   // have to request home first
				//	public ModelAndView home() {
				//		return new ModelAndView("index");
				//	}

	@RequestMapping(value= {"/", "/index"})
	public ModelAndView backHome() {
		Customer customer = new Customer();
		ModelAndView mav = new ModelAndView("index");
		mav.addObject("customerLogin", customer);
		return mav;
		}	
	@RequestMapping("/tohome")
	public String goBackHome() {
		
		return ("index"); // about page
	}
	

	@RequestMapping("/AboutUs")
	public ModelAndView getAbout() {
		return new ModelAndView("about"); // about page
	}
	
	@RequestMapping("/registration")
	public ModelAndView Register() {
		
		return new ModelAndView("Registration");
	} // Registration page
	
	@RequestMapping("/Cart")
	public ModelAndView Cart(
			@SessionAttribute("customerLogin") Customer customerLogin) {
		
		String email = customerLogin.getcEmail();
		List<Products> cartList = new ArrayList<>();
		

		CustomerServices customerServices = new CustomerServices();
		

			cartList = customerServices.getCustomerProducts(email);
			System.out.println(cartList.toString());

		
		ModelAndView mav = new ModelAndView("Cart");

		mav.addObject("cartList", cartList);
		// mav.setViewName("index");
		

		return mav;
		
	}
	
	@RequestMapping("/ShowCustomers")
	public ModelAndView ShowCustomers() {
		
		CustomerServices customerServices = new CustomerServices();
		List<Customer> customerList = customerServices.getAllCustomers();
		ModelAndView mav = new ModelAndView("showcustomers");
		mav.addObject("customerList", customerList);
		
		
		return mav;
	}

	
	@RequestMapping("/allproducts")
	public ModelAndView getAllProducts() {

		ModelAndView mav = new ModelAndView("allproducts");
		
		ProductsServices ps = new ProductsServices();
		List<Products> plist = new ArrayList<>();
		
//		p = ps.getAllProducts();
		plist = ps.getAllProducts();
		
		mav = new ModelAndView("allproducts");
		mav.addObject("productsList", plist);
		
		return mav;
	}
	
	// update products
	@RequestMapping("/saveProduct")
	public ModelAndView saveProduct(@ModelAttribute Products product) {
		boolean result = true;
		ProductsServices productsServices = new ProductsServices();
		System.out.println(product.toString());
		if (product != null) {
			result = productsServices.updateProducts(product);
		}
		String message = result?"Product updated = " + product.getpId():"Product not updated";
		List<Products> productsList = productsServices.getAllProducts();
		
		ModelAndView mav = new ModelAndView("allProducts");
		mav.addObject("messageResult", message);
		mav.addObject("productsList", productsList);
		
		return mav;
	}	

	
	@RequestMapping("/addCustomer")
	public ModelAndView insertCustomer(
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		
			ModelAndView mav = new ModelAndView("index");
			
			CustomerServices customerServices = new CustomerServices();
			Customer customer = new Customer(email, name, password);
			boolean result = customerServices.insertCustomer(customer);
			
			String message = result?"Welcome Customer!  " + customer.getcName() + " You've added to our system ":"try to register again ";
			
			mav.addObject("viewMessage", message);
			
			return mav ;
		}
	
	@RequestMapping("/GetAddProducts")
	public @ResponseBody ModelAndView GetAddProducts()
	{
		return new ModelAndView("addproduct");
	}
	
	@RequestMapping("/addProduct")
	public @ResponseBody ModelAndView insertProduct(
			@RequestParam("name") String bname,
			@RequestParam("image") String image,
			@RequestParam("description") String description,
			@RequestParam("price") String price,
			@RequestParam("Quantity") String Quantity,
			@RequestParam("Option") String Option
			) 
	{
		
		ModelAndView mav = new ModelAndView();
		Products products = new Products(bname, image, description, Integer.parseInt(Quantity), Double.parseDouble(price), Option);
		
		ProductsServices productsServices = new ProductsServices();
		
		boolean result = productsServices.addProducts(products);
		
		String message = result?"Product saved":"try again, not saved";
		
		mav.addObject("messageResult", message);
		mav.setViewName("addproduct");
		
		return mav ;
	}
	
		
	
	@RequestMapping("/loginpage")
	public ModelAndView goToLoginpage() {
		return new ModelAndView("loginpage"); // registration 
	}	
	
	@RequestMapping("/LogIn")
	public ModelAndView getLogIn(
			
			@RequestParam("email") String email,
			@RequestParam("password") String password) {
		
		CustomerServices customerServices = new CustomerServices();
		boolean foundCustomer = customerServices.validateCustomer(email, password);	
		
		
		ModelAndView mav = new ModelAndView("index"); // home page

		
			Customer customer = customerServices.getCustomerByEmail(email);
			
			mav.addObject("name", customer.getcName());
			mav.addObject("customer", customer);
			mav.addObject("customerLogin", customer);
			
			String message = foundCustomer? "Congrats you've logged in " + customer.getcName() :"Try to log in again! ";
			
			mav.addObject("viewMessage", message);
			mav.setViewName("index");
			
			return mav;
		
		}	
	
	@RequestMapping("/addToCart")
	public @ResponseBody ModelAndView addToCart(						
			@SessionAttribute("customerLogin") Customer customerLogin,
			@RequestParam("itemId") int itemId) {
		ModelAndView mav = new ModelAndView();
		
		List<Products> cartList = new ArrayList<>();
		
		String email = customerLogin.getcEmail();
		
		CustomerServices customerServices = new CustomerServices();
		
		boolean result = customerServices.registerCustomerToProducts(email, itemId);
		System.out.println(result);
		if(result) {
			cartList = customerServices.getCustomerProducts(email);
			System.out.println(cartList.toString());

		}
		mav = new ModelAndView("Cart");

		mav.addObject("cartList", cartList);
		mav.setViewName("Cart");
		return mav;
	}
	
	// The key to remove the content from visual table is to remove the whole key object
	// I was passing @SessionAttributes("CustomerLogin") use it as 
	
	@RequestMapping("/removeProduct")
	public ModelAndView deleteItemFromCart(
			@SessionAttribute("customerLogin") Customer customerLogin,
			@RequestParam("itemId") int Id) {
		System.out.println("item id from url = " + Id);
		
		String email = customerLogin.getcEmail();
		// delete the item from cart with id 
		CustomerServices customerServices = new CustomerServices();
		//boolean result = customerServices.removeProductsFromCart(email, Id);
		
		boolean result = customerServices.removeProductsFromCart(customerLogin, Id);
		System.out.println("Result : " + result); 
		
		String message =  result?"Item removed = "+ Id:"Item not deleted yet";

		//List<Products> cartList = customerLogin.getcProducts();
		
		//customerLogin.setcProducts(customerLogin.)
		
		ModelAndView mav = new ModelAndView("Cart");  
		mav.addObject("messageResult", message);
		mav.addObject("cartList", customerLogin.getcProducts());
		//mav.addObject("customerLogin", customerLogin);
		return mav;
		
	}
	
	@RequestMapping("/updateProducts/{urlId}")
	public ModelAndView updateProducts(@PathVariable("urlId") int Id) {
		
		ProductsServices productsServices = new ProductsServices();
		Products foundProducts = productsServices.getProductsById(Id);	
		
		ModelAndView mav = new ModelAndView("editProducts");
		mav.addObject("products", foundProducts);
		return mav;
		
	}
	
	@RequestMapping("/LogOut")
	public ModelAndView getLogOut() {
		
		return new ModelAndView("LogOut"); // 
	}	

}
