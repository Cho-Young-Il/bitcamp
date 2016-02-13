package basic;

import java.util.Random;

public class BoardController implements Controller {

	@Override
	public void execute() throws Exception {
		
		Random r = new Random();
		for (int i = 1; i < 100; i++) {
			int num = r.nextInt(100) + 1;
			Thread.sleep(num);
		}
		System.out.println("BoardController 실행완료");
		
	}
	
}






