package com.koreait.fashionshop.controller.product;

import java.util.List;

import javax.servlet.ServletContext;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ServletContextAware;
import org.springframework.web.servlet.ModelAndView;

import com.koreait.fashionshop.exception.ProductRegistException;
import com.koreait.fashionshop.model.common.FileManager;
import com.koreait.fashionshop.model.domain.Product;
import com.koreait.fashionshop.model.domain.Psize;
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
		List productList = productService.selectAll();
		mav.addObject("productList", productList);
		return mav;
	}

	// ��ǰ��� ��
	@RequestMapping(value = "/admin/product/registform")
	public String registForm() {
		return "admin/product/regist_form";
	}
	// ��ǰ ��

	// ��ǰ ���
	@RequestMapping(value="/admin/product/regist", method = RequestMethod.POST, produces = "text/html;charset=utf8")
	@ResponseBody
	public String registProduct(Product product) {
		logger.debug("����ī�װ� " + product.getSubCategory().getSubcategory_id());
		logger.debug("��ǰ�� " + product.getProduct_name());
		logger.debug("���� " + product.getPrice());
		logger.debug("�귣�� " + product.getBrand());
		logger.debug("�󼼳��� " + product.getDetail());
		for(Psize psize : product.getPsize()) {
			logger.debug(psize.getFit());
		}
		/*
		logger.debug("���ε� �̹����� " + product.getRepImg().getOriginalFilename());
		
		for (int i=0; i<product.getAddImg().length;i++) {
			logger.debug("�߰��̹����� " + product.getAddImg()[i].getOriginalFilename());
		}
		*/
		productService.regist(fileManager,product);//��ǰ���		
		
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"result\":1,");
		sb.append("\"msg\":\"��ǰ��� ����\"");
		sb.append("}");
		
		return sb.toString();
	}

	

	// ��ǰ ����

	// ��ǰ ����
	
	// ���� ó�� 
	//���� �޼��� �߿��� �ϳ��� ���ܰ� �߻��ϸ�, �Ʒ��� �ڵ鷯�� ����
	@ExceptionHandler(ProductRegistException.class)
	@ResponseBody
	public String handleException(ProductRegistException e) {
		StringBuilder sb = new StringBuilder();
		sb.append("{");
		sb.append("\"result\":0");
		sb.append("\"msg\":\""+e.getMessage()+"\"");
		sb.append("}");
		return sb.toString();
	}
	
	/*****************************************
	 	���θ� ����Ʈ ��û ó��
	 *****************************************/
	
	//��ǰ��� ��û ó�� 
	@RequestMapping(value = "/shop/product/list", method = RequestMethod.GET)
	public ModelAndView getShopProductList(int subcategory_id) {//����ī�װ��� id 
		List topList = topCategoryService.selectAll();//��ǰī�װ� ��� 
		List productList = productService.selectById(subcategory_id);//��ǰ���

		ModelAndView mav = new ModelAndView();
		mav.addObject("topList",topList);
		mav.addObject("productList",productList);
		
		mav.setViewName("shop/product/list");
		return mav;
	}
	
	//��ǰ�󼼺��� ��û 
	@RequestMapping(value = "/shop/product/detail", method = RequestMethod.GET)
	public ModelAndView getShopProductDetail(int product_id) {
		List topList = topCategoryService.selectAll();//��ǰī�װ� ��� 
		Product product = productService.select(product_id);//��ǰ1�ǰ�������
		
		ModelAndView mav = new ModelAndView("shop/product/detail");
		mav.addObject("topList",topList);
		mav.addObject("product",product);
		
		return mav;
	}
}