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
	private static String memberpath ="";
	private static String vaccinepath ="";
	
	public static boolean filesave(int type) {
									//1.��ȸ������ 2.�������
		try {
		FileOutputStream fileOutputStream = null;
		if(type==1) {										
		//1.���ϰ�ü�� ��� ����
		fileOutputStream = new FileOutputStream(memberpath);
		//�ݺ��� �̿� ��ȸ������ �ϳ��� ȸ�� ��������
		for(Member member : MemberController.memberlist) {
		//�� ȸ������ �̿��� ȸ������Ʈ���� �ϳ��� ȸ�� ��������
		String outstring = member.getName()+",";
			
		}
		}
		if(type==2) {
			//1.���ϰ�ü�� ��� ����
			fileOutputStream = new FileOutputStream(vaccinepath);
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
		
		fileInputStream = new FileInputStream(memberpath);
		
		byte[] bytes = new byte[10000];
		
		String insString = new String(bytes);
		
		String[] members = insString.split("\n");
		
		for(int i = 0; i<members.length-1 ; i++) {
			
			String[] field = members[i].split(",");
			
			Member member = new Member(field[0] , field[1] , field[2], 
					field[3]  , field[4]);
			MemberController.memberlist.add(member);
		}
		}
		if(type==2) {
			fileInputStream = new FileInputStream(vaccinepath);
			
			byte[] bytes = new byte[10000];
			
			String insString = new String(bytes);
			
			String[] vaccines = insString.split("\n");
			
			for(int i = 0; i<vaccines.length-1 ; i++) {
				
				String[] field = vaccines[i].split(",");
				
				Member vaccine = new Vaccine(field[0] , field[1] , field[2], 
						field[3]  , field[4]);
				AdminController.vaccinList.add(vaccine);
			}
		}
		}catch (Exception e) {
			System.out.println(" [�˸�] : ���� �ҷ����� ���� �߻� [ �����ڿ��� ���� ]");
		}
		return false;
	}
	
	
	
}





















