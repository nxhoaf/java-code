package core;

import java.net.URL;

public class Validator {
	public int getInteger(String integer) {
		Integer i = new Integer(integer);
		return i;
	}
	public static boolean isValidUrlStatic(String url) {
		boolean isValid = false;
		try {
			new URL(url);
			isValid = true;
		} catch (Exception e) {}
		return isValid;
	}
	public boolean isValidUrl(String url) {
		boolean isValid = false;
		try {
			new URL(url);
			isValid = true;
		} catch (Exception e) {}
		return isValid;
	}
	public static boolean isValidIntegerStatic(String integer) {
		return isValidIntegerPrivateStatic(integer);
	}
	private static boolean isValidIntegerPrivateStatic(String integer) {
		boolean isValid = false;
		try {
			Integer.parseInt(integer);
			isValid = true;
		} catch (Exception e) {}
		return isValid;
	}
	public boolean isValidInteger(String integer) {
		return isValidIntegerPrivate(integer);
	}
	private boolean isValidIntegerPrivate(String integer) {
		boolean isValid = false;
		try {
			Integer.parseInt(integer);
			isValid = true;
		} catch (Exception e) {}
		return isValid;
	}
}
