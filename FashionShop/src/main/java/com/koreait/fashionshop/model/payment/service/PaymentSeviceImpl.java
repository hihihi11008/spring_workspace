package com.koreait.fashionshop.model.payment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.exception.CartException;
import com.koreait.fashionshop.model.domain.Cart;
import com.koreait.fashionshop.model.payment.repository.CartDAO;

@Service
public class PaymentSeviceImpl implements PaymentService{
	@Autowired
	private CartDAO cartDAO;
	

	@Override
	public List selectCartList() {
		return null;
	}

	@Override
	public List selectCartList(int member_id) {
		return null;
	}

	@Override
	public Cart selectCart(int cart_id) {
		return null;
	}

	@Override
	public void insert(Cart cart) throws CartException{
		cartDAO.insert(cart);
	}

	@Override
	public void update(Cart cart) {
		
	}

	@Override
	public void delete(Cart cart) {
		
	}

}
