package controller;

import java.util.ArrayList;
import model.Vaccine;

public class AdminController { // 혁

//	필드 : ArrayList<Vaccine> vaccinelist
//	메소드 : login, register, update , v_list
	//좋아요
	// 필드
	static ArrayList<Vaccine> vaccinList = new ArrayList<>();
	
	// 메소드
	public static boolean login(String Code) {
		if(Code.equals("12345")) {
			System.out.println("반갑습니다. 관리자님");
			return true; // 관리자로그인성공시
		}
		return false; // 관리자 로그인실패시
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
