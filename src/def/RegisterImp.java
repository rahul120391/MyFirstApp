package def;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class RegisterImp {

	private String DRIVER="com.mysql.jdbc.Driver";
	private String URL="jdbc:mysql://localhost:3306";
	private String USER="root";
	private String PASSWORD="Mike@12345";
	private String SQL_INSERT="INSERT into MyDatabase.login (username,password) VALUE (?,?)";
	private int i;
	
	//192.168.43.240
	public int registerUser(User user) {
		// TODO Auto-generated method stub
		String username=user.getmUsername();
		String password=user.getmPassword();
		
		try {
			Class.forName(DRIVER);
			Connection con=DriverManager.getConnection(URL,USER,PASSWORD);
			PreparedStatement ps=con.prepareStatement(SQL_INSERT);
			ps.setString(1, username);
			ps.setString(2, password);
			i=ps.executeUpdate();
			
		}
		catch (Exception e) {
			// TODO: handle exception
		}
		return i;
	}

}
