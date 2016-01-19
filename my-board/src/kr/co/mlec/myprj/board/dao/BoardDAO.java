/*
 *    java.sql.Date를 java.util.Date로 변환시 주의
 *    rs.getDate() : 반환타입이 java.sql.Date 
 *    VO 클래스의 타입이 java.util.Date 인 경우
 * 
 *    // 날짜 정보만 유지
 *    vo.setRegDate(rs.getDate("reg_date"));  
 * 
 *    위의 경우를 해결하기 위한 방법 2가지
 *    1. rs.getTimestamp 메서드를 활용
 *       vo.setRegDate(rs.getTimestamp("reg_date"));
 *       
 *    생각할 부분 
 *       화면에서 시간 정보를 출력하기 위해서는 
 *       fmt 태그등을 이용해서 별도의 변환작업이 필요함
 *       <fmt:formatDate value="${commentVO.regDate}" 
			             pattern="yyyy-MM-dd HH:mm" />
 *     
 *    2. VO 클래스의 데이터 타입을 String 로 선언
 *       private String regDate;
 *       
 *       sql문에서 날짜 정보를 가져올 때 to_char를 사용
 *       select to_char(
 *              reg_date, 'yyyy-mm-dd hh24:mi') reg_date 
 *       vo.setRegDate(rs.getString("reg_date"));
 *       
 *       화면에서는 ${commentVO.regDate} 사용이 가능
 * 
 */


package kr.co.mlec.myprj.board.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import kr.co.mlec.myprj.board.MiniBoardVO;
import kr.co.mlec.myprj.board.MiniBoardCommentVO;
import kr.co.mlec.myprj.board.MiniBoardFileVO;
import kr.co.mlec.common.ConnectionFactory;
import kr.co.mlec.common.Constants;

public class BoardDAO {
	
	// =======================================
	// 게시물 테이블에 대한  CRUD 시작.....
	// =======================================
	public List<MiniBoardVO> selectBoard(int pageNo) throws Exception {
		List<MiniBoardVO> list = new ArrayList<>();
		
		int start = (pageNo - 1) * 10;
		int end   = pageNo * 10;
		
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "select no, writer, title, view_cnt, recom_cnt, "
				   + "       (select count(*)                        "
				   + " 	        from t77_mini_board_comment       "
				   + "         where no = a.no ) as comment_cnt  "
				   + "  from (                                       "
				   + " 		  select rownum rnum, a1.*                 "
				   + " 		  from (                                 "
				   + " 				select *                         "
				   + " 				  from t77_mini_board            "
				   + " 				 order by no desc                "
				   + " 			   ) a1	                             "
				   + "       ) a                                     "
				   + " where rnum between ? and ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, start);
		pstmt.setInt(2, end);
		ResultSet rs = pstmt.executeQuery();
		
		// ResultSet -> List<ContentVO>
		while (rs.next()) {
			MiniBoardVO vo = new MiniBoardVO();
			vo.setNo(rs.getInt("no"));
			vo.setWriter(rs.getString("writer"));
			vo.setTitle(rs.getString("title"));
			vo.setViewCnt(rs.getInt("view_cnt"));
			// 댓글수
			vo.setCommentCnt(rs.getInt("comment_cnt"));
			// 추천수
			vo.setRecomCnt(rs.getInt("recom_cnt"));
			
			list.add(vo);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}
	
	// 전체 게시물 개수 반환
	public int selectBoardCount() throws Exception {
		Class.forName(Constants.ORACLE_DRIVER);
		Connection con = DriverManager.getConnection(
				Constants.ORACLE_URL,
				Constants.ORACLE_USER, Constants.ORACLE_PASS);
		String sql = "select count(*) cnt "
				   + "  from t77_mini_board ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		int cnt = rs.getInt("cnt");
		return cnt;
	}
	
	public MiniBoardVO selectBoardByNo(int no) throws Exception {
		Class.forName(Constants.ORACLE_DRIVER);
		Connection con = DriverManager.getConnection(
				Constants.ORACLE_URL,
				Constants.ORACLE_USER, Constants.ORACLE_PASS);
		
		String sql = "select no, writer, title, content, "
				   + "       view_cnt, reg_date, recom_cnt "
				   + "  from t77_mini_board "
				   + " where no = ?         ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		MiniBoardVO vo = new MiniBoardVO();
		if (rs.next()) {
			vo.setNo(rs.getInt("no"));
			vo.setTitle(rs.getString("title"));
			vo.setWriter(rs.getString("writer"));
			vo.setContent(rs.getString("content"));
			vo.setViewCnt(rs.getInt("view_cnt"));
			vo.setRecomCnt(rs.getInt("recom_cnt"));
			vo.setRegDate(rs.getDate("reg_date"));
		} 
		
		rs.close();
		pstmt.close();
		con.close();
		
		return vo;
	}

	public MiniBoardVO selectPrevBoard(int no) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "select no, title "
				   + "  from t77_mini_board "
				   + " where no = (select max(no)        "
				   + "               from t77_mini_board "
				   + "              where no < ?)        ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			MiniBoardVO vo = new MiniBoardVO();
			vo.setNo(rs.getInt("no"));
			vo.setTitle(rs.getString("title"));
			return vo;
		} 
		
