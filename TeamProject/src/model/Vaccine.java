package model;

public class Vaccine {

	
	//필드 : private v_name , v_area , v_count
//	생성자 : 빈생성자 , 전체생성자
	//메소드 : get , set
	
	
	// 필드
	private String v_name;
	private String v_area;
	private int v_count;
	
	// 생성자
	public Vaccine() {}

	public Vaccine(String v_name, String v_area, int v_count) {
		this.v_name = v_name;
		this.v_area = v_area;
		this.v_count = v_count;
	}

	
	// 메소드
	
	public String getV_name() {return v_name;}
	public void setV_name(String v_name) {this.v_name = v_name;}
	public String getV_area() {return v_area;}
	public void setV_area(String v_area) {this.v_area = v_area;}
	public int getV_count() {return v_count;}
	public void setV_count(int v_count) {this.v_count = v_count;}
	
		
}
