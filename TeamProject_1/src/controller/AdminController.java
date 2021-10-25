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
         // TODO Auto-generated method stub
         
      }
   
   
   
   
}