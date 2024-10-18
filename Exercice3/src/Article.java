
public class Article {

	private int IdArticle;
	private String Description;
	private String Brand;
	private float UnitaryPrice;
	
	public Article(int idArticle, String description, String brand, float unitaryPrice) {

		this.IdArticle = idArticle;
		this.Description = description;
		this.Brand = brand;
		this.UnitaryPrice = unitaryPrice;
	}
	
	

	@Override
	public String toString() {
		return "Article [IdArticle=" + IdArticle + ", Description=" + Description + ", Brand=" + Brand
				+ ", UnitaryPrice=" + UnitaryPrice + "]";
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

	public String getBrand() {
		return Brand;
	}

	public void setBrand(String brand) {
		Brand = brand;
	}

	public float getUnitaryPrice() {
		return UnitaryPrice;
	}

	public void setUnitaryPrice(float unitaryPrice) {
		UnitaryPrice = unitaryPrice;
	}
	
	
}
