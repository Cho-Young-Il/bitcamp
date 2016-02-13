package kr.co.mlec.basic2;

import java.sql.Connection;
import java.sql.PreparedStatement;

import kr.co.mlec.basic.ConnectionFactory;

/*
 * 트랜잭션 테스트
 * -DDL 명령어는 자동 커밋이 실행됨(create, drop ...)
 * 
 * -현재 사용자는 commit을 하기 전에 자신이 처리한 데이터를 확인 할 수 없다.
 * -다른 사용자는 commit을 하기 전에 타사용자가 처리한 데이터를 확인 할 수 없다.
 * 
 * -동시에 테이블에 대해서 작업을 수행 했을 때 커밋하지 않은 경우 락이 발생할 수 있다.
 * 
 * -JDBC 프로그램은 기본 설정이 자동커밋 상태로 설정되어 있다.
 * 	따라서, 롤백할 수 없다.
 *  만약, 트랜잭션을 처리하려면 자동커밋 상태를 변경해줘야 한다.
 *  
 * -commit		: 데이터베이스에 완전하게 적용
 * -rollback	: 데이터를 트랜잭션 시작지점 까지 되돌린다.
 * -savepoint	: 트랜잭션 중간에 되돌릴수 있는 저장점을 생성
 */
public class JdbcTest08 {
	public static void main(String[] args) {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = ConnectionFactory.getInstance();
			//자동커밋 상태 변경
			conn.setAutoCommit(false);
			
			String sql1 = "UPDATE T77_ACCOUNT "
						+ "   SET MONEY = MONEY - 5000"
						+ " WHERE ID = 'a'";
			
			stmt = conn.prepareStatement(sql1);
			stmt.executeUpdate();
			
			//두번째 실행 쿼리에 컬럼명 오류 발생..
			String sql2 = "UPDATE T77_ACCOUNT "
					+ "   SET MONEY = MONY + 5000" //mony 오류
					+ " WHERE ID = 'b'";
		
			stmt = conn.prepareStatement(sql2);
			stmt.executeUpdate();
			
			//정상적으로 수행 되었을 경우 데이터베이스에 적용
			conn.commit();
		} catch(Exception e) {
			//데이터를 트랜잭션 시작까지 되돌린다.
			try{conn.rollback();} catch(Exception e2) {}
			e.printStackTrace();
		}
	}
}	