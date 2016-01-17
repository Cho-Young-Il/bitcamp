package bitmem.dao.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitmem.util.DBConnectionPool;
import bitmem.vo.board.Board;
import bitmem.vo.board.BoardComment;
import bitmem.vo.board.BoardFile;

public class OracleBoardDao implements BoardDao{
	private DBConnectionPool connPool;
	
	public void setDbConnectionPool(DBConnectionPool connPool) {
		this.connPool = connPool;
	}

	@Override
	public int getTotalBoardCnt() throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
					"select count(*) "
					+ "from board ");
			rs = stmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}
		}
	}
	
	@Override
	public int getTotalBoardCntByTitle(String title) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
					"select count(*) "
					+ "from board "
					+ "where title like '%" + title + "%' ");
			rs = stmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}
		}
	}
	
	@Override
	public int getTotalBoardCntByWriter(String writer) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
					"select count(*) "
					+ "from board "
					+ "where writer_name like '%" + writer + "%' ");
			rs = stmt.executeQuery();
			rs.next();
			return rs.getInt(1);
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}
		}
	}
	
	@Override
	public List<Board> selectBoard(int pageNo, int totalBoardCnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			
			conn = connPool.getConnection();
			
			int start = (pageNo - 1) * 15 + 1;
			int end = pageNo * 15;
			
			if(end == totalBoardCnt / pageNo) {
				end = totalBoardCnt;
			}
			stmt = conn.prepareStatement(
					"select rnum, no, writer_name, writer_id, title, view_cnt, recom_cnt "
					+ "from (select rownum rnum, no, writer_name, writer_id, title, view_cnt, recom_cnt "
					+ "		   from (select no, writer_name, writer_id, title, view_cnt, recom_cnt "
					+ "				   from board "
					+ "		  		  order by no desc)"
					+ "		)"
					+ "where rnum between ? and ? ");
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			
			rs = stmt.executeQuery();
			
			List<Board> boardList = new ArrayList<>();
			while(rs.next()) {
				boardList.add(new Board()
							.setNo(rs.getInt("no"))
							.setTitle(rs.getString("title"))
							.setWriter_name(rs.getString("writer_name"))
							.setWriter_id(rs.getString("writer_id"))
							.setView_cnt(rs.getInt("view_cnt"))
							.setRecom_cnt(rs.getInt("recom_cnt")));
			}
			return boardList;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public List<Board> selectBoardByTitle(
			String title, int pageNo, int totalBoardCnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			
			int start = (pageNo - 1) * 15 + 1;
			int end = pageNo * 15;
			
			if(end == totalBoardCnt / pageNo) {
				end = totalBoardCnt;
			}
			stmt = conn.prepareStatement(
					"select rnum, no, writer_name, writer_id, title, view_cnt, recom_cnt "
					+ "from (select rownum rnum, no, writer_name, writer_id, title, view_cnt, recom_cnt "
					+ "		   from (select no, writer_name, writer_id, title, view_cnt, recom_cnt "
					+ "				   from board "
					+ 				 "where title like '%" + title + "%' "
					+ "		  		  order by no desc)"
					+ "		)"
					+ "where rnum between ? and ? ");
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
			
			List<Board> boardList = new ArrayList<>();
			while(rs.next()) {
				boardList.add(new Board()
							.setNo(rs.getInt("no"))
							.setTitle(rs.getString("title"))
							.setWriter_name(rs.getString("writer_name"))
							.setWriter_id(rs.getString("writer_id"))
							.setView_cnt(rs.getInt("view_cnt"))
							.setRecom_cnt(rs.getInt("recom_cnt")));
			}
			
			return boardList;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public List<Board> selectBoardByWriter(
			String writer, int pageNo, int totalBoardCnt) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			
			int start = (pageNo - 1) * 15 + 1;
			int end = pageNo * 15;
			
			if(end == totalBoardCnt / pageNo) {
				end = totalBoardCnt;
			}
			stmt = conn.prepareStatement(
					"select rnum, no, writer_name, writer_id, title, view_cnt, recom_cnt "
					+ "from (select rownum rnum, no, writer_name, writer_id, title, view_cnt, recom_cnt "
					+ "		   from (select no, writer_name, writer_id, title, view_cnt, recom_cnt "
					+ "				   from board "
					+ 				 "where writer_name like '%" + writer + "%' "
					+ "		  		  order by no desc)"
					+ "		)"
					+ "where rnum between ? and ? ");
			stmt.setInt(1, start);
			stmt.setInt(2, end);
			rs = stmt.executeQuery();
			
			List<Board> boardList = new ArrayList<>();
			while(rs.next()) {
				boardList.add(new Board()
							.setNo(rs.getInt("no"))
							.setTitle(rs.getString("title"))
							.setWriter_name(rs.getString("writer_name"))
							.setWriter_id(rs.getString("writer_id"))
							.setView_cnt(rs.getInt("view_cnt"))
							.setRecom_cnt(rs.getInt("recom_cnt")));
			}
			
			return boardList;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public Board selectBoardByNo(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"select no, title, writer_name, writer_id, content, view_cnt, recom_cnt, reg_date "
				+ "from board "
				+ "where no = ?");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			Board board = new Board();
			if(rs.next()) {
				board.setNo(rs.getInt("no"))
					 .setTitle(rs.getString("title"))
					 .setWriter_name(rs.getString("writer_name"))
					 .setWriter_id(rs.getString("writer_id"))
					 .setContent(rs.getString("content"))
					 .setView_cnt(rs.getInt("view_cnt"))
					 .setRecom_cnt(rs.getInt("recom_cnt"))
					 .setReg_date(rs.getDate("reg_date"));
			}
			
			return board;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public Board selectPrevBoard(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"select no, title "
				+ "from board "
				+ "where no = (select max(no) "
				+ "				 from board "
				+ "				where no < ?)");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			Board board = new Board();
			if(rs.next()) {
				board.setNo(rs.getInt("no"))
					 .setTitle(rs.getString("title"));
			}
			
			return board;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public Board selectNextBoard(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
					"select no, title "
					+ "from board "
					+ "where no = (select min(no) "
					+ "				 from board "
					+ "				where no > ?)");
			stmt.setInt(1, no);
			rs = stmt.executeQuery();
			Board board = new Board();
			if(rs.next()) {
				board.setNo(rs.getInt("no"))
					 .setTitle(rs.getString("title"));
			}
			
			return board;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	@SuppressWarnings("resource")
	public int insertBoard(Board board) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"select seq_board_no.nextVal from dual ");
			rs = stmt.executeQuery();
			rs.next();
			int no = rs.getInt(1);
			
			stmt = conn.prepareStatement(
					"insert into board("
					+ "		no, title, writer_name, writer_id, content"
					+ ")values("
					+ "		?, ?, ?, ?, ?"
					+ ")");
			stmt.setInt(1, no);
			stmt.setString(2, board.getTitle());
			stmt.setString(3, board.getWriter_name());
			stmt.setString(4, board.getWriter_id());
			stmt.setString(5, board.getContent());
			stmt.executeUpdate();
			
			return no;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void updateBoard(Board board) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
					"update board "
					+ " set title=?, content=? "
					+ "where no = ?");
			stmt.setString(1, board.getTitle());
			stmt.setString(2, board.getContent());
			stmt.setInt(3, board.getNo());
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void deleteBoard(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"delete board "
				+ "where no = ?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void updateViewCnt(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"update board "
				+ " set view_cnt = view_cnt + 1"
				+ "where no = ?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void updateRecomCnt(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
					"update board "
					+ " set recom_cnt = recom_cnt + 1"
					+ "where no = ?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void insertFile(BoardFile boardFile) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"insert into board_file("
				+ "		file_no, no, file_size, "
				+ "		ori_file_name, real_file_name, file_path "
				+ ")values("
				+ "		seq_board_file_no.nextVal, "
				+ "		?, ?, ?, ?, ?"
				+ ")");
			stmt.setInt(1, boardFile.getNo());
			stmt.setLong(2, boardFile.getFile_size());
			stmt.setString(3, boardFile.getOri_file_name());
			stmt.setString(4, boardFile.getReal_file_name());
			stmt.setString(5, boardFile.getFile_path());
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public List<BoardFile> selectFile(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"select file_no, no, file_size, "
				+ "		ori_file_name, real_file_name, file_path "
				+ "from board_file "
				+ "where no = ?");
			stmt.setInt(1, no);
			
			rs = stmt.executeQuery();
			List<BoardFile> fileList = new ArrayList<>();
			while(rs.next()) {
				fileList.add(new BoardFile()
							.setFile_no(rs.getInt("file_no"))
							.setNo(rs.getInt("no"))
							.setFile_size(rs.getLong("file_size"))
							.setOri_file_name(rs.getString("ori_file_name"))
							.setReal_file_name(rs.getString("real_file_name"))
							.setFile_path(rs.getString("file_path")));
			}
			return fileList;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void deleteFileByBoardNo(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"delete board_file "
				+ "where no = ?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void insertComment(BoardComment boardComment) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"insert into board_comment("
				+ "		comment_no, no, name, id, content "
				+ ")values("
				+ "		seq_board_comment_no.nextVal,"
				+ "		?, ?, ?, ?"
				+ ")");
			stmt.setInt(1, boardComment.getNo());
			stmt.setString(2, boardComment.getName());
			stmt.setString(3, boardComment.getId());
			stmt.setString(4, boardComment.getContent());
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public List<BoardComment> selectComment(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"select comment_no, no, name, id, content, reg_date "
				+ "from board_comment "
				+ "order by reg_date desc ");
			rs = stmt.executeQuery();
			List<BoardComment> comments = new ArrayList<>();
			while(rs.next()) {
				comments.add(new BoardComment()
							.setComment_no(rs.getInt("comment_no"))
							.setNo(rs.getInt("no"))
							.setName(rs.getString("name"))
							.setId(rs.getString("id"))
							.setContent(rs.getString("content"))
							.setReg_date(rs.getTimestamp("reg_date")));
			}
			return comments;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public BoardComment selectCommentOne(int comment_no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"select * "
				+ "from board_comment "
				+ "where comment_no = ?");
			stmt.setInt(1, comment_no);
			rs = stmt.executeQuery();
			
			BoardComment boardComment = new BoardComment();
			if(rs.next()) {
				boardComment.setNo(rs.getInt("no"))
							.setName(rs.getString("name"))
							.setId(rs.getString("id"))
							.setContent(rs.getString("content"))
							.setComment_no(rs.getInt("comment_no"))
							.setReg_date(rs.getDate("reg_date"));
			}
			return boardComment;
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(rs != null) rs.close(); } catch(Exception e) {}
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void updateComment(BoardComment boardComment) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"update board_comment "
				+ " set name=?, content=? "
				+ "where comment_no = ?");
			stmt.setString(1, boardComment.getName());
			stmt.setString(2, boardComment.getContent());
			stmt.setInt(3, boardComment.getComment_no());
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void deleteComment(int comment_no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"delete board_comment "
				+ "where comment_no = ?");
			stmt.setInt(1, comment_no);
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}

	@Override
	public void deleteCommentByBoardNo(int no) throws Exception {
		Connection conn = null;
		PreparedStatement stmt = null;
		
		try {
			conn = connPool.getConnection();
			stmt = conn.prepareStatement(
				"delete board_comment "
				+ "where no = ?");
			stmt.setInt(1, no);
			stmt.executeUpdate();
		} catch(Exception e) {
			throw e;
		} finally {
			try { if(stmt != null) stmt.close(); } catch(Exception e) {}
			try { if(conn != null) conn.close(); } catch(Exception e) {}			
		}
	}
}
