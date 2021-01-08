package com.koreait.fashionshop.model.bank.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.exception.WithdrawFailException;

@Repository
public class JdbcKbankDAO implements KbankDAO{
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	//DI��? ������ �ִ� ��ü�� ���� �������� ����, �ܺηκ��� ���Թ��� 
	//			��ü�� ���յ��� ��ȭ��Ű������ 
	//			�׷��ٸ� ���յ� ������ ���ֹ����� ���..?
	
	//���
	public void withdraw(int money) throws WithdrawFailException{
		int result = jdbcTemplate.update("update kbank set total=total-?", money);
		if (result==0) {
			throw new WithdrawFailException("��ݽ����߽��ϴ�");
		}
	}

}
