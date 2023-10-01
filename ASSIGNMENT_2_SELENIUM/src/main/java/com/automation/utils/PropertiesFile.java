package com.automation.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFile {
	
	//Lấy ra các config
	public static String getConfigs (String key) throws IOException {
		FileInputStream fis = null; 
		String value = null;
		try {
			fis = new FileInputStream("./Configuration/Config.properties");
			Properties config = new Properties();
			config.load(fis);
			return value = config.getProperty(key);
			
		} catch (IOException e) {
			System.out.println("An error occurred when reading value of " + key);
			e.printStackTrace();
		} finally {
			if (fis != null) {
				fis.close();
			}
		}	
		return value; 	
	}
	//Lấy ra các element locator
	public static String getElements (String key) throws IOException {
		
		FileInputStream fis = null;
		String value = null;
		
		try {
			fis = new FileInputStream("./Configuration/Element.properties");
			Properties element = new Properties();
			element.load(fis);
			return value = element.getProperty(key);
		} catch (FileNotFoundException e) {
			System.out.println("An error occurred when reading value of " + key);
			e.printStackTrace();
		} finally {
			if(fis != null) {
				fis.close();
			}
		}
		return value;
	}
	
}
