package kr.co.khedu.java.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.khedu.java.model.StudentsVO;

public class StudentsRegisterManager {
	public static Scanner sc = new Scanner(System.in);

	public static void totalSelectManager() throws SQLException {
		ArrayList<StudentsVO> studentsList = new ArrayList<StudentsVO>();
		studentsList = StudentsDAO.selectSQL();
		printStudentsList(studentsList);
	}

	public static void printStudentsList(ArrayList<StudentsVO> studentsList) {
		 	System.out.println(String.format("%-4s%-4.9s%-5s%-4s%-5s%-4s%-4s%-4s","학번","이름","국어","영어","수학","총합","평균","통과여부"));
		for (StudentsVO svo : studentsList) {
			 System.out.println(String.format("%-5d%-5s%-5d%-5d%-5d%-5d%-5.1f%-5s",svo.getId(),svo.getName(),svo.getKor(),svo.getEng(),svo.getMath(),svo.getSum(),svo.getAvg(),svo.getPass()));
		}

	}

	public static void studentInsert() throws SQLException {
		boolean exitFlag = false;
		String name = null;
		int kor = 0;
		int eng = 0;
		int math = 0;
		while (!exitFlag) {
			System.out.print("입력할 이름을 입력하시오: ");
			name = sc.nextLine();
			System.out.print("입력할 국어성적을 입력하시오: ");
			try {
				kor = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("입력할 영어성적을 입력하시오: ");
			try {
				eng = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("입력할 수학성적을 입력하시오: ");
			try {
				math = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			exitFlag = true;
		}
		StudentsVO students = new StudentsVO(0, name, kor, eng, math);
		boolean successFlag = StudentsDAO.studentsInsert(students);
		if (successFlag = true) {
			System.out.println("입력처리 성공");
		} else {
			System.out.println("입력처리 실패");
		}
	}

	public static void studentDelete() throws SQLException {

		int id = 0;
		boolean exitFlag = false;
		while (!exitFlag) {
			System.out.print("삭제할 번호를 입력하세요: ");
			try {
				id = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			exitFlag = true;
		}
		StudentsVO svo = new StudentsVO();
		svo.setId(id);
		boolean successFlag = StudentsDAO.studentsDelete(svo);
		if (successFlag = true) {
			System.out.println("삭제처리 성공");
		} else {
			System.out.println("삭제처리 실패");
		}
	}

	public static void studentUpdate() throws SQLException {
		boolean exitFlag = false;
		int id = 0;
		String name = null;
		int kor = 0;
		int eng = 0;
		int math = 0;
		while (!exitFlag) {
			System.out.print("수정할 학생의 번호를 입력하세요: ");
			try {
				id = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("수정할 이름을 입력하시오: ");
			name = sc.nextLine();
			System.out.print("수정할 국어성적을 입력하시오: ");
			try {
				kor = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("수정할 영어성적을 입력하시오: ");
			try {
				eng = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			System.out.print("수정할 수학성적을 입력하시오: ");
			try {
				math = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			exitFlag = true;
		}
		StudentsVO students = new StudentsVO(id, name, kor, eng, math);
		boolean successFlag = StudentsDAO.studentsInsert(students);
		if (successFlag = true) {
			System.out.println("수정처리 성공");
		} else {
			System.out.println("수정처리 실패");
		}
	}

	public static void studentPassProc() throws SQLException {
		boolean exitFlag = false;
		int id = 0;
		while (!exitFlag) {
			try {
				System.out.print("통과여부를 확인할 ID 입력: >>");
				id = Integer.parseInt(sc.nextLine());
			} catch (NumberFormatException e) {
				System.out.println("숫자를 입력하세요");
				System.out.println();
				continue;
			}
			exitFlag = true;
		}
		StudentsVO students = new StudentsVO();
		students.setId(id);
		boolean successFlag = StudentsDAO.studentsPassProc(students);
		if (successFlag = true) {
			System.out.println("프로시저처리 성공");
		} else {
			System.out.println("프로시저 실패");
		}

	}
}
