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
	private static String memberpath ="";
	private static String vaccinepath ="";
	
	public static boolean filesave(int type) {
									//1.비회원정보 2.백신정보
		try {
		FileOutputStream fileOutputStream = null;
		if(type==1) {										
		//1.파일객체에 경로 저장
		fileOutputStream = new FileOutputStream(memberpath);
		//반복문 이용 비회원에서 하나씩 회원 가져오기
		for(Member member : MemberController.memberlist) {
		//각 회원마다 이용한 회원리스트에서 하나씩 회원 가져오기
		String outstring = member.getName()+",";
			
		}
		}
		if(type==2) {
			//1.파일객체에 경로 저장
			fileOutputStream = new FileOutputStream(vaccinepath);
			//반복문 이용 비회원에서 하나씩 회원 가져오기
			for(Vaccine vaccine : AdminController.vaccinList) {
			//각 회원마다 이용한 회원리스트에서 하나씩 회원 가져오기
			String outstring = vaccine.getV_name()+",";
				
			}	
			
			
		}
		}catch (Exception e) {
			System.out.println("[알림] : 파일 저장 오류 발생 [ 관리자에게 문의 ]");
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
			
			Member member = new Member
		}
		}
		}catch (Exception e) {
			System.out.println(" [알림] : 파일 불러오기 오류 발생 [ 관리자에게 문의 ]");
		}
		return false;
	}
	
	
	
}





















