package controller;

import java.util.ArrayList;
import model.Vaccine;

public class AdminController implements VeccineList { // 혁

//   필드 : ArrayList<Vaccine> vaccinelist
//   메소드 : login, register, update , v_list
   //좋아요
   // 필드
   public static ArrayList<Vaccine> vaccinList = new ArrayList<>();
   
   // 메소드
   
   
   public static boolean register(Vaccine vaccineinformation) {
      vaccinList.add(vaccineinformation);
      
      return true;
   }
   public static boolean update(int indexnum) {
      vaccinList.remove(indexnum);
      
      return true;
   }
   @Override
	public void List() {
        System.out.println("=============잔여백신리스트============");
        System.out.println("\n번호\t백신이름\t지역\t남은수량");
        int i = 1;
        for(Vaccine vaccine : AdminController.vaccinList) {
        	System.out.println(i+vaccine.getV_name()+vaccine.getV_area()+
        			vaccine.getV_count());
        	i++;
        }
		
	}
   
   
   
   
}