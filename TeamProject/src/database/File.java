package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import controller.AdminController;
import controller.MemberController;
import model.Member;
import model.Vaccine;

public class File {

	
//	필드 : filepath
//	메소드 : save , load
	private static String memberpath ="C:/Users/jihyeong kim/git/Teamproject/TeamProject/src/database/member.txt";
	private static String vaccinepath ="C:/Users/jihyeong kim/git/Teamproject/TeamProject/src/database/vaccine.txt";
	
	public static boolean filesave(int type) {
		// 1.비회원정보 2.백신정보
		try {
			FileOutputStream fileOutputStream = null;
			if (type == 1) {
				// 1.파일객체에 경로 저장
				fileOutputStream = new FileOutputStream(memberpath);
				// 반복문 이용 비회원에서 하나씩 회원 가져오기
				for (Member member : MemberController.memberlist) {
					// 각 회원마다 이용한 회원리스트에서 하나씩 회원 가져오기
					String outstring = member.getName() + "," + member.getPhone() + "," + member.getVaccinename() + ","
							+ member.getArea() + "\n";
					//바이트로 내보내기
					for(Member temp : MemberController.memberlist) {
						if(!temp.getPhone().equals(member.getPhone())) {
							fileOutputStream.write(outstring.getBytes());
						}
					}
				}
				//스트림 사용후 초기화
				fileOutputStream.flush();
				fileOutputStream.close();
				
				return true;
			}
			if (type == 2) {
				// 1.파일객체에 경로 저장
				fileOutputStream = new FileOutputStream(vaccinepath);
				// 반복문 이용 비회원에서 하나씩 회원 가져오기
				for (Vaccine vaccine : AdminController.vaccinList) {
					// 각 회원마다 이용한 회원리스트에서 하나씩 회원 가져오기
					String outstring = vaccine.getV_name() + "," + vaccine.getV_area() + "," + vaccine.getV_count()+ "\n";
					fileOutputStream.write(outstring.getBytes());
				}
				fileOutputStream.flush();
				fileOutputStream.close();
				
				return true;

			}
		} catch (Exception e) {
			System.out.println("[알림] : 파일 저장 오류 발생 [ 관리자에게 문의 ]");
		}
		return false;
	}
	// 불러오기 메소드
	public static boolean fileload(int type) {
		try { 
			FileInputStream fileInputStream = null;
			if (type == 1) {
				// 입력 스트림 경로 설정
				fileInputStream = new FileInputStream(memberpath);
				// 스트림 바이트배열 선언
				byte[] bytes = new byte[10000];
				// 입력스트림에서 바이트 읽어와서 배열에 저장
				fileInputStream.read( bytes );
				// 바이트배열 -> 문자열 변환
				String insString = new String(bytes);
				//회원 분리 /n
				String[] members = insString.split("\n");
				// 반복문을 이용한 회원별 필드 분리하기
				for (int i = 0; i < members.length - 1; i++) {
					// 회원별 필드 분리
					String[] field = members[i].split(",");
					// 분리된 필드를 객채화 
					Member member = new Member(field[0], field[1], field[2], field[3]);
					// 각 객체를 리스트에 저장
					for(Member temp : MemberController.memberlist) {
						if(!temp.getPhone().equals(member.getPhone())) {
							MemberController.memberlist.add(member);
						}
					}
					

				}
				fileInputStream.close(); //스트림 닫기
				return true; //파일 불러오기 성공
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
					for(Vaccine temp : AdminController.vaccinList) {
						if(!temp.getV_name().equals(vaccine.getV_name())
								&&!temp.getV_area().equals(vaccine.getV_area())) {
							AdminController.vaccinList.add(vaccine);
						}
					}
					
				}
				fileInputStream.close();
				return true;
			}
		} catch (Exception e) {
			System.out.println(" [알림] : 파일 불러오기 오류 발생 [ 관리자에게 문의 ]");
		}
		return false;
	}

}
























