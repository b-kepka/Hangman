package src;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Properties;
import java.util.Random;

public class Hasla {
	ArrayList<String> array = new ArrayList<>();
	Random random = new Random();
	String randomPassword;
	Properties prop = new Properties();
	public Hasla(){
		choosePassword();
	}
	public void choosePassword() {
		try {
			FileInputStream fileInput = new FileInputStream("src/hasla.properties");
			prop.load(fileInput);
			prop.keySet().forEach(key -> array.add(prop.getProperty(key.toString())));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
		int randomIndex = random.nextInt(array.size());
		randomPassword = array.get(randomIndex);
	}
}
