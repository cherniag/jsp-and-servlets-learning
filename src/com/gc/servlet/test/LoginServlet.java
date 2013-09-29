package com.gc.servlet.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gc.domain.UserDetails;
import com.gc.service.AuthorizationService;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private AuthorizationService authorizationService = new AuthorizationService();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		boolean authorized = authorizationService.authenticate(userId, password);
		if(authorized){
			UserDetails userDetails = authorizationService.getUserDetails(userId);
			
			/*
			  	First method - send command to browser to redirect:
			  	//store userDetails in session
				request.getSession().setAttribute("userDetails", userDetails);
				//send command to browser
				response.sendRedirect("success.jsp");
			*/
			
			/*
			  	Second method - use forward: 
			  		1. browser doesn't know about redirect 
			  		2. we can add new parameters
			  		3. we don't have to store everything in session
			 */
			//get dispatcher
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("success.jsp");
			//set new attribute
			request.setAttribute("userDetails", userDetails);
			//use forward to servlet
			requestDispatcher.forward(request, response);
			return;
		}else{
			response.sendRedirect("login.jsp");
			return;
		}
	}

}
