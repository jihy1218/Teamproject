package controller;

import java.util.ArrayList;

import model.Member;

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
	
	
	
}
