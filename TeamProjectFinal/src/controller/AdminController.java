package controller;

import java.util.ArrayList;

import database.File;
import model.Vaccine;
import view.Application;

public class AdminController implements VeccineList { // ��

//   �ʵ� : ArrayList<Vaccine> vaccinelist
//   �޼ҵ� : login, register, update , v_list
   //���ƿ�
   // �ʵ�
   public static ArrayList<Vaccine> vaccinList = new ArrayList<>();
   
   // �޼ҵ�
   
   
   public static boolean register(Vaccine vaccineinformation) {
	      for(Vaccine temp : AdminController.vaccinList) {
	    	  if(temp.getV_name().equals(vaccineinformation.getV_name())&&
	    			  temp.getV_area().equals(vaccineinformation.getV_area())) {    		    	      
	    		  return false;
	    	  }
	      }	   
	      vaccinList.add(vaccineinformation);  
	      
	      return true;		   
	   }
   
   public static int check(String v_name , String v_area) {
	  for(int i = 0 ; i < vaccinList.size() ; i++) { 
		  if(vaccinList.get(i).getV_name().equals(v_name)
				  &&vaccinList.get(i).getV_area().equals(v_area)) {
			  return i;
		  }
	  }	  return 1;    
   }
   
   
   public static void update(int index_num) {
	   System.out.println("1. ��� ������ 2.��� ���� 3.����̸�����");
	   int ch = Application.scanner.nextInt();
	   
	   if(ch==1) {
		   vaccinList.remove(index_num);
		   System.out.println("���� �Ϸ�");
		   return;
	   }
	   if(ch==2) {
		   System.out.println("�����: ");
		   int edit = Application.scanner.nextInt();
		   vaccinList.get(index_num).setV_count(edit);
		   return;
	   }
	   //��������������
	   if(ch==3) {
		   System.out.println("�������̸� :");
		   String ch2 = Application.scanner.next();
		   vaccinList.get(index_num).setV_name(ch2);
	   }
   }
   
  @Override
	public void List() {
	  System.out.println("============�ܿ���ŵ�ϸ���Ʈ=========");
		System.out.println("\n��ȣ\t����̸�\t����\t��������");
		int i = 1;
		for(Vaccine vaccine : AdminController.vaccinList) {
			System.out.println(i+"\t"+vaccine.getV_name()+"\t"+vaccine.getV_area()+
								"\t"+vaccine.getV_count());
			i++;
		}
	}

  

   
   
   
}