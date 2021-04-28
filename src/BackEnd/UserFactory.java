package BackEnd;

import java.util.Scanner;

public class UserFactory 
{
	static Scanner scan=new Scanner(System.in);
	public static User createNewUser(String usertype)
	{
		User newUser=null;
		if(usertype=="Admin")
		{
			newUser=(Admin) Admin.createOrGetAdmin();
		}
		else if(usertype=="Customer")
		{
			System.out.println("Enter your username:");
			String username=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Enter your password:");
			String password=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Enter the balance:");
			double balance=scan.nextDouble();
			newUser=(Customer) new Customer(username,password,userType.CUSTOMER,balance);
		}
		else if(usertype=="Owner")
		{
			System.out.println("Enter your username:");
			String username=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Enter your password:");
			String password=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Enter the balance:");
			double balance=scan.nextDouble();
			Restaurant restaurant=new Restaurant();
			newUser=new Owner(username,password,userType.OWNER,restaurant,balance);
			//((Owner)newUser).getRestaurant().getAllProducts();
		}
		else
		{
			System.out.println("User is couldn't created");
		}
		if(newUser!=null)
		{
			User.addNewUserToList(newUser);
		}
		return newUser;
	}
}