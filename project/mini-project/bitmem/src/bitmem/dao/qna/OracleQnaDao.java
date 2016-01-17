package bitmem.dao.qna;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitmem.util.DBConnectionPool;
import bitmem.vo.qna.QnaCommentVO;
import bitmem.vo.qna.QnaVO;

public class OracleQnaDao implements QnaDao{
	private DBConnectionPool connPool;
	
	public void setDbConnectionPool(DBConnectionPool connPool) {
		this.connPool = connPool;
	}
	
	public List<QnaVO> selectQna() throws Exception {
		List<QnaVO> list = new ArrayList<>();
		Connection conn = connPool.getConnection();
		
		String sql = "select no, title, writer, view_cnt"
				+ "     from board_qna"
				+ "    order by no desc";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			QnaVO vo = new QnaVO();
			vo.setNo(rs.getInt("no"));
			vo.setWriter(rs.getString("writer"));
			vo.setTitle(rs.getString("title"));
			vo.setViewCnt(rs.getInt("view_cnt"));
			list.add(vo);
			
		}
		stmt.close();
		conn.close();
		
		return list;
	}
	
	public QnaVO selectQnaByNo(int no) throws Exception {
		Connection conn = connPool.getConnection();
		
		String sql = "select * from board_qna"
				+ "	   where no = ? ";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, no);
		
		ResultSet rs = stmt.executeQuery();
		
		QnaVO vo = new QnaVO();
		if(rs.next()) {
			vo.setNo(rs.getInt("no"));
			vo.setTitle(rs.getString("title"));
			vo.setWriter(rs.getString("writer"));
			vo.setContent(rs.getString("content"));
			vo.setViewCnt(rs.getInt("view_cnt"));
			vo.setRegDate(rs.getDate("reg_date"));
		}
		stmt.close();
		conn.close();
		
		return vo;
	}
	
	public int insertQna(QnaVO vo) throws Exception {
		Connection conn = connPool.getConnection();
		
		String sql = "insert into board_qna ("
				+ "   no, title, writer, content"
				+ " ) values ( "
				+ "   seq_board_qna_no.nextVal, "
				+ "   ?, ?, ? "
				+ ")";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		int index = 1;
		stmt.setString(index++, vo.getTitle());
		stmt.setString(index++, vo.getWriter());
		stmt.setString(index++, vo.getContent());
		
		stmt.executeUpdate();
		
		stmt.close();
		conn.close();
		return index;
	}
	
	public void updateQna(QnaVO vo) throws Exception {
		Connection conn = connPool.getConnection();
		
		String sql = "update board_qna"
				+ "       set title = ?,"
				+ "          content = ?"
				+ "        where no = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		int index = 1;
		stmt.setString(index++, vo.getTitle());
		stmt.setString(index++, vo.getContent());
		stmt.setInt(index++, vo.getNo());
		
		stmt.executeUpdate();
		
		stmt.close();
		conn.close();
	}
	
	public void deleteQna(QnaVO vo) throws Exception {
		Connection conn = connPool.getConnection();
		
		String sql = "delete board_qna"
				+ "    where no = ? ";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		int index = 1;
		
		stmt.setInt(index++, vo.getNo());
		stmt.executeUpdate();
		
		stmt.close();
		conn.close();
	}
	// =======================================
	// 댓글 테이블에 대한 DAO.....
	// =======================================
	public List<QnaCommentVO> selectCommentQna(int no) throws Exception {
		List<QnaCommentVO> list = new ArrayList<>();
		
		Connection conn = connPool.getConnection();
		
		String sql = "select * from board_comment_qna"
				+ "    where no = ?"
				+ "    order by comment_no asc " ;
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, no);
		ResultSet rs = stmt.executeQuery();
		
		while(rs.next()) {
			QnaCommentVO vo = new QnaCommentVO();
			vo.setNo(rs.getInt("no"));
			vo.setCommentNo(rs.getInt("comment_no"));
			vo.setContent(rs.getString("content"));
			vo.setNickName(rs.getString("nick_name"));
			vo.setRegDate(rs.getDate("reg_date"));
			
			list.add(vo);
		}
			stmt.close();
			conn.close();
		
			return list;
	}

	public void insertCommentQna(QnaCommentVO vo) throws Exception {
		Connection conn = connPool.getConnection();
		
		String sql =  "insert into board_comment_qna ("
				+ "    comment_no, no, nick_name, content "
				+ "   )values("
				+ "    seq_board_comment_qna_no.nextVal,"
				+ "    ?, ?, ? "
				+ " )";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		int index = 1;
		stmt.setInt(index++, vo.getNo());
		stmt.setString(index++, vo.getNickName());
		stmt.setString(index++, vo.getContent());
		
		stmt.executeUpdate();
		
		stmt.close();
		conn.close();
	}

	public void deleteCommentQna(QnaCommentVO vo) throws Exception {
		Connection conn = connPool.getConnection();
		
		String sql = "delete board_comment_no "
				+ "    where comment_no = ?";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, vo.getCommentNo());
		stmt.executeUpdate();
		
		stmt.close();
		conn.close();
	}

	public void deleteCommentByQnaNO(int no) throws Exception {
		Connection conn = connPool.getConnection();
		
		String sql = "delete board_comment_qna "
				+ "    where comment_no = ? ";
		
		PreparedStatement stmt = conn.prepareStatement(sql);
		stmt.setInt(1, no);
		stmt.executeUpdate();
		
		stmt.close();
		conn.close();
	}
	
}
