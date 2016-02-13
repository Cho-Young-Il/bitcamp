package member.test;

import member.controller.MemberController;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MemberTest {
	public static void main(String[] args) {
		//설정파일 로딩하기
		ApplicationContext container = 
				new ClassPathXmlApplicationContext(
				"config/spring/application-context.xml");
		MemberController control = 
				container.getBean("memberController", MemberController.class);
		try {
			control.retrieveMemberInfo("member-1");
			//control.registMember();
		} catch(Exception e) {
			e.printStackTrace();
		}	
	}
}