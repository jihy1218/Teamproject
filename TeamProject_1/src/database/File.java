package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import controller.AdminController;
import controller.MemberController;
import model.Member;
import model.Vaccine;

public class File {

	
//	�ʵ� : filepath
//	�޼ҵ� : save , load
	private static String path ="";
	
	public static boolean filesave(int type) {
									//1.��ȸ������ 2.�������
		try {
		FileOutputStream fileOutputStream = null;
		if(type==1) {										
		//1.���ϰ�ü�� ��� ����
		fileOutputStream = new FileOutputStream(path);
		//�ݺ��� �̿� ��ȸ������ �ϳ��� ȸ�� ��������
		for(Member member : MemberController.memberlist) {
		//�� ȸ������ �̿��� ȸ������Ʈ���� �ϳ��� ȸ�� ��������
		String outstring = member.getName()+",";
			
		}
		}
		if(type==2) {
			//1.���ϰ�ü�� ��� ����
			fileOutputStream = new FileOutputStream(path);
			//�ݺ��� �̿� ��ȸ������ �ϳ��� ȸ�� ��������
			for(Vaccine vaccine : AdminController.vaccinList) {
			//�� ȸ������ �̿��� ȸ������Ʈ���� �ϳ��� ȸ�� ��������
			String outstring = vaccine.getV_name()+",";
				
			}	
			
			
		}
		}catch (Exception e) {
			System.out.println("[�˸�] : ���� ���� ���� �߻� [ �����ڿ��� ���� ]");
		}
		return false;
	}
	public static boolean fileload(int type) {
		try {
		FileInputStream fileInputStream = null;
		if(type==1) {
		
		fileInputStream = new FileInputStream(path);
		
		byte[] bytes = new byte[10000];
		
		String insString = new String(bytes);
		String a;
		}
		}catch (Exception e) {
			System.out.println(" [�˸�] : ���� �ҷ����� ���� �߻� [ �����ڿ��� ���� ]");
		}
		return false;
	}
	
	
	
}





















