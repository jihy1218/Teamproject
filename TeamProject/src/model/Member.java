package model;

public class Member {

	//�ʵ� : private name , phone , area
	//������ : ������� , ��ü������
	//�޼ҵ� : get, set
	
	// �ʵ�
	private String name;
	private int phone;
	private String area;
	
	// ������
	public Member() {}

	
	public Member(String name, int phone, String area) {
	
		this.name = name;
		this.phone = phone;
		this.area = area;
	}

	
	// �޼ҵ�
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public int getPhone() {return phone;}
	public void setPhone(int phone) {this.phone = phone;}
	public String getArea() {return area;}
	public void setArea(String area) {this.area = area;}	
	
	
}
