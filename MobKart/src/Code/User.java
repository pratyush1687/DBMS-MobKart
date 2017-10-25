package Code;
import java.sql.*;
import java.util.*;


public class User {

	int login()
	{int check=0;
		try {
			
			Scanner scn=new Scanner(System.in);
			String username = null;
			System.out.println("enter username ");
			username=scn.nextLine();
			
			String password;
			System.out.println("enter password ");
			password=scn.nextLine();
			
			//1. get a connection
			Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobkart?useSSL=false", "root", "");
			PreparedStatement stmt= myConn.prepareStatement("select * from user where username=? and password=?");
			stmt.setString(1,username);
			stmt.setString(2,password);
			ResultSet rs=stmt.executeQuery();
			if(rs.first()==false)
				{System.out.println("wrong username or password");
				check=0;
				}
			else
				{System.out.println("successfully logged in");
				System.out.println();
				check=1;
				}
			
			
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
		
		return check;
		
		
	}
	void SignUp()
	{
		try {
			Scanner scn=new Scanner(System.in);
			String username;
			System.out.println("enter username (lenght should be 10)");
			username=scn.nextLine();
			
			String firstName;
			System.out.println("enter firstName");
			firstName=scn.nextLine();
			
			String middleName;
			System.out.println("enter middleName");
			middleName=scn.nextLine();
			
			String lastName;
			System.out.println("enter lastName");
			lastName=scn.nextLine();
			
			String emailId;
			System.out.println("enter emailId");
			emailId=scn.nextLine();
			
			String password;
			System.out.println("enter password");
			password=scn.nextLine();
			
			String phoneNo;
			System.out.println("enter contact details");
			phoneNo=scn.nextLine();
			
			
		//1. get a connection
		Connection myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mobkart?useSSL=false", "root", "");
		
		
		
		PreparedStatement  myStmt = myConn.prepareStatement("insert into user(username,password,firstName,middleName,lastNmae,emailId) values(?,?,?,?,?,?)");
		myStmt.setString(1, username);
		myStmt.setString(2, password);
		myStmt.setString(3, firstName);
		myStmt.setString(4, middleName);
		myStmt.setString(5, lastName);
		myStmt.setString(6, emailId);
		myStmt.executeUpdate();
		
		PreparedStatement mystmt2= myConn.prepareStatement("insert into phoneno(username,phoneNo) values(?,?)");
		mystmt2.setString(1, username);
		mystmt2.setString(2, phoneNo);
		mystmt2.executeUpdate();
		
		}
		catch(Exception exc){
			exc.printStackTrace();
		}
		
	}
}
