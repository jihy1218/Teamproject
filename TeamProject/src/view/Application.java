package view;

import java.util.Scanner;

import controller.AdminController;
import controller.MemberController;
import controller.VeccineList;
import database.File;
import model.Vaccine;

public class Application {

	public static Scanner scanner = new Scanner(System.in); // 여기저기서 끌어다쓰기위해

	public static void main(String[] args) { //
		File.fileload(1);
		File.fileload(2);
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
				}
				if (check.equals("admin")) {
					System.out.println("관리자");
					adminmenu();
				}
				if (check.equals("실패")) {
					System.out.println("실패");
				}
				

			} catch (Exception e) {

				System.out.println("[[알림]] : 메뉴 페이지 오류[ 관리자에게 문의 ] ");
				scanner = new Scanner(System.in); // 입력객체 초기화
			}
		}
	}

	// 예약자 메뉴
	public static void membermenu(String name, String phone) {
		while (true) {
			System.out.println("=========================예약자메뉴============================");
			System.out.println("1.잔여백신확인|2.잔여백신선택|3.잔여백신신청확인|4.잔여백신신청취소|5.로그아웃");
			System.out.println("===========================================================");
			System.out.print(">>선택 : ");
			int ch = scanner.nextInt();
			if (ch == 1) { // 잔여백신확인 전체리스트가 나와야함 처음에는 비어있을수있음
				System.out.println("============잔여백신리스트=========");
				System.out.println("번호\t백신이름\t지역\t남은수량");
				int i = 1;
				for (Vaccine vaccine : AdminController.vaccinList) {
					System.out.println(i + "\t" + vaccine.getV_name() + "\t" + vaccine.getV_area() + "\t"
							+ vaccine.getV_count() + "");
					i++;
				}

			} else if (ch == 2) { // 선택하기
				System.out.println("선택할 백신명 : "); String v_name = scanner.next();
				System.out.println("선택할 지역명 : "); String v_area = scanner.next();
				boolean v_ch = MemberController.select(name, phone,v_name, v_area);
				if(v_ch) {
				System.out.println("선택되었습니다.");
				}
				else {
					System.out.println("존재하지 않는 백신 또는 지역입니다");
				}
			} else if (ch == 3) { // 신청확인
				boolean m_check = MemberController.check(phone);
				if(m_check==false) {
					System.out.println("예약 x");
				}
			} else if (ch == 4) { // 신청취소
				boolean m_cancel = MemberController.cancel(phone);
				if(m_cancel) {
					System.out.println("취소 되었습니다");
				}else {
					System.out.println("예약 x");
				}
			} else if (ch == 5) {
				return;
			} else {
				System.out.println("[[알림]] : 잘못된입력입니다. [관리자에게문의]");
			}
		}
	}

	// 관리자 메뉴
	public static void adminmenu() {
		try {
			while (true) {
				System.out.println("================관리자메뉴===============");
				System.out.println("1.잔여백신등록|2.잔여백신수정|3.잔여백신재고확인|4.뒤로가기");
				System.out.println("======================================");
				System.out.print(">>선택 : ");
				int ch = scanner.nextInt();
				if (ch == 1) { // 등록
					System.out.println("=============잔여백신등록메뉴============");
					System.out.println("백신 이름 : "); String name = scanner.next();
					System.out.println("지역 : "); String area = scanner.next();
					System.out.println("재고 : "); int count = scanner.nextInt();
					Vaccine vaccineinformation = new Vaccine(name, area, count);
					
					boolean regi = AdminController.register(vaccineinformation);
					if(regi) {
						System.out.println("잔여백신이 등록되었습니다.");
					}else {
						System.out.println("실패");
					}
				} else if (ch == 2) { // 등록취소
					System.out.println("============잔여백신 수정=============");
					System.out.println("수정할 백신명:"); String v_name = scanner.next();
					System.out.println("수정할 백신 지역: "); String v_area = scanner.next();
					int check = AdminController.check(v_name, v_area);
					if(check==-1) {
						System.out.println("존재X");
					}else {
						AdminController.update(check);
					}
				} else if (ch == 3) { // 등록 리스트 확인
					AdminController adminController = new AdminController();
					adminController.List();
				}else if(ch==4) {
					return;
				}
				else {
					System.out.println("[[알림]] : 잘못된입력입니다. [관리자에게문의]");
				}
					
				
				
				}
			}catch(	Exception e) {System.out.println();}
		
		
	}
}
