package controller;

import java.util.ArrayList;
import model.Vaccine;

public class AdminController implements VeccineList { // ��

//	�ʵ� : ArrayList<Vaccine> vaccinelist
//	�޼ҵ� : login, register, update , v_list
	//���ƿ�
	// �ʵ�
	public static ArrayList<Vaccine> vaccinList = new ArrayList<>();
	
	// �޼ҵ�
	public static boolean login(String Code) {
		if(Code.equals("12345")) {
			System.out.println("�ݰ����ϴ�. �����ڴ�");
			return true; // �����ڷα��μ�����
		}
		return false; // ������ �α��ν��н�
	}

	
	
	public static boolean register() {
		return true;
	}
	public static boolean update() {
		return true;
	}
	public static boolean v_list() {
		return true;
	}
	
	
	
}
