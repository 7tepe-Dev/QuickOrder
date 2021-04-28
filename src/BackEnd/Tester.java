package BackEnd;

import java.util.Scanner;

public class Tester 
{

	public static User currentUser;
	public static boolean LogIn(String userName,String password)
	{
		for(User user:User.getAllUsers())
		{
			if(user.userName.equals(userName) && user.password.equals(password))
			{
				currentUser=user;
				return false;
			}
		}
		return true;
	}
	public static void main(String[] args) 
	{
		//For creating default users
		Admin admin=Admin.createOrGetAdmin();
		Customer c1=new Customer("hakanGultekin","hakan2582",userType.CUSTOMER,250);
		Customer c2=new Customer("kaganOzetci","35kagan26",userType.CUSTOMER,1200);
		Customer c3=new Customer("mertSancar","1212mert",userType.CUSTOMER,670);
		Restaurant r1=new Restaurant();
		r1.setRestaurantName("Kardesler Steak");
		r1.addNewProduct(new Product("Steak",120));
		r1.addNewProduct(new Product("Salad",24));
		r1.addNewProduct(new Product("Coke",5));
		Restaurant r2=new Restaurant();
		r2.setRestaurantName("MC Donalds");
		r2.addNewProduct(new Product("Big Mac",20));
		r2.addNewProduct(new Product("Chicken Burger",15));
		r2.addNewProduct(new Product("Fanta",6));
		Restaurant r3=new Restaurant();
		r3.setRestaurantName("Fatma Home Cooking");
		r3.addNewProduct(new Product("Rive With Meat",25));
		r3.addNewProduct(new Product("Hot Soup",12));
		r3.addNewProduct(new Product("Fresh Buttermilk",5));
		Owner kardesler=new Owner("selami","selami2674",userType.OWNER,r1,12000);
		Owner mcDonalds=new Owner("stephan","stststephan02",userType.OWNER,r2,43500);
		Owner homeCooking=new Owner("Fatma","26fatma33",userType.OWNER,r3,5400);
		//end of default users
		//adding default users to allusers list
		User.addNewUserToList(admin);
		User.addNewUserToList(c1);
		User.addNewUserToList(c2);
		User.addNewUserToList(c3);
		User.addNewUserToList(kardesler);
		User.addNewUserToList(mcDonalds);
		User.addNewUserToList(homeCooking);
		//program starts here
		System.out.println("Welcome to the Restaurant Project.");
		System.out.println("Please enter your username and password");
		Scanner scan=new Scanner(System.in);
		boolean check=true;
		while(check)
		{
			System.out.println("Username:");
			String userName=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			System.out.println("Password:");
			String password=scan.next();
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			check=LogIn(userName,password);
		}
		if(currentUser.usertype==userType.ADMIN )
		{
			//show everything;
			System.out.println("All users:");
			for(User user:User.getAllUsers())
			{
				System.out.println(user.userName);
			}
			System.out.println("All restaurants:");
			for(Restaurant r:Restaurant.getAllRestaurants())
			{
				System.out.println(r.getRestaurantName());
			}
			
		}
		else if(currentUser.usertype==userType.CUSTOMER)
		{
			//show all restaurants
			System.out.println("All restaurants listed below:");
			for(Restaurant r:Restaurant.getAllRestaurants())
			{
				System.out.println(r.getRestaurantName());
			}
		}
		else if(currentUser.usertype==userType.OWNER)
		{
			//show only its restaurant
			System.out.println("Your restaurant:");
			Restaurant r=((Owner)currentUser).getRestaurant();
			System.out.println(r.getRestaurantName());
		}
		else
		{
			System.out.println("Something went wrong.");
		}
		/*User xd=UserFactory.createNewUser("Owner");
		if(xd.usertype==userType.OWNER)
		{
			((Owner)xd).getRestaurant().addNewProduct(new Product("suþi",152));
			((Owner)xd).getRestaurant().addNewProduct(new Product("japaneseThýng",338));
		}
		ArrayList<User> users=new ArrayList<User>();
		users.add(a);
		users.add(c);
		users.add(d);
		users.add(de);
		users.add(xd);
		a.addNewUserToList();
		c.addNewUserToList();
		try
		{
			User d=UserFactory.createNewUser("Owner");
			((Owner) d).getRestaurant();
			d.addNewUserToList();
		}
		catch(NullPointerException e)
		{
			System.out.println("boþ atmýþsýn abem napiyim.");
		}
		for(User user :User.getAllUsers())
		{
			if(user.usertype==userType.OWNER)
			{
				Owner owner=(Owner)user;
				System.out.println("Restoran ismi:"+owner.getRestaurant().getRestaurantName());
				//Adding products to restaurant
				for(Product p:owner.getRestaurant().getAllProducts())
				{
					System.out.println("Product name:"+p.getProductName());
				}
			}
			else if(user.usertype==userType.CUSTOMER)
			{
				System.out.println("hey customer.your name is:"+((Customer)user).userName);
			}
			if(user.usertype==userType.OWNER)
			{
				Owner owner=(Owner)user;
				System.out.println(owner.getRestaurant().getRestaurantName());
			}
			
		}*/
		scan.close();
	}
}