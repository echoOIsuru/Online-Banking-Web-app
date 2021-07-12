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

@WebServlet("/DeleteServlet")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		boolean result = false;
		String id = request.getParameter("customerid");

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			CustomerServiceImp customer = new CustomerServiceImp();

			List<Customer> CustomerDetails = customer.customerInfor(id);

			result = customer.deleteCustomerDetails(id);
			request.setAttribute("CustomerDetails", CustomerDetails);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result == true) {
			//success
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Your account deleted!');");
			pw.println("</script>");
			RequestDispatcher dis = request.getRequestDispatcher("index.jsp");
			dis.include(request, response);
		} else {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Your request was unsuccessful');");
			pw.println("</script>");
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			dis.include(request, response);
		}

	}

}
