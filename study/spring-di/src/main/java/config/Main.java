package config;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		String cPath = "config/test.xml";
		System.out.println("컨텍스트 로딩 전");
		ClassPathXmlApplicationContext container = 
				new ClassPathXmlApplicationContext(cPath);
		System.out.println("컨텍스트 로딩 완료");
		
		ConfigTest configTest = (ConfigTest)container.getBean("config1");
		System.out.println("user : " + configTest.getUser());
		System.out.println("pass : " + configTest.getPass());
	}
}
