package fr.fms.dao;

import java.sql.Connection;
import java.util.logging.Logger;
import fr.fms.entities.BddConnexion;
import fr.fms.entities.Users;

public interface Dao<T> {
	public static Connection connection = BddConnexion.getInstanceConnexion();
	public static final Logger logger = Logger.getLogger(Dao.class.getName());
	void display();
	void delete(int entities);
	void update(int entities);
	void create(T entities);
	T read(T entities);
}
