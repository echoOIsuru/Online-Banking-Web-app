package com.manage.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.model.Customer;
import com.manage.service.CustomerServiceImp;

/**
 * Servlet implementation class HomeServlet
 */
@WebServlet("/HomeServlet")
public class HomeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String id = request.getParameter("customerid");
		boolean msg = request.getParameter("ProfileSubmit") != null;
		boolean msg2 = request.getParameter("ManageCard") != null;
		boolean msg3 = request.getParameter("update") != null;
		boolean msg4 = request.getParameter("back") != null;
		boolean msg5 = request.getParameter("delete") != null;

		try {
			// get validated customer informations
			CustomerServiceImp customer = new CustomerServiceImp();

			List<Customer> CustomerDetails = customer.customerInfor(id);

			// set request
			request.setAttribute("CustomerDetails", CustomerDetails);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (msg == true) {
			//Redirect to  the customer profile page
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/Cprofile.jsp");
			dis.forward(request, response);
		} else if (msg2 == true) {
			//Redirect to  the card login page
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/manage_card_login.jsp");
			dis.forward(request, response);
		} else if (msg3 == true) {
			//Redirect to  the customer profile update page
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/customer_update.jsp");
			dis.forward(request, response);
		} else if (msg4 == true) {
			//Redirect to  the home page
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			dis.forward(request, response);
		}else if(msg5==true) {
			//Redirect to  the customer profile delete request page
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/customer_delete.jsp");
			dis.forward(request, response);
		}

	}

}
