package student.mange;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;



public class StudentDao {

	public static boolean insertStudentToDB(Student st) {
		boolean flag = false;
		try {
			//jdbc code ...
			Connection con = CP.createConnection();
			String q = "insert into students(sname,sphone,scity) values(?,?,?)";
			//PreparedStatement
			PreparedStatement pstmt = con.prepareStatement(q);
			//set the value of parameter.
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			//execute query
			pstmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return flag;
	}
	
	public static boolean deleteStudent(int userId) {
		boolean flag = false;
		try {
			Connection con = CP.createConnection();
			String q = "delete from students where sid=?";
			PreparedStatement pstmt = con.prepareStatement(q);
			pstmt.setInt(1, userId);
			pstmt.executeUpdate();
			flag = true;
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return flag;
	}
	
	
	public static void showAllStudents() {
		try {
			Connection con = CP.createConnection();
			String q = "select * from students";
			Statement stmt = con.createStatement();
			ResultSet set = stmt.executeQuery(q);
			while(set.next()) {
				int id = set.getInt(1);
				String name = set.getString(2);
				String phone = set.getString(3);
				String city = set.getString(4);
				System.out.println("ID : "+id);
				System.out.println("Name : "+name);
				System.out.println("Phone : "+phone);
				System.out.println("City : "+city);
				System.out.println("*********************");
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
