package controller;

import java.util.ArrayList;

import database.File;
import model.Vaccine;
import view.Application;

public class AdminController implements VeccineList { // 혁

//   필드 : ArrayList<Vaccine> vaccinelist
//   메소드 : login, register, update , v_list
   //좋아요
   // 필드
   public static ArrayList<Vaccine> vaccinList = new ArrayList<>();
   
   // 메소드
   
   
   public static boolean register(Vaccine vaccineinformation) {
      vaccinList.add(vaccineinformation);
      File.filesave(2);
      return true;
   }
   public static int check(String v_name , String v_area) {
	  for(int i = 0 ; i < vaccinList.size() ; i++) { 
		  if(vaccinList.get(i).getV_name().equals(v_name)
				  &&vaccinList.get(i).getV_area().equals(v_area)) {
			  return i;
		  }
	  }
	  return -1;    
   }
   
   public static void update(int index_num) {
	   System.out.println("1. 백신 등록취소 2.재고 수정 ");
	   int ch = Application.scanner.nextInt();
	   if(ch==1) {
		   vaccinList.remove(index_num);
		   System.out.println("삭제 완료");
		   return;
	   }
	   if(ch==2) {
		   System.out.println("재고값: ");
		   int edit = Application.scanner.nextInt();
		   vaccinList.get(index_num).setV_count(edit);
		   return;
	   }
   }
   
  @Override
	public void List() {
	  System.out.println("============잔여백신등록리스트=========");
		System.out.println("\n번호\t백신이름\t지역\t남은수량");
		int i = 1;
		for(Vaccine vaccine : AdminController.vaccinList) {
			System.out.println(i+"\t"+vaccine.getV_name()+"\t"+vaccine.getV_area()+
								"\t"+vaccine.getV_count());
			i++;
		}
	}

  

   
   
   
}