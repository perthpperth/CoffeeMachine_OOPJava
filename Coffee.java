package package2;

public class Coffee extends Drink {
	private String type;
	
	public Coffee(String name, double price, String type) {
		super(name, price);
		this.type = type;
	}
	public String getCoffeeType() {
		return type;
	}
}

