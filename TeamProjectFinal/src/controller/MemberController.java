package controller;

import java.util.ArrayList;
import java.util.Iterator;

import database.File;
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
		}				
			int p_len = phone.length();
			if (p_len<11||p_len>11) {
				
				return "����";
			}
		return "������";  }
	// ch==2  ��ż����ϱ�
	public static boolean select(String name, String phone,String v_name, String v_area) {
		for(Vaccine temp : AdminController.vaccinList) {
			if(temp.getV_name().equals(v_name)&&temp.getV_area().equals(v_area)) {				
				memberlist.add(new Member(name, phone, v_name, v_area));
				temp.setV_count(temp.getV_count()-1);
				return true;
			}
		}
		
		
		return false;
	}
	// ch==3 ��ûȮ��
	public static boolean check(String phone) {
		for(Member temp : memberlist) {
			if(temp.getPhone().equals(phone)) {
				System.out.println("������: "+temp.getName()+"\t��Ÿ�: "+temp.getVaccinename()+"\t����: "+temp.getArea());
				return true;
			}
		}
		return false;
	}
	// ��û���
	public static boolean cancel(String phone) {
		for(Member member : memberlist) {
			if(member.getPhone().equals(phone)) {
				for(Vaccine vaccine : AdminController.vaccinList) {
					if(vaccine.getV_name().equals(member.getVaccinename())) {
						vaccine.setV_count(vaccine.getV_count()+1);
						memberlist.remove(memberlist.indexOf(member));						
						return true;
					}
				}
			}
		}
		return false;	
	}

	
	
	@Override
		public void List() {
		 	System.out.println("============�ܿ���Ÿ���Ʈ=========");
			System.out.println("\n��ȣ\t����̸�\t����\t��������");
			int i = 1;
			for(Vaccine vaccine : AdminController.vaccinList) {
				System.out.println(i+"\t"+vaccine.getV_name()+"\t"+vaccine.getV_area()+
									"\t"+vaccine.getV_count());
				i++;
			}
		}
	
	
	
}