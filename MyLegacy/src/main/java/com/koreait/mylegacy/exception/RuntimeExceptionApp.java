package com.koreait.mylegacy.exception;

/*
 * ��翹���� �ֻ��� ��ü�� �׳� Exception�ε�
 * �� ���ܴ� ũ�� Ŀ���� Ÿ�ӿ� ó���� �����ϴ� ����
 * ��Ÿ�ӽ� ���ܸ� ó���� �� �ִ� ��Ÿ�ӿ��ܰ� �ִ�. (�������� ����)
 * */
public class RuntimeExceptionApp {
	public static void main(String[] args) {
		int[] arr=new int[3];
		arr[0]=11;
		arr[1]=12;
		arr[2]=13;
		
		//��� �Ʒ��� �ڵ带 ������� ����ó���� ���������� ������, �����ڴ� ���� �������� ���α׷����� �����Ϸ��� 
		//������ ����� �����ؾ��Ѵ�
		
		try {
			arr[3]=6;//�������� �ʴ� �ε���[] �迭�� ������ �Ѿ
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("�˼��մϴ�. ������ �߻��߾");
			//����ڿ��� �̸��� �߼�, sms���� ����, �پ��� ó�� ���� �����ϱ� ���� �α� �� ���
		}
	}
	
}
