package controller;

import java.util.ArrayList;

import model.Member;
import model.Vaccine;

public class MemberController implements VeccineList { 	// ����
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
	public static boolean select(int index) {
		
		
		return true;
	}
	public static boolean check() {
		return true;
	}
	
	public static boolean cancel() {
		for (int i = 0; i < memberlist.size(); i++) {
			System.out.println(memberlist.get(i));		
			
			
		}		
		return true;	
	}
	@Override
		public void List() {
		 	System.out.println("============�ܿ���ŵ�ϸ���Ʈ=========");
			System.out.println("\n��ȣ\t����̸�\t����\t��������");
			int i = 1;
			for(Vaccine vaccine : AdminController.vaccinList) {
				System.out.println(i+"\t"+vaccine.getV_name()+"\t"+vaccine.getV_area()+
									"\t"+vaccine.getV_count());
				i++;
			}
		}
	
	
	
}
