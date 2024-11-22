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
import com.kh.subjectMVCProject.model.TraineeVO;


public class TraineeDAO {
	public static final String TRAINEE_SELECT ="SELECT * FROM TRAINEE";
	public static final String TRAINEE_INSERT = "insertSQL INTO TRAINEE(NO, NAME, KOR, ENG, MAT) VALUES(TRAINEE_NO_SEQ.NEXTVAL, ?, ?, ?, ?)";
	public static final String TRAINEE_CALL_RANK_PROC = "{call TRAINEE_RANK_PROC()}";
	public static final String TRAINEE_UPDATE = "UPDATE TRAINEE SET NAME = ?, KOR = ?, ENG = ?, MAT = ? WHERE NO = ? ";
	public static final String TRAINEE_DELETE = "deleteSQL FROM TRAINEE WHERE NO = ?";
	public static final String TRAINEE_SORT = "SELECT * FROM TRAINEE ORDER BY RANK";
	
	public static ArrayList<TraineeVO> traineeSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>();
		
		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(TRAINEE_SELECT);

		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			int kor = rs.getInt("KOR");
			int eng = rs.getInt("ENG");
			int mat = rs.getInt("MAT");
			int total = rs.getInt("TOTAL");
			int ave = rs.getInt("AVE");
			int rank = rs.getInt("RANK");

			TraineeVO stu = new TraineeVO();
			traineeList.add(stu);
		}
		DBUtility.dbClose(con, stmt, rs);	
		return traineeList;
	}

	public static boolean traineeInsertSQL(TraineeVO svo) throws SQLException {
		// Conection
		boolean successFlag = false;
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(TRAINEE_INSERT);
		//pstmt.setString(1, svo.getName());
	
		int result1 = pstmt.executeUpdate();
		System.out.println((result1 != 0) ? "입력성공" : "입력실패");

		cstmt = con.prepareCall(TRAINEE_CALL_RANK_PROC);
		int result2 = cstmt.executeUpdate();
		System.out.println((result2 != 0) ? "프로시저성공" : "프로시저실패");


		DBUtility.dbClose(con, pstmt,cstmt);
		successFlag = (result1 != 0 && result2 != 0) ? true : false;
		
		return successFlag;
	}

	public static boolean traineeUpdate(TraineeVO svo) throws SQLException {
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;
		
		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(TRAINEE_UPDATE);
		//spstmt.setString(1, svo.getName());
	

		int result = pstmt.executeUpdate();
		cstmt = con.prepareCall(TRAINEE_CALL_RANK_PROC);
		int result2 = cstmt.executeUpdate();

		successFlag = (result2 != 0) ? true : false;
		
		DBUtility.dbClose(con, pstmt,cstmt);
		return successFlag;
	}

	public static boolean traineeDeleteSQL(TraineeVO svo) throws SQLException {
		Connection con = null;
		PreparedStatement pstmt = null;
		boolean successFlag = false;

		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(TRAINEE_DELETE);
		//pstmt.setString(1, svo.getId());
		int result = pstmt.executeUpdate();
		successFlag =(result != 0) ? true : false;

		DBUtility.dbClose(con, pstmt);
		return successFlag;
	}

	public static ArrayList<TraineeVO> traineeSort() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<TraineeVO> traineeList = new ArrayList<TraineeVO>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(TRAINEE_SELECT);

		while (rs.next()) {
			int no = rs.getInt("NO");
			String name = rs.getString("NAME");
			int kor = rs.getInt("KOR");
			int eng = rs.getInt("ENG");
			int mat = rs.getInt("MAT");
			int total = rs.getInt("TOTAL");
			int ave = rs.getInt("AVE");
			int rank = rs.getInt("RANK");

			TraineeVO stu = new TraineeVO();
			traineeList.add(stu);
		}
		
		DBUtility.dbClose(con, stmt, rs);
		return traineeList;
	}

}
