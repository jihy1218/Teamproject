package view;

import java.util.Scanner;

import controller.AdminController;
import controller.MemberController;
import controller.VeccineList;
import database.File;
import model.Vaccine;

public class Application {

	public static Scanner scanner = new Scanner(System.in); // �������⼭ ����پ�������

	public static void main(String[] args) { //
		File.fileload(1);
		File.fileload(2);
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
				}
				if (check.equals("admin")) {
					System.out.println("������");
					adminmenu();
				}
				if (check.equals("����")) {
					System.out.println("����");
				}
				

			} catch (Exception e) {

				System.out.println("[[�˸�]] : �޴� ������ ����[ �����ڿ��� ���� ] ");
				scanner = new Scanner(System.in); // �Է°�ü �ʱ�ȭ
			}
		}
	}

	// ������ �޴�
	public static void membermenu(String name, String phone) {
		while (true) {
			System.out.println("=========================�����ڸ޴�============================");
			System.out.println("1.�ܿ����Ȯ��|2.�ܿ���ż���|3.�ܿ���Ž�ûȮ��|4.�ܿ���Ž�û���|5.�α׾ƿ�");
			System.out.println("===========================================================");
			System.out.print(">>���� : ");
			int ch = scanner.nextInt();
			if (ch == 1) { // �ܿ����Ȯ�� ��ü����Ʈ�� ���;��� ó������ �������������
				System.out.println("============�ܿ���Ÿ���Ʈ=========");
				System.out.println("��ȣ\t����̸�\t����\t��������");
				int i = 1;
				for (Vaccine vaccine : AdminController.vaccinList) {
					System.out.println(i + "\t" + vaccine.getV_name() + "\t" + vaccine.getV_area() + "\t"
							+ vaccine.getV_count() + "");
					i++;
				}

			} else if (ch == 2) { // �����ϱ�
				System.out.println("������ ��Ÿ� : "); String v_name = scanner.next();
				System.out.println("������ ������ : "); String v_area = scanner.next();
				boolean v_ch = MemberController.select(name, phone,v_name, v_area);
				if(v_ch) {
				System.out.println("���õǾ����ϴ�.");
				}
				else {
					System.out.println("�������� �ʴ� ��� �Ǵ� �����Դϴ�");
				}
			} else if (ch == 3) { // ��ûȮ��
				boolean m_check = MemberController.check(phone);
				if(m_check==false) {
					System.out.println("���� x");
				}
			} else if (ch == 4) { // ��û���
				boolean m_cancel = MemberController.cancel(phone);
				if(m_cancel) {
					System.out.println("��� �Ǿ����ϴ�");
				}else {
					System.out.println("���� x");
				}
			} else if (ch == 5) {
				return;
			} else {
				System.out.println("[[�˸�]] : �߸����Է��Դϴ�. [�����ڿ��Թ���]");
			}
		}
	}

	// ������ �޴�
	public static void adminmenu() {
		try {
			while (true) {
				System.out.println("================�����ڸ޴�===============");
				System.out.println("1.�ܿ���ŵ��|2.�ܿ���ż���|3.�ܿ�������Ȯ��|4.�ڷΰ���");
				System.out.println("======================================");
				System.out.print(">>���� : ");
				int ch = scanner.nextInt();
				if (ch == 1) { // ���
					System.out.println("=============�ܿ���ŵ�ϸ޴�============");
					System.out.println("��� �̸� : "); String name = scanner.next();
					System.out.println("���� : "); String area = scanner.next();
					System.out.println("��� : "); int count = scanner.nextInt();
					Vaccine vaccineinformation = new Vaccine(name, area, count);
					
					boolean regi = AdminController.register(vaccineinformation);
					if(regi) {
						System.out.println("�ܿ������ ��ϵǾ����ϴ�.");
					}else {
						System.out.println("����");
					}
				} else if (ch == 2) { // ������
					System.out.println("============�ܿ���� ����=============");
					System.out.println("������ ��Ÿ�:"); String v_name = scanner.next();
					System.out.println("������ ��� ����: "); String v_area = scanner.next();
					int check = AdminController.check(v_name, v_area);
					if(check==-1) {
						System.out.println("����X");
					}else {
						AdminController.update(check);
					}
				} else if (ch == 3) { // ��� ����Ʈ Ȯ��
					AdminController adminController = new AdminController();
					adminController.List();
				}else if(ch==4) {
					return;
				}
				else {
					System.out.println("[[�˸�]] : �߸����Է��Դϴ�. [�����ڿ��Թ���]");
				}
					
				
				
				}
			}catch(	Exception e) {System.out.println();}
		
		
	}
}
