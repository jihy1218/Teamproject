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
						if(result) membermenu(name, phone);	
				} else if (ch == 2) {
					System.out.println("�������ڵ带 �Է��ϼ��� : ");
					String code = scanner.next();
					boolean result = AdminController.login(code);
						if(result) { 
							adminmenu(code);	
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

	}

	// ������ �޴�
	public static void adminmenu(String code) {

	}

}
