package lab7_SELENIUM_library;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileUtils {
	
	public static String getConfigProperty(String key) throws IOException {
		
		File f = new File("./Configuration/configs.properties");
		FileReader fr = new FileReader(f);
		Properties config = new Properties();
		config.load(fr);
		return config.get(key).toString();

	}
	
	public static String getElementProperty(String key) {
		
		String value = null;
		FileInputStream fis = null;
		
		try {
			fis = new FileInputStream("./ElementLocator/Element.properties");
			Properties element = new Properties();
			element.load(fis);
			return value = element.getProperty(key);
		} catch (IOException e) {
			System.out.print("An error occurred when reading value of " + key);
			e.printStackTrace();
		} finally {
			if (fis != null) {
				
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
		return value;
	}
}
