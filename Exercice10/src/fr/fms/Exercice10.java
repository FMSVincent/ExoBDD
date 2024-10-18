package fr.fms;

import java.util.Scanner;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.UsersDao;
import fr.fms.entities.BddConnexion;
import fr.fms.entities.Users;

public class Exercice10 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UsersDao reqUserDao = new UsersDao();
		
		
		System.out.print("Login : ");
		String login = sc.nextLine();
		System.out.print("password : ");
		String password =sc.nextLine();
		
		Users user = new Users(login, password);
		
		if (reqUserDao.read(user) != null) {
			ArticleDao getArticle = new ArticleDao();
			getArticle.display();
		}else {
			System.out.println("Impossible de se connecter !");
			BddConnexion.closeConnection();
		}
		sc.close();
	}

}
