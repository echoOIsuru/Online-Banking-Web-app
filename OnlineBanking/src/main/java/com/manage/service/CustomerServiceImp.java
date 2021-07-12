/**
 * OOP PROJECT 2021
 * @author IT20133290 R.M.Isuru Sahan Kumarasingha
 */
package com.manage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.manage.model.Customer;
import com.manage.model.MCustomer;
import com.manage.util.CommonConstants;
import com.manage.util.CommonUtil;
import com.manage.util.DBConnection;

public class CustomerServiceImp implements InCustomerService {

	private static Connection con = null;
	private static PreparedStatement stmt = null;
	private static ResultSet rs = null;
	public static boolean stat = false;
	public static String cardStat; // card activity status

	public List<MCustomer> card_validate(String cardNo, String pass) {

		ArrayList<MCustomer> mcustomer = new ArrayList<>();

		// validation
		try {

			con = DBConnection.getConnection();

			
			stmt = con.prepareStatement(CommonConstants.VALIDATE_CARD_SQL);
			stmt.setString(1, cardNo);
			stmt.setString(2, CommonUtil.passwordHash(pass));

			rs = stmt.executeQuery();

			// fetch results
			if (rs.next()) {
				String cid = rs.getString(1);
				String cnumber = rs.getString(2);
				String ctype = rs.getString(3);
				String cname = rs.getString(4);
				//use for card is disable or enable
				cardStat = rs.getString(9);  

				/*
				 * Add customer details to model class
				 */
				MCustomer c = new MCustomer();
				c.setmID(cid);
				c.setmName(cname);
				c.setmCardNumber(cnumber);
				c.setmCardType(ctype);

				mcustomer.add(c);
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				/*
				 * Thrown when database access error occurs or this method is
				 *called on a closed connection
				 */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return mcustomer;

	}

	public boolean insertCustomerDetails(String list[]) {

		boolean success = false;

		/*
		 *  Generate customer id
		 */
		String ids = CommonUtil.generateIDs(getIDs()); 

		try {

			String name = list[0];
			String mobile = list[1];
			String email = list[2];
			
			/*
			 * password hashing before insert
			 */
			String cPassword = CommonUtil.passwordHash(list[3]); 

			String address = list[4];
			String acType = list[5];
			String nic = list[6];
			String sQuestion = list[7];
			String answer = list[8];

			con = DBConnection.getConnection();

			/**
			 * check whether null values passed
			 */
			if (sQuestion.equals(CommonConstants.FORM_VALUE_NULL) || acType.equals(CommonConstants.FORM_VALUE_NULL)) {

				success = false;
			} else {
				
				/*
				 * check whether which security question selected
				 */
				if (sQuestion.equals("q1")) {

					stmt = con.prepareStatement(CommonConstants.INSERT_CUSTOMER_SQL_1);
				
				} else if (sQuestion.equals("q2")) {

					stmt = con.prepareStatement(CommonConstants.INSERT_CUSTOMER_SQL_2);

				} else {

					stmt = con.prepareStatement(CommonConstants.INSERT_CUSTOMER_SQL_3);

				}
				stmt.setString(1, ids);
				stmt.setString(2, name);
				stmt.setString(3, mobile);
				stmt.setString(4, email);
				stmt.setString(5, cPassword);
				stmt.setString(6, address);
				stmt.setString(7, acType);
				stmt.setString(8, nic);
				stmt.setString(9, answer);

				int result = stmt.executeUpdate();

				if (result > 0) {
					success = true;
				} else {
					success = false;
				}
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				/*
				 * Thrown when database access error occurs or this method is
				 *called on a closed connection
				 */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return success;

	}

	public List<Customer> customer_validate(String email, String password) {

		ArrayList<Customer> cus = new ArrayList<>();
		// validation
		try {

			con = DBConnection.getConnection();
			stmt = con.prepareStatement(CommonConstants.VALIDATE_CUSTOMER_SQL);

			stmt.setString(1, email);
			stmt.setString(2, CommonUtil.passwordHash(password));

			rs = stmt.executeQuery();

			// fetch results
			if (rs.next()) {

				String customer_id = rs.getString(1);
				String name = rs.getString(2);
				String mobile = rs.getString(3);
				String mail = rs.getString(4);
				String address = rs.getString(6);
				String account_type = rs.getString(7);
				String nic = rs.getString(8);
				String answer = rs.getString(9);

				Customer c = new Customer();
				c.setCustomer_id(customer_id);
				c.setName(name);
				c.setMobile(mobile);
				c.setEmail(mail);
				c.setAddress(address);
				c.setAccount_type(account_type);
				c.setNic(nic);
				c.setAnswer(answer);

				cus.add(c);

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				/*
				 * Thrown when database access error occurs or this method is
				 *called on a closed connection
				 */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cus;
	}

	
	private ArrayList<String> getIDs() {
		/*
		 * Get customer ids to the array list 
		 */
		ArrayList<String> arrayList = new ArrayList<String>();

		try {
			con = DBConnection.getConnection();
			stmt = con.prepareStatement(CommonConstants.GET_CUSTOMER_IDS_SQL);
			rs = stmt.executeQuery();

			while (rs.next()) {
				arrayList.add(rs.getString(1));
			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				/*
				 * Thrown when database access error occurs or this method is
				 *called on a closed connection
				 */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return arrayList;
	}

	public List<Customer> customerInfor(String customerid) {
		
		ArrayList<Customer> cus = new ArrayList<>();

		try {

			con = DBConnection.getConnection();
			stmt = con.prepareStatement(CommonConstants.GET_CUSTOMER_INFO_SQL);

			stmt.setString(1, customerid);

			rs = stmt.executeQuery();

			// fetch results
			if (rs.next()) {

				String customer_id = rs.getString(1);
				String name = rs.getString(2);
				String mobile = rs.getString(3);
				String mail = rs.getString(4);
				String address = rs.getString(6);
				String account_type = rs.getString(7);
				String nic = rs.getString(8);
				String answer = rs.getString(9);

				Customer c = new Customer();
				c.setCustomer_id(customer_id);
				c.setName(name);
				c.setMobile(mobile);
				c.setEmail(mail);
				c.setAddress(address);
				c.setAccount_type(account_type);
				c.setNic(nic);
				c.setAnswer(answer);

				cus.add(c);

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				/*
				 * Thrown when database access error occurs or this method is
				 *called on a closed connection
				 */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return cus;

	}

	public boolean updateCustomerDetails(String id, String name, String mobile, String email, String oldPassword,
			String newPassword, String address) {

		boolean success = false;
		String temp = "";

		try {

			con = DBConnection.getConnection();

			//check whether password is null
			if (newPassword == null) {
				newPassword = "";
			}

			stmt = con.prepareStatement(CommonConstants.VALIDATE_CUSTOMER_PASSWORD);
			stmt.setString(1, id);
			rs = stmt.executeQuery();

			if (rs.next()) {
				temp = rs.getString(1);
			}

			/*
			 * Update customer details without password change 
			 */
			if (CommonUtil.passwordHash(newPassword).equals(temp) || newPassword.isEmpty()) {

				stat = false;
				stmt = con.prepareStatement(CommonConstants.UPDATE_CUSTOMER_INFO_NOPASS_SQL);

				stmt.setString(1, name);
				stmt.setString(2, mobile);
				stmt.setString(3, email);
				stmt.setString(4, address);
				stmt.setString(5, id);

				int result = stmt.executeUpdate();

				if (result > 0) {
					success = true;
				} else {
					success = false;
				}

			} else {
			/*
			 * Update customer details with password
			 */
				stat = false;

				if (temp.equals(CommonUtil.passwordHash(oldPassword))) {

					stmt = con.prepareStatement(CommonConstants.UPDATE_CUSTOMER_INFO_SQL);

					stmt.setString(1, name);
					stmt.setString(2, mobile);
					stmt.setString(3, email);
					stmt.setString(4, address);
					stmt.setString(5, CommonUtil.passwordHash(newPassword));
					stmt.setString(6, id);

					int result = stmt.executeUpdate();

					if (result > 0) {
						success = true;
					} else {
						success = false;
					}

				} else {
					stat = true;
				}

			}

		} catch (SQLException | ClassNotFoundException e) {
			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				/*
				 * Thrown when database access error occurs or this method is
				 *called on a closed connection
				 */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		System.out.println(stat);
		return success;
	}

	public boolean deleteCustomerDetails(String id) {

		boolean success = false;
		
		/*
		 * Delete customer's all details
		 */
		try {
			con = DBConnection.getConnection();

			stmt = con.prepareStatement(CommonConstants.DELETE_CUSTOMER_PROFILE);
			stmt.setString(1, id);

			
			
			int result = stmt.executeUpdate();

			if (result > 0) {
				
				success = true;
				stmt = con.prepareStatement(CommonConstants.DELETE_MCUSTOMER_DETAILS);
				stmt.setString(1, id);
				stmt.executeUpdate();
			} else {
				success = false;
			}

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				/*
				 * Thrown when database access error occurs or this method is
				 *called on a closed connection
				 */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return success;

	}

	public int insertMcustomerDetails(String id, String card_number, String card_type, String card_name,
			String card_password, String month, String year, String ccv) {

		int success = 0;
		int number = 0;

		try {
			con = DBConnection.getConnection();
			
			/**
			 * check whether null values passed
			 */
			if (card_type.equals(CommonConstants.FORM_VALUE_NULL) || year.equals(CommonConstants.FORM_VALUE_NULL)
					|| month.equals(CommonConstants.FORM_VALUE_NULL)) {

				success = 0;

			} else {

				stmt = con.prepareStatement(CommonConstants.GET_MCUSTOMER_COUNT_SQL);
				stmt.setString(1, id);

				rs = stmt.executeQuery();

				if (rs.next()) {
					number = rs.getInt(1);
				}
				
				/*
				 * Check customers card count
				 */
				success = CommonUtil.getCardResult(number);

				/*
				 * Success equals 2 means customer can add another card did not reach maximum
				 * limit
				 */
				if (success == 2) {

					stmt = con.prepareStatement(CommonConstants.INSERT_MCUSTOMER_SQL);
					stmt.setString(1, id);
					stmt.setString(2, card_number);
					stmt.setString(3, card_type);
					stmt.setString(4, card_name);
					stmt.setString(5, CommonUtil.passwordHash(card_password));
					stmt.setString(6, month);
					stmt.setString(7, year);
					stmt.setString(8, ccv);
					stmt.setString(9, CommonConstants.CARD_STATUS_ENABLE);

					int result = stmt.executeUpdate();

					if (result > 0) {
						success = 1;
					} else {
						success = 0;
					}

				}
			}
		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				/*
				 * Thrown when database access error occurs or this method is
				 *called on a closed connection
				 */
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}

		return success;

	}

	public int disableCard(String id, String card_number) {
		int success = 0;

		try {
			con = DBConnection.getConnection();

			stmt = con.prepareStatement(CommonConstants.DISABLE_CARD_SQL);
			stmt.setString(1, CommonConstants.CARD_STATUS_DISABLE);
			stmt.setString(2, id);
			stmt.setString(3, card_number);

			success = stmt.executeUpdate();

		} catch (SQLException | ClassNotFoundException e) {

			e.printStackTrace();

		} finally {
			/*
			 * Close prepared statement and database connectivity at the end of
			 * transaction
			 */
			try {
				if (stmt != null) {
					stmt.close();
				}
				if (con != null) {
					con.close();
				}
				/*
				 * Thrown when database access error occurs or this method is
				 *called on a closed connection
				 */
			} catch (SQLException e) {

				e.printStackTrace();
			}
		}

		return success;

	}

}
