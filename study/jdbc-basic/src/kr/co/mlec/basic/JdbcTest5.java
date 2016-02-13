package kr.co.mlec.basic;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.common.Constants;

public class JdbcTest5 {
	public static void main(String[] args) throws Exception{
		Class.forName(Constants.ORACLE_DRIVER);
		Connection conn = ConnectionFactory.getInstance();
		
		String sql = "select employee_id as eid, last_name, salary "
				+" from employees"
				+ " order by employee_id desc";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			int eId = rs.getInt("eid");
			String lastName = rs.getString("last_name");
			int salary = rs.getInt("salary");
			
			System.out.println(eId + "\t" + lastName + "\t" + salary);
		}
		
		stmt.close();
		conn.close();
	}
}
