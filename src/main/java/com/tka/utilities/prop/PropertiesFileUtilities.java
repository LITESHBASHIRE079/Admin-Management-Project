package com.tka.utilities.prop;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtilities {
	
	static FileInputStream fis = null;
	
	public static String url(){
		
		try {
			fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Java Projects\\AdminManagement\\src\\main\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		try {
			properties.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String url = properties.getProperty("url");
		
		return url;		
		
	}
	
	public static String username() {
		try {
			fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Java Projects\\AdminManagement\\src\\main\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		String usern = properties.getProperty("username");
		return usern;
	}
	
	public static String password() {
		try {
			fis = new FileInputStream("C:\\Users\\Lenovo\\Desktop\\Java Projects\\AdminManagement\\src\\main\\resources\\config.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Properties properties = new Properties();
		String passwd = properties.getProperty("password");
		return passwd;
	}

}
