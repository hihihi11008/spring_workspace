package com.koreait.fashionshop.model.product.service;

import java.io.File;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.koreait.fashionshop.common.FileManager;
import com.koreait.fashionshop.model.domain.Color;
import com.koreait.fashionshop.model.domain.Image;
import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.Psize;
import com.koreait.fashionshop.model.product.repository.ColorDAO;
import com.koreait.fashionshop.model.product.repository.ImageDAO;
import com.koreait.fashionshop.model.product.repository.ProductDAO;
import com.koreait.fashionshop.model.product.repository.PsizeDAO;

@Service
public class ProductServiceImpl implements ProductService{
	private static final Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);
	@Autowired
	private ProductDAO productDAO;
	
	@Autowired
	private ImageDAO imageDAO;
	
	@Autowired
	private PsizeDAO psizeDAO;

	@Autowired
	private ColorDAO colorDAO;
	
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
	public void regist(FileManager fileManager, Product product) {
		String ext=FileManager.getExtend(product.getRepImg().getOriginalFilename());
		product.setFilename(ext);//Ȯ���� ����
		//db�� �ִ� ���� DAO���� ��Ű�� 
		productDAO.insert(product);
		
		//���Ͼ��ε�� fileManager���� ��Ű�� 
		//��ǥ�̹��� ���ε� 
		// ��ǰ�� product_id�� �̿��Ͽ�, ��ǥ�̹����� ��������
		String basicImg = product.getProduct_id()+"."+ext;
		fileManager.saveFile(fileManager.getSaveBasicDir()+File.separator+basicImg, product.getRepImg());
		
		//�߰� �̹��� ���ε� (FileManager���� �߰��̹��� ������ŭ ���ε� ������ ��Ű��ȴ� 
		for (int i=0; i<product.getAddImg().length;i++) {
			MultipartFile file = product.getAddImg()[i];
			ext = FileManager.getExtend(file.getOriginalFilename());
			
			//image table�� �ֱ� 
			Image image = new Image();
			image.setProduct_id(product.getProduct_id());
			image.setFilename(ext);//Ȯ���ڳֱ�
			imageDAO.insert(image);
			
			//�Ŵ����� ���� �޼��� ȣ��
			String addImg = image.getImage_id()+"."+ext;
			fileManager.saveFile(fileManager.getSaveAddonDir()+File.separator+addImg, file);
		}
		
		//��Ÿ�ɼ� ��, ����,������ �ֱ� (�ݺ������� )
		
		
		//������ 
		for(Psize psize : product.getPsize()) {
			logger.debug("����� ������ ������� " + psize.getFit());
			//psize.setProduct_id(product.getProduct_id());//fk����
			//psizeDAO.insert(psize);
		}
		
		//����
		for(Color color : product.getColor()) {
			logger.debug("�Ѱܹ��� ������ " + color.getPicker());
			//color.setProduct_id(product.getProduct_id());
			//colorDAO.insert(color);
		}
		
	}

	@Override
	public void update(Product product) {
		
	}

	@Override
	public void delete(int product_id) {
		
	}

}
