package fr.fms.buisness;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import fr.fms.entities.Article;

public class ShopBuisness implements Ishop {

	public static Map<Integer, Article> articles = new HashMap<Integer, Article>();
	public static List<Article> shopingCart = new ArrayList<Article>();

	/**
	 * methode qui sert a afficher les articles
	 */
	@Override
	public void displayArticle() {
		if (articles.size() > 0) {
			articles.forEach((key, value) -> {
				System.out.println(value);
			});
		} else
			System.out.println("pas d'article a afficher");
	}

	/**
	 * methode qui sert a acheter un article
	 * 
	 * @param int id de l'article
	 */

	@Override
	public Article addArticleToShopingCart(int idArticle) {
		Article articleBought = articles.get(idArticle);
		shopingCart.add(articleBought);
		if (articleBought == null)
			return null; // je peux creer une class articleException
		return articleBought;
	}
	
	public Boolean deleteArticleInShopingCart(int idArticle) {
		boolean isDelete = false;
		for (int i = 0; i < shopingCart.size(); i++) {
			if(shopingCart.get(i).getIdArticle() == idArticle) {
				shopingCart.remove(i);
				isDelete = true;
				break;
			}
		}
		return isDelete;
	}

	/**
	 * methode qui affiche le panier du client
	 */

	@Override
	public Boolean displayShoppingCard() {
		if (shopingCart.size() > 0) {
			shopingCart.forEach(value -> System.out.println(value));
			return true;
		}
		return false;
	}
}
