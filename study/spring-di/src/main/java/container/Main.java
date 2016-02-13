package container;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.FileSystemResource;

public class Main {
	public static void main(String[] args) {
		/*
		//클래스 패스 기준으로 xml 파일 로딩하기
		String cpPath = "container/container.xml";
		
		//File을 읽어서 로딩하는 Resource 객체
		ClassPathResource cpr = new ClassPathResource(cpPath);
		
		// 컨테이너 : BeanFactory
		System.out.println("컨테이너 로딩 전");
		BeanFactory container = new XmlBeanFactory(cpr);
		
		System.out.println("컨테이너 로딩 종료");
		
		//Bean 객체 접근하기
		HamSand ham = (HamSand)container.getBean("ham");
		ham.info();
		*/
		
		// 파일 시스템 기준으로 xml 파일 로딩하기
		String cpPath = "src/main/resources/container/container.xml";
		
		//File을 읽어서 로딩하는 Resource 객체
		FileSystemResource cpr = new FileSystemResource(cpPath);
		
		// 컨테이너 : BeanFactory
		System.out.println("컨테이너 로딩 전");
		BeanFactory container = new XmlBeanFactory(cpr);
		
		System.out.println("컨테이너 로딩 종료");
		
		//Bean 객체 접근하기
		HamSand ham = (HamSand)container.getBean("ham");
		ham.info();
	}
}
