/*
    컨트롤러 실행 시작
	BoardController 실행완료
	BoardController 실행시간 : 4.276초
	MemberController 실행완료
	MemberController 실행시간 : 3.276초
 */
package basic3;

public class Main {
	public static void main(String[] args) {
		try {
			System.out.println("컨트롤러 실행 시작");
			
			Controller ctrl = new BoardController();
			long s = System.currentTimeMillis();
			ctrl.execute();
			double time = (System.currentTimeMillis() - s) / 1000d;
			System.out.println("BoardController 실행시간 : " + time);
			
			ctrl = new MemberController();
			s = System.currentTimeMillis();
			ctrl.execute();
			time = (System.currentTimeMillis() - s) / 1000d;
			System.out.println("MemberController 실행시간 : " + time);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
