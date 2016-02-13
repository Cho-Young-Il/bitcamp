package kr.co.mlec.common;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {
	public static Connection getInstance() throws Exception {
		Class.forName(Constants.ORACLE_DRIVER);
		Connection con = DriverManager.getConnection(
				Constants.ORACLE_URL, 
				Constants.ORACLE_USER, Constants.ORACLE_PASS);
		return con;
	}
}










