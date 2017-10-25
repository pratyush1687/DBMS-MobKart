package Code;
import java.sql.*;
import java.util.*;

public class FirstMenu {
	void searchPhone()
	{
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobkart?useSSL=false", "root", "");
			
			Scanner scn = new Scanner(System.in);
			
					 System.out.println("Enter the name of the phone :");
					 String pname = scn.next();
					 PreparedStatement stmt=myConn.prepareStatement("select mobileName from mobilePhone where mobilename like ?");
					 stmt.setString(1, "%" + pname + "%");
					 ResultSet rs=stmt.executeQuery();  
					 int i=1;
					 while(rs.next())
					 {
						 System.out.println(i + " " + rs.getString(1));
						 i++;
					 }
					 if(i==1)
						 System.out.println("no results found !");
					 
					 
			
					
		 // default:
		   // 	System.out.println("enter valid choice !");
					
				
			
			scn.close();	
			
		}
catch(Exception exc){
	exc.printStackTrace();
	}
	}
	
	void comparePhone()
	{
		try {
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobkart?useSSL=false", "root", "");
			
			Scanner scn = new Scanner(System.in);
			
					 System.out.println("Enter the name of the first phone :");
					 String pname1 = scn.next();
					 System.out.println("Enter the name of the second phone :");
					 String pname2 = scn.next();
					 PreparedStatement stmt1=myConn.prepareStatement("select mobileName from mobilePhone where mobilename like ?");
					 stmt1.setString(1, "%" + pname1 + "%");
					 ResultSet rs1=stmt1.executeQuery();  
					 
					 PreparedStatement stmt2=myConn.prepareStatement("select mobileName from mobilePhone where mobilename like ?");
					 stmt2.setString(1, "%" + pname2 + "%");
					 ResultSet rs2=stmt2.executeQuery();  
					 
					 
					 if(rs1.first()==false)
						 System.out.println("first phone not found");
					 if(rs2.first()==false)
						 System.out.println("second phone not found");
					 if(rs1.first()==true&&rs2.first()==false)
					 { int i=1;
					 while(rs1.next())
					 {
						 System.out.println(i + " " + rs1.getString(1));
						 i++;
					 }
					 while(rs2.next())
					 {
						 System.out.println(i + " " + rs2.getString(1));
						 i++;
					 }
					
					 
					 }
			
					
		 // default:
		   // 	System.out.println("enter valid choice !");
					
				
			
			scn.close();	
			
		}
catch(Exception exc){
	exc.printStackTrace();
	}
	}
	
	void advanceSearch()
	{
		try {
		Scanner scn = new Scanner(System.in);
	
		 System.out.println("Enter the price range :");
			float pricel = scn.nextFloat();
			float priceh = scn.nextFloat();
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobkart?useSSL=false", "root", "");
			PreparedStatement stmt1 = myConn.prepareStatement("select mobileName,price from Mobilephone where price between ? AND ?");
			stmt1.setFloat(1, pricel);
			stmt1.setFloat(2, priceh);
			ResultSet rs1=stmt1.executeQuery(); 
			int j=1;
			while(rs1.next())
			{
				System.out.println(j + " " + rs1.getString(1) + " " + rs1.getFloat(2));
				j++;
			}
			if(j==1)
				System.out.println("no results found !");
		scn.close();	
		}
		catch(Exception exc){
			exc.printStackTrace();
			}
	}
	
	public void viewCart() {
		// TODO Auto-generated method stub
		
	}
	

}
