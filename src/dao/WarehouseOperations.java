package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.Storage;
import model.User;
import model.Warehouse;
import utility.ConnectionManager;

public class WarehouseOperations {
	
	//Adding boxes to database
	public void addToWarehouse(Warehouse wh) {
		try{
			Connection con = ConnectionManager.getConnection();
			
			String sql ="insert into week6_warehouse(p_id,u_name,p_type,no_of_boxes,no_of_days)values(seq_user.nextval,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, wh.getU_name());
			ps.setString(2, wh.getP_type());
			ps.setString(3, wh.getNo_of_boxes());
			ps.setString(4, wh.getNo_of_days());
			
			boolean result;
			result = ps.executeUpdate()>0;
			if(result==true)
				System.out.println("Added Boxes Successfully");
			else 
				System.out.println("Adding boxes Failed. Please check your details and try again.");
			
			con.close();
		}
		catch(Exception e) {
			System.out.println("Please try again.");
		}
		
	}
	
	//Removing boxes from database
	public void removeFromWarehouse(String p_id) {
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql ="delete from week6_warehouse where p_id = ?";
			
			PreparedStatement ps1 = con.prepareStatement(sql);	
			
			ps1.setString(1, p_id);
			
			boolean result;
			result = ps1.executeUpdate()>0;
			if(result==true)
				System.out.println("Boxes under Product id: "+p_id+", Removed Successfully");
			else 
				System.out.println("Boxes under Product id: "+p_id+"  Removal Failed, Check the product id entered.");
			
			con.close();
			
		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		
	}
	
	//Displaying User Orders
	public List<Warehouse> displayWarehouse() {
		List<Warehouse> orderdetails = new ArrayList<Warehouse>();
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql ="select * from week6_warehouse order by p_id ASC";
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				Warehouse wh = new Warehouse(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
			
				orderdetails.add(wh);
			}
			
			con.close();
			
		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		
		return orderdetails;
		
	}

//	public List<Storage> displayStorage() {
//		List<Storage> storagedetails = new ArrayList<Storage>();
//		try {
//			Connection con = ConnectionManager.getConnection();
//			
//			String sql ="select * from week6_storage";
//			
//			Statement st = con.createStatement();
//			
//			ResultSet rs = st.executeQuery(sql);
//			
//			while(rs.next()) {
//				Storage s = new Storage(rs.getString(1),rs.getString(2),rs.getString(3));
//				
//				storagedetails.add(s);
//			}
//			
//			con.close();
//			
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//		return storagedetails;
//	}
	
	//Displaying Storage Capacity of Warehouse
	public void displayStorage() {
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql ="select * from week6_storage";
			
			Statement st = con.createStatement();
			
			ResultSet rs = st.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println();
				System.out.println("Total Warehouse Capacity : "+rs.getString(1)+" Boxes");
				System.out.println();
				System.out.println("Occupied Warehouse Capacity : "+rs.getString(2)+" Boxes");
				System.out.println();
				System.out.println("Free Space Available : "+rs.getString(3)+" Boxes");
				System.out.println();
			}
			
			con.close();
			
		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		
	}


