package com.koreait.fashionshop.model.member.repository;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;

public interface MemberDAO {
	public List selectAll(); //��� ȸ����������
	public Member select(); //ȸ��1����������
	public void insert(Member member);//ȸ�����
	public void update(Member member);//ȸ������ ����
	public void delete(Member member);//ȸ������ ���� (���̵�� ����� ��ġ�Ұ��(��ٷӰ�) ����- �������߰��ǹǷ� ȸ�����߿��ϹǷ�)	
}