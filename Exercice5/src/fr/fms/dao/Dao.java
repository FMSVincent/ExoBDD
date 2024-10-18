package fr.fms.dao;

import java.sql.Connection;
import java.util.logging.Logger;

import fr.fms.entities.Article;
import fr.fms.entities.BddConnexion;

public interface Dao<T> {
	public static Connection connection = BddConnexion.getConnexion();
	public static final Logger logger = Logger.getLogger(Dao.class.getName());
	void displayArticles();
	void deleteArticle(int article);
	void updateArticle(int article);
	void createArticle(Article article);
	void readArticle(int article);
}
