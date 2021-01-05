package com.koreait.fashionshop.model.member.repository;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;

public interface MemberDAO {
	public List selectAll(); //모든 회원가져오기
	public Member select(); //회원1명가져오기
	public void insert(Member member);//회원등록
	public void update(Member member);//회원정보 수정
	public void delete(Member member);//회원정보 삭제 (아이디와 비번이 일치할경우(까다롭게) 삭제- 조건이추가되므로 회원은중요하므로)	
}
