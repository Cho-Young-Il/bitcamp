package collection;

public class HamCheeseSand implements ISand{

	private String title;
	
	public HamCheeseSand(){
		System.out.println("HamCheeseSand 기본 생성자 호출됨");
	}
	
	public void setTitle(String title){
		this.title=title;
	}
	
	@Override
	public void info() {
		System.out.println(title);
	}
}
