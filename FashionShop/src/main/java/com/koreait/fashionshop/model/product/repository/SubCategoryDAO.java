package com.koreait.fashionshop.model.product.repository;

import java.util.List;

import com.koreait.fashionshop.model.domain.SubCategory;

public interface SubCategoryDAO {
	//CRUD
	public List<SubCategory> selectAll();//��� ���ڵ� �������� 
	public List<SubCategory> selectAllById(int topcategory_id);//������ ���� ī�װ����� �Ҽӵ� ����ī�װ��� ��� �������� 
	public SubCategory select(int subcategory_id);
	public void insert(SubCategory subcategory);
	public void update(SubCategory subcategory);
	public void delete(int subcategory_id);

}