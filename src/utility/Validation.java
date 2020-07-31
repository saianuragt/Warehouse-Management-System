package utility;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Admin;
import model.User;

public class Validation {
	
	public boolean adminValidation(Admin admin) {
		boolean result = false;
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql ="select * from week6_admin where A_EMAIL = ? and A_PASSWORD = ?";
			
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, admin.getA_email());
			ps.setString(2, admin.getA_password());
			
			ResultSet rs = ps.executeQuery();
			
			result = rs.next();
			
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

	public boolean userValidation(User user) {
		boolean result = false;
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql ="select * from week6_user where U_EMAIL = ? and U_PASSWORD = ?";
			
			PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setString(1, user.getU_email());
			ps1.setString(2, user.getU_password());
			
			ResultSet rs = ps1.executeQuery();
			
			result = rs.next();
			
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		return result;
	}

}
