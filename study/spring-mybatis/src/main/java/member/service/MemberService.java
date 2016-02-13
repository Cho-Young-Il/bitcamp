package member.service;

import java.util.List;

import member.vo.MemberVO;

public interface MemberService {
	public List<MemberVO> retrieveMember() throws Exception;
	
	public MemberVO retrieveMemberInfo(String id) throws Exception;
	
	public void registMember(MemberVO memberVO) throws Exception;
}
 