package com.kh.bread;

import java.util.Scanner;

import com.kh.bread.control.CustomeRegisterManager;
import com.kh.bread.control.MenuTableRegisterManager;
import com.kh.bread.control.ShopDAO;
import com.kh.bread.control.ShopRegisterManager;
import com.kh.bread.view.CustomerChoice;
import com.kh.bread.view.MenuChoice;
import com.kh.bread.view.MenuTableChoice;
import com.kh.bread.view.MenuViewer;
import com.kh.bread.view.ShopChoice;

public class BreadMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws Exception {
		int no;
		boolean exitFlag = false;
		while (!exitFlag) {
			try {
				MenuViewer.mainMenuView();
				no = Integer.parseInt(sc.nextLine());
				switch (no) {
				case MenuChoice.MENUTABLE:
					menuTableMenu();
					break;
				case MenuChoice.CUSTOMER:
					customerMenu();
					break;
				case MenuChoice.SHOP:
					shopMenu();
					break;
				case MenuChoice.EXIT:
					System.out.println("프로그램을 종료합니다.");
					exitFlag = true;
					break;
				default:
					System.out.println("해당 메뉴 번호만 입력하세요.");
				}

			} catch (Exception e) {
				System.out.println("\n입력에 오류가 있습니다.\n프로그램을 다시 시작하세요.");
			}
		}
	}

	private static void menuTableMenu() throws Exception {
		int no;
		boolean exitFlag = false;
		MenuTableRegisterManager mtrm = new MenuTableRegisterManager();
		while (!exitFlag) {
			MenuViewer.menuTableMenuView();
			no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case MenuTableChoice.LIST:
				mtrm.menuTableSelect();
				break;
			case MenuTableChoice.INSERT:
				mtrm.menuTableInsert();
				break;
			case MenuTableChoice.UPDATE:
				mtrm.menuTableUpdate();
				break;
			case MenuTableChoice.DELETE:
				mtrm.menuTableDelete();
				break;
			case MenuTableChoice.MAIN:
				System.out.println("메인화면으로 돌아갑니다.");
				exitFlag = true;
				break;
			default:
				System.out.println("해당 메뉴 번호만 입력하세요.");
			}
		}
	}

	private static void customerMenu() throws Exception {
		int no;
		boolean exitFlag = false;
		CustomeRegisterManager crm = new CustomeRegisterManager();
		while (!exitFlag) {
			MenuViewer.customerMenuView();
			no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case CustomerChoice.LIST:
				crm.customerSelect();
				break;
			case CustomerChoice.INSERT:
				crm.customerInsert();
				break;
			case CustomerChoice.UPDATE:
				crm.customerUpdate();
				break;
			case CustomerChoice.DELETE:
				crm.customerDelete();
				break;
			case CustomerChoice.MAIN:
				System.out.println("메인화면으로 돌아갑니다.");
				exitFlag = true;
				break;
			default:
				System.out.println("해당 메뉴 번호만 입력하세요.");
			}
		}
	}

	private static void shopMenu() throws Exception {
		int no;
		boolean exitFlag = false;
		ShopRegisterManager srm = new ShopRegisterManager();
		ShopDAO sdao = new ShopDAO();
		while (!exitFlag) {
			MenuViewer.shopMenuView();
			no = Integer.parseInt(sc.nextLine());
			switch (no) {
			case ShopChoice.LIST:
				srm.shopSelect();
				break;
			case ShopChoice.SUM:
				sdao.sumShop();
				break;
			case ShopChoice.MAIN:
				System.out.println("메인화면으로 돌아갑니다.");
				exitFlag = true;
				break;
			default:
				System.out.println("해당 메뉴 번호만 입력하세요.");
			}
		}
	}

}
