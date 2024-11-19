package studentTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnection {
	public static Connection dbCon() {
		//객체참조변수 선언
		Connection con = null;
		
		
		//1. jdbc driver load
		try {
				Class.forName("oracle.jdbc.driver.OracleDriver");
			} catch (ClassNotFoundException e) {
				System.out.println(e.toString());
			}
		//2. connection
		try {
				con = DriverManager.getConnection("jdbc:oracle:thin:@127.0.0.1:1521/xe","HR","hr");
			} catch (SQLException e) {
				System.out.println(e.toString());
			}
		return con;
	}
	
	public static void dbClose(Connection con, Statement stmt,ResultSet rs) {
		if(con != null) { 
			try {
				con.close();
				System.out.println("6.con close 성공");
			} catch (SQLException e) {
		
				System.out.println("6.con close 실패"+e.toString());
			}
		}
		if(stmt != null) {
			try {
				con.close();
				System.out.println("6.stmt close 성공");
			} catch (SQLException e) {
				System.out.println("6.stmt close 실패"+e.toString());
			}
		}
		if(rs != null) {
			try {
				con.close();
				System.out.println("6.rs close 성공");
			} catch (SQLException e) {
				System.out.println("6.rs close 실패"+e.toString());
			}
		}
	}
	
	
}
