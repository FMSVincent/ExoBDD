package fr.fms.entities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnexion {

	public static Connection connexion = null;

	public static Connection getConnexion() {

		if (connexion == null) {
			try {
				Properties prop = CreateConfigFile.readPropertiesFile(
						"C:\\Users\\BickelV\\Desktop\\Fms_formation\\S7\\ExBdd\\Exercice9\\credentials.properties");

				Class.forName(prop.getProperty("db.driver.class"));

				connexion = DriverManager.getConnection(prop.getProperty("db.url"), prop.getProperty("db.username"),
						prop.getProperty("db.password"));
				System.out.println("Connected BDD");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("Cant connect BDD" + e.getMessage());
			} catch (IOException e) {
				System.out.println("cant read config file" + e.getMessage());
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		return connexion;
	}

}
