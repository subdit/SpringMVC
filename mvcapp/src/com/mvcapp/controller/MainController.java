package com.mvcapp.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.BikeShop.entities.Customer;
import com.BikeShop.entities.Products;
import com.BikeShop.services.CustomerServices;
import com.BikeShop.services.ProductsServices;

@SessionAttributes("customerLogin")
@Controller
public class MainController {

//	Request for navigation to welcome page 
	@RequestMapping(value = { "/", "/WelcomePage" })
	public ModelAndView getHomePage() {
		return new ModelAndView("WelcomePage");
	}

// LogIn page 
	@RequestMapping("/loginpage")
	public ModelAndView getLoginPage() {

		return new ModelAndView("loginpage");
	}

// Send login to Index page as Home
	@RequestMapping("/LogIn")
	public ModelAndView getLogIn(@RequestParam("email") String email, @RequestParam("password") String password) {

		CustomerServices customerServices = new CustomerServices();
		boolean foundCustomer = customerServices.validateCustomer(email, password);

		ModelAndView mav = new ModelAndView();

		Customer customer = customerServices.getCustomerByEmail(email);

		mav.addObject("name", customer.getcName());
		mav.addObject("customer", customer);
		mav.addObject("customerLogin", customer);

		String message = foundCustomer ? "Congrats you've logged in " + customer.getcName() : "Try to log in again! ";

		mav.addObject("viewMessage", message);
		mav.setViewName("index");

		return mav;

	}

// Checkout page still working on it and it shows in ViewPage as Under Construction
	@RequestMapping("/checkoutPage")
	public ModelAndView getCheckOut() {

		return new ModelAndView("checkoutPage");
	}

	// Edit Product show input in AdminPage
	@RequestMapping("/editproduct/{urlId}")
	public ModelAndView editProduct(@PathVariable("urlId") int id) {

		ProductsServices ps = new ProductsServices();
		Products product = ps.getProductsById(id);

		ModelAndView mav = new ModelAndView("editproduct");
		mav.addObject("product", product);

		return mav;
	}

// LogOut is End of the session 
	@RequestMapping("/LogOut")
	public ModelAndView getLogOut() {

		return new ModelAndView("WelcomePage");
	}

// Landing page after Login then go to Index(Home) page
	@RequestMapping("/tohome")
	public String goBackHome() {
		return ("index");
	}

// WelcomePage to prompt the Customer Register and logIn before they be able to visit home page
	@RequestMapping("/WelcomePage")
	public ModelAndView WelcomeAll() {
		return new ModelAndView("WelcomePage"); // about page
	}

//AdminPage to have a control and perform the CRUD 
	@RequestMapping("/AdminPage")
	public ModelAndView getAdmin() {
		return new ModelAndView("AdminPage"); // about page
	}

// Not yet implement on the way Uncer Construction 
	@RequestMapping("/AdminLogIn")
	public ModelAndView getAdminLogIn() {
		return new ModelAndView("AdminPage"); // about page
	}

// About page is displaying coming soon
	@RequestMapping("/AboutUs")
	public ModelAndView getAboutUs() {
		return new ModelAndView("about");
	}

//	getting registration 
	@RequestMapping("/register")
	public ModelAndView getRegistration() {
		ModelAndView mav = new ModelAndView("Registration");
		mav.addObject("customerKey", new Customer());
		return mav;
	}

// =========================== Begin Customer Section ============================================ //

//	Adding Customers to the database using CustomerKey from Registration form. 
	@RequestMapping("/addCustomer")
	public ModelAndView insertCustomer(@Valid @ModelAttribute("customerKey") Customer c, BindingResult errors) {
		ModelAndView mav = new ModelAndView();
		if (errors.hasErrors()) {
			mav.setViewName("Registration");
			return mav;
		} else {
			CustomerServices cs = new CustomerServices();
			boolean result = cs.insertCustomer(c);

			mav.setViewName("WelcomePage");
			return mav;
		}
	}

// Show customers
	@RequestMapping("/ShowCustomers")
	public ModelAndView ShowCustomers() {

		CustomerServices customerServices = new CustomerServices();
		List<Customer> customerList = customerServices.getAllCustomers();
		ModelAndView mav = new ModelAndView("showcustomers");
		mav.addObject("customerList", customerList);

		return mav;
	}
//   ==================== End Customer Section ================================================== //

//  ==================== Begin Products  Section / View in AdminPage ============================ //

// Show all products for shopping
	@RequestMapping("/allproducts")
	public ModelAndView getAllProducts() {

		ModelAndView mav = new ModelAndView("allproducts");

		ProductsServices ps = new ProductsServices();
		List<Products> plist = new ArrayList<>();

		plist = ps.getAllProducts();

		mav = new ModelAndView("allproducts");
		mav.addObject("productsList", plist);

		return mav;
	}

// Update product in database
	@RequestMapping("/updateProduct/{urlId}")
	public ModelAndView updateProducts(@PathVariable("urlId") int id, @RequestParam("name") String name,
			@RequestParam("image") String image, @RequestParam("description") String description,
			@RequestParam("Quantity") int Quantity, @RequestParam("price") double price,
			@RequestParam("Option") String Option) {

		Products newP = new Products(id, name, image, description, Quantity, price, Option);

		ProductsServices productsServices = new ProductsServices();
		boolean result = productsServices.updateProducts(newP);

		String message = result ? "Product Udated for ID# " + id : "Unable to Update ID#" + id;

		List<Products> plist = new ArrayList<>();
		plist = productsServices.getAllProducts();

		ModelAndView mav = new ModelAndView("adminAllProducts");
		mav.addObject("productsList", plist);
		mav.addObject("messageResult", message);
		return mav;

	}

// Remove product in database
	@RequestMapping("/removeProduct/{urlId}")
	public ModelAndView removeProduct(@PathVariable("urlId") int id) {

		ProductsServices productsServices = new ProductsServices();

		boolean result = productsServices.removeProducts(id);

		String message = result ? "Product Deleted for ID# " + id : "Unable to Delete ID#" + id;

		List<Products> plist = new ArrayList<>();

		plist = productsServices.getAllProducts();
		ModelAndView mav = new ModelAndView("adminAllProducts");
		mav.addObject("productsList", plist);
		mav.addObject("messageResult", message);
		return mav;

	}

// This "/GetAddProducts" 
	@RequestMapping("/GetAddProducts")
	public @ResponseBody ModelAndView GetAddProducts() {
		return new ModelAndView("addproduct");
	}

// 		
	@RequestMapping("/adminAllProducts")
	public ModelAndView adminAllProducts() {

		ModelAndView mav = new ModelAndView("adminAllProducts");

		ProductsServices ps = new ProductsServices();
		List<Products> plist = new ArrayList<>();

		plist = ps.getAllProducts();

		mav = new ModelAndView("adminAllProducts");
		mav.addObject("productsList", plist);

		return mav;

	}

