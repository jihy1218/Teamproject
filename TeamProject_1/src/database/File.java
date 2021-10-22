package database;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import controller.MemberController;
import model.Member;

public class File {

	
//	필드 : filepath
//	메소드 : save , load
	private static String path ="";
	
	public static boolean filesave(int type) {
									//1.비회원정보 2.백신정보
		try {
		FileOutputStream fileOutputStream = null;
		if(type==1) {										
		//1.파일객체에 경로 저장
		fileOutputStream = new FileOutputStream(path);
		//반복문 이용 비회원에서 하나씩 회원 가져오기
		for(Member member : MemberController.memberlist) {
		//각 회원마다 이용한 회원리스트에서 하나씩 회원 가져오기
		String	
			
		}
		}
		if(type==2) {}
		}catch (Exception e) {
			System.out.println("[알림] : 파일 저장 오류 발생 [ 관리자에게 문의 ]");
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
			System.out.println(" [알림] : 파일 불러오기 오류 발생 [ 관리자에게 문의 ]");
		}
		return false;
	}
	
	
	
}





















