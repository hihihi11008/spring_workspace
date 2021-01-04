package com.koreait.fashionshop.controller.admin;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.common.FileManager;
import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.SubCategory;
import com.koreait.fashionshop.model.product.service.ProductService;
import com.koreait.fashionshop.model.product.service.SubCategoryService;
import com.koreait.fashionshop.model.product.service.TopCategoryService;

//������ ��忡���� ��ǰ�� ���� ��û ó��
@Controller
public class ProductController implements ServletContextAware{
	private static final Logger logger = LoggerFactory.getLogger(ProductController.class);
	@Autowired
	private TopCategoryService topCategoryService;

	@Autowired
	private SubCategoryService subCategoryService;
	
	@Autowired
	private ProductService productService;
	
	@Autowired
	private FileManager fileManager;
	
	//�츮�� �� Servletcontext�� ����ϴ°�? getRealPath()����Ϸ���
	private ServletContext servletContext;
	
	@Override
	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		//�� Ÿ�̹��� ��ġ�� ����, ���� ��������θ� FileManager�� �����س��� 
		fileManager.setSaveBasicDir(servletContext.getRealPath(fileManager.getSaveBasicDir()));
		fileManager.setSaveAddonDir(servletContext.getRealPath(fileManager.getSaveAddonDir()));
		
		logger.debug(fileManager.getSaveBasicDir());
	}
	
	// ���� ī�װ� ��������
	@RequestMapping(value = "/admin/product/registform", method = RequestMethod.GET)
	public ModelAndView getTopList() {
		List topList = topCategoryService.selectAll();// 3�ܰ�:���� ��ü�� �Ͻ�Ű��

		// 4�ܰ�:����
		ModelAndView mav = new ModelAndView();
		mav.addObject("topList", topList);
		mav.setViewName("admin/product/regist_form");
		return mav;
	}

	// ���� ī�װ� ��������
	// ������������ java��ü�� json�� ��ȯ�� �ڵ����� ó�����ִ� ���̺귯���� �����Ѵ�
	@RequestMapping(value = "/admin/product/sublist", method = RequestMethod.GET)
	@ResponseBody
	public List<SubCategory> getSubList(int topcategory_id) {
		List<SubCategory> subList = subCategoryService.selectAllById(topcategory_id);
		return  subList;
	}

	/*
	 * @RequestMapping(value="/admin/product/sublist",method=RequestMethod.GET,
	 * produces = "application/json;charset=utf8")
	 * 
	 * @ResponseBody //jsp�� ���� ���������� �ƴ�, �ܼ� �����͸� ���۽� public String getSubList(int
	 * topcategory_id) { logger.debug("topcategory_id:" +topcategory_id);
	 * 
	 * List<SubCategory> subList=subCategoryService.selectAllById(topcategory_id);
	 * 
	 * //����Ʈ�� jsop���� �����ؾ� �Ѵ�. StringBuilder sb = new StringBuilder();
	 * sb.append("{"); sb.append("\"subList\" : ["); for(int
	 * i=0;i<subList.size();i++) { SubCategory subCategory=subList.get(i);
	 * sb.append("{");
	 * sb.append("\"subcategory_id\":"+subCategory.getSubcategory_id()+",");
	 * sb.append("\"topcategory_id\":"+subCategory.getTopcategory_id()+",");
	 * sb.append("\"name\":\""+subCategory.getName()+"\""); if(i<subList.size()-1) {
	 * sb.append("},"); }else { sb.append("}"); } }
	 * 
	 * sb.append("]"); sb.append("}");
	 * 
	 * return sb.toString(); }
	 */

	// ��ǰ ���
	@RequestMapping(value = "/admin/product/list", method = RequestMethod.GET)
	public ModelAndView getProductList() {
		ModelAndView mav = new ModelAndView("admin/product/product_list");
		return mav;
	}

	// ��ǰ��� ��
	@RequestMapping(value = "/admin/product/registform")
	public String registForm() {
		return "admin/product/regist_form";
	}
	// ��ǰ ��

	// ��ǰ ���
	@RequestMapping(value="/admin/product/regist", method = RequestMethod.POST)
	@ResponseBody
	public String registProduct(Product product) {
		logger.debug("����ī�װ� " + product.getSubcategory_id());
		logger.debug("��ǰ�� " + product.getProduct_name());
		logger.debug("���� " + product.getPrice());
		logger.debug("�귣�� " + product.getBrand());
		logger.debug("�󼼳��� " + product.getDetail());
		/*
		logger.debug("���ε� �̹����� " + product.getRepImg().getOriginalFilename());
		
		for (int i=0; i<product.getAddImg().length;i++) {
			logger.debug("�߰��̹����� " + product.getAddImg()[i].getOriginalFilename());
		}
		*/
		productService.regist(fileManager,product);//��ǰ���		
		/*
		for(int i=0; i<product.getFit().length;i++) {
			String fit = product.getFit()[i];
			logger.debug("���� ������� " + fit);
		}
		*/
		return "hahah";
	}

	

	// ��ǰ ����

	// ��ǰ ����
	
	// ���� ó�� 
	//���� �޼��� �߿��� �ϳ��� 
}