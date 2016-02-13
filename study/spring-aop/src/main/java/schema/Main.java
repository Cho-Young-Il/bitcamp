/*
    컨트롤러 실행 시작
	BoardController 실행완료
	BoardController 실행시간 : 4.276초
	MemberController 실행완료
	MemberController 실행시간 : 3.276초
 */
package schema;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
	public static void main(String[] args) {
		try {
			ApplicationContext container = 
					new ClassPathXmlApplicationContext(
							"schema/test.xml");
			Controller ctrl = 
					container.getBean("board", Controller.class);
			System.out.println(ctrl.execute());
			
			ctrl = container.getBean("member", Controller.class);
			System.out.println(ctrl.execute());
			
			/*
			핵심 기능 구현 클래스 타입으로 호출하기 위해서는
			aop:config 태그에 
			proxy-target-class="true" 설정 후 가능함
			
			Controller ctrl = 
				container.getBean("board", BoardController.class);
			ctrl.execute();
			
			ctrl = container.getBean("member", MemberController.class);
			ctrl.execute();
			*/
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
