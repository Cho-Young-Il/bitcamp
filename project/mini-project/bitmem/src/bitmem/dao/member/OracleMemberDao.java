package bitmem.dao.member;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitmem.util.DBConnectionPool;
import bitmem.vo.member.Member;

public class OracleMemberDao implements MemberDao{
	private DBConnectionPool connPool;
	
	public void setDbConnectionPool(DBConnectionPool connPool) {
		this.connPool = connPool;
	}
	
	@Override
	public List<Member> selectList() throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = connPool.getConnection();
			stmt = connection.prepareStatement(
					"SELECT * "
					+ "FROM BIT_MEMBER "
					+ "ORDER BY CLASS_NO DESC");
			
			rs = stmt.executeQuery();
			
			List<Member> members = new ArrayList<>();
			while(rs.next()) {
				members.add(new Member()
					.setNo(rs.getInt("NO"))
					.setClassNo(rs.getInt("CLASS_NO"))
					.setPermission(rs.getInt("PERMISSION"))
					.setBirth(rs.getString("BIRTH"))
					.setPhoneNo(rs.getString("PHONE_NO"))
					.setGender(rs.getString("GENDER"))
					.setId(rs.getString("ID"))
					.setAuth(rs.getString("AUTH"))
					.setName(rs.getString("NAME"))
					.setEmail(rs.getString("EMAIL"))
					.setRegDate(rs.getDate("REG_DATE")));
			}
			
			return members;
			
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(connection != null) connection.close(); } catch(Exception e) {}
		}
	}
	
	@Override
	public Member selectOne(int no) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			connection = connPool.getConnection();
			stmt = connection.prepareStatement(
					"SELECT * "
					+ "FROM BIT_MEMBER "
					+ "WHERE NO = ?");
			stmt.setInt(1, no);
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Member()
				.setNo(rs.getInt("NO"))
				.setClassNo(rs.getInt("CLASS_NO"))
				.setPermission(rs.getInt("PERMISSION"))
				.setBirth(rs.getString("BIRTH"))
				.setPhoneNo(rs.getString("PHONE_NO"))
				.setGender(rs.getString("GENDER"))
				.setId(rs.getString("ID"))
				.setAuth(rs.getString("AUTH"))
				.setName(rs.getString("NAME"))
				.setEmail(rs.getString("EMAIL"))
				.setRegDate(rs.getDate("REG_DATE"));
			} else {
				throw new Exception("해당 번호의 회원을 찾을 수 없습니다.");
			}
			
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(connection != null) connection.close(); } catch(Exception e) {}
		}
	}
	
	@Override
	public int insert(Member member) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = connPool.getConnection();
			stmt = connection.prepareStatement(
					"INSERT INTO BIT_MEMBER ("
					+ "	NO, PERMISSION, BIRTH, PHONE_NO, GENDER,"
					+ " ID, AUTH, NAME, EMAIL, PASSWORD, REG_DATE"
					+ ")VALUES("
					+ " SEQ_BIT_MEMBER.NEXTVAL, 0, ?, ?, ?, ?, ?, ?, ?, ?, SYSDATE"
					+ ")");
			stmt.setString(1, member.getBirth());
			stmt.setString(2, member.getPhoneNo());
			stmt.setString(3, member.getGender());
			stmt.setString(4, member.getId());
			stmt.setString(5, member.getAuth());
			stmt.setString(6, member.getName());
			stmt.setString(7, member.getEmail());
			stmt.setString(8, member.getPassword());
			
			return stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(connection != null) connection.close(); } catch(Exception e) {}
		}
	}
	
	@Override
	public Member exist(Member member) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {
			connection = connPool.getConnection();
			stmt = connection.prepareStatement(
					"SELECT * "
					+ "FROM BIT_MEMBER "
					+ "WHERE ID=? AND PASSWORD=?");
			stmt.setString(1, member.getId());
			stmt.setString(2, member.getPassword());
			
			rs = stmt.executeQuery();
			
			if(rs.next()) {
				return new Member()
					.setNo(rs.getInt("NO"))
					.setClassNo(rs.getInt("CLASS_NO"))
					.setPermission(rs.getInt("PERMISSION"))
					.setBirth(rs.getString("BIRTH"))
					.setPhoneNo(rs.getString("PHONE_NO"))
					.setGender(rs.getString("GENDER"))
					.setId(rs.getString("ID"))
					.setAuth(rs.getString("AUTH"))
					.setName(rs.getString("NAME"))
					.setEmail(rs.getString("EMAIL"))
					.setRegDate(rs.getDate("REG_DATE"));
			} else {
				return null;
			}
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(connection != null) connection.close(); } catch(Exception e) {}
		}
	}

	@Override
	public int update(Member member) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = connPool.getConnection();
			stmt = connection.prepareStatement(
					"UPDATE BIT_MEMBER "
					+ " SET PASSWORD=?, PHONE_NO=?, EMAIL=?"
					+ "WHERE NO=?");
			stmt.setString(1, member.getPassword());
			stmt.setString(2, member.getPhoneNo());
			stmt.setString(3, member.getEmail());
			stmt.setInt(4, member.getNo());
			
			return stmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(connection != null) connection.close(); } catch(Exception e) {}
		}
	}
	
	@Override
	public int updatePermission(Member member) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = connPool.getConnection();
			stmt = connection.prepareStatement(
					"UPDATE BIT_MEMBER "
					+ " SET PERMISSION=?, CLASS_NO=?"
					+ "WHERE NO=?");
			stmt.setInt(1, member.getPermission());
			stmt.setInt(2, member.getClassNo());
			stmt.setInt(3, member.getNo());
			
			return stmt.executeUpdate();
			
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(connection != null) connection.close(); } catch(Exception e) {}
		}
	}
	
	@Override
	public void delete(String[] numbers) throws Exception {
		Connection connection = null;
		PreparedStatement stmt = null;
		
		try {
			connection = connPool.getConnection();
			
			for(String number : numbers) {
				stmt = connection.prepareStatement(
						"DELETE "
						+ "FROM BIT_MEMBER "
						+ "WHERE NO=?");
				stmt.setInt(1, Integer.parseInt(number));
				stmt.executeUpdate();
			}
		} catch(Exception e) {
			
		} finally {
			try { if(connection != null) connection.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
		}
	}
}
