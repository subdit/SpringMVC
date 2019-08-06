package com.BikeShop.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BikeShop.entities.Customer;
import com.BikeShop.services.CustomerServices;

/**
 * Servlet implementation class LogInControl
 */
@WebServlet("/Login")
public class LogInControl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInControl() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String email = request.getParameter("email");
		String userpasswd = request.getParameter("userpasswd");
		
		
		CustomerServices cServices = new CustomerServices();
		System.out.println(cServices.toString());
		boolean validCustomer = cServices.validateCustomer(email, userpasswd);
		
		Customer customer = cServices.getCustomerByEmail(email);
		
		
		System.out.println("ValidCustomer? " + validCustomer);
		if(validCustomer)
		{
			String username = customer.getcName();
			request.setAttribute("username", username);
			
			RequestDispatcher rd = request.getRequestDispatcher("welcomepage.jsp");
			rd.forward(request, response);
		} else {
			RequestDispatcher rd = request.getRequestDispatcher("invalidLogin.jsp");
			rd.forward(request, response);
		}
		
	}

}