//	public void displaySelectedStorage(String u_name) {
//		try {
//			Connection con = ConnectionManager.getConnection();
//			
//			String sql ="select * from week6_warehouse where u_name = ? order by p_id ASC";
//			
//			PreparedStatement ps1 = con.prepareStatement(sql);
//			ps1.setString(1, u_name);
//			ResultSet rs = ps1.executeQuery();
//			while(rs.next()) {
//				System.out.println("Product Id : "+rs.getString(1)+"     "+"User Name : "+rs.getString(2)+"     "+"Product Type : "+rs.getString(3)+"     "+"No of Boxes : "+rs.getString(4)+"     "+"No of Days : "+rs.getNString(5));
//				System.out.println();
//			}
//			
//			con.close();
//			
//		}catch(Exception e) {
//			System.out.println(e);
//		}
//	}
	
	//Displaying user details sorted by user name
	public List<Warehouse> displaySelectedStorage(String u_name) {
		
		List<Warehouse> userdetails = new ArrayList<Warehouse>();
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql ="select * from week6_warehouse where u_name = ? order by p_id ASC";
			
			PreparedStatement ps1 = con.prepareStatement(sql);
			ps1.setString(1, u_name);
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				 Warehouse wh = new Warehouse(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5));
				userdetails.add(wh);
			}
			
			con.close();
			
		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		return userdetails;
	}
	
	//Adding boxes count to warehouse count
	public void addBoxesToCount(String wh) {
		int occupied=0,free=0;
		try {
			Connection con = ConnectionManager.getConnection();
			String sql1 = "select * from week6_storage";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				occupied = rs.getInt(2);
				occupied= occupied+Integer.parseInt(wh);
				free = rs.getInt(3);
				free = free-Integer.parseInt(wh);
			}
			con.close();

		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		try {
			Connection con = ConnectionManager.getConnection();	

			String sql2= "update week6_storage set s_occupied = ?, s_free = ?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, occupied);
			ps2.setInt(2, free);
			ps2.executeUpdate();

			con.close();

		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		
	}

	//Updating removed boxes count from warehouse storage count
	public void removeBoxesFromCount(String p_id) {
		int boxes = 0;
		try {
			Connection con = ConnectionManager.getConnection();
			String sql1 = "select * from week6_warehouse where p_id=?";
			PreparedStatement ps = con.prepareStatement(sql1);
			ps.setString(1, p_id);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				boxes=rs.getInt(4);

			}
			con.close();

		}catch(Exception e) {
			System.out.println(e);
		}
		int occupied=0,free=0;
		try {
			Connection con = ConnectionManager.getConnection();
			String sql1 = "select * from week6_storage";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				occupied = rs.getInt(2);
				occupied= occupied-boxes;
				free = rs.getInt(3);
				free = free+boxes;
			}
			con.close();

		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		try {
			Connection con = ConnectionManager.getConnection();	
			String sql2= "update week6_storage set s_occupied = ?, s_free = ?";
			PreparedStatement ps2 = con.prepareStatement(sql2);
			ps2.setInt(1, occupied);
			ps2.setInt(2, free);
			ps2.executeUpdate();
			con.close();

		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		
	}

	//Checking for free space in warehouse
	public boolean checkFreeSpace(String no_of_boxes) {
		int free=0,box;
		boolean result = false;
		try {
			Connection con = ConnectionManager.getConnection();
			String sql1 = "select * from week6_storage";
			PreparedStatement ps1 = con.prepareStatement(sql1);
			ResultSet rs = ps1.executeQuery();
			while(rs.next()) {
				free = rs.getInt(3);
				box=Integer.parseInt(no_of_boxes);
				if(free>box) {
					result = true;
					
				}
				else
					result = false;
			}
			con.close();

		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		return result;
		
	}

	//Adding details to Billing table in database
	public void addToBill(Warehouse wh) {
		
		int id = 0;
		try {
			Connection con = ConnectionManager.getConnection();
			String sql1 = "select * from week6_warehouse";
			PreparedStatement ps = con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id=rs.getInt(1);

			}
			con.close();

		}catch(Exception e) {
			System.out.println("Please try again.");
		}
		try {
			Connection con = ConnectionManager.getConnection();
			
			String sql ="insert into week6_billing(b_id,u_name,p_id,p_type,no_of_boxes,no_of_days,t_amount)values(seq_billing.nextval,?,?,?,?,?,?)";
			
			PreparedStatement ps = con.prepareStatement(sql);
			
			ps.setString(1, wh.getU_name());
			ps.setInt(2, id);
			ps.setString(3, wh.getP_type());
			ps.setString(4, wh.getNo_of_boxes());
			ps.setString(5, wh.getNo_of_days());
			ps.setInt(6, (Integer.parseInt(wh.getNo_of_boxes())*(Integer.parseInt(wh.getNo_of_days()))*(50)));
			
			ps.executeUpdate();
			
			con.close();
		}catch(Exception e) {
			System.out.println("Please try again.");
		}
	}
}

