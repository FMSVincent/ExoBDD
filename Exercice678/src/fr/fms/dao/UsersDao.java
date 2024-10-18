package fr.fms.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import fr.fms.entities.Article;
import fr.fms.entities.Users;

public class UsersDao implements Dao<Users> {


	static ArrayList<Users> users = new ArrayList<Users>();

	/**
	 * methode qui sert a afficher la liste des utilisateurs
	 */

	@Override
	public void display() {
		String strSql = "SELECT * FROM T_Users";
		try (java.sql.Statement statement = connection.createStatement()) {
			try (ResultSet resultSet = statement.executeQuery(strSql)) {
				while (resultSet.next()) {
					int rsIdUsers = resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					String rsPassword = resultSet.getString(3);
					users.add(new Users(rsLogin, rsPassword));
				}
			}
			for (Users user : users) {
				System.out.println(user);
			}
		} catch (SQLException e) {
			System.out.println("");
			logger.severe("pb lors de l'affichage des utilisateurs");
		}
	}

	/**
	 * methode qui sert a creer un utilisateur
	 * 
	 * @param objet user
	 */


	@Override
	public void create(Users user) {

		String strSql = "INSERT INTO T_Users (Login, password) VALUES (?, ?)";
		try (PreparedStatement ps = connection.prepareStatement(strSql)) {
			ps.setString(1, user.getLogin());
			ps.setString(2, user.getPassword());
			if (ps.executeUpdate() == 1) {
				System.out.println("insertion ok");
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("pb lors de la creation d'un article");
		}
	}

	/**
	 * methode qui sert a lire un utilisateur
	 */
	
	@Override
	public void read(int idUser) {
		String readArticleSQL = "SELECT * FROM T_Users WHERE IdUser = " + idUser;
		try (PreparedStatement preparedStatement = connection.prepareStatement(readArticleSQL)) {
			preparedStatement.setInt(1, idUser);
			try (ResultSet resultSet = preparedStatement.executeQuery()) {
				if (resultSet.next()) {
					int rsIdUser = resultSet.getInt(1);
					String rsLogin = resultSet.getString(2);
					System.out.println("Utilisateur : " + rsIdUser + ", " + rsLogin);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("pb lors de la récuperation d'un utilisateurs");
		}
	}

	/**
	 * methode qui sert a metter a jour un utilisateur
	 * 
	 * @param id utilisateur
	 */

	@Override
	public void update(int idUser) {
		try (Statement statement = connection.createStatement()) {
			String strSql = "UPDATE T_Users SET Login = 'New Login' WHERE IdUser = " + idUser;

			int row = statement.executeUpdate(strSql);
			if (row == 1)
				System.out.println("update OK");
		} catch (SQLException e) {
			e.printStackTrace();
			logger.severe("probleme lors de la mise a jour d'un utilisateur");
		}
	}

	/**
	 * methode qui sert a supprimer un utilisateur
	 * 
	 * @param id utilisateur
	 */

	@Override
	public void delete(int idUser) {
		try (Statement statement = connection.createStatement()) {
			String strSql = "DELETE FROM T_Users WHERE IdUser =" + idUser;

			int row = statement.executeUpdate(strSql);
			if (row == 1)
				System.out.println("DELETE OK");
		}

		catch (SQLException e) {
			e.printStackTrace();
			logger.severe("pb lors de la suppression d'un utilisateur");
		}

	}
	
}
