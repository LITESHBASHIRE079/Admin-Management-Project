package com.tka.utilities.prop;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropUtil {
	public static String valueofAnyKey(String Anykey) {
		InputStream inputstream= null;
		inputstream= PropUtil.class.getClassLoader().getResourceAsStream("config.properties");
		Properties properties = new Properties();
		try {
			properties.load(inputstream);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return properties.getProperty(Anykey);
	}

}
