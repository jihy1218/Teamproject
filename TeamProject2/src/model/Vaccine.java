package model;

public class Vaccine {

	
	//�ʵ� : private v_name , v_area , v_count
//	������ : ������� , ��ü������
	//�޼ҵ� : get , set
	
	
	// �ʵ�
	private String v_name;
	private String v_area;
	private int v_count;
	
	// ������
	public Vaccine() {}

	public Vaccine(String v_name, String v_area, int v_count) {
		this.v_name = v_name;
		this.v_area = v_area;
		this.v_count = v_count;
	}

	
	// �޼ҵ�
	
	public String getV_name() {return v_name;}
	public void setV_name(String v_name) {this.v_name = v_name;}
	public String getV_area() {return v_area;}
	public void setV_area(String v_area) {this.v_area = v_area;}
	public int getV_count() {return v_count;}
	public void setV_count(int v_count) {this.v_count = v_count;}
	
		
}
