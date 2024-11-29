package com.kh.flightReservation;

import java.util.Scanner;

import com.kh.flightReservation.controller.FlightRegisterManager;
import com.kh.flightReservation.view.FLIGHT_CHOICE;

public class main {
	public static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		int num = 0;
		FlightRegisterManager frm = new FlightRegisterManager();
		while(true) {
			System.out.println("1.출력 2.입력 3.수정 4.삭제 5.정렬 6.인상");
			num = Integer.parseInt(sc.nextLine());
			switch (num) {
			case 1:
				frm.selectManager();
				break;
			case 2:
				frm.insertManager();
				break;
			case 3:
				frm.updateManager();
				break;
			case 4:
				frm.deleteManager();
				break;
			case 5:
				frm.selectSortManager();
				break;
			case 6:
				frm.salaryUpProcManager();
				break;
			default : 
				break;
			
			}
			
			
			
			
		}
		
	}
	
}