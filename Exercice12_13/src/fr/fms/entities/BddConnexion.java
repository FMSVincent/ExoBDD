package fr.fms.entities;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class BddConnexion {

	private static Connection connexion = null;

	// attribut private static
	// je rends le constructeur privé
	// methode pour publier vers lexterieur
	// lazy? ne sois invoqué qu une fois ?

	private BddConnexion() {
	}

	public static synchronized Connection getInstanceConnexion() {

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

	public static synchronized Connection closeConnection() {
		if (connexion != null) {
			try {
				connexion.close();
				connexion = null;
				System.out.println("Database connection closed.");
			} catch (SQLException e) {
				System.err.println("Error closing the database connection: " + e.getMessage());
				e.printStackTrace();
			}
		} else {
			System.out.println("No active database connection to close.");
		}
		return connexion;
	}

}
