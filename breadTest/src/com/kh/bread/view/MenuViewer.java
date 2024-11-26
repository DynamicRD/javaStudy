package com.kh.bread.view;

public class MenuViewer {
	// 메인메뉴
	public static void mainMenuView() {
		System.out.println();
		System.out.println("============================================================================");
		System.out.println("빵집 프로그램");
		System.out.println("해당 번호를 입력하세요.");
		System.out.println("1. 메뉴 정보 들어가기    2. 고객 정보 들어가기    3. 가게 정보 들어가기    4. 프로그램 종료");
		System.out.print("번호 선택 : ");
	}
	// 메뉴판 메뉴
	public static void menuTableMenuView() {
		System.out.println();
		System.out.println("============================================================================");
		System.out.println("메뉴 번호를 입력하세요.");
		System.out.println("1. 메뉴 정보 목록    2. 메뉴 정보 입력    3. 메뉴 정보 수정    4. 메뉴 정보 삭제    5. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

	// 고객 메뉴
	public static void customerMenuView() {
		System.out.println();
		System.out.println("============================================================================");
		System.out.println("고객 정보 번호를 입력하세요.");
		System.out.println("1. 고객 정보 목록    2. 고객 정보 입력    3. 고객 정보 수정    4. 고객 정보 삭제    5. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}


	// 가게 메뉴
	public static void shopMenuView() {
		System.out.println();
		System.out.println("============================================================================");
		System.out.println("가게 정보 번호를 입력하세요.");
		System.out.println("1. 가게 정보 목록    2. 총 매출 출력    3. 메인 메뉴");
		System.out.print("번호 선택 : ");
	}

}
