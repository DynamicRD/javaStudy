package com.kh.bread.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.bread.model.MenuTableVO;

public class MenuTableDAO {
	public static String SELECTSQL = "select * from MENUTABLE order by b_NO";
	public static String INSERTSQL = "insert into MENUTABLE values (MENUTABLE_B_NO_SEQ.nextval, ?, ?, ?)";
	public static String UPDATESQL = "update MENUTABLE set NAME=?, PRICE=?, AMOUNT=? where B_NO=?";
	public static String DELETESQL = "delete from MENUTABLE where B_NO = ?";

	// 메뉴 목록
	public void selectMenuTable() throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		MenuTableVO mtvo = null;
		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(SELECTSQL);
			rs = pstmt.executeQuery();
			System.out.println("=============================");
			System.out.println("메뉴번호\t메뉴명\t가격\t재고");
			while (rs.next()) {
				mtvo = new MenuTableVO();
				mtvo.setbNo(rs.getInt("B_NO"));
				mtvo.setName(rs.getString("NAME"));
				mtvo.setPrice(rs.getInt("PRICE"));
				mtvo.setAmount(rs.getInt("AMOUNT"));
			
				System.out.println(mtvo.getbNo() + "\t" + mtvo.getName() + "\t" + mtvo.getPrice()+"\t"+mtvo.getAmount());
			}
		} catch (SQLException se) {
			System.out.println(se);
		} catch (Exception e) {
			System.out.println(e);
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException se) {
			}
		}
	}

	// 메뉴 등록
	public void insertMenuTable(MenuTableVO mtvo) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtility.dbCon(); //
			pstmt = con.prepareStatement(INSERTSQL);
			pstmt.setString(1, mtvo.getName()); //
			pstmt.setInt(2, mtvo.getPrice()); //
			pstmt.setInt(3, mtvo.getAmount()); //
			int result = pstmt.executeUpdate(); //
			if (result == 1) {
				System.out.println(mtvo.getName() + " 메뉴 등록 성공.");
			} else {
				System.out.println("메뉴 등록 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 메뉴 수정
	public void updateMenuTable(MenuTableVO mtvo) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(UPDATESQL);
			pstmt.setString(1, mtvo.getName()); //
			pstmt.setInt(2, mtvo.getPrice()); //
			pstmt.setInt(3, mtvo.getAmount()); //
			pstmt.setInt(4, mtvo.getbNo());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(mtvo.getName() + " 메뉴 수정 성공.");
			} else {
				System.out.println("메뉴 수정 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 메뉴 삭제
	public void deleteMenuTable(int no) throws Exception {
		StringBuffer sql = new StringBuffer();
		sql.append(DELETESQL);
		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtility.dbCon();

			pstmt = con.prepareStatement(sql.toString());
			pstmt.setInt(1, no);
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println("메뉴 삭제 성공");
			} else {
				System.out.println("메뉴 삭제 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
}
