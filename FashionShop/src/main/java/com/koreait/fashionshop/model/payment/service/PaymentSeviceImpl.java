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
	
	//주문관련 3가지 DAO 
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

	//주문 등록
	@Override
	public void registOrder(OrderSummary orderSummary, Receiver receiver) {
		//주문요약 등록
		orderSummaryDAO.insert(orderSummary);
		//주문 요약이 등록된 이후 orderSummary VO에는 mybatis의 selectkey에의해 order_summary_id가 채워져있다. 
		//따라서 취득한 주문번호를 배송정보, 상세주문에 넣어줘야함 
		
		//배송정보 등록
		receiver.setOrder_summary_id(orderSummary.getOrder_summary_id());
		receiverDAO.insert(receiver);
		
		//주문상세 등록 
		//장바구니를 조회하여 OrderDetail VO처리
		//장바구니 가져오기 
	}

}
