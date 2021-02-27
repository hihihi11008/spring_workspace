package com.koreait.fashionshop.excel;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelManager {
	FileInputStream fis;
	public ExcelManager() {
		//������ ������ �����ϱ� ���ؼ��� ���� ��Ʈ���� �ʿ��ϴ� 
		try {
			fis = new FileInputStream("C:/spring_workspace/FashionShop/src/main/webapp/resources/excel/myskill.xlsx");
			
			//������ �����ϴ� ��ü ����  XSSFWorkbook
			XSSFWorkbook workbook = new XSSFWorkbook(fis);
			
			//���������� ������ �����̹Ƿ�, �̽������ʹ� ��Ʈ�� �����Ѵ� 
			XSSFSheet sheet = workbook.getSheetAt(0);//ù��° sheet����
			
			//�� �������ʹ� sheet�� ������ �� �����Ƿ�, �� ����� �����ϴ������� �˾ƺ��� 
			int rows=sheet.getPhysicalNumberOfRows();//�����Ͱ� ä���� row ��
			System.out.println("���ڵ� ���� : "+rows);
			
			//�ο�� �÷�����ŭ �ݺ��������Ͽ� �����͸� �����غ��� 
			for (int i=0; i<rows;i++) {
				XSSFRow row = sheet.getRow(i);
				
				//�÷��� ��ŭ �ݺ��� ����
				int columnCount =row.getPhysicalNumberOfCells();
				for(int a =0; a<columnCount;a++) {
					XSSFCell cell = row.getCell(a);
				
					//������ �ڷ����� �Ǵ��Ͽ� �׿� �°� ����
					if (cell.getCellType() == CellType.STRING) {//�����ڷ����� �����ΰ��
						System.out.print(cell.getStringCellValue()+"\t");
					}else if (cell.getCellType() == CellType.NUMERIC) {
						System.out.print((int)cell.getNumericCellValue()+"\t");
					}
				}
				System.out.println();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if (fis!=null) {
				try {
					fis.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new ExcelManager();
	}
}