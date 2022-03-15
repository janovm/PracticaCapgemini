package conexiones;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Properties;

public class ConfigDir {
	private Properties prop;
	private static ConfigDir config;

	public ConfigDir() throws NoSuchFieldException, SecurityException, IOException {
		prop = new Properties();
		InputStream is = getClass().getResourceAsStream("properties.properties");
		prop.load(is);
	}

	public ArrayList<String> getData() {
		ArrayList<String> datos = new ArrayList<>();
		datos.add(prop.getProperty("url"));
		datos.add(prop.getProperty("username"));
		datos.add(prop.getProperty("dbpassword"));
		datos.add(prop.getProperty("queryListar"));
		datos.add(prop.getProperty("queryAdd"));
		datos.add(prop.getProperty("queryDelete"));
		datos.add(prop.getProperty("queryUpdate"));
		datos.add(prop.getProperty("querySQL"));
		return datos;
	}

	public static ConfigDir getInstance() {
		try {
			config = new ConfigDir();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return config;
	}
}
