package model;

public class Member {

	//�ʵ� : private name , phone , area
	//������ : ������� , ��ü������
	//�޼ҵ� : get, set
	
	// �ʵ�
	private String name;
	private String phone;
	private String vaccinename;
	private String area;
	
	
	// ������
	public Member() {}

	
	public Member(String name, String phone, String vaccinename, String area ) {
	
		this.name = name;
		this.phone = phone;
		this.vaccinename = vaccinename;
		this.area = area;
		
	}

	
	// �޼ҵ�
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getArea() {return area;}
	public void setArea(String area) {this.area = area;}
	public String getVaccinename() {return vaccinename;}
	public void setVaccinename(String vaccinename) {this.vaccinename = vaccinename;}	
	
	
}
