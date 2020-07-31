package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import dao.UserOperations;
import dao.WarehouseOperations;
import model.Storage;
import model.User;
import model.Warehouse;

public class AdminFunctions {
    public void admin() throws IOException {
		
		int choiceAdmin;
		do {
			System.out.println();
			System.out.println("*********************************************************************************");
			System.out.println("Dear Admin, you can perform the following tasks:");
			System.out.println();
			System.out.println("1. Add a User");
			System.out.println("2. Update User Details");
			System.out.println("3. Delete a User");
			System.out.println("4. Show all Users Details");
			System.out.println("5. Show Warehouse Orders Details");
			System.out.println("6. Show Warehouse Storage Details");
			System.out.println("7. Exit");
			System.out.println("*********************************************************************************");
			System.out.println("Enter your choice:");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choiceAdmin = Integer.parseInt(br.readLine());
			
			//variables
			String u_id,u_name,u_email,u_password;
			
			//objects
			User user = null;
			UserOperations user_op = new UserOperations();
			Warehouse wh = null;
			WarehouseOperations wh_op = new WarehouseOperations();
			
			switch (choiceAdmin) {
			case 1:
				//adding user details
				System.out.println();
				System.out.println("*********************************************************************************");
				System.out.println("Adding User Details");
				System.out.println("*********************************************************************************");
				System.out.println("Enter the user id: ");
				u_id = br.readLine();
				System.out.println("Enter the user name: ");
				u_name= br.readLine();
				System.out.println("Enter the user email: ");
				u_email = br.readLine();
				System.out.println("Enter the password: ");
				u_password = br.readLine();
				
				user = new User(u_id,u_name,u_email,u_password);
				
				try {
					user_op.addUser(user);
				}catch(Exception e) {
					System.out.println("Please try again.");
				}
				
				break;
			case 2:
				//updating user details
				System.out.println();
				System.out.println("*********************************************************************************");
				System.out.println("Updating User Details");
				System.out.println("*********************************************************************************");
				System.out.println("Enter the user id: ");
				u_id = br.readLine();
				System.out.println("Enter the user name: ");
				u_name= br.readLine();
				System.out.println("Enter the user email: ");
				u_email = br.readLine();
				System.out.println("Enter the password: ");
				u_password = br.readLine();
				
				user = new User(u_id,u_name,u_email,u_password);
				
				try {
					user_op.updateUser(user);
				}catch(Exception e) {
					System.out.println("Please try again.");
				}
				
				break;
			case 3:
				//deleting user details
				System.out.println();
				System.out.println("*********************************************************************************");
				System.out.println("Deleting User Details");
				System.out.println("*********************************************************************************");
				System.out.println("Enter the user id: ");
				u_id = br.readLine();
				
				try {
					user_op.deleteUser(u_id);
				}catch(Exception e) {
					System.out.println("Please try again.");
				}
				break;
			case 4:
				//displaying all user details
				System.out.println();
				System.out.println("*********************************************************************************");
				System.out.println("Showing all User Details");
				System.out.println("*********************************************************************************");
				System.out.println("USER ID        USER NAME       USER EMAIL ID ");
				System.out.println("*********************************************************************************");
				try {
					List<User> userdetails1 = new ArrayList<User>();
					user_op.displayUser();
					userdetails1 = user_op.displayUser();
					for(User u:userdetails1) {
						System.out.println("    "+u.getU_id()+"            "+u.getU_name()+"           "+u.getU_email());
						System.out.println();
					}
				}catch(Exception e) {
					System.out.println("Please try again.");
				}
				break;
			case 5:
				//displaying warehouse details
				System.out.println();
				System.out.println("*******************************************************************************************");
				System.out.println("Showing Warehouse Orders Details");
				System.out.println("*******************************************************************************************");
				System.out.println("PRODUCT ID        USER NAME       PRODUCT TYPE       NUMBER OF BOXES       NO OF DAYS");
				System.out.println("*******************************************************************************************");
				try {
					List<Warehouse> orderdetails1 = new ArrayList<Warehouse>();
					wh_op.displayWarehouse();
					orderdetails1 = wh_op.displayWarehouse();
					for(Warehouse w : orderdetails1) {
						System.out.println("     "+w.getP_id()+"               "+w.getU_name()+"            "+w.getP_type()+"                    "+w.getNo_of_boxes()+"                  "+w.getNo_of_days());
						System.out.println();
					}
				}catch(Exception e) {
					System.out.println("Please try again.");
				}
				break;
			case 6:
				//displaying storage details
				System.out.println();
				System.out.println("*********************************************************************************");
				System.out.println("Showing Warehouse Storage Details");
				System.out.println("*********************************************************************************");

				try {
					wh_op.displayStorage();					
				}catch(Exception e) {
					System.out.println("Please try again.");
				}
				break;
			case 7:
				System.out.println("------------------------------THANK YOU------------------------------------------");
				System.out.println();
				break;
			default:
				System.out.println("Wrong Choice");
				break;
			}
		
		}
		while(choiceAdmin !=7);
	}
    
}
