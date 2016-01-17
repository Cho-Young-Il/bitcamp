package bitmem.dao.message;

import java.util.List;

import bitmem.vo.message.MessageVO;

public interface MsgDao {
	public List<MessageVO> selectSendMessage(String sender) throws Exception;
	public List<MessageVO> selectReceiveMessage(String receiver) throws Exception;
	public void insertSendMessage(MessageVO messagevo) throws Exception;
	public void insertReceiveMessage(MessageVO messagevo) throws Exception;
	public void deleteSendMessage(int no) throws Exception;
	public void deleteReceiveMessage(int no) throws Exception;
}
