package bitmem.dao.message;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitmem.util.DBConnectionPool;
import bitmem.vo.message.MessageVO;

public class OracleMsgDao implements MsgDao{
private DBConnectionPool connPool;
	
	public void setDbConnectionPool(DBConnectionPool connPool) {
		this.connPool = connPool;
	}

	
	@Override
	public List<MessageVO> selectSendMessage(String sender) throws Exception {
		Connection conn = connPool.getConnection();
		String sql = "select *"
				+ " from bit_send_message"
				+ " where sender = ?"
				+ " order by no desc";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index=1;
		pstmt.setString(index++, sender);
		ResultSet rs = pstmt.executeQuery();
		
		List<MessageVO> list = new ArrayList<>();
		while(rs.next()){
			MessageVO messagevo = new MessageVO();
			messagevo.setNo(rs.getInt("no"));
			messagevo.setSender(rs.getString("sender"));
			messagevo.setReceiver(rs.getString("receiver"));
			messagevo.setContent(rs.getString("content"));
			messagevo.setRegDate(rs.getTimestamp(("reg_date")));
			list.add(messagevo);
		}
		
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}
	
	public List<MessageVO> selectReceiveMessage(String receiver) throws Exception{
		Connection conn = connPool.getConnection();
		String sql = "select *"
				+ " from bit_receive_message "
				+ " where receiver = ?"
				+ " order by no desc";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index=1;
		pstmt.setString(index++, receiver);
		ResultSet rs = pstmt.executeQuery();
		
		List<MessageVO> list = new ArrayList<>();
		while(rs.next()){
			MessageVO messagevo = new MessageVO();
			messagevo.setNo(rs.getInt("no"));
			messagevo.setSender(rs.getString("sender"));
			messagevo.setReceiver(rs.getString("receiver"));
			messagevo.setContent(rs.getString("content"));
			messagevo.setRegDate(rs.getTimestamp(("reg_date")));
			list.add(messagevo);
		}
		rs.close();
		pstmt.close();
		conn.close();
		return list;
	}

	public void insertSendMessage(MessageVO messagevo) throws Exception{
		Connection conn = connPool.getConnection();
		String sql = "insert into bit_send_message("
				+ " no, sender, receiver, content)values("
				+ "seq_send_message_no.nextVal, ?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index=1;
		pstmt.setString(index++, messagevo.getSender());
		pstmt.setString(index++, messagevo.getReceiver());
		pstmt.setString(index++, messagevo.getContent());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public void insertReceiveMessage(MessageVO messagevo) throws Exception{
		Connection conn = connPool.getConnection();
		String sql = "insert into bit_receive_message("
				+ " no, sender, receiver, content)values("
				+ "seq_receive_message_no.nextVal, ?,?,?)";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index=1;
		pstmt.setString(index++, messagevo.getSender());
		pstmt.setString(index++, messagevo.getReceiver());
		pstmt.setString(index++, messagevo.getContent());
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public void deleteSendMessage(int no) throws Exception{
		Connection conn = connPool.getConnection();
		String sql = "delete bit_send_message "
				+ " where no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index=1;
		pstmt.setInt(index++, no);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
	
	public void deleteReceiveMessage(int no) throws Exception{
		Connection conn = connPool.getConnection();
		String sql = "delete bit_receive_message "
				+ " where no = ?";
		PreparedStatement pstmt = conn.prepareStatement(sql);
		int index=1;
		pstmt.setInt(index++, no);
		
		pstmt.executeUpdate();
		
		pstmt.close();
		conn.close();
	}
}
