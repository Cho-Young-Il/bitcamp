package setterInjection;

public class Menu {
	private String desc;
	private int price;
	private ISand sand;
	
	public Menu() {
		System.out.println("Menu 기본 생성자");
	}
	
	public Menu(String desc, int price) {
		this.desc = desc;
		this.price = price;
		System.out.println("Menu 다중 파라미터 생성자 호출");
	}
	
	public void printSand() {
		sand.info();
	}

	public void setDesc(String desc) {
		this.desc = desc;
		System.out.println("menu setDesc : " + desc);
	}

	public void setPrice(int price) {
		this.price = price;
		System.out.println("menu setPrice : " + price);
	}

	public void setSand(ISand sand) {
		this.sand = sand;
		System.out.println("menu setSand : " + sand);
	}
}
