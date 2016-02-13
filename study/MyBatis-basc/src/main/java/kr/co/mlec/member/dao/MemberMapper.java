/*
 * select -> Object(하나)
 * select -> list(여러개)
 * insert
 * update
 * delete
 */
package kr.co.mlec.member.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.member.MemberVO;
import kr.co.mlec.member.SearchVO;

public class MemberMapper {

	private static SqlSession sqlMapper;
	
	public MemberMapper() throws Exception {
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
//		System.out.println(sqlMapper);
//		test01();
//		test02();
//		insertMember();
//		updateMember();
//		deleteMember();
//		selectForeach();
		dynamicSelect();
	}
	
	/*
	 * select - 결과가 하나인것
	 */
	public void test01() throws Exception {
//		sqlMapper.selectOne("xml 파일에 아이디 설정");
//		sqlMapper.selectOne("xml 파일에 아이디 설정", "쿼리 수행 필요 파라미터");
//		MemberVO member = sqlMapper.selectOne("kr.co.mlec.member.dao.MemberMapper.getMemberInfo1", "member-2");
//		MemberVO param = new MemberVO();
//     	param.setName("spring");
//     	param.setEmail("abc@yahoo.co.kr");
//     	
//     	MemberVO member = sqlMapper.selectOne(
//     		"kr.co.mlec.member.dao.MemberMapper.getMemberInfo2",
//     		param
//     	);
//     	
//     	System.out.println(member.getId());
//     	System.out.println(member.getEmail());
//     	System.out.println(member.getName());
//     	System.out.println(member.getAddr());
     	
//		MemberVO param = new MemberVO();
//     	param.setName("spring");
//     	param.setEmail("abc@yahoo.co.kr");
//     	
//     	String id = sqlMapper.selectOne(
//     			"kr.co.mlec.member.dao.MemberMapper.getMemberInfo2",
//         		param
//     	);
//     	System.out.println("회원아이디 : " + id);
		int count = sqlMapper.selectOne(
				"kr.co.mlec.member.dao.MemberMapper.getMemberInfo4"
		);
		System.out.println("전체 회원 수 : " + count);
	}

	/*
	 * select - 결과가 여러개
	 */
	private void test02() throws Exception {
//		List<MemberVO> list = sqlMapper.selectList(
//				"kr.co.mlec.member.dao.MemberMapper.getMemberList1"
//		);
//		for(MemberVO member : list) {
//			System.out.println(member.getId());
//			System.out.println(member.getAddr());
//			System.out.println(member.getName());
//			System.out.println(member.getEmail());
//			System.out.println(member.getJoinDate());
//			System.out.println("---------------");
//		}
		List<MemberVO> list = sqlMapper.selectList(
				"kr.co.mlec.member.dao.MemberMapper.getMemberList2"
		);
		for(MemberVO member : list) {
			System.out.println(member.getId());
			System.out.println(member.getAddr());
			System.out.println(member.getName());
			System.out.println(member.getEmail());
			System.out.println(member.getJoinDate());
			System.out.println("---------------");
		}
	}

	private void insertMember() throws Exception {
		sqlMapper.insert(
				"kr.co.mlec.member.dao.MemberMapper.insertMember",
				new MemberVO()
				.setId("member-5").setName("김")
				.setEmail("kim@mlec.com").setAddr("김포")
		);
		sqlMapper.commit();
		System.out.println("데이터가 입력되었습니다.");
	}
	
	private void updateMember() throws Exception {
		//아이디가 member-5인 회원의 주소를 "서울로 변경
		sqlMapper.update(
				"kr.co.mlec.member.dao.MemberMapper.updateMember",
				new MemberVO().setId("member-5").setAddr("서울")
		);
		sqlMapper.commit();
		System.out.println("데이터가 업데이트 되었습니다.");
	}
	
	private void deleteMember() throws Exception {
		sqlMapper.delete(
				"kr.co.mlec.member.dao.MemberMapper.deleteMember",
				"member-5"
		);
		sqlMapper.commit();
		System.out.println("데이터가 삭제 되었음");
	}
	
	private void selectForeach() throws Exception {
		String[] addrs = {"seoul", "busan"};
		MemberVO param = new MemberVO();
		param.setAddrs(addrs);
		
		List<MemberVO> list = sqlMapper.selectList(
				"kr.co.mlec.member.dao.MemberMapper.selectForEach",
				param
		);
		for(MemberVO member : list) {
			System.out.println(member.getId());
			System.out.println(member.getAddr());
			System.out.println(member.getName());
			System.out.println(member.getEmail());
			System.out.println(member.getJoinDate());
			System.out.println("---------------");
		}
	}
	
	private void dynamicSelect( ) throws Exception {
//		MemberVO param = new MemberVO();
////		param.setId("member-1");
//		List<MemberVO> list = sqlMapper.selectList(
//				"kr.co.mlec.member.dao.MemberMapper.selectDynamic1",
//				param
//		);
//		
//		for(MemberVO member : list) {
//			System.out.println(member.getId());
//			System.out.println(member.getAddr());
//			System.out.println(member.getName());
//			System.out.println(member.getEmail());
//			System.out.println(member.getJoinDate());
//			System.out.println("---------------");
//		}
		
//		SearchVO search = new SearchVO();
//		search.setSearchType("id");
//		search.setSearchWord("member-1");
//		search.setSearchType("addr");
//		search.setSearchWord("busan");
//		
//		List<MemberVO> list = sqlMapper.selectList(
//				"kr.co.mlec.member.dao.MemberMapper.selectDynamic2",
//				search
//		);
//		
//		for(MemberVO member : list) {
//			System.out.println(member.getId());
//			System.out.println(member.getAddr());
//			System.out.println(member.getName());
//			System.out.println(member.getEmail());
//			System.out.println(member.getJoinDate());
//			System.out.println("---------------");
//		}
		
		//addr에 "e" 가 포함되는 모든 회원의 정보를 출력
//		List<MemberVO> list = sqlMapper.selectList(
//				"kr.co.mlec.member.dao.MemberMapper.selectLike",
//				"e"
//		);
//		
//		for(MemberVO member : list) {
//			System.out.println(member.getId());
//			System.out.println(member.getAddr());
//			System.out.println(member.getName());
//			System.out.println(member.getEmail());
//			System.out.println(member.getJoinDate());
//			System.out.println("---------------");
//		}
		
		MemberVO param = new MemberVO();
		param.setId("member-1");
		param.setName("sbc");
		param.setAddr("s");
		List<MemberVO> list = sqlMapper.selectList(
				"kr.co.mlec.member.dao.MemberMapper.selectLike",
				param
		);
		
		for(MemberVO member : list) {
			System.out.println(member.getId());
			System.out.println(member.getAddr());
			System.out.println(member.getName());
			System.out.println(member.getEmail());
			System.out.println(member.getJoinDate());
			System.out.println("---------------");
		}
	}

	public static void main(String[] args) {
		try {
			new MemberMapper();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}