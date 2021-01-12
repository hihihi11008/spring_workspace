package com.koreait.fashionshop.model.qna.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.QnaDMLException;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.domain.Qna;

@Repository
public class MybatisQnaDAO implements QnaDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	@Override
	public List<Qna> selectAll() {
		return sqlSessionTemplate.selectList("Qna.selectAll");
	}

	@Override
	public List<Qna> selectAll(Member member) {
		return null;
	}

	@Override
	public Qna select(int qna_id) {
		return null;
	}

	@Override
	public void insert(Qna qna) throws QnaDMLException{
		int result = sqlSessionTemplate.insert("Qna.insert", qna);
		if (result==0) {
			throw new QnaDMLException("등록 실패 하였습니다");
		}
	}

	@Override
	public void reply(Qna qna) {
		
	}

	@Override
	public void update(Qna qna) {
		
	}

	@Override
	public void delete(int qna_id) {
		
	}

}
