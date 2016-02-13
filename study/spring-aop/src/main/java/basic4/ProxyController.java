package basic4;

public class ProxyController {
	// 실행시킬 대상 클래스 타입을 명시
	private Controller ctrl;
	
	public ProxyController (Controller ctrl) {
		this.ctrl = ctrl;
	}
	
	public void execute() throws Exception {
		String clzName = ctrl.getClass().getSimpleName();
		
		long s = System.currentTimeMillis();
		ctrl.execute();
		double time = (System.currentTimeMillis() - s) / 1000d;
		System.out.println(clzName + " 실행시간 : " + time);
	}
}










