package view;

import java.util.Scanner;

import controller.AdminController;
import controller.MemberController;
import controller.VeccineList;
import model.Vaccine;

public class Application {

	public static Scanner scanner = new Scanner(System.in); // 여기저기서 끌어다쓰기위해

	public static void main(String[] args) { //

		mainmenu(); // 메인 메뉴 메소드 호출
	} 

	public static void mainmenu() {
		while (true) {
			try {
				System.out.println("=======코로나 잔여백신 예약프로그램==========");
				System.out.println("이름을입력하세요 : ");
				String name = scanner.next();
				System.out.println("전화번호를 입력하세요 : ");
				String phone = scanner.next();
				String check = MemberController.m_login(name, phone);
				
				if (check.equals("예약자")) {
					System.out.println("[알림] : 로그인성공");
					membermenu(name, phone);
				}if (check.equals("admin")) {
					System.out.println("관리자");
					adminmenu();
				}
				
			
			}
			 catch (Exception e) {
				 
				System.out.println("[[알림]] : 메뉴 페이지 오류[ 관리자에게 문의 ] ");
				scanner = new Scanner(System.in); // 입력객체 초기화
			}
		}
	}

	// 예약자 메뉴
	public static void membermenu(String id, String phone) {
		while(true) {
			System.out.println("=========================예약자메뉴============================");
			System.out.println("1.잔여백신확인|2.잔여백신선택|3.잔여백신신청확인|4.잔여백신신청취소|5.로그아웃");
			System.out.println("===========================================================");
			System.err.print(">>선택 : "); int ch = scanner.nextInt();
			if(ch==1) {	// 잔여백신확인 전체리스트가 나와야함 처음에는 비어있을수있음
				System.out.println("============잔여백신리스트=========");
				System.out.println("\n번호\t백신이름\t지역\t남은수량");
				int i = 1;
				for(Vaccine vaccine : AdminController.vaccinList) {
					System.out.println(i+"\t"+vaccine.getV_name()+"\t"+vaccine.getV_area()+
										vaccine.getV_count());
					i++;
				}
				AdminController.v_list();
				VeccineList.List();
			}
			else if(ch==2) { // 선택하기
				System.out.println("");
				MemberController.select();
			}
			else if(ch==3) { // 신청확인
				MemberController.check();
			}
			else if(ch==4) { // 신청취소
				MemberController.cancel();
			}
			else if(ch==5) {
				return;
			}
			else {
				System.out.println("[[알림]] : 잘못된입력입니다. [관리자에게문의]");
			}
		}
	}

	// 관리자 메뉴
	public static void adminmenu() {
		try {
			while (true) {
				System.out.println("================관리자메뉴===============");
				System.out.println("1.잔여백신등록|2.잔여백신등록취소|3.잔여백신재고확인");
				System.out.println("======================================");
				System.out.print(">>선택 : ");
				int ch = scanner.nextInt();
				if (ch == 1) { // 등록
					System.out.println("=============잔여백신등록메뉴============");
					System.out.println("백신 이름 : "); String name = scanner.next();
					System.out.println("지역 : "); String area = scanner.next();
					System.out.println("재고 : "); int count = scanner.nextInt();
					AdminController.register(name, area);
					System.out.println("잔여백신이 등록되었습니다.");
				} else if (ch == 2) { // 등록취소
					System.out.println("============잔여백신 등록취소=============");
					System.out.println("등록취소할 백신 번호 : "); int index = scanner.nextInt();
					System.out.println("");
					AdminController.update();
				} else if (ch == 3) { // 등록 리스트 확인
					System.out.println("============잔여백신등록리스트=========");
					System.out.println("\n번호\t백신이름\t지역\t남은수량");
					int i = 1;
					for(Vaccine vaccine : AdminController.vaccinList) {
						System.out.println(i+"\t"+vaccine.getV_name()+"\t"+vaccine.getV_area()+
											vaccine.getV_count());
						i++;
					}
					AdminController.v_list();
				} else {
					System.out.println("[[알림]] : 잘못된입력입니다. [관리자에게문의]");
				}
			}
		}catch (Exception e) {
			System.out.println();
		}
	}
}
