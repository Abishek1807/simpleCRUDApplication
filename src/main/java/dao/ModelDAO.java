package dao;

import java.sql.*;

import model.UserDetails;

public class ModelDAO {
	
	private Connection connection() throws Exception {
		String url = "jdbc:mysql://localhost:3306/crudapp";
		String un = "root";
		String pw = "root@123";
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection(url, un, pw);
		return connection;
	}
	
	public int signUpUser(UserDetails ud) throws Exception {
		String query = "INSERT INTO usertable (uname, unumber, uemail, upassword) values (?,?,?,?)";
		
		Connection con = connection();
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, ud.getName());
		pst.setString(2, ud.getNumber());
		pst.setString(3, ud.getEmail());
		pst.setString(4, ud.getPassword());
		
		int result = pst.executeUpdate();
		
		pst.close();
		con.close();
		
		return result;
	}

	
	public boolean loginUser(String un, String pass) throws Exception {
		
		String query = "SELECT * FROM usertable WHERE uemail=? AND upassword=?";
		
		Connection con = connection();
		
		PreparedStatement pst = con.prepareStatement(query);	
		pst.setString(1, un);
		pst.setString(2, pass);
		
		ResultSet rs = pst.executeQuery();
		
		if (rs.next()) { 
			pst.close();
			con.close();
			return true;
		} 
		pst.close();
		con.close();
		return false;
	}
	
	public UserDetails getUserDetails(String user) throws Exception {
		Connection con = connection();
		
		String query = "SELECT * FROM usertable WHERE uemail=?";
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, user);
		ResultSet rs = pst.executeQuery();
		
		rs.next();
		UserDetails ud = new UserDetails();
		ud.setName(rs.getString(2));
		ud.setNumber(rs.getString(3));
		// email left as we have that there in login session
		ud.setPassword(rs.getString(5));
		
		pst.close();
		con.close();
		return ud;
		
	}

	public int editUserDetails(UserDetails ud, String email) throws Exception {
		
		Connection con = connection();
		
		String query = "UPDATE usertable SET uname=?, unumber=?, upassword=? WHERE uemail=?";
		
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, ud.getName());
		pst.setString(2, ud.getNumber());
		pst.setString(3, ud.getPassword());
		pst.setString(4, email);
		
		int result = pst.executeUpdate();
		
		pst.close();
		con.close();
		
		return result;
		
	}

	public int deleteAccount(String user) throws Exception {
		Connection con = connection();
		String query = "DELETE FROM usertable WHERE uemail = ?";
		PreparedStatement pst = con.prepareStatement(query);
		pst.setString(1, user);
		int result = pst.executeUpdate();
		
		pst.close();
		con.close();
		return result;
		
	}
}