		rs.close();
		pstmt.close();
		con.close();
		
		return null;
	}
	
	public MiniBoardVO selectNextBoard(int no) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "select no, title "
				   + "  from t77_mini_board "
				   + " where no = (select min(no)        "
				   + "               from t77_mini_board "
				   + "              where no > ?)        ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		
		ResultSet rs = pstmt.executeQuery();
		
		if (rs.next()) {
			MiniBoardVO vo = new MiniBoardVO();
			vo.setNo(rs.getInt("no"));
			vo.setTitle(rs.getString("title"));
			return vo;
		} 
		
		rs.close();
		pstmt.close();
		con.close();
		
		return null;
	}
	
	public int insertBoard(MiniBoardVO vo) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		// 게시물 번호를 파일테이블에서 사용하게 하기 위해서
		// 게시물 번호를 먼저 뽑은 후 번호를 반환한다.
		String noSql = "select seq_t77_mini_board_no.nextVal "
				     + "  from dual ";
		PreparedStatement pstmt = con.prepareStatement(noSql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		// 게시글 번호 추출
		int no = rs.getInt(1);
		
		// 동적으로 값을 설정하기
		// 쿼리문에서 사용자가 입력하는 값은 "?" 로 표기한다.
		// ? 개수 만큼 쿼리를 실행 하기전에 값을 설정해야 함(중요)
		String sql = "insert into t77_mini_board("
				   + "    no, writer, title, content"
				   + ") values ("
				   + "    ?, ?, ?, ? "
				   + ")";
		
		pstmt = con.prepareStatement(sql);
		// ? 자리에 값을 설정
		// pstmt.setXxx(물음표 위치, 물음표에 입력될 값)
		int index = 1;
		pstmt.setInt(index++, no);
		pstmt.setString(index++, vo.getWriter());
		pstmt.setString(index++, vo.getTitle());
		pstmt.setString(index++, vo.getContent());
		
		int cnt = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
		return no;
	}
	public void updateBoard(MiniBoardVO vo) throws Exception {
		Class.forName(Constants.ORACLE_DRIVER);
		Connection con = DriverManager.getConnection(
				Constants.ORACLE_URL,
				Constants.ORACLE_USER, Constants.ORACLE_PASS);
		
		String sql = "update t77_mini_board "
				   + "   set title = ?,     "
				   + "       content = ?    "
				   + " where no = ?         ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int index = 1;
		pstmt.setString(index++, vo.getTitle());
		pstmt.setString(index++, vo.getContent());
		pstmt.setInt(index++, vo.getNo());
		
		int cnt = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
		
	}
	
	public void deleteBoard(MiniBoardVO vo) throws Exception {
		Class.forName(Constants.ORACLE_DRIVER);
		Connection con = DriverManager.getConnection(
				Constants.ORACLE_URL,
				Constants.ORACLE_USER, Constants.ORACLE_PASS);
		
		String sql = "delete t77_mini_board "
				   + " where no = ?         ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int index = 1;
		pstmt.setInt(index++, vo.getNo());
		
		int cnt = pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	/**
	 * 조회수 증가
	 * @param no - 게시글 번호
	 * @throws Exception
	 */
	public void updateViewCnt(int no) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "update t77_mini_board          "
				   + "   set view_cnt = view_cnt + 1 "
				   + " where no = ?                  ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int index = 1;
		pstmt.setInt(index++, no);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	public void updateRecomCnt(int no) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "update t77_mini_board          "
				   + "   set recom_cnt = recom_cnt + 1 "
				   + " where no = ?                  ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int index = 1;
		pstmt.setInt(index++, no);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
	// =======================================
	// 파일 테이블에 대한  CRUD 시작.....
	// =======================================
	public void insertFile(MiniBoardFileVO vo) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "insert into t77_mini_board_file (        "
				   + "    file_no, no, ori_file_name,          "
				   + "    real_file_name, file_size, file_path "
				   + ") values ("
				   + "    seq_mini_board_file_no.nextVal, ?, ?, "
				   + "    ?, ?, ? "
				   + ")";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int index = 1;
		pstmt.setInt   (index++, vo.getNo());
		pstmt.setString(index++, vo.getOriFileName());
		pstmt.setString(index++, vo.getRealFileName());
		pstmt.setLong  (index++, vo.getFileSize());
		pstmt.setString(index++, vo.getFilePath());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}

	public List<MiniBoardFileVO> selectFile(int no) throws Exception {
		List<MiniBoardFileVO> list = new ArrayList<>();
		
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "select file_no, no, ori_file_name, "
				   + "       real_file_name, file_size, file_path "
				   + "  from t77_mini_board_file "
				   + " where no = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			MiniBoardFileVO vo = new MiniBoardFileVO();
			vo.setFileNo(rs.getInt("file_no"));
			vo.setNo(rs.getInt("no"));
			vo.setOriFileName(rs.getString("ori_file_name"));
			vo.setRealFileName(rs.getString("real_file_name"));
			vo.setFileSize(rs.getLong("file_size"));
			vo.setFilePath(rs.getString("file_path"));
			list.add(vo);
		}
		
		pstmt.close();
		con.close();
		
		return list;
	}

	public void deleteFileByBoardNo(int no) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "delete t77_mini_board_file "
				   + " where no = ?              ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int index = 1;
		pstmt.setInt(index++, no);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	

	// =======================================
	// 댓글 테이블에 대한  CRUD 시작.....
	// =======================================
	public int insertComment(MiniBoardCommentVO commentVO) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		
		String noSql = "select seq_mini_board_comment_no.nextVal "
					 + " from dual ";
		PreparedStatement pstmt = con.prepareStatement(noSql);
		ResultSet rs = pstmt.executeQuery();
		rs.next();
		
		int commentNo = rs.getInt(1);
		
		String sql = "insert into t77_mini_board_comment (        "
				   + "    comment_no, no, nick_name, content   "
				   + ") values ("
				   + "    ?, ?, ?, ?"
				   + ")";
		
		pstmt = con.prepareStatement(sql);
		int index = 1;
		pstmt.setInt(index++, commentNo);
		pstmt.setInt   (index++, commentVO.getNo());
		pstmt.setString(index++, commentVO.getNickName());
		pstmt.setString(index++, commentVO.getContent());
		
		pstmt.executeUpdate();
		
		rs.close();
		pstmt.close();
		con.close();
		
		return commentNo;
	}
	
	public MiniBoardCommentVO selectCommentByNo(int commentNo) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		String sql = "select comment_no, no, nick_name, "
				+ "			 content, to_char(reg_date, 'yyyy-mm-dd HH24:mi') reg_date "
				+ "		from t77_mini_board_comment "
				+ "	   where comment_no = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, commentNo);
		ResultSet rs = pstmt.executeQuery();
		
		MiniBoardCommentVO commentVO = new MiniBoardCommentVO();
		if(rs.next()) {
			commentVO.setCommentNo(rs.getInt("comment_no"));
			commentVO.setNo(rs.getInt("no"));
			commentVO.setNickName(rs.getString("nick_name"));
			commentVO.setContent(rs.getString("content"));
			commentVO.setRegDate(rs.getString("reg_date"));
		}
		rs.close();
		pstmt.close();
		con.close();
		
		return commentVO;
	}
	
	public List<MiniBoardCommentVO> selectComment(int no) throws Exception {
		List<MiniBoardCommentVO> list = new ArrayList<>();
		
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "select comment_no, no, nick_name, "
				   + "       content, to_char(reg_date, 'yyyy-mm-dd HH24:mi') reg_date "
				   + "  from t77_mini_board_comment "
				   + " where no = ? ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, no);
		ResultSet rs = pstmt.executeQuery();
		
		while (rs.next()) {
			MiniBoardCommentVO vo = new MiniBoardCommentVO();
			vo.setCommentNo(rs.getInt("comment_no"));
			vo.setNo(rs.getInt("no"));
			vo.setNickName(rs.getString("nick_name"));
			vo.setContent(rs.getString("content"));
//			vo.setRegDate(rs.getDate("reg_date"));
			vo.setRegDate(rs.getString("reg_date"));
			list.add(vo);
		}
		
		rs.close();
		pstmt.close();
		con.close();
		
		return list;
	}

	public void deleteComment(int commentNo) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "delete t77_mini_board_comment "
				   + " where comment_no = ?         ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int index = 1;
		pstmt.setInt(index++, commentNo);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	

	public void deleteCommentByBoardNo(int no) throws Exception {
		Connection con = ConnectionFactory.getInstance();
		
		String sql = "delete t77_mini_board_comment "
				   + " where no = ?                 ";
		
		PreparedStatement pstmt = con.prepareStatement(sql);
		int index = 1;
		pstmt.setInt(index++, no);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		con.close();
	}
	
}





















