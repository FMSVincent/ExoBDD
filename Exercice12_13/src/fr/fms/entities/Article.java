package fr.fms.entities;

public class Article {
	
	int IdArticle;
	String Description;
	float UnitaryPrice;
	String Brand;
	
	public Article(int idArticle, String description,String brand, float rsPrice ) {
		
		IdArticle = idArticle;
		Description = description;
		UnitaryPrice = rsPrice;
		Brand = brand;
	}
	
	public Article(String description,String brand, int unitaryPrice ) {
		Description = description;
		UnitaryPrice = unitaryPrice;
		Brand = brand;
	}

	@Override
	public String toString() {
		return "Article [ID=" + IdArticle + ", Description=" + Description + ", UnitaryPrice=" + UnitaryPrice
				+ ", Brand=" + Brand + "]";
	}

	public int getIdArticle() {
		return IdArticle;
	}

	public void setIdArticle(int idArticle) {
		IdArticle = idArticle;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	public float getUnitaryPrice() {
		return UnitaryPrice;
	}

	public void setUnitaryPrice(int unitaryPrice) {
		UnitaryPrice = unitaryPrice;
	}

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}
	
	

}