package setterInjection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String cPath = "setterInjection/test.xml";
		System.out.println("컨테이너로딩 전");
		ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext(cPath);
		System.out.println("컨테이너 로딩 완료");
		
	}
}
