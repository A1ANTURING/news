package com.ht.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;


public class PropertiesUtil {
	public static String getValue(String key) throws IOException{
		Properties properties = new Properties();
		InputStream inputStream = PropertiesUtil.class.getResourceAsStream("/news.properties");
		properties.load(inputStream);
		String value = properties.getProperty(key);
		return value ;
	}
	
	public static void main(String[] args) throws IOException {
		System.out.println(getValue("dbUrl"));
	}
}
