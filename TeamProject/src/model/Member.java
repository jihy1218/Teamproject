package model;

public class Member {

	//필드 : private name , phone , area
	//생성자 : 빈생성자 , 전체생성자
	//메소드 : get, set
	
	// 필드
	private String name;
	private String phone;
	private String vaccinename;
	private String area;
	
	
	// 생성자
	public Member() {}

	
	public Member(String name, String phone, String vaccinename, String area ) {
	
		this.name = name;
		this.phone = phone;
		this.vaccinename = vaccinename;
		this.area = area;
		
	}

	
	// 메소드
	
	public String getName() {return name;}
	public void setName(String name) {this.name = name;}
	public String getPhone() {return phone;}
	public void setPhone(String phone) {this.phone = phone;}
	public String getArea() {return area;}
	public void setArea(String area) {this.area = area;}
	public String getVaccinename() {return vaccinename;}
	public void setVaccinename(String vaccinename) {this.vaccinename = vaccinename;}	
	
	
}
