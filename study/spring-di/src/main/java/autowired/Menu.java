package autowired;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Menu {
	private ISand sand;
	private ColaDrink colaDrink;
	
	public Menu() {
		System.out.println("Menu 기본 생성자");
	}
	
	public void printSand() {
		sand.info();
	}

	@Autowired
	@Qualifier("cheese")
	public void setSand(ISand sand) {
		this.sand = sand;
	}
	
	@Autowired
	public void setColaDrink(ColaDrink colaDrink) {
		this.colaDrink = colaDrink;
	}
	
	public void info() {
		sand.info();
		colaDrink.info();
	}
}
