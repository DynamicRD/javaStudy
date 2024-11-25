package com.kh.movie;

import java.sql.SQLException;
import java.util.Scanner;

import com.kh.movie.control.AudienceRegisterManager;
import com.kh.movie.control.CinemaRegisterManager;
import com.kh.movie.control.MovieRegisterManager;
import com.kh.movie.view.CURDChoice;
import com.kh.movie.view.MenuChoice;
import com.kh.movie.view.MenuViewer;

public class MovieMain {
	public static Scanner sc = new Scanner(System.in); 
	public static void main(String[] args) {
		int no;
		boolean exitFlag = false; 
		while (!exitFlag) {
			try {
				MenuViewer.mainMenuView();
				no = Integer.parseInt(sc.nextLine()); 
				switch (no) {
				case MenuChoice.CINAMA:
					cinemaMenu();
					break;
				case MenuChoice.MOVIE:
					movieMenu();
					break;
				case MenuChoice.AUDIENCE:
					audienceMenu();
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
		}//end of file
	}
	//영화정보
	private static void movieMenu() throws SQLException {
		int no;
		MovieRegisterManager mrm = new MovieRegisterManager();  

		MenuViewer.movieMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case CURDChoice.LIST:
			System.out.println("");
			mrm.selectManager();
			break;
		case CURDChoice.INSERT:
			System.out.println("");
			mrm.insertManager();
			break;
		case CURDChoice.UPDATE:
			System.out.println("");
			mrm.updateManager();
			break;
		case CURDChoice.DELETE:
			System.out.println("");
			mrm.deleteManager();
			break;
		case CURDChoice.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
		
	}
	//영화관정보
	private static void cinemaMenu() throws SQLException {
		int no;
		CinemaRegisterManager crm = new CinemaRegisterManager();  

		MenuViewer.cinemaMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case CURDChoice.LIST:
			System.out.println("");
			crm.selectManager();
			break;
		case CURDChoice.INSERT:
			System.out.println("");
			crm.insertManager();
			break;
		case CURDChoice.UPDATE:
			System.out.println("");
			crm.updateManager();
			break;
		case CURDChoice.DELETE:
			System.out.println("");
			crm.deleteManager();
			break;
		case CURDChoice.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}
		
	}
	//과목정보
	private static void audienceMenu() throws SQLException{
		int no;
		AudienceRegisterManager arm = new AudienceRegisterManager();  

		MenuViewer.audienceMenuView();
		no = Integer.parseInt(sc.nextLine());
		switch (no) {
		case CURDChoice.LIST:
			System.out.println("");
			arm.selectManager();
			break;
		case CURDChoice.INSERT:
			System.out.println("");
			arm.insertManager();
			break;
		case CURDChoice.UPDATE:
			System.out.println("");
			arm.updataManager();
			break;
		case CURDChoice.DELETE:
			System.out.println("");
			arm.deleteManager();
			break;
		case CURDChoice.MAIN:
			return;
		default:
			System.out.println("해당 메뉴 번호만 입력하세요.");
		}

	}
}

