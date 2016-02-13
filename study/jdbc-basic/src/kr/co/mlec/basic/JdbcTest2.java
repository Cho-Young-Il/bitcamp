package kr.co.mlec.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/*
 * 프로그램 작성 순서
 * 1. 드라이버 로딩
 * 2. 드라이버 매니져를 통한 연결 객체 얻기
 * 3. 실행할 sql 작성
 * 4. sql을 실행할 statement 객체 얻기
 * 5. sql 실행
 * 6. 실행된 결과 처리
 * 7. 객체 닫기
 */
public class JdbcTest2 {
	public static void main(String[] args) throws Exception{
		//1.드라이버 로딩
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		//2.연결 객체 얻기
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.20.90:1521:XE", 
				"hr", "hr");
		
		//3.sql문 작성
		String sql = "INSERT INTO T77_BOARD("
				    	+ "NO, WRITER, TITLE, CONTENT"
				    + ") VALUES ("
				    	+ "seq_board_no.nextVal, 'hong', 'JDBC', '프로그램 입력'"
				    + ")";
		
		//4.sql을 실행할 statement객체 얻기
		//-PreparedStatement pstmt
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		//5.sql 실행
		int cnt = stmt.executeUpdate();
		
		//6.실행 결과 처리 : 개발자 마음대로..
		System.out.println(cnt + "개의 행이 추가되었습니다.");
		
		stmt.close();
		conn.close();
	}
}
