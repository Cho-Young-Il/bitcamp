package configDivide;

public class Menu {
	private String desc;
	private int price;
	private ISand sand;
	private ColaDrink colaDrink;
	
	public Menu() {
		System.out.println("Menu 기본 생성자");
	}
	
	public void printSand() {
		sand.info();
	}

	public void setSand(ISand sand) {
		this.sand = sand;
		System.out.println("menu setSand : " + sand);
	}
	
	public void setColaDrink(ColaDrink colaDrink) {
		this.colaDrink = colaDrink;
	}
	
	public void info() {
		sand.info();
		colaDrink.info();
	}
}
