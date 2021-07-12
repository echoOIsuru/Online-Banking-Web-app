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
import com.manage.util.CommonConstants;

@WebServlet("/MloginServlet")
public class MloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("customerid");
		boolean addcard = request.getParameter("addcard") != null;
		String accNo = request.getParameter("McardNumber");
		String pass = request.getParameter("McardPassword");
		boolean stat = false;

		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		
		try {
			// get validated customer informations
			CustomerServiceImp mcu = new CustomerServiceImp();
			List<MCustomer> mCustomerDetails = mcu.card_validate(accNo, pass);
			request.setAttribute("mCustomerDetails", mCustomerDetails);

			// customer information

			List<Customer> CustomerDetails = mcu.customerInfor(id);
			request.setAttribute("CustomerDetails", CustomerDetails);

			// set request

			if (mCustomerDetails.isEmpty() != true) {
				stat = true;
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		
		if (addcard == true) {
			// Redirect to the card adding page
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/manage_card_add.jsp");
			dis.forward(request, response);
		} else {
			
			//success
			if (stat == true) {	
				//Check whether a card is enabled
				if(CustomerServiceImp.cardStat.equals(CommonConstants.CARD_STATUS_ENABLE)) {
					RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/manage_card_home.jsp");
					dis.forward(request, response);
					
				}else {
					pw.println("<script type=\"text/javascript\">");
					pw.println("alert('This card was disabled! contact Hot Line!');");
					pw.println("</script>");
					RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/manage_card_login.jsp");
					dis.include(request, response);
				}

			} else {
				pw.println("<script type=\"text/javascript\">");
				pw.println("alert('Wrong email or password!');");
				pw.println("</script>");
				RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/manage_card_login.jsp");
				dis.include(request, response);
			}
		}
	}

}
