package controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dao.ConvertToPdf;
import dao.UserOperations;
import dao.WarehouseOperations;
import model.Warehouse;
import utility.ConnectionManager;

public class UserFunctions {
	public void user() throws Exception {
		int choiceUser;
		
		System.out.println();
		System.out.println("*********************************************************************************");
		System.out.println();
		System.out.println("            Dear User, we charge Rs 50 for each box for 1 Day");
		System.out.println();
		System.out.println("*********************************************************************************");
		
		do {
			System.out.println();
			System.out.println("Dear User, you can perform the following tasks:");
			System.out.println();
			System.out.println("1. Display Your Stored Boxes");
			System.out.println("2. Add Boxes To Warehouse");
			System.out.println("3. Remove Boxes From Warehouse");
			System.out.println("4. Exit");
			System.out.println("*********************************************************************************");
			System.out.println("Enter your choice:");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			choiceUser = Integer.parseInt(br.readLine());
			
			String p_id,u_name,p_type,no_of_boxes,no_of_days;
			
			Warehouse wh = null;
			WarehouseOperations wh_op = new WarehouseOperations();
			ConvertToPdf pdf = new ConvertToPdf();
			
			switch (choiceUser) {
			case 1:
				//displaying storage details
				System.out.println("Enter user name: ");
				u_name = br.readLine();
				System.out.println();
				System.out.println("*******************************************************************************************");
				System.out.println("Showing Your Boxes In Warehouse");
				System.out.println("*******************************************************************************************");
				System.out.println("PRODUCT ID        USER NAME       PRODUCT TYPE       NUMBER OF BOXES       NO OF DAYS");
				System.out.println("*******************************************************************************************");
				try {
					List<Warehouse> userdetails1 = new ArrayList<Warehouse>();
					wh_op.displaySelectedStorage(u_name);
					userdetails1 = wh_op.displaySelectedStorage(u_name);
					for(Warehouse w : userdetails1) {
						System.out.println("     "+w.getP_id()+"               "+w.getU_name()+"            "+w.getP_type()+"                    "+w.getNo_of_boxes()+"                  "+w.getNo_of_days());
						System.out.println();
					}
				}catch(Exception e) {
					System.out.println("Please try again.");
				}
				break;
			case 2:
				//adding boxes to storage
				System.out.println();
				System.out.println("*********************************************************************************");
				System.out.println("Adding Boxes To Warehouse");
				System.out.println("*********************************************************************************");
				System.out.println("Enter user name: ");
				u_name = br.readLine();
				System.out.println("Enter product type: ");
				p_type = br.readLine();
				System.out.println("Enter number of boxes: ");
				no_of_boxes = br.readLine();
				System.out.println("Enter number of days: ");
				no_of_days = br.readLine();
				
				wh = new Warehouse(u_name, p_type, no_of_boxes, no_of_days);
				String box = wh.getNo_of_boxes(); 
				
				try {
					if(wh_op.checkFreeSpace(box)) {
					wh_op.addToWarehouse(wh);
					wh_op.addBoxesToCount(box);
					Thread.sleep(1500);
					wh_op.addToBill(wh);
					pdf.generateBill();
					}
					else
						System.out.println("Sorry user, There is no space available for your boxes.");
					System.out.println();
				}catch(Exception e) {
					System.out.println("Please try again.");
				}
				break;
				
			case 3:
				//removing boxes from storage
				System.out.println();
				System.out.println("*********************************************************************************");
				System.out.println("Removing Boxes From Warehouse");
				System.out.println("*********************************************************************************");
				System.out.println("Enter product id: ");
				p_id = br.readLine();
				
				try {
					wh_op.removeBoxesFromCount(p_id);
					wh_op.removeFromWarehouse(p_id);
					
				}catch(Exception e) {
					System.out.println("Please try again.");
				}
				break;
			case 4:
				System.out.println("---------------------------------THANK YOU---------------------------------------");
				System.out.println();
				
				break;
			default:
				System.out.println("Wrong Choice");
				break;
				
			}
		
		}while(choiceUser !=4);
	}
}