	@RequestMapping("/addProduct")
	public @ResponseBody ModelAndView insertProduct(@RequestParam("name") String bname,
			@RequestParam("image") String image, @RequestParam("description") String description,
			@RequestParam("price") double price, @RequestParam("Quantity") int Quantity,
			@RequestParam("Option") String Option) {

		ModelAndView mav = new ModelAndView();
		Products products = new Products(bname, image, description, Quantity, price, Option);

		ProductsServices productsServices = new ProductsServices();
		boolean result = productsServices.addProducts(products);
		String message = result ? "Product Added" : "try again, not saved";

		ProductsServices ps = new ProductsServices();
		List<Products> plist = new ArrayList<>();
		plist = ps.getAllProducts();

		mav = new ModelAndView("adminAllProducts");
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
		String message = result ? "Product updated = " + product.getpId() : "Product not updated";
		List<Products> productsList = productsServices.getAllProducts();

		ModelAndView mav = new ModelAndView("allProducts");
		mav.addObject("messageResult", message);
		mav.addObject("productsList", productsList);

		return mav;
	}
//  ==================== End Products Section ================================================ //
//
//	
//
// ==================== Begin Cart Section ================================================== //

// Show cart after customer login
	@RequestMapping("/Cart")
	public ModelAndView Cart(@SessionAttribute("customerLogin") Customer customerLogin) {

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

	// Add product to Cart using @Session with CustomerLoging
	@RequestMapping("/addToCart")
	public @ResponseBody ModelAndView addToCart(@SessionAttribute("customerLogin") Customer customerLogin,
			@RequestParam("itemId") int itemId) {
		ModelAndView mav = new ModelAndView();

		List<Products> cartList = new ArrayList<>();

		String email = customerLogin.getcEmail();

		CustomerServices customerServices = new CustomerServices();

		boolean result = customerServices.registerCustomerToProducts(email, itemId);
		System.out.println(result);
		if (result) {
			cartList = customerServices.getCustomerProducts(email);
			System.out.println(cartList.toString());

		}
		mav = new ModelAndView("Cart");

		mav.addObject("cartList", cartList);
		mav.setViewName("Cart");
		return mav;
	}

// Customer Remove products from Cart
	@RequestMapping("/removeProduct")
	public ModelAndView deleteItemFromCart(@SessionAttribute("customerLogin") Customer customerLogin,
			@RequestParam("itemId") int Id) {
		System.out.println("item id from url = " + Id);

		String email = customerLogin.getcEmail();
		// delete the item from cart with id
		CustomerServices customerServices = new CustomerServices();
		// boolean result = customerServices.removeProductsFromCart(email, Id);

		boolean result = customerServices.removeProductsFromCart(customerLogin, Id);
		System.out.println("Result : " + result);

		String message = result ? "Item removed = " + Id : "Item not deleted yet";

		ModelAndView mav = new ModelAndView("Cart");
		mav.addObject("messageResult", message);
		mav.addObject("cartList", customerLogin.getcProducts());
		// mav.addObject("customerLogin", customerLogin);
		return mav;

	}

//  ==================== End Cart Section ================================================== //

//	@InitBinder
//	public void initBinder(WebDataBinder binder) {
//		binder.setDisallowedFields(new String[] { "cName" });
//
//	}

}