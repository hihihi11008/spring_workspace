package com.koreait.fashionshop.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.model.domain.TopCategory;

@Repository //component-scan의 대상이 되려면! 
public class MyBatisTopCategoryDAO implements TopCategoryDAO{
	@Autowired
	private SqlSessionTemplate sessionTemplate; 
	
	@Override
	public List<TopCategory> selectAll() {
		return sessionTemplate.selectList("TopCategory.selectAll");
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
