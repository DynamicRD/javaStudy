package com.kh.movie.control;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.kh.movie.model.MovieVO;


public class MovieDAO {

	public static final String movie_SELECT = "SELECT * FROM movie";
    public static final String movie_INSERT = "INSERT INTO movie VALUES(movie_c_id_SEQ.NEXTVAL, ?, ?, ?,?)";
    public static final String movie_UPDATE = "UPDATE movie set title = ?, genre = ?, duration = ?, c_id = ? WHERE m_id = ?";
    public static final String movie_DELETE = "DELETE FROM movie WHERE m_id = ?";
 
	public static ArrayList<MovieVO> movieSelect() throws SQLException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		ArrayList<MovieVO> movieList = new ArrayList<MovieVO>();

		con = DBUtility.dbCon();
		stmt = con.createStatement();
		rs = stmt.executeQuery(movie_SELECT);

		if(rs.next()) {
			do{
				int m_id = rs.getInt("m_id");
				String title = rs.getString("title");
				String  genre = rs.getString("genre");
				int  duration= rs.getInt("duration");
				int  c_id= rs.getInt("c_id");
				MovieVO mvo = new MovieVO();
				movieList.add(mvo);
			}while (rs.next());
		}else {
			movieList = null; 
		}
		DBUtility.dbClose(con, stmt, rs);
		return movieList;
	}
	
	public static boolean movieInsert(MovieVO svo) throws SQLException {
		// Conection
		boolean successFlag = false; 
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		// 1 Load, 2. connect
		con = DBUtility.dbCon();

		pstmt = con.prepareStatement(movie_INSERT);
		pstmt.setInt(1, svo.getM_id());
		

		int result1 = pstmt.executeUpdate();
		System.out.println((result1 != 0) ? "입력성공" : "입력실패");

		DBUtility.dbClose(con, pstmt, cstmt);
		successFlag = (result1 != 0) ? true : false;
		
		return successFlag; 
	}

	public static boolean movieUpdate(MovieVO svo) throws SQLException {
		boolean successFlag = false; 
		Connection con = null;
		CallableStatement cstmt = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(movie_UPDATE);
		pstmt.setInt(1, svo.getM_id());
		

		int result1 = pstmt.executeUpdate();

		
		successFlag = (result1 != 0) ? true : false;

		DBUtility.dbClose(con, pstmt, cstmt);
		return successFlag; 
	}

	public static boolean movieDelete(MovieVO mvo) throws SQLException {
		boolean successFlag =false; 
		Connection con = null;
		PreparedStatement pstmt = null;

		con = DBUtility.dbCon();
		pstmt = con.prepareStatement(movie_DELETE);
		pstmt.setInt(1, mvo.getM_id());
		int result = pstmt.executeUpdate();
		successFlag = (result != 0) ? true : false ;

		DBUtility.dbClose(con, pstmt);
		return successFlag; 
	}

	

}
