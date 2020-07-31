package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.Admin;
import model.User;
import utility.Validation;

public class Main {
	
	public static void main(String[] args) throws Exception {
		System.out.println("*********************************************************************************");
		System.out.println("                         WELCOME TO STORAGE MANAGER");
		System.out.println("*********************************************************************************");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		//variables
		String a_email,a_password;
		String u_email,u_password;
		
		//objects
		Validation val = new Validation();
		AdminFunctions admin_func = new AdminFunctions();
		UserFunctions user_func = new UserFunctions();
		
		
		while(true) {
			System.out.println("1. ADMIN");
			System.out.println("2. USER");
			System.out.println("3. EXIT");
			System.out.println("Enter your choice:");
			
			int choice = Integer.parseInt(br.readLine()); 
			
			switch(choice) {
			case 1:
				System.out.println("*********************************************************************************");
				System.out.println("Enter email: ");
				a_email = br.readLine();
				System.out.println("Enter password: ");
				a_password = br.readLine();
				
				Admin admin = new Admin(a_email,a_password);
				
				if(val.adminValidation(admin)) {
					System.out.println("Admin log-in successful");
					admin_func.admin();
					System.out.println("*********************************************************************************");
				}
				else {
					System.out.println("Admin log-in failed. Please check the email and password ");
					System.out.println("*********************************************************************************");
				}
				
				//admin_func.admin();
				
				break;
				
			case 2:
				System.out.println("*********************************************************************************");
				System.out.println("Enter email: ");
				u_email = br.readLine();
				System.out.println("Enter password: ");
				u_password = br.readLine();
				
				User user = new User(u_email,u_password);
				
				if(val.userValidation(user)) {
					System.out.println("User log-in successful");
					user_func.user();
					System.out.println("*********************************************************************************");
				}
				else {
					System.out.println("User log-in failed. Please check the email and password ");
					System.out.println("*********************************************************************************");
				}
				
				//user_func.user();
				
				break;
			case 3:
				System.out.println("								THANK YOU!");
				System.out.println("*********************************************************************************");
				break;
			default :
				System.out.println("Please enter a valid choice");
				System.out.println("*********************************************************************************");
			}
		
			
		}
	}

}//end of Main
