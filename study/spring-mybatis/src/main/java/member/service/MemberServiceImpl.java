package member.service;

import java.util.List;

import member.dao.MemberDAO;
import member.vo.MemberVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	private MemberDAO memberDAO;

	public List<MemberVO> retrieveMember() throws Exception {
		return memberDAO.selectMember();
	}
	
	public MemberVO retrieveMemberInfo(String id) throws Exception {
		return memberDAO.selectMemberById(id);
	}
	
	@Transactional(rollbackFor=Exception.class)
	public void registMember(MemberVO memberVO) throws Exception {
		memberDAO.insertMember(memberVO);
		memberDAO.updateMember(memberVO);
	}	
}