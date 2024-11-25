package com.kh.bread.control;

import java.util.Scanner;

import com.kh.bread.model.CustomerVO;


public class CustomeRegisterManager {
	// 고객 목록
		public void customerSelect() throws Exception {
			CustomerDAO cdao = new CustomerDAO();
			System.out.println("전체 고객테이블");
			cdao.selectCustomer();
			System.out.println();
		}

		// 고객 등록 관리
		public void customerInsert() throws Exception {
			Scanner input = new Scanner(System.in);
			CustomerDAO cdao = new CustomerDAO();
			CustomerVO cvo = new CustomerVO();
			String name = null; 
			int bNo = 0;
			int amount = 0;
			MenuTableDAO mtdao = new MenuTableDAO();
			System.out.println("메뉴 전체 리스트");
			mtdao.selectMenuTable();
			System.out.println();
			System.out.println("고객 이름 입력");
			System.out.print("고객 이름 : ");
			name = input.nextLine();
			System.out.print("메뉴 번호 : ");
			bNo = Integer.parseInt(input.nextLine());
			System.out.print("구매 수량 : ");
			amount = Integer.parseInt(input.nextLine());
			cvo.setName(name);
			cvo.setbNo(bNo);
			cvo.setAmount(amount);
			cdao.insertCustomer(cvo);
			System.out.println();
			System.out.println("고객 전체 리스트");
			cdao.selectCustomer();
			System.out.println();
		}

		// 고객 수정 관리
		public void customerUpdate() throws Exception {
			Scanner input = new Scanner(System.in);
			Scanner input1 = new Scanner(System.in);
			CustomerDAO cdao = new CustomerDAO();
			CustomerVO cvo = new CustomerVO();
			int cNo = 0;
			String name = null; 
			int bNo = 0;
			int amount = 0;
			MenuTableDAO mtdao = new MenuTableDAO();
			System.out.println("메뉴 전체 리스트");
			mtdao.selectMenuTable();
			System.out.println("고객 전체 리스트");
			cdao.selectCustomer();
			System.out.println();
			System.out.println("수정할 고객번호 입력");
			System.out.print("고객번호 : ");
			cNo = Integer.parseInt(input.nextLine());
			System.out.println();
			System.out.println("새로운 정보 모두 입력");
			System.out.print("고객 이름 : ");
			name = input.nextLine();
			System.out.print("메뉴 번호 : ");
			bNo = Integer.parseInt(input.nextLine());
			System.out.print("구매 수량 : ");
			amount = Integer.parseInt(input.nextLine());
			cvo.setcNo(cNo);
			cvo.setName(name);
			cvo.setbNo(bNo);
			cvo.setAmount(amount);
			cdao.updateCustomer(cvo);
			System.out.println();
			System.out.println("고객 전체 리스트");
			cdao.selectCustomer();
			System.out.println();
		}

		// 고객 삭제 관리
		public void customerDelete() throws Exception {
			Scanner input = new Scanner(System.in);
			CustomerDAO cdao = new CustomerDAO();
			CustomerVO cvo = new CustomerVO();
			int bNo; // 입력한 일련번호
			System.out.println("고객 전체 리스트");
			cdao.selectCustomer();
			System.out.println();
			System.out.println("삭제할 고객 번호 입력");
			System.out.print("고객번호 : ");
			bNo = input.nextInt();
			cdao.deleteCustomer(bNo);
			System.out.println();
			System.out.println("고객 전체 리스트");
			cdao.selectCustomer();
			System.out.println();
		}
	}
