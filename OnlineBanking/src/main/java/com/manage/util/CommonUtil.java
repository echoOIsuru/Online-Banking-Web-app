/**
 * OOP PROJECT 2021
 * @author IT20133290 R.M.Isuru Sahan Kumarasingha
 */
package com.manage.util;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Properties;

public class CommonUtil {

	public static final Properties properties = new Properties();

	static {
		try {
			// Read the property only once when load the class
			properties.load(CommonUtil.class.getResourceAsStream(CommonConstants.PROPERTY_FILE));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/* Use to generate customer id
	 * @param ArrayList
	 * @return String id
	 */
	public static String generateIDs(ArrayList<String> arrayList) {

		String id;
		int next = arrayList.size();
		next++;
		id = CommonConstants.BANK_PREFIX + next;
		while (arrayList.contains(id)) {
			next++;
			id = CommonConstants.BANK_PREFIX + next;
		}
		return id;
	}

	/*Use to check user's card count
	 * @param card count
	 * @return integer
	 */
	public static int getCardResult(int Number) {
		int valid = 0;

		if (Number < 3) {
			valid = 2;
		} else {
			valid = 3;
		}

		return valid;
	}

	/*
	 * Use to encrypt the password
	 */
	public static String passwordHash(String pass) {

		MessageDigest message;
		StringBuilder sb = new StringBuilder();
		try {
			message = MessageDigest.getInstance("MD5");

			message.update(pass.getBytes());

			byte[] array = message.digest();// get result to byte array

			for (byte b : array) {
				sb.append(String.format("%02x", b));// hexadecimal convert to the string
			}

		} catch (NoSuchAlgorithmException e) {

			e.printStackTrace();
		}

		return sb.toString();
	}

}
