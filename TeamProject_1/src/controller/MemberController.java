package controller;

import java.util.ArrayList;

import model.Member;
import model.Vaccine;

public class MemberController implements VeccineList { 	// 동진
// 	필드 : ArrayList<Member> memberlist
//	메소드 : login , select , cancel , list(v_list로 대체)
	// 필드
	public static ArrayList<Member> memberlist = new ArrayList<>();
	// 메소드
	public static String m_login(String name , String phone) {
		if(name.equals("admin")&& phone.equals("12345678910")) {
			return "admin";
			
		}else {
		return "예약자";  }
	}
	public static boolean select(String name, String phone , String v_name, String v_area) {
		for(Vaccine temp : AdminController.vaccinList) {
			if(temp.getV_name().equals(v_name)&&temp.getV_area().equals(v_area)) {				
				memberlist.add(new Member(name, phone, v_name, v_area));
				temp.setV_count(temp.getV_count()-1);
				return true;
			}
		}
		return false;
	}
	public static boolean check() {
		
		return true;
	}
	
	public static boolean cancel() {
		for (int i = 0; i < memberlist.size(); i++) {
					
			
			
		}		
		return true;	
	}
	@Override
		public void List() {
		 	System.out.println("============잔여백신등록리스트=========");
			System.out.println("\n번호\t백신이름\t지역\t남은수량");
			int i = 1;
			for(Vaccine vaccine : AdminController.vaccinList) {
				System.out.println(i+"\t"+vaccine.getV_name()+"\t"+vaccine.getV_area()+
									"\t"+vaccine.getV_count());
				i++;
			}
		}
	
	
	
}
