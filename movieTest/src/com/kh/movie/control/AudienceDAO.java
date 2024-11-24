package com.kh.movie.control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

import com.kh.movie.model.AudienceVO;

public class AudienceDAO {
	
	public static Scanner sc = new Scanner(System.in);
	public static String selectSQL = "SELECT * FROM AUDIENCE";
	public static String insertSQL = "INSERT INTO AUDIENCE VALUES(audience_a_id_seq.nextval,?,?,?)";
	public static String deleteSQL = "DELETE FROM AUDIENCE WHERE a_id = ?";
	public static String updateSQL = "UPDATE AUDIENCE SET a_id = ?, name = ?,phone = ?,c_id= ?";
	
	public static ArrayList<AudienceVO> audienceSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<AudienceVO> audienceList = new ArrayList<AudienceVO>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(selectSQL);
		if(rs.next()) {
			do{
			int a_id = rs.getInt("a_id");
			String name = rs.getString("name");
			int phone = rs.getInt("phone");
			int c_id = rs.getInt("c_id");
			AudienceVO avo = new AudienceVO();
			audienceList.add(avo);
			}while (rs.next());
		}else {
			audienceList = null; 
		}
		DBUtility.dbClose(con, stmt, rs);
		return audienceList;
	}
	public static boolean audienceInsert(AudienceVO avo) throws SQLException {
		// Conection
		boolean successFlag = false;
		Connection con = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;

		// 1.Load,2.connect
		con = DBUtility.dbCon();
		
		// 3.statement
		boolean exitFlag = false;
		pstmt = con.prepareStatement(insertSQL);
		pstmt.setString(1, avo.getName());

		int result1 = pstmt.executeUpdate();
		System.out.println((result1 != 0) ? "입력성공" : "입력실패");

		DBUtility.dbClose(con, pstmt, cstmt);
		successFlag = (result1 != 0) ? true : false;
		
		return successFlag; 
	}
	public static boolean audienceDelete(AudienceVO avo) throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;
		// 1.Load,2.connect
		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(deleteSQL);
		pstmt.setInt(1, avo.getA_id());
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "삭제성공" : "삭제실패");
	
		// 5.sql 객체 반납
		DBUtility.dbClose(con, pstmt);
		return result != 0;
	}
	public static boolean audienceUpdate(AudienceVO avo) throws SQLException {
		// Connection
		Connection con = null;
		PreparedStatement pstmt = null;

		// 1.Load,2.connect
		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(updateSQL);
		pstmt.setInt(1, avo.getA_id());
		pstmt.setString(2, avo.getName());
		pstmt.setInt(3, avo.getPhone());
		pstmt.setInt(4, avo.getC_id());
		int result = pstmt.executeUpdate();
		// 4.내용이 잘 입력되었는지 체크
		System.out.println((result != 0) ? "수정성공" : "수정실패");
		// 5.sql 객체 반납
		DBUtility.dbClose(con, pstmt);
		return result != 0;
	}
	
}
