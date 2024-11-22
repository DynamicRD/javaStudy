package com.kh.subjectMVCProject.control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import com.kh.subjectMVCProject.model.StudentVO;


public class StudentDAO {
	public static final String STUDENT_SELECT ="SELECT * FROM STUDENT";
	public static final String STUDENT_INSERT = "insertSQL INTO STUDENT(NO, NAME, KOR, ENG, MAT) VALUES(STUDENT_NO_SEQ.NEXTVAL, ?, ?, ?, ?)";
	public static final String STUDENT_CALL_RANK_PROC = "{call STUDENT_RANK_PROC()}";
	public static final String STUDENT_UPDATE = "UPDATE STUDENT SET NAME = ?, KOR = ?, ENG = ?, MAT = ? WHERE NO = ? ";
	public static final String STUDENT_DELETE = "deleteSQL FROM STUDENT WHERE NO = ?";
	public static final String STUDENT_SORT = "SELECT * FROM STUDENT ORDER BY RANK";
	
	public static ArrayList<StudentVO> studentSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();
		
		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(STUDENT_SELECT);

		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			int kor = rs.getInt("KOR");
			int eng = rs.getInt("ENG");
			int mat = rs.getInt("MAT");
			int total = rs.getInt("TOTAL");
			int ave = rs.getInt("AVE");
			int rank = rs.getInt("RANK");

			StudentVO stu = new StudentVO();
			studentList.add(stu);
		}
		DBUtility.dbClose(con, stmt, rs);	
		return studentList;
	}

	public static boolean studentInsert(StudentVO svo) throws SQLException {
		// Conection
		boolean successFlag = false;
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(STUDENT_INSERT);
		pstmt.setString(1, svo.getName());
	
		int result1 = pstmt.executeUpdate();
		System.out.println((result1 != 0) ? "입력성공" : "입력실패");

		cstmt = con.prepareCall(STUDENT_CALL_RANK_PROC);
		int result2 = cstmt.executeUpdate();
		System.out.println((result2 != 0) ? "프로시저성공" : "프로시저실패");


		DBUtility.dbClose(con, pstmt,cstmt);
		successFlag = (result1 != 0 && result2 != 0) ? true : false;
		
		return successFlag;
	}

	public static boolean studentUpdate(StudentVO svo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		
		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(STUDENT_UPDATE);
		pstmt.setString(1, svo.getName());
	

		int result = pstmt.executeUpdate();
		cstmt = con.prepareCall(STUDENT_CALL_RANK_PROC);
		int result2 = cstmt.executeUpdate();

		successFlag = (result2 != 0) ? true : false;
		
		DBUtility.dbClose(con, pstmt,cstmt);
		return successFlag;
	}

	public static boolean studentDelete(StudentVO svo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false;

		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(STUDENT_DELETE);
		pstmt.setString(1, svo.getId());
		int result = pstmt.executeUpdate();
		successFlag =(result != 0) ? true : false;

		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}

	public static ArrayList<StudentVO> studentSort() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<StudentVO> studentList = new ArrayList<StudentVO>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(STUDENT_SELECT);

		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			int kor = rs.getInt("KOR");
			int eng = rs.getInt("ENG");
			int mat = rs.getInt("MAT");
			int total = rs.getInt("TOTAL");
			int ave = rs.getInt("AVE");
			int rank = rs.getInt("RANK");

			StudentVO stu = new StudentVO();
			studentList.add(stu);
		}
		
		DBUtility.dbClose(con, stmt, rs);
		return studentList;
	}

}
