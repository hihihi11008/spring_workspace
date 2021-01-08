package com.koreait.fashionshop.model.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.domain.Member;
import com.koreait.fashionshop.model.domain.OrderDetail;
import com.koreait.fashionshop.model.domain.OrderSummary;
import com.koreait.fashionshop.model.domain.Receiver;
import com.koreait.fashionshop.model.payment.repository.CartDAO;
import com.koreait.fashionshop.model.payment.repository.OrderDetailDAO;
import com.koreait.fashionshop.model.payment.repository.OrderSummaryDAO;
import com.koreait.fashionshop.model.payment.repository.PaymethodDAO;
import com.koreait.fashionshop.model.payment.repository.ReceiverDAO;

@Service
public class PaymentSeviceImpl implements PaymentService{
	@Autowired
	private CartDAO cartDAO;
	
	@Autowired
	private PaymethodDAO paymethodDAO;
	
	//�ֹ����� 3���� DAO 
	@Autowired
	private OrderSummaryDAO orderSummaryDAO;
	
	@Autowired
	private ReceiverDAO receiverDAO;

	@Autowired
	private OrderDetailDAO orderDetailDAO;

	@Override
	public List selectCartList() {
		return null;
	}

	@Override
	public List selectCartList(int member_id) {
		return cartDAO.selectAll(member_id);
	}

	@Override
	public Cart selectCart(int cart_id) {
		return null;
	}

	@Override
	public void insert(Cart cart) throws CartException{
		cartDAO.duplicateCheck(cart);
		cartDAO.insert(cart);
	}

	@Override
	public void update(List<Cart> cartList) throws CartException{
		for(Cart cart :cartList) {
			cartDAO.update(cart);
		}
	}

	@Override
	public void delete(Cart cart) {
		
	}

	public void delete(Member member) throws CartException{
		cartDAO.delete(member);
	}

	@Override
	public List selectPaymethodList() {
		return paymethodDAO.selectAll();
	}

	//�ֹ� ���
	@Override
	public void registOrder(OrderSummary orderSummary, Receiver receiver) {
		//�ֹ���� ���
		orderSummaryDAO.insert(orderSummary);
		//�ֹ� ����� ��ϵ� ���� orderSummary VO���� mybatis�� selectkey������ order_summary_id�� ä�����ִ�. 
		//���� ����� �ֹ���ȣ�� �������, ���ֹ��� �־������ 
		
		//������� ���
		receiver.setOrder_summary_id(orderSummary.getOrder_summary_id());
		receiverDAO.insert(receiver);
		
		//�ֹ��� ��� 
		//��ٱ��ϸ� ��ȸ�Ͽ� OrderDetail VOó��
		//��ٱ��� �������� 
	}

}
