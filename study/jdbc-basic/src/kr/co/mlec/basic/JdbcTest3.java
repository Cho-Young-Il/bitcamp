package kr.co.mlec.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTest3 {
	public static void main(String[] args) throws Exception{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.20.90:1521:XE", 
				"hr", "hr");
		
		String sql = "update t77_board"
				+" set title = '프로그램변경'"
				+ " where no = 1";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		int cnt = stmt.executeUpdate();
		
		System.out.println(cnt + "개의 행이 변경되었습니다.");
		stmt.close();
		conn.close();
	}
}
