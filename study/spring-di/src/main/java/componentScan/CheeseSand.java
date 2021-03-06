package componentScan;

import org.springframework.stereotype.Component;

@Component
public class CheeseSand implements ISand {
	private String title;
	public CheeseSand() {
		System.out.println("CheeseSand 기본 생성자 호출됨");
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public void info() {
		System.out.println(title);
	}
}
