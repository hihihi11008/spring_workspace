/*
 * ���ϰ� ���õ� ������ ����� ��Ƴ��� Ŭ����
 * */
package com.koreait.fashionshop.common;

import java.io.File;

public class FileManager {
	private String saveDir;
	public void setSaveDir(String saveDir) {
		this.saveDir = saveDir;
	}
	public String getSaveDir() {
		return saveDir;
	}
	
	//Ȯ���ڸ� �����ϱ� 
	public static String getExtend(String path) {
		int lastIndex = path.lastIndexOf(".");
		String ext = path.substring(lastIndex+1, path.length());
		//System.out.println(ext);		
		return ext;
	}
	
	//���ϻ���  : ȣ���ڴ� �����ϰ���� ������ ��θ� �ѱ��
	public static boolean deleteFile(String path) {
		File file = new File(path);
		return file.delete();
	}
}




