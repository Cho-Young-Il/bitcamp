package bitmem.dao.member;

import java.util.List;

import bitmem.vo.member.Member;

public interface MemberDao {
	List<Member> selectList() throws Exception;
	Member selectOne(int no) throws Exception;
	Member exist(Member member) throws Exception;
	int insert(Member member) throws Exception;
	int update(Member member) throws Exception;
	int updatePermission(Member member) throws Exception;
	void delete(String[] numbers) throws Exception;
}
