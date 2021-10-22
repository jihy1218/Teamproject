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
				System.out.println("�̸����Է��ϼ��� : ");
				String name = scanner.next();
				System.out.println("��ȭ��ȣ�� �Է��ϼ��� : ");
				String phone = scanner.next();
				String check = MemberController.m_login(name, phone);
				
				if (check.equals("������")) {
					System.out.println("[�˸�] : �α��μ���");
					membermenu(name, phone);
				}if (check.equals("admin")) {
					System.out.println("������");
					adminmenu();
				}
				
			
			}
			 catch (Exception e) {
				 
				System.out.println("[[�˸�]] : �޴� ������ ����[ �����ڿ��� ���� ] ");
				scanner = new Scanner(System.in); // �Է°�ü �ʱ�ȭ
			}
		}
	}

	// ������ �޴�
	public static void membermenu(String id, String phone) {
		while(true) {
			System.out.println("=========================�����ڸ޴�============================");
			System.out.println("1.�ܿ����Ȯ��|2.�ܿ���ż���|3.�ܿ���Ž�ûȮ��|4.�ܿ���Ž�û���|5.�α׾ƿ�");
			System.out.println("===========================================================");
			System.err.print(">>���� : "); int ch = scanner.nextInt();
			if(ch==1) {	// �ܿ����Ȯ�� ��ü����Ʈ�� ���;��� ó������ �������������
				
			}
			else if(ch==2) { // �����ϱ�
				MemberController.select();
			}
			else if(ch==3) { // ��ûȮ��
				MemberController.check();
			}
			else if(ch==4) { // ��û���
				MemberController.cancel();
			}
			else if(ch==5) {
				return;
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
			if(ch==1) { // ���
				AdminController.register();
			}
			else if(ch==2) { // ������
				AdminController.update();
			}
			else if(ch==3) { // ��� ����Ʈ Ȯ��
				AdminController.v_list();
			}
			else { System.out.println("[[�˸�]] : �߸����Է��Դϴ�. [�����ڿ��Թ���]");
					
			}
		}
	}

}
