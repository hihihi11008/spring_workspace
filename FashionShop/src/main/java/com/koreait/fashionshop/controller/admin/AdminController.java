package com.koreait.fashionshop.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AdminController {

	//�����ڸ�� ���ο�û
	@RequestMapping("/admin")
	public String adminMain() {
		return "admin/main";
	}
	
	//
}
