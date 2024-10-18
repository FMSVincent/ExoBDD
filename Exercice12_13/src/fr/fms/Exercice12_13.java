package fr.fms;

import java.sql.Connection;
import java.util.Scanner;

import fr.fms.buisness.ShopBuisness;
import fr.fms.dao.ArticleDao;
import fr.fms.dao.UsersDao;
import fr.fms.entities.Article;
import fr.fms.entities.BddConnexion;
import fr.fms.entities.Users;

public class Exercice12_13 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		UsersDao reqUserDao = new UsersDao();

		System.out.print("Login : ");
		String login = sc.nextLine();
		System.out.print("password : ");
		String password = sc.nextLine();

		Users user = new Users(login, password);

		if (reqUserDao.read(user) != null) {
			Connection isConnected = BddConnexion.getInstanceConnexion();
			ArticleDao reqArticlesDao = new ArticleDao();
			ShopBuisness reqArticleBuisness = new ShopBuisness();
			reqArticlesDao.getAll();

			int inputChoiceMenu = 0;
			int inputShopingCart = 0;

			// avant d'acheter ajouter au panier
			// dans panier pouvoir acheter

			while (inputChoiceMenu != 6 && isConnected != null) {
				System.out.println(
						"-- 1 Afficher les articles, -- 2 ajouter au panier, -- 3 Gerer mon panier  -- 6 se déconnecter");
				inputChoiceMenu = sc.nextInt();

				switch (inputChoiceMenu) {
				case 1:
					System.out.println("Liste des articles");
					reqArticleBuisness.displayArticle();
					sc.nextLine();
					break;

				case 2:
					System.out.println("rentrer id de l'article a ajouter au panier");
					int inputdIdArticleBought = sc.nextInt();
					Article ar = reqArticleBuisness.addArticleToShopingCart(inputdIdArticleBought);
					System.out.println(ar);
					sc.nextLine();
					break;
					
				case 3:
					
					while (inputShopingCart != 3) {
						System.out.println("-- 1 Afficher mon panier, -- 2 supprimer un article du panier, -- 3 quitter");
						inputShopingCart = sc.nextInt();
						switch (inputShopingCart) {

						case 1:
							System.out.println("Liste des articles du panier");
							reqArticleBuisness.displayShoppingCard();
							sc.nextLine();
							break;

						case 2:
							System.out.println("id de larticle a supprimer");
							int inputIdArtiToDelete = sc.nextInt();
							reqArticleBuisness.deleteArticleInShopingCart(inputIdArtiToDelete);
							reqArticleBuisness.displayShoppingCard();
							sc.nextLine();
							break;
							
						case 3:
							inputShopingCart = 3;
							inputChoiceMenu = 0;
							sc.nextLine();
							break;

						default:
							inputShopingCart = 3;
							inputChoiceMenu = 0;
							sc.nextLine();
							break;
						}
					} break;

				case 6:
					isConnected = BddConnexion.closeConnection();
					System.out.println("Disconnected !");
					break;
				default:
					break;
				}
			}

		} else {
			System.out.println("Impossible Connection !");
		}
		sc.close();
	}

}
