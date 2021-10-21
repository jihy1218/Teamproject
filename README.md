# Teamproject
백신 예약 프로그램
	1. 패키지 구성 
		M
		V
		C 	
	2. 클래스 구성
		Data : file
		M : Member Vaccine 
		V : Application(mainmenu , membermenu , adminmenu)
		C : MemberController , adminController
	3. 클래스 설계 [ 필드, 생성자 , 메소드]
		Member
			필드 : private name , phone , area
			생성자 : 빈생성자 , 전체생성자
			메소드 : get, set
		Vaccine
			필드 : private v_name , v_area , v_count
			생성자 : 빈생성자 , 전체생성자
			메소드 : get , set
 
		File
			필드 : filepath
			메소드 : save , load
		MemberController
			필드 : ArrayList<Member> memberlist
			메소드 : login , select , cancel , list(v_list로 대체)
		
		AdminController
			필드 : ArrayList<Vaccine> vaccinelist
			메소드 : login, register, update&delete , v_list
