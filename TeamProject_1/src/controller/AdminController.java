package controller;

import java.util.ArrayList;
import model.Vaccine;

public class AdminController implements VeccineList { // ��

//   �ʵ� : ArrayList<Vaccine> vaccinelist
//   �޼ҵ� : login, register, update , v_list
   //���ƿ�
   // �ʵ�
   public static ArrayList<Vaccine> vaccinList = new ArrayList<>();
   
   // �޼ҵ�
   
   
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