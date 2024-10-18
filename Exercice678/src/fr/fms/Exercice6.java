package fr.fms;

import java.sql.Connection;

import fr.fms.dao.ArticleDao;
import fr.fms.dao.Dao;
import fr.fms.dao.UsersDao;
import fr.fms.entities.Users;

public class Exercice6 {

	public static void main(String[] args) {
		
		// article
		ArticleDao reqArticleDao = new ArticleDao();
		reqArticleDao.display();
		reqArticleDao.delete(1);

		
		// user
		UsersDao reqUserDao = new UsersDao();
		reqUserDao.display();
		reqUserDao.create(new Users("logNewUser", "1234"));
		reqUserDao.delete(2);
		reqUserDao.read(1);
		reqUserDao.update(1);

	}

}
