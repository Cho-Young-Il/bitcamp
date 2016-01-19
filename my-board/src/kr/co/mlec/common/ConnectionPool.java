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
	
	// Ŀ�ؼ� Ǯ ���� ����
	static {
		try {
			Class.forName(Constants.ORACLE_DRIVER);

			System.out.println("���� Ǯ ���� ����");
			for (int i = 1; i <= INIT_COUNT; i++) {
				freeList.add(DriverManager.getConnection(
						Constants.ORACLE_URL, 
						Constants.ORACLE_USER, 
						Constants.ORACLE_PASS));
				System.out.println(i + "�� Ŀ�ؼ� Ǯ ���");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// Ǯ�� �ִ� Ŀ�ؼ��� �����ִ� �۾�
	public static Connection getConnection() throws Exception {
		
		if (freeList.isEmpty()) {
			throw new Exception("Ǯ�� ����ֽ��ϴ�.");
		}
		
		// ����ִ� Ǯ���� ���ᰴü�� ������ ������
//		Connection con = freeList.get(0);
//		freeList.remove(0);
		
		// remove ������ ��ü�� ��ȯ
		Connection con = freeList.remove(0);
		
		// ����ִ� Ǯ���� ���� ���� ��ü�� ������� Ǯ�� �̵���Ų��.
		usedList.add(con);
		
		System.out.println("���� ����ִ� Ŀ�ؼ� ���� : " + freeList.size());
		System.out.println("���� ������� Ŀ�ؼ� ���� : " + usedList.size());
		
		return con; 
	}
	
	// ����ڰ� �� ������� �� �ݱ� �۾� ó��
	// usedList���� freeList�� �̵���Ű��
	public static void close(Connection con) {
		// usedList���� ����
		usedList.remove(con);
		
		// ������ freeList�� �̵�
		freeList.add(con);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			for (int i = 0; i < 4; i++) {
				System.out.print("Ŀ�ؼ� ��û");
				sc.nextLine();
				
				Connection con = ConnectionPool.getConnection();
				Thread.sleep(1000);
				// �� �������, Ŀ�ؼ� �ݱ�
				ConnectionPool.close(con);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
















