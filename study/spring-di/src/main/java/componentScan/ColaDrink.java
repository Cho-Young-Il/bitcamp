package componentScan;

import org.springframework.stereotype.Component;

@Component
public class ColaDrink {
	private String title;
	public ColaDrink () {}
	public void setTitle(String title) {
		this.title = title;
	}
	public void info() {
		System.out.println(title);
	}
}
