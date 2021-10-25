package view;

import java.util.Scanner;

import controller.AdminController;
import controller.MemberController;
import controller.VeccineList;
import model.Vaccine;

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
				System.out.println("============�ܿ���Ÿ���Ʈ=========");
				System.out.println("\n��ȣ\t����̸�\t����\t��������");
				int i = 1;
				for(Vaccine vaccine : AdminController.vaccinList) {
					System.out.println(i+"\t"+vaccine.getV_name()+"\t"+vaccine.getV_area()+
										vaccine.getV_count());
					i++;
				}
				AdminController.v_list();
				VeccineList.List();
			}
			else if(ch==2) { // �����ϱ�
				System.out.println("================��ż���â================");
				
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
		try {
			while (true) {
				System.out.println("================�����ڸ޴�===============");
				System.out.println("1.�ܿ���ŵ��|2.�ܿ���ŵ�����|3.�ܿ�������Ȯ��|4.�ڷΰ���");
				System.out.println("======================================");
				System.out.print(">>���� : ");
				int ch = scanner.nextInt();
				if (ch == 1) { // ���
					System.out.println("=============�ܿ���ŵ�ϸ޴�============");
					System.out.println("��� �̸� : "); String name = scanner.next();
					System.out.println("���� : "); String area = scanner.next();
					System.out.println("��� : "); int count = scanner.nextInt();
					AdminController.register(name, area);
					System.out.println("�ܿ������ ��ϵǾ����ϴ�.");
				} else if (ch == 2) { // ������
					System.out.println("============�ܿ���� ������=============");
					System.out.println("�������� ��� ��ȣ : "); int index = scanner.nextInt();
					System.out.println("");
					AdminController.update();
				} else if (ch == 3) { // ��� ����Ʈ Ȯ��
					System.out.println("============�ܿ���ŵ�ϸ���Ʈ=========");
					System.out.println("\n��ȣ\t����̸�\t����\t��������");
					int i = 1;
					for(Vaccine vaccine : AdminController.vaccinList) {
						System.out.println(i+"\t"+vaccine.getV_name()+"\t"+vaccine.getV_area()+
											vaccine.getV_count());
						i++;
				}
					
				
				}else if(ch==4) {
					return;
				}
				else {
					System.out.println("[[�˸�]] : �߸����Է��Դϴ�. [�����ڿ��Թ���]");
				}
			}
		}catch (Exception e) {
			System.out.println();
		}
	}
}
