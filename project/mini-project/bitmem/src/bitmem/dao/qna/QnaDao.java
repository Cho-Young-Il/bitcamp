package bitmem.dao.qna;

import java.util.List;

import bitmem.vo.qna.QnaCommentVO;
import bitmem.vo.qna.QnaVO;

public interface QnaDao {
	public List<QnaVO> selectQna() throws Exception;
	public QnaVO selectQnaByNo(int no) throws Exception;
	public int insertQna(QnaVO vo) throws Exception;
	public void updateQna(QnaVO vo) throws Exception;
	public void deleteQna(QnaVO vo) throws Exception;
	public List<QnaCommentVO> selectCommentQna(int no) throws Exception;
	public void insertCommentQna(QnaCommentVO vo) throws Exception;
	public void deleteCommentQna(QnaCommentVO vo) throws Exception;
	public void deleteCommentByQnaNO(int no) throws Exception;
}
