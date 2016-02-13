package container;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main2 {
	public static void main(String[] args) {
//		String cpPath = "src/main/resources/container/container.xml";
//		System.out.println("컨테이너 로딩 전");
//		ApplicationContext container = 
//				new ClassPathXmlApplicationContext(cpPath);
//		System.out.println("컨테이너 로딩 종료");
		
		String cpPath = "src/main/resources/container/container.xml";
		System.out.println("컨테이너 로딩 전");
		ApplicationContext container = 
				new FileSystemXmlApplicationContext(cpPath);
		System.out.println("컨테이너 로딩 종료");
		
		ISand sand = (ISand)container.getBean("ham");
		sand.info();
		sand = (ISand)container.getBean("ham2");
		sand.info();
		sand = (ISand)container.getBean("ham3");
		sand.info();
		sand = (ISand)container.getBean("ham4");
		sand.info();
		sand = (ISand)container.getBean("#ham5");
		sand.info();
	}
}
