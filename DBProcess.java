package demo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBProcess {
	Connection conn;
	Statement st;
	// connect DB
	public void connectDB() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost/bankdb", "root", "");
			System.out.println("connect DB success");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	//change account table
	public int changeTB(String sql) {
		int n =0;
		try {			
			connectDB();
			st =conn.createStatement();
			n = st.executeUpdate(sql);
			conn.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return n;
	}
}
