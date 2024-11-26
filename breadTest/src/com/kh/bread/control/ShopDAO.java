package com.kh.bread.control;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.kh.bread.model.ShopVO;

public class ShopDAO {
	public static String SELECTSQL = "select * from SHOP order by NO";
	public static String INSERTSQL = "insert into SHOP values (SHOP_NO_SEQ.nextval, ?, ?)";
	
	//가게 조회
	public void selectShop() throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopVO svo = null;
		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(SELECTSQL);
			rs = pstmt.executeQuery();
			System.out.println("=============================");
			System.out.println("결재번호\t메뉴번호\t수입");
			while (rs.next()) {
				svo = new ShopVO();
				svo.setNo(rs.getInt("NO"));
				svo.setbNo(rs.getInt("B_NO"));
				svo.setIncome(rs.getInt("INCOME"));

				System.out.println(
						svo.getNo() + "\t" + svo.getbNo() + "\t" + svo.getIncome());

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

	// 가게 등록
	public void insertShop(ShopVO svo) throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		try {
			con = DBUtility.dbCon(); //
			pstmt = con.prepareStatement(INSERTSQL);
			pstmt.setInt(1, svo.getbNo()); //
			pstmt.setInt(2, svo.getIncome()); //
			int i = pstmt.executeUpdate(); //
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

	public void sumShop() throws Exception {

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ShopVO svo = null;
		int sum = 0;
		try {
			con = DBUtility.dbCon();
			pstmt = con.prepareStatement(SELECTSQL);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				svo = new ShopVO();
				svo.setNo(rs.getInt("NO"));
				svo.setbNo(rs.getInt("B_NO"));
				svo.setIncome(rs.getInt("INCOME"));
				sum+=svo.getIncome();
			}
			System.out.println("가게의 총 수입은 "+sum+"원 입니다.");
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
	
}
