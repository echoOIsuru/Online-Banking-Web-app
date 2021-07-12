/**
 * OOP PROJECT 2021
 * @author IT20133290 R.M.Isuru Sahan Kumarasingha
 */
package com.manage.service;

import java.util.List;

import com.manage.model.Customer;
import com.manage.model.MCustomer;

public interface InCustomerService {

	/**
	 * Validate customer's card
	 * @return List<MCustomer>
	 */
	List<MCustomer> card_validate(String cardNo, String pass);

	/**
	 * Insert customer details
	 * @return boolean
	 */
	boolean insertCustomerDetails(String list[]);

	/**
	 * Validate customer profile
	 * @return List<Customer>
	 */
	List<Customer> customer_validate(String email, String password);

	/**
	 * Get customer details
	 * @return List<Customer>
	 */
	List<Customer> customerInfor(String customerid);

	/**
	 * Update customer profile
	 * @return boolean
	 */
	boolean updateCustomerDetails(String id, String name, String mobile, String email, String oldPassword,
			String newPassword, String address);

	/**
	 * Delete customer all details,cards
	 * @return boolean
	 */
	boolean deleteCustomerDetails(String id);

	/**
	 * Insert customer card details
	 * @return integer
	 */
	int insertMcustomerDetails(String id, String card_number, String card_type, String card_name, String card_password,String month,String year,String ccv);

	/**
	 * Disable customer card details
	 * @return integer
	 */
	int disableCard(String id, String card_number);
	
}
