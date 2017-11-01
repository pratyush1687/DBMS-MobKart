package priyanka;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class SearchPhone {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/temp","root","");
		//	Statement stmt = con.createStatement();
			Scanner scn = new Scanner(System.in);
			System.out.println("Select the field by which you want to search :");
			System.out.println("1->name        2->price");
			System.out.println("3 -> New Phones");
			System.out.println("4 -> Top Selling");
			System.out.println("5 -> by Price");
			System.out.println("6 -> by Brand");
			System.out.println("7 -> Best Rated Phones");
			int field = scn.nextInt();
			String model;
			ResultSet rs = null;
			int x;
			switch(field)
			{
			case 1 : System.out.println("Enter the name of the phone :");
					 String pname = scn.next();
					 PreparedStatement stmt=con.prepareStatement("select name from Mobile where name like ?");
					 stmt.setString(1, "%" + pname + "%");
					 rs=stmt.executeQuery();  
					 int i=1;
					 while(rs.next())
					 {
						 System.out.println(i + " " + rs.getString("name"));
						 i++;
					 }
					 if(i==1)
						 System.out.println("no results found !");
					 else
					 {
						 System.out.println("Enter the index no to view complete details :");
						 x = scn.nextInt();
						 rs.absolute(x);
						 
					 }
					 break;
					 
			case 2: System.out.println("Enter the price range :");
					float pricel = scn.nextFloat();
					float priceh = scn.nextFloat();
					PreparedStatement stmt1 = con.prepareStatement("select name,price from Mobile where price between ? AND ?");
					stmt1.setFloat(1, pricel);
					stmt1.setFloat(2, priceh);
				    rs=stmt1.executeQuery(); 
					int j=1;
					while(rs.next())
					{
						System.out.println(j + " " + rs.getString("name") + " " + rs.getFloat("price"));
						j++;
					}
					if(j==1)
						System.out.println("no results found !");
					else
					{
						System.out.println("Enter the index no to view complete details :");
						 x = scn.nextInt();
						 rs.absolute(x);
					}
					break;
					
			case 3: String sqlQuery1 = "SELECT * FROM Mobile  ORDER BY dateoflaunch DESC";
					Statement stmt21 = con.createStatement();
				    rs = stmt21.executeQuery(sqlQuery1);
				    j=1;
				    while(rs.next() && j<=10)
				    {
				    	System.out.println(j + " " + rs.getString("name") + " " + rs.getFloat("price"));
						j++;
				    }
				    System.out.println("Enter the index to view complete details :");
				    x = scn.nextInt();
				    rs.absolute(x);
					
			case 4: String sqlQuery = "SELECT * FROM Mobile  ORDER BY quantitysold DESC";
					Statement stmt2 = con.createStatement();
				    rs = stmt2.executeQuery(sqlQuery);
				    j=1;
				    while(rs.next() && j<=10)
				    {
				    	System.out.println(j + " " + rs.getString("name") + " " + rs.getFloat("price"));
						j++;
				    }
				    System.out.println("Enter the index to view complete details :");
				    x = scn.nextInt();
				    rs.absolute(x);
				    
				    //PRINT DETAILS RS.GETSBLAH.BLAH.BLAH
				    
			case 5: System.out.println("Enter the price range :");
					float pricell = scn.nextFloat();
					float pricehh = scn.nextFloat();
					PreparedStatement stmt11 = con.prepareStatement("select name,price from Mobile where price between ? AND ?");
					stmt11.setFloat(1, pricell);
					stmt11.setFloat(2, pricehh);
				    rs=stmt11.executeQuery(); 
					int p=1;
					while(rs.next())
					{
						System.out.println(p + " " + rs.getString(1) + " " + rs.getFloat(2));
						p++;
					}
					if(p==1)
						System.out.println("no results found !");
					else
					{
						System.out.println("Enter the index no to view complete details :");
						 x = scn.nextInt();
						 rs.absolute(x);
					}
					break;
			
				    
			case 6:  System.out.println("Enter the brand of the phone :");
					 String name = scn.next();
					 PreparedStatement stmt0=con.prepareStatement("select brand from Mobile where name like ?");
					 stmt0.setString(1, "%" + name + "%");
					 rs=stmt0.executeQuery();  
					 int k=1;
					 while(rs.next())
					 {
						 System.out.println(k + " " + rs.getString(1));
						 k++;
					 }
					 if(k==1)
						 System.out.println("no results found !");
					 else
					 {
						 System.out.println("Enter the index no to view complete details :");
						 x = scn.nextInt();
						 rs.absolute(x);
						 
					 }
					 break;
				    
			case 7:  sqlQuery = "SELECT * FROM Mobile  ORDER BY rating DESC";
				     stmt2 = con.createStatement();
					 rs = stmt2.executeQuery(sqlQuery);
					 j=1;
					 while(rs.next() && j<=10)
					 {
						System.out.println(j + " " + rs.getString(1) + " " + rs.getFloat(2));
						j++;
					 }
					 System.out.println("Enter the index to view complete details :");
				     x = scn.nextInt();
					 rs.absolute(x);
					 
					 //PRINT DETAILS
		    default:
		    	System.out.println("enter valid choice !");
		    
					
				
			}
			scn.close();
			
			System.out.println("COMPLETE DETAILS ARE :");
			//System.out.println("name" + rs.getString("name"));
			
			System.out.println("Mobile Name: "+rs.getString("name"));
			System.out.println("Model name: "+rs.getString("modelname"));
			System.out.println("Brand: "+rs.getString("brand"));
			System.out.println("Front Camera: "+rs.getString("frontCamera"));
			
			System.out.println("Rear Camera: "+rs.getString("rearCamera"));
			
			System.out.println("Price: "+rs.getString("price"));
			
			System.out.println("Memory RAM : "+rs.getString("memoryRam"));
			
			System.out.println("Main Memory: "+rs.getString("mainMemory"));
			
			System.out.println("OS Name: "+rs.getString("osName"));
			
			
			
			String s=rs.getString("batteryId");
			 PreparedStatement stmt1=con.prepareStatement("select batteryDuration,batteryCapacity,batteryType from battery where batteryId=?");
			 stmt1.setString(1,s);
			 ResultSet rstemp=stmt1.executeQuery();  
			 rstemp.next();
			System.out.println("Battery duration: "+rstemp.getString("batteryDuration"));
			
			System.out.println("Battery capacity: "+rstemp.getString("batteryCapacity"));
			
			System.out.println("Battery type: "+rstemp.getString("batteryType"));
			String s2=rs.getString("processorId");
			 PreparedStatement stmt2=con.prepareStatement("select processorCompany,processorName,processorNo from processor where processorId=?");
			 stmt2.setString(1,s2);
			 ResultSet rstemp2=stmt2.executeQuery(); 
			rstemp2.next();
			System.out.println("Processor company: "+rstemp2.getString("processorCompany"));
			
			System.out.println("Processor name: "+rstemp2.getString("processorName"));
			
			System.out.println("Processor Number: "+rstemp2.getString("processorNo"));
		}
		catch(Exception e){System.out.println(e);}
	}

}
