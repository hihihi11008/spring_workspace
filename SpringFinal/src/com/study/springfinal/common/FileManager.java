/*
 * ���ϰ� ���õ� ������ ����� ��Ƴ��� Ŭ����
 * */
package com.study.springfinal.common;

import java.io.File;

public class FileManager {
	
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




