package com.kh.subjectMVCProject.control;

import java.sql.Connection;

public class Test {

	public static void main(String[] args) {
		Connection con = DBUtility.dbCon();
		if(con != null) {
			System.out.println("데이터베이스 접속 성공");
		}else {
			System.out.println("데이터베이스 접속 실패");
		}
	}

}
