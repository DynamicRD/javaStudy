package kr.co.khedu.java;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.khedu.java.controller.DBUtility;
import kr.co.khedu.java.controller.StudentsRegisterManager;
import kr.co.khedu.java.model.StudentsVO;
import kr.co.khedu.java.view.StudentsCURDMenu;
import kr.co.khedu.java.view.StudentsMenu;

public class StudentsMVCProject { 
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;
		while (!exitFlag) {
			StudentsMenu.printMenu();
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case StudentsCURDMenu.PRINT:
				StudentsRegisterManager.totalSelectManager();
				break;
			case StudentsCURDMenu.INSERT:
				StudentsRegisterManager.studentInsert();
				break;
			case StudentsCURDMenu.DELETE:
				StudentsRegisterManager.studentDelete();
				break;
			case StudentsCURDMenu.UPDATE:
				StudentsRegisterManager.studentUpdate();
				break;
			case StudentsCURDMenu.STUDENTS_PROC:
				StudentsRegisterManager.studentPassProc();
				break;
			case StudentsCURDMenu.EXIT:
				exitFlag = true;
				break;
			default:
				break;
			}
		}
		System.out.println("The end");
	}
}
