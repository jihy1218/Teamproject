package view;

import java.lang.reflect.Member;
import java.util.Scanner;

import controller.MemberController;

public class Application {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {	// 
		
		mainmenu(); // 메인 메뉴 메소드 호출
	}
	
	public static void mainmenu() {
		while(true) {
			System.out.println("=======코로나 잔여백신 예약프로그램==========");
			System.out.println("1.비회원로그인|2.관리자로그인");
			System.out.println("=======================================");
			System.out.print("선택 : "); int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("이름을입력하세요 : "); String name = scanner.next();
				System.out.println("전화번호를 입력하세요 : "); int phone = scanner.nextInt();
			
//				boolean result = MemberController.m_login(name , phone);
				// 중복으로 이름&&번호 똑같이 들어가면 체크해야할듯
//				if(result) {
					membermenu(name,phone);
//				}
			}
			else if(ch==2) {}
			else {
				System.out.println("[[알림]] : 잘못된입력입니다. [관리자에게문의]");
			}
		}
	}
	
	
	
	// 예약자 메뉴
	public static void membermenu(String id , int phone) {
		
	}
	// 관리자 메뉴
	public static void boardmenu(String id) {
		
	}
	
	
	
	
}
