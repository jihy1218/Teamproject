package view;

import java.lang.reflect.Member;
import java.util.Scanner;

import controller.MemberController;

public class Application {

	public static Scanner scanner = new Scanner(System.in);
	
	public static void main(String[] args) {	// 
		
		mainmenu(); // ���� �޴� �޼ҵ� ȣ��
	}
	
	public static void mainmenu() {
		while(true) {
			System.out.println("=======�ڷγ� �ܿ���� �������α׷�==========");
			System.out.println("1.��ȸ���α���|2.�����ڷα���");
			System.out.println("=======================================");
			System.out.print("���� : "); int ch = scanner.nextInt();
			if(ch==1) {
				System.out.println("�̸����Է��ϼ��� : "); String name = scanner.next();
				System.out.println("��ȭ��ȣ�� �Է��ϼ��� : "); int phone = scanner.nextInt();
			
//				boolean result = MemberController.m_login(name , phone);
				// �ߺ����� �̸�&&��ȣ �Ȱ��� ���� üũ�ؾ��ҵ�
//				if(result) {
					membermenu(name,phone);
//				}
			}
			else if(ch==2) {}
			else {
				System.out.println("[[�˸�]] : �߸����Է��Դϴ�. [�����ڿ��Թ���]");
			}
		}
	}
	
	
	
	// ������ �޴�
	public static void membermenu(String id , int phone) {
		
	}
	// ������ �޴�
	public static void boardmenu(String id) {
		
	}
	
	
	
	
}
