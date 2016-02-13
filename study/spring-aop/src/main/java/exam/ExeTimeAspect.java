package exam;

import org.aspectj.lang.ProceedingJoinPoint;

public class ExeTimeAspect {
	public Object exeTime(ProceedingJoinPoint point) throws Throwable {
		Object ret = null;
		
		try {
			String cName = point.getTarget().getClass().getName();
			
			long s = System.currentTimeMillis();
			ret = point.proceed();
			double time = (System.currentTimeMillis() - s) / 1000d;
			System.out.println(cName + " 실행시간 : " + time);
		} finally {
		}
		
		return ret;
	}
}
