package com.koreait.fashionshop.model.product.service;

import java.util.List;

import com.koreait.fashionshop.common.FileManager;
import com.koreait.fashionshop.model.domain.Product;

public interface ProductService {
	public List selectAll();
	public List selectById(int subcategory_id);
	public Product select(int product_id);
	public void regist(FileManager fileManager,Product product);//insert �� �ϴ°� �ƴϱ� ����
	public void update(Product product);
	public void delete(int product_id);
}
