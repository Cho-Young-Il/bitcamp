package kr.co.mlec.basic2;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.Scanner;

import kr.co.mlec.common.ConnectionPool;

/*
 * 테이블 하나당 VO 클래스가 하나 만들어진다.
 * t77_mini_board -> MiniBoardVO(MiniBoard)
 * 컬럼명			변수명
 * NO		-> 	no
 * WRITER	->	wrtier
 * TITLE	->	title
 * CONTENT	->	content
 * REG_DATE	->	regDate
 * VIEW_CNT	->	viewCnt
 * 
 * 
 * ResultSet의 메타정보를 가져올 수 있는 API클래스
 * -ResultSetMetaData
 *  1. 컬럼의 개수
 *  2. 컬럼의 타입
 *  3. 컬럼의 이름 을 가져올수 있다.
 *  
 */
public class JdbcTest09 {
	public static void main(String[] args) {
		
		try {
			Connection conn = ConnectionPool.getConnection();
			
			Scanner sc = new Scanner(System.in);
			
			System.out.print("테이블 명 : ");
			String tableName = sc.nextLine();
			
			String sql = "select * "
					+ "     from " + tableName;
			
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			//실행된 결과에 대한 메타 정보 추출
			ResultSetMetaData rsmd = rs.getMetaData();
			int columnCnt = rsmd.getColumnCount();
			System.out.println("컬럼 카운트 : " + columnCnt);
			
			System.out.println("------------------------");
			System.out.println("컬럼명\t컬럼타입명\t\t\t\t\t\t");
			System.out.println("------------------------");
			for(int i = 1; i <= columnCnt; i++) {
				String name = rsmd.getColumnName(i);
				String type = rsmd.getColumnTypeName(i);
				System.out.println(name + "\t" + type);
			}
			System.out.println("------------------------");
			
			ConnectionPool.close(conn);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}