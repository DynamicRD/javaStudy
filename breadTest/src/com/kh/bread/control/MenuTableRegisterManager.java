package com.kh.bread.control;

import java.util.Scanner;

import com.kh.bread.model.MenuTableVO;

public class MenuTableRegisterManager {
	// 메뉴 목록
	public void menuTableSelect() throws Exception {
		MenuTableDAO mtdao = new MenuTableDAO();
		System.out.println("전체 메뉴테이블");
		mtdao.selectMenuTable();
		System.out.println();
	}

	// 메뉴 등록 관리
	public void menuTableInsert() throws Exception {
		Scanner input = new Scanner(System.in);
		MenuTableDAO mtdao = new MenuTableDAO();
		MenuTableVO mtvo = new MenuTableVO();
		String name = null; 
		int price = 0;
		System.out.println("메뉴 전체 리스트");
		mtdao.selectMenuTable();
		System.out.println();
		System.out.println("메뉴 이름 입력");
		System.out.print("메뉴 이름 : ");
		name = input.nextLine();
		System.out.print("메뉴 가격 : ");
		price = Integer.parseInt(input.nextLine());
		mtvo.setName(name);
		mtvo.setPrice(price);
		mtdao.insertMenuTable(mtvo);
		System.out.println();
		System.out.println("메뉴 전체 리스트");
		mtdao.selectMenuTable();
		System.out.println();
	}

	// 메뉴 수정 관리
	public void menuTableUpdate() throws Exception {
		Scanner input = new Scanner(System.in);
		Scanner input1 = new Scanner(System.in);
		MenuTableDAO mtdao = new MenuTableDAO();
		MenuTableVO mtvo = new MenuTableVO();
		int bNo = 0;
		String name = null; 
		int price = 0;
		System.out.println("메뉴 전체 리스트");
		mtdao.selectMenuTable();
		System.out.println();
		System.out.println("수정할 메뉴 일련번호 입력");
		System.out.print("일련번호 : ");
		bNo = input1.nextInt();
		System.out.println();
		System.out.println("새로운 정보 모두 입력");
		System.out.print("메뉴 이름 : ");
		name = input.nextLine();
		System.out.print("메뉴 가격 : ");
		price = Integer.parseInt(input.nextLine());
		mtvo.setbNo(bNo);
		mtvo.setName(name);
		mtvo.setPrice(price);
		mtdao.updateMenuTable(mtvo);
		System.out.println();
		System.out.println("메뉴 전체 리스트");
		mtdao.selectMenuTable();
		System.out.println();
	}

	// 메뉴 삭제 관리
	public void menuTableDelete() throws Exception {
		Scanner input = new Scanner(System.in);
		MenuTableDAO mtdao = new MenuTableDAO();
		MenuTableVO mtvo = new MenuTableVO();
		int bNo; // 입력한 일련번호
		System.out.println("메뉴 전체 리스트");
		mtdao.selectMenuTable();
		System.out.println();
		System.out.println("삭제할 메뉴 일련번호 입력");
		System.out.print("일련번호 : ");
		bNo = input.nextInt();
		mtdao.deleteMenuTable(bNo);
		System.out.println();
		System.out.println("메뉴 전체 리스트");
		mtdao.selectMenuTable();
		System.out.println();
	}
}
