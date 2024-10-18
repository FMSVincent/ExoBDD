package fr.fms;

import java.sql.Connection;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.UsersDao;
import fr.fms.entities.BddConnexion;
import fr.fms.entities.Users;

public class Exercice9 {

	public static void main(String[] args) {

		Connection x = BddConnexion.getInstanceConnexion();
		Connection y = BddConnexion.getInstanceConnexion();
		Connection z = BddConnexion.getInstanceConnexion();

		System.out.println("Hashcode of x is " + x.hashCode());
		System.out.println("Hashcode of y is " + y.hashCode());
		System.out.println("Hashcode of z is " + z.hashCode());

		if (y == x && y == z)
			System.out.println("une seul connexion");
		else
			System.out.println("plusieurs connexion");

		// article
		ArticleDao reqArticleDao = new ArticleDao();
		reqArticleDao.display();
		reqArticleDao.delete(1);

		// user
		UsersDao reqUserDao = new UsersDao();
		reqUserDao.display();
		reqUserDao.create(new Users("logNewUser", "1234"));
		// reqUserDao.delete(2);
		reqUserDao.read(1);
		reqUserDao.update(1);

	}

}
