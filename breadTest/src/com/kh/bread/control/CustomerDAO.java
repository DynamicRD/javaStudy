package com.kh.bread.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.bread.model.CustomerVO;
import com.kh.bread.model.MenuTableVO;

public class CustomerDAO {
	public static String SELECTSQL = "select * from CUSTOMER order by C_NO";
	public static String INSERTSQL = "insert into CUSTOMER values (CUSTOMER_C_NO_SEQ.nextval, ?, ?, ?)";
	public static String UPDATESQL = "update CUSTOMER set NAME=?, B_NO=?,AMOUNT=? where C_NO=?";
	public static String DELETESQL = "delete from CUSTOMER where C_NO = ?";
	public static String SELECTMENUSQL = "select * from MENUTABLE order by b_NO";

	// 고객 목록
	public void selectCustomer() throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		CustomerVO cvo = null;
		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(SELECTSQL);
			rs = pstmt.executeQuery();
			System.out.println("=============================");
			System.out.println("고객번호\t고객명\t메뉴번호\t구매량");
			while (rs.next()) {
				cvo = new CustomerVO();
				cvo.setcNo(rs.getInt("C_NO"));
				cvo.setName(rs.getString("NAME"));
				cvo.setbNo(rs.getInt("B_NO"));
				cvo.setAmount(rs.getInt("AMOUNT"));

				System.out.println(cvo.getcNo() + "\t" + cvo.getName() + "\t" + cvo.getbNo() + "\t" + cvo.getAmount());

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

	// 고객 등록
	public void insertCustomer(CustomerVO cvo) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtility.dbCon(); //
			pstmt = con.prepareStatement(INSERTSQL);
			pstmt.setString(1, cvo.getName()); //
			pstmt.setInt(2, cvo.getbNo()); //
			pstmt.setInt(3, cvo.getAmount()); //
			int result = pstmt.executeUpdate(); //
			if (result == 1) {
				System.out.println(cvo.getName() + " 고객 등록 완료.");
				System.out.println("고객 등록 성공");
				int menuTablePrice = 0;
				// ===========
				ResultSet rs = null;
				MenuTableVO mtvo = null;
				pstmt = con.prepareStatement(SELECTMENUSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					mtvo = new MenuTableVO();
					mtvo.setbNo(rs.getInt("B_NO"));
					mtvo.setName(rs.getString("NAME"));
					mtvo.setPrice(rs.getInt("PRICE"));
					if(mtvo.getbNo() == cvo.getbNo()) {
						break;
					}
				}
				ShopRegisterManager srm = new ShopRegisterManager();
				srm.shopInsert(cvo.getbNo(), cvo.getAmount() * mtvo.getPrice());
				// ===========
				
			} else {
				System.out.println("고객 등록 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();

				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 메뉴 수정
	public void updateCustomer(CustomerVO cvo) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(UPDATESQL);
			pstmt.setString(1, cvo.getName()); //
			pstmt.setInt(2, cvo.getbNo()); //
			pstmt.setInt(3, cvo.getAmount()); //
			pstmt.setInt(4, cvo.getcNo());
			int result = pstmt.executeUpdate();
			if (result == 1) {
				System.out.println(cvo.getName() + " 고객 수정 완료.");
				System.out.println("고객 수정 성공");
				// ===========
				ResultSet rs = null;
				MenuTableVO mtvo = null;
				pstmt = con.prepareStatement(SELECTMENUSQL);
				rs = pstmt.executeQuery();
				while (rs.next()) {
					mtvo = new MenuTableVO();
					mtvo.setbNo(rs.getInt("B_NO"));
					mtvo.setName(rs.getString("NAME"));
					mtvo.setPrice(rs.getInt("PRICE"));
					if(mtvo.getbNo() == cvo.getbNo()) {
						break;
					}
				}
				ShopRegisterManager srm = new ShopRegisterManager();
				srm.shopInsert(cvo.getbNo(), cvo.getAmount() * mtvo.getPrice());
				// ===========
			} else {
				System.out.println("고객 수정 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}

	// 메뉴 삭제
	public void deleteCustomer(int no) throws Exception {
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
				System.out.println("고객 삭제 완료.");
				System.out.println("고객 삭제 성공");
			} else {
				System.out.println("고객 삭제 실패");
			}
		} catch (SQLException e) {
			System.out.println("e=[" + e + "]");
		} catch (Exception e) {
			System.out.println("e=[" + e + "]");
		} finally {
			try {
				// 데이터베이스와의 연결에 사용되었던 오브젝트를 해제
				if (pstmt != null)
					pstmt.close();
				if (con != null)
					con.close();
			} catch (SQLException e) {
			}
		}
	}
}
