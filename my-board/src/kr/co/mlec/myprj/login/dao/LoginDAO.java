package kr.co.mlec.myprj.login.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import kr.co.mlec.common.ConnectionPool;
import kr.co.mlec.myprj.login.vo.LoginVO;

public class LoginDAO {
	public LoginVO selectMember(LoginVO member) 
			throws Exception {
		
		// t77_member 테이블에 화면에서 입력받은 id, pass와
		// 동일한 데이터가 있는지 카운드를 반환
		Connection con = ConnectionPool.getConnection();
		String sql = "select id, pass, name, grade   "
				   + "  from t77_member              "
				   + " where id = ?                  "
				   + "   and pass = ?                ";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		pstmt.setString(1, member.getId());
		pstmt.setString(2, member.getPass());
		
		ResultSet rs = pstmt.executeQuery();
		if (rs.next()) {
			LoginVO result = new LoginVO();
			result.setId(rs.getString("id"));
			result.setPass(rs.getString("pass"));
			result.setName(rs.getString("name"));
			result.setGrade(rs.getString("grade"));
			return result;
		}
		
		return null;
	}
}










