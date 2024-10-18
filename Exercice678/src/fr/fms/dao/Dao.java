package fr.fms.dao;

import java.sql.Connection;
import java.util.Set;
import java.util.logging.Logger;
import fr.fms.entities.BddConnexion;

public interface Dao<T> {
	public static Connection connection = BddConnexion.getConnexion();
	public static final Logger logger = Logger.getLogger(Dao.class.getName());
	void display();
	void delete(int entities);
	void update(int entities);
	void create(T entities);
	void read(int article);
}
