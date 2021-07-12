/**
 * OOP PROJECT 2021
 * @author IT20133290 R.M.Isuru Sahan Kumarasingha
 */
package com.manage.util;

public class CommonConstants {

	/** Constant for config.properties file*/
	public static final String PROPERTY_FILE = "config.properties";

	/** Constant for database url */
	public static final String URL = "url";

	/** Constant for database user name*/
	public static final String USERNAME = "username";

	/** Constant for database password */
	public static final String PASSWORD = "password";

	/** Constant for driver name */
	public static final String DRIVER_NAME = "driverName";

	/** Constant for insert customer details query option 1 */
	public static final String INSERT_CUSTOMER_SQL_1 = "insert into customer(customer_id,name,mobile,email,password,address,account_type,nic,question1) values(?,?,?,?,?,?,?,?,?);";

	/** Constant for insert customer details query option 2 */
	public static final String INSERT_CUSTOMER_SQL_2 = "insert into customer(customer_id,name,mobile,email,password,address,account_type,nic,question2) values(?,?,?,?,?,?,?,?,?);";

	/** Constant for insert customer details query option 3 */
	public static final String INSERT_CUSTOMER_SQL_3 = "insert into customer(customer_id,name,mobile,email,password,address,account_type,nic,question3) values(?,?,?,?,?,?,?,?,?);";

	/** Constant for insert customer card details query */
	public static final String INSERT_MCUSTOMER_SQL = "insert into manage_card_customer values(?,?,?,?,?,?,?,?,?);";

	/** Constant for get customer card count query */
	public static final String GET_MCUSTOMER_COUNT_SQL = "select count(cus_id) from manage_card_customer where cus_id=?;";

	/** Constant for validate card details query */
	public static final String VALIDATE_CARD_SQL = "select * from manage_card_customer where card_number=? and card_password=? ;";

	/** Constant for validate customer query */
	public static final String VALIDATE_CUSTOMER_SQL = "select * from customer where email=? and password=?";

	/** Constant for get customer details query */
	public static final String GET_CUSTOMER_INFO_SQL = "select * from customer where customer_id=?";

	/** Constant for get customer ids query */
	public static final String GET_CUSTOMER_IDS_SQL = "select customer_id from customer";

	/** Constant for customer id prefix */
	public static final String BANK_PREFIX = "BNK";
	
	/** Constant for card enabled */
	public static final String CARD_STATUS_ENABLE = "enable";
	
	/** Constant for card disabled */
	public static final String CARD_STATUS_DISABLE = "disable";
	
	/** Constant for form null value */
	public static final String FORM_VALUE_NULL = "error";

	/** Constant for update customer details */
	public static final String UPDATE_CUSTOMER_INFO_SQL = "update customer set name=?,mobile=?,email=?,address=?,password=? where customer_id=?";

	/** Constant for update customer details without password */
	public static final String UPDATE_CUSTOMER_INFO_NOPASS_SQL = "update customer set name=?,mobile=?,email=?,address=? where customer_id=?";

	/** Constant for validate customer password*/
	public static final String VALIDATE_CUSTOMER_PASSWORD = "select password from customer where customer_id=?";

	/** Constant for delete customer details */
	public static final String DELETE_CUSTOMER_PROFILE = "delete from customer where customer_id=?";
	
	/** Constant for delete customer card details */
	public static final String DELETE_MCUSTOMER_DETAILS = "delete from manage_card_customer where cus_id=?";
	
	/** Constant for disable customer card*/
	public static final String DISABLE_CARD_SQL="update manage_card_customer set activity=? where cus_id=? and card_number=?";

}