package autowired;

public class HamSand implements ISand{

	private String title;
	
	public void setTitle(String title){
		this.title=title;
	}//setter방법
	
	@Override
	public void info() {
		System.out.println(title);
	}
}
