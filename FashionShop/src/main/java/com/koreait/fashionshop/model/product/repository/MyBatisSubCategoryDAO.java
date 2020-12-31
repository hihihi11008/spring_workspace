package com.koreait.fashionshop.model.product.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.koreait.fashionshop.model.domain.SubCategory;

@Repository
public class MyBatisSubCategoryDAO implements SubCategoryDAO{
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	@Override
	public List<SubCategory> selectAll() {
		return null;
	}

	@Override
	public List selectAllById(int topcategory_id) {
		return sqlSessionTemplate.selectList("SubCategory.selectAllById", topcategory_id);
	}

	@Override
	public SubCategory select(int subcategory_id) {
		return null;
	}

	@Override
	public void insert(SubCategory subcategory) {
		
	}

	@Override
	public void update(SubCategory subcategory) {
		
	}

	@Override
	public void delete(int subcategory_id) {
		
	}

}
