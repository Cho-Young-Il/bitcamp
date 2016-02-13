package basic2;

import java.util.Random;

public class BoardController implements Controller {

	@Override
	public void execute() throws Exception {
		long s = System.currentTimeMillis();
		Random r = new Random();
		for (int i = 1; i < 100; i++) {
			int num = r.nextInt(100) + 1;
			Thread.sleep(num);
		}
		double time = (System.currentTimeMillis() - s) / 1000d;
		
		System.out.println("BoardController 실행완료");
		System.out.println(
				"BoardController 실행시간 : " + time + "초");
	}
	
}






