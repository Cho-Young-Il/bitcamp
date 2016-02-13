package container;

public class HamSand implements ISand{

	private String title;
	
	public HamSand(){
		this.title="햄";
		System.out.println("HamSand 기본 생성자 호출됨");
	}
	public HamSand(String title){
		this.title = title;
	}//생성자방법
	
	public void setTitle(String title){
		this.title=title;
	}//setter방법
	
	@Override
	public void info() {
		System.out.println(title);
	}
}
