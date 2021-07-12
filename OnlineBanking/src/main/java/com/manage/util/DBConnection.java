/**
 * OOP PROJECT 2021
 * @author IT20133290 R.M.Isuru Sahan Kumarasingha
 */
package com.manage.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//Using singleton pattern

public class DBConnection extends CommonUtil {

	private static Connection con;

	// Avoid create new instance
	private DBConnection() {
	}

	public static Connection getConnection() throws ClassNotFoundException, SQLException {

		if (con == null || con.isClosed()) {

			Class.forName(properties.getProperty(CommonConstants.DRIVER_NAME));
			con = DriverManager.getConnection(properties.getProperty(CommonConstants.URL),
					properties.getProperty(CommonConstants.USERNAME), properties.getProperty(CommonConstants.PASSWORD));
		}

		return con;
	}

}
