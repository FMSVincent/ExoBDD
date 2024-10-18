package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;

public class ArticleDao implements Dao<Article> {

	static ArrayList<Article> articles = new ArrayList<Article>();

	/**
	 * methode qui sert a afficher la liste des articles
	 */

	@Override
	public void display() {
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
			for (Article article : articles) {
				System.out.println(article);
			}
		} catch (SQLException e) {
			System.out.println("");
			logger.severe("pb lors de l'affichage des articles");
		}
	}

	/**
	 * methode qui sert a creer un article et l'inserer en BDD
	 * 
	 * @param url
	 * @param login
	 * @param password
	 */


	@Override
	public void create(Article article) {

		String strSql = "INSERT INTO T_Articles (Description, Brand, UnitaryPrice) VALUES (?, ?, ?)";
		try (PreparedStatement ps = connection.prepareStatement(strSql)) {
			ps.setString(1, article.getDescription());
			ps.setString(2, article.getBrand());
			ps.setLong(3, (long) article.getUnitaryPrice());
			if (ps.executeUpdate() == 1) {
				System.out.println("insertion ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("pb lors de la creation d'un article");
		}
	}

	/**
	 * methode qui sert a lire un article
	 */
	
	@Override
	public void read(int idArticle) {
		String readArticleSQL = "SELECT * FROM T_Articles WHERE idArticle = " + idArticle;
		try (PreparedStatement preparedStatement = connection.prepareStatement(readArticleSQL)) {
			preparedStatement.setInt(1, idArticle);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					int rsIDArticle = resultSet.getInt(1);
					String rsDescription = resultSet.getString(2);
					String rsMarque = resultSet.getString(3);
					int rsPrixUnitaire = resultSet.getInt(4);
					System.out.println("article selectionné : " + rsIDArticle + " - " + rsDescription + " - " + rsMarque
							+ " - " + rsPrixUnitaire);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("pb lors de la récuperation d'un article");
		}
	}

	/**
	 * methode qui sert a metter a jour un article
	 * 
	 * @param url
	 * @param login
	 * @param password
	 */

	@Override
	public void update(int idArticle) {
		try (Statement statement = connection.createStatement()) {
			String strSql = "UPDATE T_Articles SET Description = 'nouvelle description', "
					+ "Brand = 'Logitech', UnitaryPrice = 500 " + "WHERE IdArticle = "+idArticle;

			int row = statement.executeUpdate(strSql);
			if (row == 1)
				System.out.println("update OK");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("probleme lors de la mise a jour d'un article");
		}
	}

	/**
	 * methode qui sert a supprimer un article
	 * 
	 * @param url
	 * @param login
	 * @param password
	 */

	@Override
	public void delete(int idArticle) {
		try (Statement statement = connection.createStatement()) {
			String strSql = "DELETE FROM T_Articles WHERE IdArticle =" + idArticle;

			int row = statement.executeUpdate(strSql);
			if (row == 1)
				System.out.println("DELETE OK");
		}

		catch (SQLException e) {
			e.printStackTrace();
			logger.severe("pb lors de la suppression d'un article");
		}

	}
}
