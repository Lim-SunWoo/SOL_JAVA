package mymain;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class TestProperties {
	public static void main(String[] args) {
		try {
			Properties prop = new Properties();
			InputStream is = new FileInputStream("src/mymain/db.properties");
			prop.load(is);
			
			String driver = prop.getProperty("driver");
			
			System.out.printf("Driver:%s\n", driver);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
