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

@WebServlet("/RegistrationServlet")
public class RegistrationServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public RegistrationServlet() {
		super();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		String list[] = new String[9];
		boolean result = false;

		String name = request.getParameter("name");
		String mobile = request.getParameter("mobile");
		String email = request.getParameter("email");
		String cPassword = request.getParameter("loginPassword");
		String address = request.getParameter("address");
		String acType = request.getParameter("aType");
		String nic = request.getParameter("govtIdNumber");
		String sQuestion = request.getParameter("securityQuestion");
		String answer = request.getParameter("answer");

		list[0] = name;
		list[1] = mobile;
		list[2] = email;
		list[3] = cPassword;
		list[4] = address;
		list[5] = acType;
		list[6] = nic;
		list[7] = sQuestion;
		list[8] = answer;

		try {
			CustomerServiceImp mcu = new CustomerServiceImp();

			result = mcu.insertCustomerDetails(list);

			if (result == true) {

				List<Customer> CustomerDetails = mcu.customer_validate(email, cPassword);

				// set request
				request.setAttribute("CustomerDetails", CustomerDetails);
			}

		} catch (Exception e) {

			e.printStackTrace();

		}

		if (result == true) {
			//success
			RequestDispatcher dis = request.getRequestDispatcher("/WEB-INF/views/home.jsp");
			dis.forward(request, response);

		} else {
			pw.println("<script type=\"text/javascript\">");
			pw.println("alert('Registration failed! try again');");
			pw.println("</script>");
			RequestDispatcher dis = request.getRequestDispatcher("customer_registration.jsp");
			dis.include(request, response);

		}

	}

}
