package student.mange;

import java.sql.Connection;
import java.sql.DriverManager;

public class CP {

	static Connection con;
	public static Connection createConnection() {
		try {
			//load the driver
			Class.forName("com.mysql.cj.jdbc.Driver");
			//create the connection.........
			String user = "root";
			String password = "root";
			String url = "jdbc:mysql://localhost:3306/studentapp";
			con = DriverManager.getConnection(url, user, password);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return con;
	}
}
