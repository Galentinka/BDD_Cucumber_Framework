package com.Utilities;

import java.util.Date;

public class Util {
	
	public static String emailWithDateStamp() {
		Date date = new Date();
		String timeStamp = date.toString().replace(" ", ":").replace(":", "_");
		return "galka" + timeStamp + "@gmail.com";
	}
	
	public static final int IMPLICIT_WAIT_TIME = 10;
	public static final int PAGE_LOAD_TIME = 200;
	public static final int SCRIPT_TIME= 1000;

}
