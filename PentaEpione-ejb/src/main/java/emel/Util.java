package emel;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.TimeZone;

public class Util {
	
	public static Date getDateNowUTC() {
		Date nowUTC = new Date();
		try {
			DateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			formatter.setTimeZone(TimeZone.getTimeZone("UTC"));
			nowUTC = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(formatter.format(new Date()));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return nowUTC;
	}
	
	public static Date NbrHour(Date d,int nbrHours) {
		if(d == null)
			return null;
		return new Date(d.getTime() + nbrHours * (3600*1000)); //+ nbrHours 
	}
	public static Date NbrMinutes(Date d,int nbrMinutes) {
		if(d == null)
			return null;
		return new Date(d.getTime() + nbrMinutes * (60000)); //+ nbrHours 
	}
	

		public static String hashPassword(String input) {
			MessageDigest messageDigest;
			try {
				messageDigest = MessageDigest.getInstance("SHA-512");
				byte[] bytes = messageDigest.digest(input.getBytes());
				BigInteger integer = new BigInteger(1, bytes);
				String result = integer.toString(16);
				while (result.length() < 128) {
					result = "0" + result;
				}
				return result;
			} catch (NoSuchAlgorithmException e) {
				e.printStackTrace();
				return input;
			}
		}
		
		public static String getSaltString() {
			String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890abcdefghijklmnopqrstuvwxyz";
			StringBuilder salt = new StringBuilder();
			Random rnd = new Random();
			while (salt.length() < 10) { // length of the random string.
				int index = (int) (rnd.nextFloat() * SALTCHARS.length());
				salt.append(SALTCHARS.charAt(index));
			}
			String saltStr = salt.toString();
			return saltStr;
		}
	
}