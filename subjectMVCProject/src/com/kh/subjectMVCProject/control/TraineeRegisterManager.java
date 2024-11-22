package com.kh.subjectMVCProject.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

import com.kh.subjectMVCProject.model.StudentVO;


public class TraineeRegisterManager {
	public static Scanner sc = new Scanner(System.in);
	//전체 학생 리스트를 출력기능
	public static void totalSelectManager() throws SQLException {
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
		studentList = StudentDAO.studentSelect();
		printStudentList(studentList);
	}

	private static void printStudentList(ArrayList<StudentVO> studentList) {
		for(StudentVO sv:studentList) {
			System.out.println(sv.toString());
		}
		
	}
	
	public static void insertManager() throws SQLException {
		// 3.statement
		System.out.print("학생 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());
		
		StudentVO studentVO = new StudentVO();
		boolean successFlag = StudentDAO.studentInsert(studentVO);
		
		if(successFlag = true) {
			System.out.println("입력처리 성공");
		}else {
			System.out.println("입력처리 실패");
		}
	}

	public static void updateManager() throws SQLException {
		System.out.print("수정할 학생의 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 이름을 입력하세요: ");
		String name = sc.nextLine();
		System.out.print("새로운 국어 점수를 입력하세요: ");
		int kor = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 영어 점수를 입력하세요: ");
		int eng = Integer.parseInt(sc.nextLine());
		System.out.print("새로운 수학 점수를 입력하세요: ");
		int mat = Integer.parseInt(sc.nextLine());
		
		StudentVO svo = new StudentVO();
		boolean successFlag = StudentDAO.studentUpdate(svo);
		
		if(successFlag = true) {
			System.out.println("수정처리 성공");
		}else {
			System.out.println("수정처리 실패");
		}
	}

	public static void deleteManager() throws SQLException {
		System.out.print("삭제할 학생 번호를 입력하세요: ");
		int no = Integer.parseInt(sc.nextLine());
		StudentVO svo = new StudentVO();
		//svo.setNo(no);
		boolean successFlag = StudentDAO.studentDelete(svo);
	
		if(successFlag = true) {
			System.out.println("삭제처리 성공");
		}else {
			System.out.println("삭제처리 실패");
		}
	}

	public static void sortManager() throws SQLException {
		ArrayList<StudentVO> studentList = null;
		studentList =StudentDAO.studentSort();
		printStudentList(studentList);
	}

}
