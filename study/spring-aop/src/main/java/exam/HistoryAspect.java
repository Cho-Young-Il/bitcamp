package exam;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.aspectj.lang.JoinPoint;

// 공통기능으로 처리할 클래스
public class HistoryAspect {
	// 핵심기능 메서드가 실행한 후
	// 호출된 클래스와 메서드 정보를 데이터 베이스에
	// 저장하는 기능
	public void history(JoinPoint point) {
		// 클래스명(패키지 포함) 얻기
		String cName = point.getTarget().getClass().getName();
		// 메서드명 얻기
		String mName = point.getSignature().getName();
		// 데이터베이스 입력
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection(
				"jdbc:oracle:thin:@localhost:1521:XE",
				"hr", "hr"
			);
			
			String sql = "insert into t77_history(     "
					   + "    class_name, method_name  "
					   + ") values (                   "
					   + "    ?, ?                     "
					   + ")";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, cName);
			pstmt.setString(2, mName);
			
			pstmt.executeUpdate();
			System.out.println("히스토리 등록 성공^^");
		} catch (Exception e) {
			System.out.println("히스토리 입력중 오류 발생");
			e.printStackTrace();
		}
	}
}












