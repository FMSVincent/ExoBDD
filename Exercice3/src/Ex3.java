import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class Ex3 {

	/**
	 * • Exercice 3 : Nous souhaitons maintenant, toujours sous Eclipse, réaliser
	 * une requête d’insertion d’un article, une autre de mise à jour, une autre qui
	 * supprime un article et une dernière qui nous renvoi toutes les infos d’un
	 * article. Vous devez afficher tous vos articles sous Eclipse ou vérifier en
	 * ligne de commande que cela a fonctionné en base.
	 */

	public static void main(String[] args) {
		ArrayList<Article> articles = new ArrayList<Article>();

		try {
			Class.forName("org.mariadb.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}

		// récuperer une connection
		String url = "jdbc:mariadb://localhost:3306/shop";
		String login = "root";
		String password = "fms2024";
		
//		// methode qui permet de creer un article
//		createArticle(url, login, password);
//		
//		// methode qui permet de mettre a jour un article
//		updateArticle(url, login, password);
//
//		
//		// methode qui permet la Suppresion d'un article
//		deleteArticle(url, login, password);
//	
		// afficher les articles
//		displayArticles(url, login, password, articles);

	}
	
	// afficher les articles
	public static void displayArticles(String url, String login, String password, ArrayList<Article> articles) {
		try (Connection connection = DriverManager.getConnection(url, login, password)) {
			String strSql = "SELECT * FROM T_Articles";
		try (java.sql.Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
					while (resultSet.next()) {
						int rsIdArticle = resultSet.getInt(1);
						String rsDescription = resultSet.getString(2);
						String rsBrand = resultSet.getString(3);
						float rsPrice = resultSet.getFloat(4);
						articles.add(new Article(rsIdArticle, rsDescription, rsBrand, rsPrice));
					}
				}
			}
			for (Article article : articles) {
				System.out.println(article);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	// inserer un article
	public static void createArticle(String url, String login, String password) {
		try(Connection connection = DriverManager.getConnection(url, login, password)) {
			String strSql = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?)";
			try(PreparedStatement ps = connection.prepareStatement(strSql)) {
				ps.setString(1, "Atari");
				ps.setString(2, "Pac man");
				ps.setLong(3, 150);
				if(ps.executeUpdate() == 1) {
					System.out.println("insertion ok");
				}
			}
		}catch(SQLException e) {
			e.printStackTrace();	
			}
	}
	
	// update un article
	public static void updateArticle(String url, String login, String password) {
		try (Connection connection = DriverManager.getConnection(url, login, password)) {
			try (Statement statement = connection.createStatement()) {
				String strSql = "UPDATE T_Articles SET Description = 'nouvelle description', " +
		                "Brand = 'Logitech', UnitaryPrice = 500 " +
		                "WHERE IdArticle = 1";

				int row = statement.executeUpdate(strSql);
				if (row == 1)
					System.out.println("update OK");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// suppression d'un article
	public static void deleteArticle(String url, String login, String password) {
		try (Connection connection = DriverManager.getConnection(url, login, password)) {

			try (Statement statement = connection.createStatement()) {
				String strSql = "DELETE FROM T_Articles WHERE IdArticle = 1";

				int row = statement.executeUpdate(strSql);
				if (row == 1)
					System.out.println("DELETE OK");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	
	}
}
