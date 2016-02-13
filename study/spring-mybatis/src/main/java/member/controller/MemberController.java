package member.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import member.service.MemberService;
import member.vo.MemberVO;

@Controller
public class MemberController {
	private static Logger logger = 
			LoggerFactory.getLogger(MemberController.class);
	
	@Autowired
	private MemberService memberService;
	
	public void retrieveMember() throws Exception {
		List<MemberVO> list = memberService.retrieveMember();
		System.out.println("회원 정보");
		System.out.println("===================================");
		for (MemberVO member : list) {
			System.out.println(member);
		}
	}
	
	public void retrieveMemberInfo(String id) throws Exception {
		logger.debug("로그테스트");
		logger.debug("로그테스트");
		logger.debug("로그테스트");
		
		MemberVO memberVO = memberService.retrieveMemberInfo(id);
		System.out.println(id + "인 회원의 정보 정보 ");
		System.out.println(memberVO);
	}
	
	public void registMember() throws Exception {
		MemberVO memberVO = new MemberVO();
		memberVO.setId("test-123456");
		memberVO.setAddr("테스트시 테스트동 테스트 아파트");
		memberVO.setEmail("tester@a.com");
		memberVO.setName("tester");
		memberService.registMember(memberVO);
		System.out.println("성공적으로 등록되었습니다.");
	}
}