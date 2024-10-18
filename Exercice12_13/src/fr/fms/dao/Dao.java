package fr.fms.dao;

import java.sql.Connection;
import java.util.logging.Logger;
import fr.fms.entities.BddConnexion;

public interface Dao<T> {
	public static Connection connection = BddConnexion.getInstanceConnexion();
	public static final Logger logger = Logger.getLogger(Dao.class.getName());
	void getAll();
	void delete(int entities);
	void update(int entities);
	void create(T entities);
	T read(T entities);
}
