package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import model.User;
import utility.ConnectionManager;

public class UserOperations {
	//Adding user to database
	public void addUser(User user) throws Exception {
		
		try{
			Connection con = ConnectionManager.getConnection();
			
			String sql ="insert into week6_user(u_id,u_name,u_email,u_password)values(?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, user.getU_id());
			ps.setString(2, user.getU_name());
			ps.setString(3, user.getU_email());
			ps.setString(4, user.getU_password());
			
			boolean result;
			result = ps.executeUpdate()>0;
			if(result==true)
				System.out.println("User Details Added Successfully");
			else 
				System.out.println("Adding User Details Failed. Please try again.");
			
			con.close();
		}
		catch(Exception e) {
			System.out.println("Please try again.");
		}
		
	}
	
	//Updating user details in database
	public void updateUser(User user) throws Exception {
		
		try{
			Connection con = ConnectionManager.getConnection();
			
			String sql ="update week6_user set u_name = ?,u_email = ?,u_password = ? where u_id = ?";
			
			PreparedStatement ps1 = con.prepareStatement(sql);
			
			ps1.setString(1, user.getU_name());
			ps1.setString(2, user.getU_email());
			ps1.setString(3, user.getU_password());
			ps1.setString(4, user.getU_id());
			
			boolean result;
			result = ps1.executeUpdate()>0;
			if(result==true)
				System.out.println("User id: "+user.getU_id()+" Details Updated Successfully");
			else 
				System.out.println("User id: "+user.getU_id()+" Details Updation Failed, Check the user id entered.");
			
			con.close();
		}
		catch(Exception e) {
			System.out.println("Please try again.");
		}
		
	}
	
	//Deleting user details from database
	public void deleteUser(String u_id) {
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql ="delete from week6_user where u_id = ?";
			
			PreparedStatement ps2 = con.prepareStatement(sql);	
			
			ps2.setString(1, u_id);
			
			boolean result;
			result = ps2.executeUpdate()>0;
			if(result==true)
				System.out.println("User id: "+u_id+" Details Deleted Successfully");
			else 
				System.out.println("User id: "+u_id+" Details Deletion Failed, Check the user id entered.");
			
			con.close();
			
		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		
	}

	//Displaying user details
	public List<User> displayUser() throws ClassNotFoundException, SQLException {
		
		List<User> userdetails = new ArrayList<User>();
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql ="select * from week6_user";
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			System.out.println();
			while(rs.next()) {
				User user = new User(rs.getString(1), rs.getString(2), rs.getString(3));
				userdetails.add(user);
			}
			
			con.close();
			
		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		return userdetails;
		
		
	}

}

