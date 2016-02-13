package kr.co.mlec.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTest6 {
	public static void main(String[] args) throws Exception{
		
		Class.forName("oracle.jdbc.driver.OracleDriver");
		
		
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.20.90:1521:XE", 
				"hr", "hr");
		
		
		String sql = "INSERT INTO T77_BOARD("
				    	+ "NO, WRITER, TITLE, CONTENT"
				    + ") VALUES ("
				    	+ "seq_board_no.nextVal, ?, ?, ?"
				    + ")";
		
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setString(1, "tester");
		stmt.setString(2, "동적입력 테스트");
		stmt.setString(3, "프로그램 물음표 데이터 입력");
		
		
		int cnt = stmt.executeUpdate();
		
		
		System.out.println(cnt + "개의 행이 추가되었습니다.");
		
		stmt.close();
		conn.close();
	}
}
