package anno;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;




@Aspect
@Component
//@Order(0)
public class LogAspect {
	
	@Pointcut("execution(public * anno..*Controller.execute(..))")
	public void logPointCut() {}
	
	// after 공통 기능 구현
	// 화면에 ####################### 출력
	@After("logPointCut()")
	public void logAfter() {
		System.out.println("#########################");
	}
	
	
	// 공통 기능을 호출하게 한 핵심기능 클래스 정보를 추출
	// before 방식으로 적용
	@Before("logPointCut()")
	public void log(JoinPoint point) {
		System.out.println("*************************");
		// 핵심기능 클래스 객체
		Class<?> clz = point.getTarget().getClass();
		// 핵심기능 클래스이름
		String cName = clz.getName();
		
		// 핵심기능 클래스 실행하는 메서드
		Signature sign = point.getSignature();
		// 핵심기능 클래스 메서드 이름
		String mName = sign.getName();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String time = sdf.format(new Date());
		System.out.println(
				cName + "." + mName + " : " + 
		        time + "에 호출되었습니다.");
	}
	
	// 핵심클래스의 메서드를 호출하는 기능을 가진 클래스를 
	// 매개변수를 통해서 받는다.
	
	// 핵심클래스의 실행결과를 올바르게 전송하기 위해서
	// 반환타입을 Object 타입으로 설정한다.
//	@Around("execution(public * anno..*Controller.execute(..))")
	public Object logAround (ProceedingJoinPoint point) throws Throwable {
		// before 
		System.out.println("**************************");
		Class<?> clz = point.getTarget().getClass();
		// 핵심기능 클래스이름
		String cName = clz.getName();
		
		// 핵심기능 클래스 실행하는 메서드
		Signature sign = point.getSignature();
		// 핵심기능 클래스 메서드 이름
		String mName = sign.getName();
		
		String pattern = "yyyy-MM-dd HH:mm:ss";
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		String time = sdf.format(new Date());
		System.out.println(
				cName + "." + mName + " : " + 
		        time + "에 호출되었습니다.");
		
		// 핵심기능 클래스 호출...
		Object ret = null;
		try {
			ret = point.proceed();
			System.out.println("핵심클래스 실행 결과 : " + ret);
			// after-returning
		} finally {
			// after
			System.out.println("##########################");
		}
		
		return ret;
	}
	
	
	
	
}










