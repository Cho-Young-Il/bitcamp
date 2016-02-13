package kr.co.mlec.basic;

import java.sql.Connection;
import java.sql.DriverManager;

/*
 * JDBC : 자바에서 SQL을 활용하는 api
 * 
 *  - 4대 구성요소
 *    1. 응용프로그램
 *    2.드라이버매니저
 *    3.드라이버
 *    4.DBMS
 *    
 *    -JDBC 프로그램을 작성하기 위해서는 드라이버를 인식하는 과정이 필요
 *    
 */
public class JdbcTest1 {
	public static void main(String[] args) {
		try {
			//jdbc 프로그램 작성시 가장 처음 할일
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//두번째 작업
			//드라이버매니저 객체를 활용한 디비 연결 얻기
			Connection conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@192.168.20.90:1521:XE", //JDBC URL
					"hr", "hr");
			System.out.println(conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
