package constructorInjection;

public class ColaDrink {
	private String drink;
	
	public ColaDrink() {}
	public ColaDrink(String drink) {
		this.drink = drink;
		System.out.println("ColaDring String 생성자 호출됨 : " + drink);
	}
	public String getDrink() {
		return drink;
	}
	public void setDrink(String drink) {
		this.drink = drink;
	}
}
