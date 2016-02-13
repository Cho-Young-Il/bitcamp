package configDivide;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String cPath = "configDivide/config2.xml";
		System.out.println("컨테이너로딩 전");
		ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext(
//						new String[] {
//								"configDivide/config1.xml",
//								"configDivide/config2.xml"
//						}
						"configDivide/config3.xml");
		System.out.println("컨테이너 로딩 완료");

		Menu menu = (Menu)container.getBean("menu");
		menu.info();
	}
}