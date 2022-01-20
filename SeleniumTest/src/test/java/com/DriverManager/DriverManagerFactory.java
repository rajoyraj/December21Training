package com.DriverManager;

public class DriverManagerFactory {

	public static DriverManager getManager(String browserType) {

		DriverManager drivermanager = null;

		switch (browserType.toLowerCase()) {
		case "chrome":
			drivermanager = new ChromeDriverManager();
			break;
		case "edge":
			drivermanager = new EdgeDriverManager();
			break;

		default:

			System.out.println("no drivers found");

			break;
		}
		return drivermanager;

	}
}
