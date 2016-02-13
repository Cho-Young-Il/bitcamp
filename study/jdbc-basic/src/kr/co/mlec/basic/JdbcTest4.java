package kr.co.mlec.basic;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JdbcTest4 {
	public static void main(String[] args) throws Exception {
		Class.forName("oracle.jdbc.driver.OracleDriver");
		Connection conn = DriverManager.getConnection(
				"jdbc:oracle:thin:@192.168.20.90:1521:XE"
				,"hr", "hr");
		
		String sql = "delete from t77_board where no = 1";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		int cnt = stmt.executeUpdate();
		
		System.out.println(cnt + "개 행이 삭제되었습니다.");
		stmt.close();
		conn.close();
	}
}
