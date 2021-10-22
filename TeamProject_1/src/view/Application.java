package view;

import java.util.Scanner;

import controller.AdminController;
import controller.MemberController;

public class Application {

	public static Scanner scanner = new Scanner(System.in); // 여기저기서 끌어다쓰기위해

	public static void main(String[] args) { //

		mainmenu(); // 메인 메뉴 메소드 호출
	} 

	public static void mainmenu() {
		while (true) {
			try {
				System.out.println("=======코로나 잔여백신 예약프로그램==========");
				System.out.println("1.비회원로그인|2.관리자로그인");
				System.out.println("=======================================");
				System.out.print("선택 : ");
				int ch = scanner.nextInt();
				if (ch == 1) {
					System.out.println("이름을입력하세요 : ");
					String name = scanner.next();
					System.out.println("전화번호를 입력하세요 : ");
					int phone = scanner.nextInt();

					boolean result = MemberController.m_login(name , phone);
						if(result) {
							System.out.println("[알림] : 로그인성공");
							membermenu(name, phone);	
						}
				} else if (ch == 2) {
					System.out.println("관리자코드를 입력하세요 : ");
					String Code = scanner.next();
					boolean result = AdminController.login(Code);
						if(result) { 
							adminmenu();	
						}
						else { System.out.println("알수없는 입력입니다.");
						}
				} else {
					System.out.println("[[알림]] : 잘못된입력입니다. [관리자에게문의]");
				}
			} catch (Exception e) {
				System.out.println("[[알림]] : 메뉴 페이지 오류[ 관리자에게 문의 ] ");
				scanner = new Scanner(System.in); // 입력객체 초기화
			}
		}
	}

	// 예약자 메뉴
	public static void membermenu(String id, int phone) {
		while(true) {
			System.out.println("=============예약자메뉴==============");
			System.out.println("");
		}
		
	}

	// 관리자 메뉴
	public static void adminmenu() {
		while(true) {
			System.out.println("================관리자메뉴===============");
			System.out.println("1.잔여백신등록|2.잔여백신등록취소|3.잔여백신재고확인");
			System.out.println("======================================");
			System.out.print(">>선택 : "); int ch = scanner.nextInt();
			if(ch==1) {
				
			}
			else if(ch==2) {
				
			}
			else if(ch==3) {
				
			}
			else { System.out.println("[[알림]] : 잘못된입력입니다. [관리자에게문의]");
					
			}
		}
	}

}
