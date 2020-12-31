package com.koreait.fashionshop.model.product.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.koreait.fashionshop.model.domain.TopCategory;
import com.koreait.fashionshop.model.product.repository.TopCategoryDAO;

@Service
public class TopCategoryServiceImpl implements TopCategoryService{
	@Autowired
	private TopCategoryDAO topCategoryDAO;

	@Override
	public List<TopCategory> selectAll() {
		return topCategoryDAO.selectAll();
	}

	@Override
	public TopCategory select(int topcategory_id) {
		return null;
	}

	@Override
	public void insert(TopCategory topcategory) {
		
	}

	@Override
	public void update(TopCategory topcategory) {
		
	}

	@Override
	public void delete(int topcategory_id) {
		
	}

}
