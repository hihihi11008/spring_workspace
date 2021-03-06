package com.koreait.fashionshop.model.domain;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Data;

@Data
public class Product {
	private int product_id; 
	private SubCategory subCategory;
	private String product_name;
	private int price;
	private String brand;
	private String detail;
	private String filename;
	
	//이미지 하나를 자동으로 처리하는 객체 선언
	//단, 이름은 html의 업로드 컴포넌트 파라미터명과 일치시켜야 자동으로 업로드 처리 
	private MultipartFile repImg; //대표이미지 
	private MultipartFile[] addImg;//추가이미지는 선택사항이며, 동시에 배열 
	
	//조인할때 사용함
	private Score score;
	private List<Psize> psizeList;
	private List<Color> colorList;
	private List<Image> imageList;
	
	//insert할때 사용
	private Color[] color;
	private Psize[] psize;
	
}