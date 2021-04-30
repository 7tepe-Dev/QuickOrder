import java.util.Scanner;

public class UserFactory 
{
	static Scanner scan=new Scanner(System.in);
	public static User createNewUser(String usertype)
	{
		User newUser=null;
		if(usertype.equals("Admin"))
		{
			newUser=(Admin) Admin.createOrGetAdmin();
		}
		else if(usertype.equals("Customer"))
		{
			System.out.println("Enter your username:");
			String username=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Enter your password:");
			String password=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Enter the balance:");
			double balance=scan.nextDouble();
			newUser=new Customer(username,password,userType.CUSTOMER,balance);
		}
		else if(usertype.equals("Owner"))
		{
			System.out.println("Enter your username:");
			String username=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Enter your password:");
			String password=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Enter the balance:");
			double balance=scan.nextDouble();
			newUser=new Owner(username,password,userType.OWNER,balance);
		}
		else
		{
			System.out.println("User is couldn't created");
		}
		/*if(newUser!=null)
		{
			User.addNewUserToList(newUser);
		}*/
		return newUser;
	}
}