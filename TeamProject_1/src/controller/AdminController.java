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