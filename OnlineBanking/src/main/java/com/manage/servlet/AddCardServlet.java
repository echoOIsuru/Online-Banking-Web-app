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
import com.manage.model.MCustomer;
import com.manage.service.CustomerServiceImp;

@WebServlet("/AddCardServlet")
public class AddCardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int result = 0;
		String id = request.getParameter("customerid");
		String number = request.getParameter("number");
		String ctype = request.getParameter("ctype");
		String cname = request.getParameter("cname");
		String password = request.getParameter("loginPassword");
		String month = request.getParameter("month");
		String year = request.getParameter("year");
		String ccv = request.getParameter("ccv");
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();

		try {

			CustomerServiceImp mcu = new CustomerServiceImp();
			result = mcu.insertMcustomerDetails(id, number, ctype, cname, password,month,year,ccv);

			List<MCustomer> mCustomerDetails = mcu.card_validate(number, password);
			request.setAttribute("mCustomerDetails", mCustomerDetails);

			// customer information
			List<Customer> CustomerDetails = mcu.customerInfor(id);
			request.setAttribute("CustomerDetails", CustomerDetails);

		} catch (Exception e) {
			e.printStackTrace();
		}

		if (result == 1) {
			//success
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/manage_card_home.jsp");
			dis.forward(request, response);
		} else if (result == 3) {
			// maximum cards added
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('You cant add more than 3 cards');");
			pw.println("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("/WEB-INF/views/manage_card_add.jsp");
			rd.include(request, response);

		} else {

			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Card adding fail');");
			pw.println("</script>");
			RequestDispatcher dis2 = request.getRequestDispatcher("/WEB-INF/views/manage_card_add.jsp");
			dis2.include(request, response);

		}

	}

}
