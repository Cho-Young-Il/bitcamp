/*
    컨트롤러 실행 시작
	BoardController 실행완료
	BoardController 실행시간 : 4.276초
	MemberController 실행완료
	MemberController 실행시간 : 3.276초
 */
package basic4;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("컨트롤러 실행 시작");
			
			ProxyController ctrl = 
					new ProxyController(new BoardController());
			ctrl.execute();
			
			ctrl = new ProxyController(new MemberController());
			ctrl.execute();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
