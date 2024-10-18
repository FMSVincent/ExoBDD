import java.util.ArrayList;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Ex2 {

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
		
		try(Connection connection = DriverManager.getConnection(url, login, password)){
			String strSql = "SELECT * FROM T_Articles";
			try(java.sql.Statement statement = connection.createStatement()) {
				try(ResultSet resultSet = statement.executeQuery(strSql)) {
					while(resultSet.next()) {
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

}
