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


@WebServlet("/UpdateServlet")

public class UpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		
		boolean value = false;
		String id = request.getParameter("customerid");
		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String oldpass = request.getParameter("oldPassword");
		String newpass = request.getParameter("loginPassword");
		String address = request.getParameter("address");

		try {
			// get validated customer informations
			CustomerServiceImp customer = new CustomerServiceImp();

			value = customer.updateCustomerDetails(id, name, mobile, email, oldpass, newpass, address);

			List<Customer> CustomerDetails = customer.customerInfor(id);

			// set request
			request.setAttribute("CustomerDetails", CustomerDetails);

		} catch (Exception e) {
			e.printStackTrace();
		}

		//Wrong password entered
		if (CustomerServiceImp.stat == true) {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Old password incorrect !');");
			pw.println("</script>");
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/Cprofile.jsp");
			dis.include(request, response);

		} else {

			if (value == true) {
				//success
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Your information updated!');");
				pw.println("</script>");
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/Cprofile.jsp");
				dis.include(request, response);
			} else {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Cannot update your information!');");
				pw.println("</script>");
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/customer_update.jsp");
				dis.include(request, response);

			}
		}

	}

}
