package collection;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String cPath = "collection/test.xml";
		System.out.println("컨테이너로딩 전");
		ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext(cPath);
		System.out.println("컨테이너 로딩 완료");
		
		Menu menu = (Menu)container.getBean("menu");
		System.out.println("list-----------");
		menu.printList();
		System.out.println("set------------");
		menu.printSet();
		System.out.println("map------------");
		menu.printMap();
		System.out.println("prop-----------");
		menu.printProperties();
	}
}
