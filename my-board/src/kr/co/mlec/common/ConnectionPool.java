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
	
	// 커넥션 풀 생성 과정
	static {
		try {
			Class.forName(Constants.ORACLE_DRIVER);

			System.out.println("최초 풀 생성 시작");
			for (int i = 1; i <= INIT_COUNT; i++) {
				freeList.add(DriverManager.getConnection(
						Constants.ORACLE_URL, 
						Constants.ORACLE_USER, 
						Constants.ORACLE_PASS));
				System.out.println(i + "개 커넥션 풀 등록");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 풀에 있는 커넥션을 꺼내주는 작업
	public static Connection getConnection() throws Exception {
		
		if (freeList.isEmpty()) {
			throw new Exception("풀이 비어있습니다.");
		}
		
		// 놀고있는 풀에서 연결객체를 꺼내고 제거함
//		Connection con = freeList.get(0);
//		freeList.remove(0);
		
		// remove 삭제한 객체를 반환
		Connection con = freeList.remove(0);
		
		// 놀고있는 풀에서 꺼낸 연결 객체를 사용중인 풀로 이동시킨다.
		usedList.add(con);
		
		System.out.println("현재 놀고있는 커넥션 개수 : " + freeList.size());
		System.out.println("현재 사용중인 커넥션 개수 : " + usedList.size());
		
		return con; 
	}
	
	// 사용자가 다 사용했을 때 닫기 작업 처리
	// usedList에서 freeList로 이동시키기
	public static void close(Connection con) {
		// usedList에서 삭제
		usedList.remove(con);
		
		// 삭제된 freeList로 이동
		freeList.add(con);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			for (int i = 0; i < 4; i++) {
				System.out.print("커넥션 요청");
				sc.nextLine();
				
				Connection con = ConnectionPool.getConnection();
				Thread.sleep(1000);
				// 다 사용했음, 커넥션 닫기
				ConnectionPool.close(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
















