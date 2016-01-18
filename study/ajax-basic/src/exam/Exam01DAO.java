package exam;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.common.ConnectionPool;

public class Exam01DAO {
	public List<MemberVO> list() throws Exception {
		Connection con = ConnectionPool.getConnection();
		String sql = "select id, name "
					+ " from t77_member "
					+ " order by name ";
		PreparedStatement stmt = con.PreparedStatement(sql);
		ResultSet rs = stmt.excuteQuery();
		List<MemberVO> list = new ArrayList<>();
		while(rs.next()) {
			MemberVO member = new MemberVO();
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			list.add(member);
		}
		ConnectionPool.close(con);
		return list;
	}

	public MemberVO detail(String id) throws Exception {
		Connection con = ConnectionPool.getConnection();
		String sql = "select id, name, pass "
					+ " from t77_member "
					+ " where id = ?";
		PreparedStatement stmt = con.PreparedStatement(sql);
		stmt.setString(1, id);
		ResultSet rs = stmt.excuteQuery();

		MemberVO member = new MemberVO();
		if(rs.next()) {
			member.setId(rs.getString("id"));
			member.setName(rs.getString("name"));
			member.setPass(rs.getString("pass"));
		}

		ConnectionPool.close(con);

		return member;
	}
}