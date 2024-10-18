package fr.fms.buisness;

import fr.fms.entities.Article;

public interface Ishop {

	void displayArticle();
	Article addArticleToShopingCart(int idArticle);
	Boolean displayShoppingCard();
	
}