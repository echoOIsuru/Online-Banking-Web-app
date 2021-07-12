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


@WebServlet("/DisableCardServlet")
public class DisableCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int result = 0;
		String id = request.getParameter("customerid");
		String number = request.getParameter("number");


		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		try {

			CustomerServiceImp mcu = new CustomerServiceImp();

			result = mcu.disableCard(id,number);
			
			// customer information
			List<Customer> CustomerDetails = mcu.customerInfor(id);
			request.setAttribute("CustomerDetails", CustomerDetails);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result == 1) {
			//success
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Your card disabled success. If you want to enable your card contact our hotline');"); 
			pw.println("</script>");
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/manage_card_login.jsp");
			dis.include(request, response);
			
		} else {

			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Your card disabled failed! try again');");
			pw.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/manage_card_login.jsp");
			rd.include(request, response);

			// maximum cards added

		}
		
		
	}

}
