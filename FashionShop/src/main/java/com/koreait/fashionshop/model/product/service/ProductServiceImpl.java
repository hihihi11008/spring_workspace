package com.koreait.fashionshop.model.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.product.repository.ProductDAO;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductDAO productDAO;

	@Override
	public List selectAll() {
		return null;
	}

	@Override
	public List selectById(int subcategory_id) {
		return null;
	}

	@Override
	public Product select(int product_id) {
		return null;
	}

	@Override
	public void regist(Product product) {
		productDAO.insert(product);
	}

	@Override
	public void update(Product product) {
		
	}

	@Override
	public void delete(int product_id) {
		
	}

}
