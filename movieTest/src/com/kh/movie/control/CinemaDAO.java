package com.kh.movie.control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.movie.model.CinemaVO;

public class CinemaDAO {
	
	public static final String cinema_SELECT = "SELECT * FROM CINEMA";
    public static final String cinema_INSERT = "INSERT INTO CINEMA VALUES(cinema_c_id_SEQ.NEXTVAL, ?, ?, ?)";
    public static final String cinema_UPDATE = "UPDATE CINEMA set name = ?, location = ?, ad_num = ? WHERE c_id = ?";
    public static final String cinema_DELETE = "DELETE FROM CINEMA WHERE c_id = ?";
 
	public static ArrayList<CinemaVO> cinemaSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<CinemaVO> cinemaList = new ArrayList<CinemaVO>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(cinema_SELECT);

		if(rs.next()) {
			do{
				int c_id = rs.getInt("c_id");
				String name = rs.getString("name");
				String  location = rs.getString("location");
				int  ad_num = rs.getInt("ad_num");
				CinemaVO stu = new CinemaVO();
				cinemaList.add(stu);
			}while (rs.next());
		}else {
			cinemaList = null; 
		}
		DBUtility.dbClose(con, stmt, rs);
		return cinemaList;
	}
	
	public static boolean cinemaInsert(CinemaVO svo) throws SQLException {
		// Conection
		boolean successFlag = false; 
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(cinema_INSERT);
		pstmt.setString(1, svo.getName());
		

		int result1 = pstmt.executeUpdate();
		System.out.println((result1 != 0) ? "입력성공" : "입력실패");

		DBUtility.dbClose(con, pstmt, cstmt);
		successFlag = (result1 != 0) ? true : false;
		
		return successFlag; 
	}

	public static boolean cinemaUpdate(CinemaVO svo) throws SQLException {
		boolean successFlag = false; 
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(cinema_UPDATE);
		pstmt.setString(1, svo.getName());
		

		int result1 = pstmt.executeUpdate();

		
		successFlag = (result1 != 0) ? true : false;

		DBUtility.dbClose(con, pstmt, cstmt);
		return successFlag; 
	}

	public static boolean cinemaDelete(CinemaVO svo) throws SQLException {
		boolean successFlag =false; 
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(cinema_DELETE);
		pstmt.setInt(1, svo.getC_id());
		int result = pstmt.executeUpdate();
		successFlag = (result != 0) ? true : false ;

		DBUtility.dbClose(con, pstmt);
		return successFlag; 
	}

	

}
