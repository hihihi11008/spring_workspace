package com.koreait.fashionshop.model.qna.service;

import java.util.List;

import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.domain.Qna;

public interface QnaService {
	public List<Qna> selectAll();
	public List<Qna> selectAll(Member member); //ȸ���� ��ϸ� �������� (ȸ����������)
	public Qna select(int qna_id);
	public void insert(Qna qna);
	public void reply(Qna qna);//����ʿ�� 
	public void update(Qna qna);
	public void delete(int qna_id);
}
