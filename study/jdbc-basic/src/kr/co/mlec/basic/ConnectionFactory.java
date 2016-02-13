package kr.co.mlec.basic;

import java.sql.Connection;
import java.sql.DriverManager;

import kr.co.mlec.common.Constants;

public class ConnectionFactory {
	public static Connection getInstance() throws Exception {
		Class.forName(Constants.ORACLE_DRIVER);
		return DriverManager.getConnection(
				Constants.ORACLE_URL, 
				Constants.ORACLE_USER,
				Constants.ORACLE_PASS);
	}
}
