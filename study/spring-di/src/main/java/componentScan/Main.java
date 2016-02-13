package componentScan;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String path = "componentScan/test.xml";
		ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext(path);
		
		Menu menu = container.getBean("menu", Menu.class);
		System.out.println("info ----------------------");
		menu.info();
		System.out.println("info ----------------------");
	}
}











