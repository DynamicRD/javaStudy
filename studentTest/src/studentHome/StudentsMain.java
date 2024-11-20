package studentHome;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

import booktest.DBConnection;

public class StudentsMain {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;

		while (!exitFlag) {
			printMenu();
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case StudentsMenu.PRINT:
				studentPrint();
				break;
			case StudentsMenu.INSERT:
				studentInsert();
				break;
			case StudentsMenu.DELETE:
				studentDelete();
				break;
			case StudentsMenu.UPDATE:
				studentUpdate();
				break;
			case StudentsMenu.STUDENTS_PROC:
				studentPassProc();
				break;
			case StudentsMenu.STUDENTS_FUNC:

				break;
			case StudentsMenu.EXIT:
				exitFlag = true;
				break;
			default:
				break;
			}
		}
		System.out.println("The end");
	}

	private static void studentPassProc() throws SQLException {
		// Connection
		Connection con = null;
		CallableStatement cstmt = null;

		// 1 Load,2 connect
		con = DBConnection.dbCon();
		System.out.print("통과여부를 확인할 ID 입력: >>");
		int id = Integer.parseInt(sc.nextLine());
		
		cstmt = con.prepareCall("{call STUDENTS_PROCEDURE(?, ?)}");
		cstmt.setInt(1, id);
		cstmt.registerOutParameter(2, Types.VARCHAR);

		int result = cstmt.executeUpdate();
		String message = cstmt.getString(2);
		System.out.println(message);
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "통과 프로시저성공" : "통과 인상 프로시저실패");
		// 5.sql 객체 반납
		DBConnection.dbClose(con, cstmt);
	}

	private static void studentUpdate() throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1.Load,2.connect
		con = DBConnection.dbCon();
		con.setAutoCommit(false);
		// 3.statement
		// 수정할 데이터를 입력
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
		Students students = new Students(id, name, kor, eng, math);
		pstmt = con.prepareStatement("UPDATE STUDENTS SET ID = ?, NAME = ?,KOR = ?,ENG= ?,MATH= ? WHERE ID = ?");
		pstmt.setInt(1, students.getId());
		pstmt.setString(2, students.getName());
		pstmt.setInt(3, students.getKor());
		pstmt.setInt(4, students.getEng());
		pstmt.setInt(5, students.getMath());
		pstmt.setInt(6, students.getId());

		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "수정성공" : "수정실패");
		if (result != 0) {
			con.commit();
		} else {
			con.rollback();
		}
		// 5.sql 객체 반납
		DBConnection.dbClose(con, pstmt);
	}

	// 삭제
	private static void studentDelete() throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;
		int id = 0;
		boolean exitFlag = false;
		// 1.Load,2.connect
		con = DBConnection.dbCon();
		con.setAutoCommit(false);
		// 3.statement
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
		pstmt = con.prepareStatement("DELETE FROM STUDENTS WHERE ID = ?");
		pstmt.setInt(1, id);
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");
		if (result != 0) {
			con.commit();
		} else {
			con.rollback();
		}
		// 5.sql 객체 반납
		DBConnection.dbClose(con, pstmt);
	}

	private static void studentInsert() throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1.Load,2.connect
		con = DBConnection.dbCon();
		con.setAutoCommit(false);
		// 3.statement
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
		Students students = new Students(0, name, kor, eng, math);
		pstmt = con.prepareStatement(
				"INSERT INTO STUDENTS(ID,NAME,KOR,ENG,MATH,SUM,AVG) VALUES(students_id_seq.nextval,?,?,?,?,?,?)");
		pstmt.setString(1, students.getName());
		pstmt.setInt(2, students.getKor());
		pstmt.setInt(3, students.getEng());
		pstmt.setInt(4, students.getMath());
		pstmt.setInt(5, students.getSum());
		pstmt.setDouble(6, students.getAvg());
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "입력성공" : "입력실패");

		if (result != 0) {
			con.commit();
		} else {
			con.rollback();
		}
		// 5.sql 객체 반납
		DBConnection.dbClose(con, pstmt);
	}

	private static void studentPrint() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<Students> studentsList = new ArrayList<Students>();

		// 1.Load,2.connect
		con = DBConnection.dbCon();
		// 3.statement
		stmt = con.createStatement();
		rs = stmt.executeQuery("SELECT * FROM STUDENTS");
		// 4.테이블 가져오기
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("NAME");
			int kor = rs.getInt("KOR");
			int eng = rs.getInt("ENG");
			int math = rs.getInt("MATH");
			Students students = new Students(id, name, kor, eng, math);
			studentsList.add(students);
		}
		// 5.출력하기
		studentsListPrint(studentsList);
		// 6.sql 객체 반납
		DBConnection.dbClose(con, stmt, rs);
	}

	private static void studentsListPrint(ArrayList<Students> studentsList) {
		for (Students stu : studentsList) {
			System.out.println(stu);
		}

	}

	private static void printMenu() {
		System.out.println("1.출력 2.입력 3.삭제 4.수정 5.통과여부 7.종료");
		System.out.print(">>");
	}

}
