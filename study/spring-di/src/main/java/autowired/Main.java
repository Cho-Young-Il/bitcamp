package autowired;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String cPath = "autowired/test2.xml";
		System.out.println("컨테이너로딩 전");
		ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext(cPath);
		System.out.println("컨테이너 로딩 완료");
		
		Menu menu = container.getBean("menu", Menu.class);
		menu.info();
	}
}