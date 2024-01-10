package package2;

public class Drink {
	protected String name;
	public double price;
	
	public Drink(String name, double price){
		this.name = name;
		this.price = price;
	}
	
	public String getDrinkType() {
		return name;
	}
	
	public double getDrinkPrice() {
		return price;
	}
	
}
