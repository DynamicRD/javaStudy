package com.kh.movie.view;

public class MenuViewer {
	// 메인메뉴
	public static void mainMenuView() {
		System.out.println();
		System.out.println("통합 영화,영화관,관객 프로그램");
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. 영화관 정보 들어가기");
		System.out.println("2. 영화 정보 들어가기");
		System.out.println("3. 관객 정보 들어가기");
		System.out.println("4. 프로그램 종료");
		System.out.print("번호 선택 : ");
	}
	// 영화관 메뉴
	public static void cinemaMenuView() {
		System.out.println();
		System.out.println("영화관 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 영화관 정보 목록");
		System.out.println("2. 영화관 정보 입력");
		System.out.println("3. 영화관 전체 수정");
		System.out.println("4. 영화관 정보 삭제");
		System.out.println("5. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

	// 영화 메뉴
	public static void movieMenuView() {
		System.out.println();
		System.out.println("영화 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 영화 정보 목록");
		System.out.println("2. 영화 정보 입력");
		System.out.println("3. 영화 정보 수정");
		System.out.println("4. 영화 정보 삭제");
		System.out.println("5. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}


	// 관객 메뉴
	public static void audienceMenuView() {
		System.out.println();
		System.out.println("관객 정보 메뉴 번호를 입력하세요.");
		System.out.println("1. 관객 정보 목록");
		System.out.println("2. 관객 정보 입력");
		System.out.println("3. 관객 정보 수정");
		System.out.println("4. 관객 정보 삭제");
		System.out.println("5. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

}
