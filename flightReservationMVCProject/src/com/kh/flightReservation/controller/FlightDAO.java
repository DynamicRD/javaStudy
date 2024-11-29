package com.kh.flightReservation.controller;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.kh.flightReservation.model.FlightVO;

public class FlightDAO {
	public final String FLIGHT_SELECT = "SELECT * FROM FLIGHT";
	public final String FLIGHT_SELECT_SORT = "SELECT * FROM FLIGHT ORDER BY DEPARTURE_DATE";
	public final String FLIGHT_DELETE = "DELETE FROM FLIGHT WHERE NO = ?";
	public final String FLIGHT_UPDATE = "UPDATE FLIGHT SET A_NO=?,DEPARTURE_DATE =?,DEPARTURE_AIRPORT=?,ARRIVAL_AIRPORT=?,PRICE=?,SEAT =? WHERE NO =?";
	public final String FLIGHT_INSERT = "INSERT INTO FLIGHT VALUES(FLIGHT_NO_SEQ.NEXTVAL,?,?,?,?,?,?)";
	public final String FLIGHT_PRICE_PROC = "{CALL FLIGHT_PRICE_PROC(?)}";
	
	public boolean flightSalaryUpProc(int aNo) {
		Connection con = null;
		CallableStatement cstmt = null;
		boolean successflag = false;
		
		try {
			con = DBUtility.dbCon();
			cstmt = con.prepareCall(FLIGHT_PRICE_PROC);
			cstmt.setInt(1, aNo);
			int count = cstmt.executeUpdate();
			successflag = (count != 0) ? (true) : (false);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBUtility.dbClose(con, cstmt);
		}
		return successflag;
	}
	
	public ArrayList<FlightVO> flightSelect(FlightVO fvo) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ArrayList<FlightVO> flightList = new ArrayList<FlightVO>();

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(FLIGHT_SELECT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				int aNo = rs.getInt("A_NO");
				Date departmentDate = rs.getDate("DEPARTURE_DATE");
				String departmentAirport = rs.getString("DEPARTURE_AIRPORT");
				String arrivalAirport = rs.getString("ARRIVAL_AIRPORT");
				int price = rs.getInt("PRICE");
				String seat = rs.getString("SEAT");

				FlightVO FlightVO = new FlightVO(no, aNo, departmentDate, departmentAirport, arrivalAirport, price,
						seat);
				flightList.add(FlightVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return flightList;
	}

	public ArrayList<FlightVO> flightSelectSort(FlightVO fvo) {
		Connection con = null;
		PreparedStatement pstmt = null; 
		ResultSet rs = null;
		ArrayList<FlightVO> flightList = new ArrayList<FlightVO>(); 

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(FLIGHT_SELECT_SORT);
			rs = pstmt.executeQuery();
			while (rs.next()) {
				int no = rs.getInt("NO");
				int aNo = rs.getInt("A_NO");
				Date departmentDate = rs.getDate("DEPARTURE_DATE");
				String departmentAirport = rs.getString("DEPARTURE_AIRPORT");
				String arrivalAirport = rs.getString("ARRIVAL_AIRPORT");
				int price = rs.getInt("PRICE");
				String seat = rs.getString("SEAT");

				FlightVO FlightVO = new FlightVO(no, aNo, departmentDate, departmentAirport, arrivalAirport, price,
						seat);
				flightList.add(FlightVO);
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt, rs);
		}
		return flightList;
	}

	public boolean flightDelete(FlightVO fvo) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		boolean successFlag = false;
		try {
			con = DBUtility.dbCon();
			con.setAutoCommit(false);

			pstmt = con.prepareStatement(FLIGHT_DELETE);
			pstmt.setInt(1, fvo.getNo());
			int count = pstmt.executeUpdate();
			if (count != 0) {
				con.commit();
				successFlag = true;
			} else {
				con.rollback();
				successFlag = false;
			}
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public boolean flightUpdate(FlightVO fvo) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(FLIGHT_UPDATE);
			pstmt.setInt(1, fvo.getaNo());
			pstmt.setDate(2, fvo.getDepartmentDate());
			pstmt.setString(3, fvo.getDepartmentAirport());
			pstmt.setString(4, fvo.getArrivalAirport());
			pstmt.setInt(5, fvo.getPrice());
			pstmt.setString(6, fvo.getSeat());
			pstmt.setInt(7, fvo.getNo());

			int count = pstmt.executeUpdate();
			successFlag = (count != 0) ? (true) : (false);
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}

	public boolean flightInsert(FlightVO fvo) {
		Connection con = null; 
		PreparedStatement pstmt = null; 
		boolean successFlag = false;

		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(FLIGHT_INSERT);
			pstmt.setInt(1, fvo.getaNo());
			pstmt.setDate(2, fvo.getDepartmentDate());
			pstmt.setString(3, fvo.getDepartmentAirport());
			pstmt.setString(4, fvo.getArrivalAirport());
			pstmt.setInt(5, fvo.getPrice());
			pstmt.setString(6, fvo.getSeat());

			int count = pstmt.executeUpdate();
			successFlag = (count != 0) ? (true) : (false);
		} catch (SQLException e) {
			System.out.println(e.toString());
		} finally {
			DBUtility.dbClose(con, pstmt);
		}
		return successFlag;
	}
}