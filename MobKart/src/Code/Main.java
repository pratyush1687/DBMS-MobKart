package Code;

import java.util.*;
import java.sql.*;

public class Main {

	public static void main(String[] args) {
		Scanner scn= new Scanner(System.in);
		int md1;
		System.out.println("Welcome to MOBKART");
		System.out.println("1. Login");
		System.out.println("2. SignUp");
		System.out.println("3.Skip");
		md1= scn.nextInt();	
		int check=1;
		
		switch (md1) {
		case 1:
			User user1=new User();
			check=user1.login();
			
			break;

		case 2:
			User user2=new User();
			user2.SignUp();
			System.out.println("you have been signed up!");
		
			break;
			
		case 3:
		
			break;
		
		
		}
		if(check==1)
		{
		System.out.println("Main Menu");	
		System.out.println("1. Search Phone");
		System.out.println("2. Compare Phone");
		System.out.println("3. Advanced Search");
		System.out.println("4. View Cart");
		int md2;
		md2=scn.nextInt();
		FirstMenu ff= new FirstMenu();
		switch (md2) {
		
		case 1:
			ff.searchPhone();
			break;
		
		case 2:
			ff.comparePhone();
			break;
			
		case 3:
			ff.advanceSearch();
			break;
			
		case 4:
			ff.viewCart();
			break;
			
		
		
		}
		
		
		
		
		
		}
		
		
	}

}
