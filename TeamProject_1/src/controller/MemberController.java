package controller;

import java.util.ArrayList;

import model.Member;

public class MemberController { 	// ����
// 	�ʵ� : ArrayList<Member> memberlist
//	�޼ҵ� : login , select , cancel , list(v_list�� ��ü)
	// �ʵ�
	public static ArrayList<Member> memberlist = new ArrayList<>();
	// �޼ҵ�
	public static String m_login(String name , String phone) {
		if(name.equals("admin")&& phone.equals("12345678910")) {
			return "admin";
			
		}else {
		return "������";  }
	}
	public static boolean select() {
		return true;
	}
	public static boolean check() {
		return true;
	}
	
	public static boolean cancel() {
		return true;
	}
	
	
	
}
