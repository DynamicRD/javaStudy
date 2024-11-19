/*
 * package studentTest;
 * 
 * import java.sql.Connection; import java.sql.DriverManager; import
 * java.sql.ResultSet; import java.sql.SQLException; import java.sql.Statement;
 * import java.util.ArrayList;
 * 
 * public class ConnectDB {
 * 
 * public static void main(String[] args) { //객체참조변수 선언 Connection con =null;
 * Statement stmt = null; ResultSet rs = null; ArrayList<Employees> employeeList
 * = new ArrayList<Employees>();
 * 
 * //1.jdbc driver load, 2.connection con = DBConnection.dbCon(); //3. statement
 * (query: c,u,r,d) //4. result set //5.데이터를 저장진행 try { stmt =
 * con.createStatement(); rs = stmt.executeQuery("SELECT * FROM EMPLOYEES"); try
 * { while(rs.next()) { int employeeID = rs.getInt("EMPLOYEE_ID"); String
 * firstName = rs.getString("FIRST_NAME"); int salary = rs.getInt("SALARY");
 * Employees employees = new Employees(employeeID,firstName,salary);
 * employeeList.add(employees);
 * System.out.println(employeeID+"\t"+firstName+"\t"+salary); }
 * System.out.println("3.Statement 객체생성성공"); } catch (SQLException e) {
 * System.out.println("3.Statement 객체생성실패"); }
 * 
 * 
 * //데이터 출력 employeesListPrint(employeeList); //7. close
 * DBConnection.dbClose(con,stmt, rs); }
 * 
 * private static void employeesListPrint(ArrayList<Employees> employeesList) {
 * for(Employees e : employeesList) { System.out.println(e); } } }
 */