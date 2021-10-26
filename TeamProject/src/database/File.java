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
	private static String memberpath ="C:/Users/505/eclipse-workspace/samp/src/database/member.txt";
	private static String vaccinepath ="C:/Users/505/eclipse-workspace/samp/src/database/vaccine.txt";
	
	public static boolean filesave(int type) {
		// 1.��ȸ������ 2.�������
		try {
			FileOutputStream fileOutputStream = null;
			if (type == 1) {
				// 1.���ϰ�ü�� ��� ����
				fileOutputStream = new FileOutputStream(memberpath);
				// �ݺ��� �̿� ��ȸ������ �ϳ��� ȸ�� ��������
				for (Member member : MemberController.memberlist) {
					// �� ȸ������ �̿��� ȸ������Ʈ���� �ϳ��� ȸ�� ��������
					String outstring = member.getName() + "," + member.getPhone() + "," + member.getVaccinename() + ","
							+ member.getArea() + "\n";
					//����Ʈ�� ��������
					fileOutputStream.write(outstring.getBytes());
				}
				//��Ʈ�� ����� �ʱ�ȭ
				fileOutputStream.flush();
				fileOutputStream.close();
				
				return true;
			}
			if (type == 2) {
				// 1.���ϰ�ü�� ��� ����
				fileOutputStream = new FileOutputStream(vaccinepath);
				// �ݺ��� �̿� ��ȸ������ �ϳ��� ȸ�� ��������
				for (Vaccine vaccine : AdminController.vaccinList) {
					// �� ȸ������ �̿��� ȸ������Ʈ���� �ϳ��� ȸ�� ��������
					String outstring = vaccine.getV_name() + "," + vaccine.getV_area() + "," + vaccine.getV_count()
							+ "\n";
					fileOutputStream.write(outstring.getBytes());
				}
				fileOutputStream.flush();
				fileOutputStream.close();
				
				return true;

			}
		} catch (Exception e) {
			System.out.println("[�˸�] : ���� ���� ���� �߻� [ �����ڿ��� ���� ]");
		}
		return false;
	}
	// �ҷ����� �޼ҵ�
	public static boolean fileload(int type) {
		try { 
			FileInputStream fileInputStream = null;
			if (type == 1) {
				// �Է� ��Ʈ�� ��� ����
				fileInputStream = new FileInputStream(memberpath);
				// ��Ʈ�� ����Ʈ�迭 ����
				byte[] bytes = new byte[10000];
				// �Է½�Ʈ������ ����Ʈ �о�ͼ� �迭�� ����
				fileInputStream.read( bytes );
				// ����Ʈ�迭 -> ���ڿ� ��ȯ
				String insString = new String(bytes);
				//ȸ�� �и� /n
				String[] members = insString.split("\n");
				// �ݺ����� �̿��� ȸ���� �ʵ� �и��ϱ�
				for (int i = 0; i < members.length - 1; i++) {
					// ȸ���� �ʵ� �и�
					String[] field = members[i].split(",");
					// �и��� �ʵ带 ��äȭ 
					Member member = new Member(field[0], field[1], field[2], field[3]);
					// �� ��ü�� ����Ʈ�� ����
					MemberController.memberlist.add(member);

				}
				fileInputStream.close(); //��Ʈ�� �ݱ�
				return true; //���� �ҷ����� ����
			}
			if (type == 2) {
				fileInputStream = new FileInputStream(vaccinepath);

				byte[] bytes = new byte[10000];
				
				fileInputStream.read( bytes );

				String insString = new String(bytes);

				String[] vaccines = insString.split("\n");

				for (int i = 0; i < vaccines.length - 1; i++) {

					String[] field = vaccines[i].split(",");

					Vaccine vaccine = new Vaccine(field[0], field[1], Integer.parseInt(field[2]));

					AdminController.vaccinList.add(vaccine);
				}
				fileInputStream.close();
				return true;
			}
		} catch (Exception e) {
			System.out.println(" [�˸�] : ���� �ҷ����� ���� �߻� [ �����ڿ��� ���� ]");
		}
		return false;
	}

}
























