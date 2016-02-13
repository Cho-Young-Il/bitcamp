package kr.co.mlec.common;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConnectionPool {
	private static final int INIT_COUNT = 3;
	
	private static List<Connection> freeList = new ArrayList<>();
	private static List<Connection> usedList = new ArrayList<>();
	
	//커넥션 풀 생성
	static {
		try {
			Class.forName(Constants.ORACLE_DRIVER);
			
			System.out.println("최초 풀 생성 시작");
			for(int i = 1; i <= INIT_COUNT; i++) {
				freeList.add(DriverManager.getConnection(
						Constants.ORACLE_URL,
						Constants.ORACLE_USER,
						Constants.ORACLE_PASS));
				System.out.println(i + "개 커넥션 풀 등록");
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	//풀에있는 커넥션을 꺼내주는 작업
	public static Connection getConnection() throws Exception {
		if(freeList.isEmpty()) {
			throw new Exception("풀이 비어있습니다.");
		}
		
		//놀고 있는 풀에서 연결객체를 꺼내고 제거함
//		Connection conn = freeList.get(0);
//		freeList.remove(0);
		
		//remove 삭제한 객체를 반환
		Connection conn = freeList.remove(0);
		
		//놀고있는 풀에서 꺼낸 연결 객체를 사용중인 풀로 이동시킨다.
		usedList.add(conn);
		
		System.out.println("현재 놀고있는 커넥션 개수 : " + freeList.size());
		System.out.println("현재 사용중인 커넥션 개수 : " + usedList.size());
		return conn;
	}
	
	public static void close(Connection conn) {
		//usedList에서 삭제
		usedList.remove(conn);
		
		//삭제된 freeList로 이동
		freeList.add(conn);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			for(int i = 0; i < 4; i++) {
				System.out.println("커넥션 요청");
				sc.nextLine();
				
				Connection conn = ConnectionPool.getConnection();
				Thread.sleep(1000);
				//다 사용했음, 커넥션 닫기
				ConnectionPool.close(conn);
			}
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			sc.close();
		}
	}
}
