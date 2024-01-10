package package2;

import package1.CoffeeMachine;

public class Discount {
	
	static double ttprice;
	
	public Discount(double ttprice){
		Discount.ttprice = ttprice;
	}
	
	public static double calculatePrice() {
		
		if(ttprice >= 5) {
		ttprice = Math.floor(ttprice);
		return ttprice;	
		}
		
		else { return CoffeeMachine.totalprice; }
	}

}