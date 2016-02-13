package anno;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("member")
public class MemberController implements Controller {

	@Override
	public String execute() throws Exception {
		
		Random r = new Random();
		for (int i = 1; i < 10; i++) {
			int num = r.nextInt(100) + 1;
			Thread.sleep(num);
		}
		System.out.println("MemberController 실행완료");
		
		return "member";
	}
	
}






