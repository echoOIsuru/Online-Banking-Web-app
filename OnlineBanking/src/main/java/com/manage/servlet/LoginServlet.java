package com.manage.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.manage.model.Customer;
import com.manage.service.CustomerServiceImp;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String email = request.getParameter("email");
		String pass = request.getParameter("password");
		boolean stat = false;
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		try {
			// get validated customer informations
			CustomerServiceImp customer = new CustomerServiceImp();

			List<Customer> CustomerDetails = customer.customer_validate(email, pass);

			// set request
			request.setAttribute("CustomerDetails", CustomerDetails);

			if (CustomerDetails.isEmpty() != true) {
				stat = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		// direct to the next page

		if (stat == true) {

			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			dis.forward(request, response);

		} else {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Wrong email or password!');");
			pw.println("</script>");
			RequestDispatcher dis = request.getRequestDispatcher("customer_login.jsp");
			dis.include(request, response);
		}

	}

}
