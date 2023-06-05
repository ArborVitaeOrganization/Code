package model.bean;

public class Products {
	
	public Products(int co, int cp, String n, String s, String c, String o, String d, int q, double p)
	{
		codeOrder = co;
		codeProduct = cp;
		name = n;
		species = s;
		country = c;
		co2 = o;
		description = d;
		quantity = q;
		price = p;
	}
	
	

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSpecies() {
		return species;
	}
	public void setSpecies(String species) {
		this.species = species;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getCo2() {
		return co2;
	}
	public void setCo2(String co2) {
		this.co2 = co2;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String des) {
		this.description = des;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}

	public int getCodeOrder() {
		return codeOrder;
	}
	
	public void setCodeOrder(int co) {
		codeOrder=co;
	}

	public int getCodeProduct() {
		return codeProduct;
	}

	public void setCodeProduct(int c) {
		codeProduct=c;
	}

	private String name, species, country, co2, description;
	private int codeOrder, codeProduct, quantity;
	private double price;
}
