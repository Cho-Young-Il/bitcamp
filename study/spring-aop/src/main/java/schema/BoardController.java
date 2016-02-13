package schema;

import java.util.Random;

public class BoardController implements Controller {

	@Override
	public String execute() throws Exception {
		
		Random r = new Random();
		for (int i = 1; i < 10; i++) {
			int num = r.nextInt(100) + 1;
			Thread.sleep(num);
		}
		System.out.println("BoardController 실행완료");
		
		return "board";
	}
	
}






