package view;

import java.util.Scanner;

import controller.AdminController;
import controller.MemberController;

public class Application {

	public static Scanner scanner = new Scanner(System.in); // �������⼭ ����پ�������

	public static void main(String[] args) { //

		mainmenu(); // ���� �޴� �޼ҵ� ȣ��
	} 

	public static void mainmenu() {
		while (true) {
			try {
				System.out.println("=======�ڷγ� �ܿ���� �������α׷�==========");
				System.out.println("1.��ȸ���α���|2.�����ڷα���");
				System.out.println("=======================================");
				System.out.print("���� : ");
				int ch = scanner.nextInt();
				if (ch == 1) {
					System.out.println("�̸����Է��ϼ��� : ");
					String name = scanner.next();
					System.out.println("��ȭ��ȣ�� �Է��ϼ��� : ");
					int phone = scanner.nextInt();

					boolean result = MemberController.m_login(name , phone);
						if(result) {
							System.out.println("[�˸�] : �α��μ���");
							membermenu(name, phone);	
						}
				} else if (ch == 2) {
					System.out.println("�������ڵ带 �Է��ϼ��� : ");
					String Code = scanner.next();
					boolean result = AdminController.login(Code);
						if(result) { 
							adminmenu();	
						}
						else { System.out.println("�˼����� �Է��Դϴ�.");
						}
				} else {
					System.out.println("[[�˸�]] : �߸����Է��Դϴ�. [�����ڿ��Թ���]");
				}
			} catch (Exception e) {
				System.out.println("[[�˸�]] : �޴� ������ ����[ �����ڿ��� ���� ] ");
				scanner = new Scanner(System.in); // �Է°�ü �ʱ�ȭ
			}
		}
	}

	// ������ �޴�
	public static void membermenu(String id, int phone) {
		while(true) {
			System.out.println("=====================�����ڸ޴�=======================");
			System.out.println("1.�ܿ��������Ȯ��|2.�ܿ���ż���|3.�ܿ���Ž�ûȮ��|4.�ܿ���Ž�û���");
			System.out.println("====================================================");
			System.err.print(">>���� : "); int ch = scanner.nextInt();
			if(ch==1) {
				
			}
			else if(ch==2) {
				
			}
			else if(ch==3) {
				
			}
			else if(ch==4) {
				
			}
			else {
				System.out.println("[[�˸�]] : �߸����Է��Դϴ�. [�����ڿ��Թ���]");
			}
		}
		
	}

	// ������ �޴�
	public static void adminmenu() {
		while(true) {
			System.out.println("================�����ڸ޴�===============");
			System.out.println("1.�ܿ���ŵ��|2.�ܿ���ŵ�����|3.�ܿ�������Ȯ��");
			System.out.println("======================================");
			System.out.print(">>���� : "); int ch = scanner.nextInt();
			if(ch==1) {
				
			}
			else if(ch==2) {
				
			}
			else if(ch==3) {
				
			}
			else { System.out.println("[[�˸�]] : �߸����Է��Դϴ�. [�����ڿ��Թ���]");
					
			}
		}
	}

}
