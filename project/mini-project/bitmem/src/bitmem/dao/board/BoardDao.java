package bitmem.dao.board;

import java.util.List;

import bitmem.vo.board.Board;
import bitmem.vo.board.BoardComment;
import bitmem.vo.board.BoardFile;

public interface BoardDao {
	 //게시판 crud
	 int getTotalBoardCnt() throws Exception;
	 int getTotalBoardCntByTitle(String title) throws Exception;
	 int getTotalBoardCntByWriter(String writer) throws Exception;
	 List<Board> selectBoard(int pageNo, int totalBoardCnt) throws Exception;
	 List<Board> selectBoardByTitle(
			 String title, int pageNo, int totalBoardCnt) throws Exception;
	 List<Board> selectBoardByWriter(
			 String writer, int pageNo, int totalBoardCnt) throws Exception;
	 Board selectBoardByNo(int no) throws Exception;
	 Board selectPrevBoard(int no) throws Exception;
	 Board selectNextBoard(int no) throws Exception;
	 int insertBoard(Board board) throws Exception;
	 void updateBoard(Board board) throws Exception;
	 void deleteBoard(int no) throws Exception;
	 void updateViewCnt(int no) throws Exception;
	 void updateRecomCnt(int no) throws Exception;
	 
	 //파일 crud
	 void insertFile(BoardFile boardFile) throws Exception;
	 List<BoardFile> selectFile(int no) throws Exception;
	 void deleteFileByBoardNo(int no) throws Exception;
	 
	 //댓글 crud
	 void insertComment(BoardComment boardComment) throws Exception;
	 List<BoardComment> selectComment(int no) throws Exception;
	 BoardComment selectCommentOne(int comment_no) throws Exception;
	 void updateComment(BoardComment boardComment) throws Exception;
	 void deleteComment(int comment_no) throws Exception;
	 void deleteCommentByBoardNo(int no) throws Exception;
}
