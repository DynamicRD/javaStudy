package studentHome;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import booktest.Books;
import booktest.DBConnection;

public class StudentsMain {
	public static Scanner sc = new Scanner(System.in);
	public static final int SELECT = 1, INSERT = 2, DELETE = 3, UPDATE = 4, EXIT = 5;

	public static void main(String[] args) throws SQLException {
		boolean exitFlag = false;

		while (!exitFlag) {
			printMenu();
			int choice = Integer.parseInt(sc.nextLine());
			switch (choice) {
			case SELECT:
				studentSelect();
				break;
			case INSERT:
				studentInsert();
				break;
			case DELETE:
				studentDelete();
				break;
			case UPDATE:
				studentUpdate();
				break;
			case EXIT:
				exitFlag = true;
				break;
			default:
				break;
			}
		}
		System.out.println("The end");
	}

	private static void studentUpdate() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;

		// 1.Load,2.connect
		con = DBConnection.dbCon();
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
		stmt = con.createStatement();
		int result = stmt.executeUpdate("UPDATE STUDENTS SET ID = " + id + ", NAME = '" + name + "',KOR =" + kor
				+ ",ENG=" + eng + ",MATH=" + math + ",SUM="+(kor+eng+math)+",AVG="+(kor+eng+math)/3 +"WHERE ID = " + id);
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "수정성공" : "수정실패");
		// 5.sql 객체 반납
		DBConnection.dbClose(con, stmt);
	}

	private static void studentDelete() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		int id = 0;
		boolean exitFlag = false;
		// 1.Load,2.connect
		con = DBConnection.dbCon();
		// 3.statement
		while(!exitFlag)
		{
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
		stmt = con.createStatement();
		int result = stmt.executeUpdate("DELETE FROM STUDENTS WHERE ID = " + id);
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");
		// 5.sql 객체 반납
		DBConnection.dbClose(con, stmt);
	}

	private static void studentInsert() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;

		// 1.Load,2.connect
		con = DBConnection.dbCon();
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
		stmt = con.createStatement();
		int result = stmt.executeUpdate(
				"INSERT INTO STUDENTS VALUES(students_id_seq.nextval,'" + students.getName()
						+ "'," + students.getKor() + "," + students.getEng() + "," + students.getMath() +","+students.getSum()+","+students.getAvg()+")");
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "입력성공" : "입력실패");
		// 5.sql 객체 반납
		DBConnection.dbClose(con, stmt);
	}

	private static void studentSelect() throws SQLException {
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
		System.out.println("1.출력 2.입력 3.삭제 4.수정 5.종료");
		System.out.print(">>");
	}

}
