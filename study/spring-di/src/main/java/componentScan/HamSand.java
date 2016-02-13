package componentScan;

import org.springframework.stereotype.Component;

/*
 *  빈으로 자동 등록됨
 *  <bean id="hamSand" class="componentScan.HamSand" /> 
 */
@Component("ham")
public class HamSand implements ISand {
	private String title;
	public HamSand() {
		System.out.println("HamSand 기본 생성자 호출됨");
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public void info() {
		System.out.println(title);
	}
}
