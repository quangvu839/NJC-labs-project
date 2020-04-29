package databaseproject;



import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseProject1 {

	public static void main(String[] args) {
		DatabaseProject1 pro = new DatabaseProject1();
		try {
			pro.createConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	void createConnection() throws SQLException {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb", "root","quangvu91");
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("SELECT * FROM users");
			
			while(rs.next()) {
				String firstName = rs.getString("firstName");
				String lastName = rs.getString("lastName");
				int IDs = rs.getInt("IDs");
				String email = rs.getString("email");
				String address = rs.getString("address");
				System.out.printf("IDs : %d, firstName: %s, lastName : %s %n", IDs, firstName, lastName);
				}
				String sql = "INSERT INTO users " + "VALUES (13,'Henry', 'Phi', 'hu832@yahoo.com', '2884 river rd')";
				stmt.executeUpdate(sql);
			System.out.print("Database Conection Success");
		} 
	catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
		
		
	}
}


