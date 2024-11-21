package kr.co.khedu.java.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.Scanner;

import kr.co.khedu.java.model.StudentsVO;

public class StudentsDAO {
	public static Scanner sc = new Scanner(System.in);
	public static String selectSQL = "SELECT * FROM STUDENTS";
	public static String insertSQL = "INSERT INTO STUDENTS(ID,NAME,KOR,ENG,MATH,SUM,AVG) VALUES(students_id_seq.nextval,?,?,?,?,?,?)";
	public static String deleteSQL = "DELETE FROM STUDENTS WHERE ID = ?";
	public static String updateSQL = "UPDATE STUDENTS SET ID = ?, NAME = ?,KOR = ?,ENG= ?,MATH= ? WHERE ID = ?";
	public static String passProcSQL = "{call STUDENTS_PROCEDURE(?, ?)}";
	
	public static ArrayList<StudentsVO> selectSQL() throws SQLException {
		// Connection
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<StudentsVO> studentsList = new ArrayList<StudentsVO>();

		// 1.Load,2.connect
		con = DBUtility.dbCon();
		// 3.statement
		stmt = con.createStatement();
		rs = stmt.executeQuery(selectSQL);
		// 4.테이블 가져오기
		while (rs.next()) {
			int id = rs.getInt("ID");
			String name = rs.getString("NAME");
			int kor = rs.getInt("KOR");
			int eng = rs.getInt("ENG");
			int math = rs.getInt("MATH");
			StudentsVO students = new StudentsVO(id, name, kor, eng, math);
			studentsList.add(students);
		}
		// 5.출력하기
		// 6.sql 객체 반납
		DBUtility.dbClose(con, stmt, rs);
		return studentsList;
	}
	public static boolean studentsInsert(StudentsVO svo) throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1.Load,2.connect
		con = DBUtility.dbCon();
		
		// 3.statement
		boolean exitFlag = false;
		pstmt = con.prepareStatement(insertSQL);
		pstmt.setString(1, svo.getName());
		pstmt.setInt(2, svo.getKor());
		pstmt.setInt(3, svo.getEng());
		pstmt.setInt(4, svo.getMath());
		pstmt.setInt(5, svo.getSum());
		pstmt.setDouble(6, svo.getAvg());
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력되었는지 체크

		// 5.sql 객체 반납
		DBUtility.dbClose(con, pstmt);
		return result != 0;
	}
	public static boolean studentsDelete(StudentsVO svo) throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1.Load,2.connect
		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(deleteSQL);
		pstmt.setInt(1, svo.getId());
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");
	
		// 5.sql 객체 반납
		DBUtility.dbClose(con, pstmt);
		return result != 0;
	}
	public static boolean studentsUpdate(StudentsVO svo) throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1.Load,2.connect
		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(updateSQL);
		pstmt.setInt(1, svo.getId());
		pstmt.setString(2, svo.getName());
		pstmt.setInt(3, svo.getKor());
		pstmt.setInt(4, svo.getEng());
		pstmt.setInt(5, svo.getMath());
		pstmt.setInt(6, svo.getId());

		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "수정성공" : "수정실패");
		// 5.sql 객체 반납
		DBUtility.dbClose(con, pstmt);
		return result != 0;
	}
	public static boolean studentsPassProc(StudentsVO svo) throws SQLException {
		// Connection
		Connection con = null;
		CallableStatement cstmt = null;

		// 1 Load,2 connect
		con = DBUtility.dbCon();
		
		cstmt = con.prepareCall(passProcSQL);
		cstmt.setInt(1, svo.getId());
		cstmt.registerOutParameter(2, Types.VARCHAR);

		int result = cstmt.executeUpdate();
		String message = cstmt.getString(2);
		System.out.println(message);
		// 4.내용이 잘 입력이 되었는지 check
		System.out.println((result != 0) ? "통과 프로시저성공" : "통과 인상 프로시저실패");
		// 5.sql 객체 반납
		DBUtility.dbClose(con, cstmt);
		return result != 0;
	}
}
