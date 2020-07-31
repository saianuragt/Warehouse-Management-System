package dao;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.itextpdf.text.Document;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

import utility.ConnectionManager;

public class ConvertToPdf {

	public void generateBill() throws Exception {
		int id = 0;
		try {
			Connection con = ConnectionManager.getConnection();
			String sql1 = "SELECT MAX(b_id) FROM week6_billing";
			PreparedStatement ps = con.prepareStatement(sql1);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				id=rs.getInt(1);

			}
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		
		Connection con = ConnectionManager.getConnection();
		
		PreparedStatement ps = con.prepareStatement("select * from week6_billing where b_id = ?");
		ps.setInt(1, id);
		ResultSet rs = ps.executeQuery();
		
		
		Document bill = new Document();
		PdfWriter.getInstance(bill, new FileOutputStream("bill.pdf"));
		bill.open();
		
		Paragraph p1 = new Paragraph("____________________________________________________________________________\n\n");
		p1.setAlignment(Paragraph.ALIGN_CENTER);
		bill.add(p1);
		
		
		Paragraph p2 = new Paragraph("SMART STORAGE MANAGER\n");
		p2.setAlignment(Paragraph.ALIGN_CENTER);
		bill.add(p2);
		
		Paragraph p3 = new Paragraph("____________________________________________________________________________\n\n");
		p3.setAlignment(Paragraph.ALIGN_CENTER);
		bill.add(p3);
		
		while(rs.next()) {
			String b_id = rs.getString(1);
			Paragraph p4 = new Paragraph("Bill Number"+"		: "+b_id+"\n");
			bill.add(p4);
			
			String u_name = rs.getString(2);
			Paragraph p5 = new Paragraph("Customer Name"+"		: "+u_name+"\n");
			bill.add(p5);
			
			String p_id = rs.getString(3);
			Paragraph p6 = new Paragraph("Product Id		: "+p_id+"\n");
			bill.add(p6);
			
			String p_type = rs.getString(4);
			Paragraph p7 = new Paragraph("Product Type		: "+p_type+"\n");
			bill.add(p7);
			
			String box = rs.getNString(5);
			Paragraph p8 = new Paragraph("Number of Boxes	: "+box+"\n");
			bill.add(p8);
			
			String days = rs.getNString(6);
			Paragraph p9 = new Paragraph("Number of Days	: "+days+"\n");
			bill.add(p9);
			
			String amt = rs.getNString(7);
			Paragraph p10 = new Paragraph("Total Amount		: Rs "+amt+"\n");
			bill.add(p10);
		}
		
		Paragraph p11 = new Paragraph("____________________________________________________________________________\n");
		p11.setAlignment(Paragraph.ALIGN_CENTER);
		bill.add(p11);
		
		Paragraph p12 = new Paragraph("THANK YOU");
		p12.setAlignment(Paragraph.ALIGN_CENTER);
		bill.add(p12);
		
		bill.close();
		
		System.out.println("Bill generated successfully");
		
		
	}

}
