package Test;

import java.util.Scanner;

import BackEnd.*;
import BackEnd.User.userType;

public class Tester 
{
	public static User currentUser;
	public static Scanner scan=new Scanner(System.in);
	public static boolean LogIn(String userName,String password)
	{
		for(User user:User.getAllUsers())
		{
			if(user.getUserName().equals(userName) && user.getPassword().equals(password))
			{
				currentUser=user;
				return true;
			}
		}
		System.out.println("Username or password is wrong.");
		System.out.println("Please try again.");
		return false;
	}
	/*public static void main(String[] args) 
	{
		//For creating default users
		Admin admin=Admin.createOrGetAdmin();
		Customer c1=new Customer("hakanGultekin","hakan2582",userType.CUSTOMER,250,"karatay/konya");
		Customer c2=new Customer("kaganOzetci","35kagan26",userType.CUSTOMER,1200,"ataþehir/istanbul");
		Customer c3=new Customer("mertSancar","1212mert",userType.CUSTOMER,670,"kýzýlay/ankara");
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
		//If client wants to add new customer or owner
		System.out.println("Welcome to the Restaurant Project.");
		System.out.println("Do you want to log in or sign up."
				+ "(Enter login or signup)");
		String choice=scan.nextLine();
		while(!(choice.equalsIgnoreCase("login") || choice.equalsIgnoreCase("signup")))
		{
			System.out.println("Please enter login or signup.Nothing else!");
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			choice=scan.nextLine();
			//scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
		}
		if(choice.equalsIgnoreCase("login"))//giriþ yap
		{
			System.out.println("You will login to an already exist account");
			System.out.println("Please enter your username and password");
			boolean check=false;
			while(!check)
			{
				System.out.println("Username:");
				scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				String userName=scan.nextLine();
				//we need to check user name if there is white space
				System.out.println("Password:");
				scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				String password=scan.nextLine();
				//we need to check password as well if there is white space
				//for now we dont check for white spaces
				check=LogIn(userName,password);
			}
			AfterLogin();
		}
		else if(choice.equalsIgnoreCase("signup"))//kaydol
		{
			System.out.println("Enter user type:");
			System.out.println("Owner/Customer");
			scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
			String type=scan.nextLine();
			while(!(type.equals("Owner")||type.equals("Customer")))
			{
				System.out.println("You entered:"+type);
				System.out.println("But we wanted:"+" Owner"+" Customer");
				System.out.println("Please enter again:");
				scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				type=scan.nextLine();
			}
			User newUser=UserFactory.createNewUser(type);
			if(newUser!=null)
			{
				User.addNewUserToList(newUser);
				System.out.println("Account created successfully");
			}
			boolean check=LogIn(newUser.userName,newUser.password);
			if(check)
			{
				AfterLogin();
			}
		}
		else
		{
			System.out.println("a problem has occurred");
		}
		scan.close();
	}*/
	private static void AfterLogin() 
	{
		System.out.println("Hello "+currentUser.getUserName());
		if(currentUser.getUsertype()==userType.ADMIN )
		{
			//show everything;
			System.out.println("All users:");
			for(User user:User.getAllUsers())
			{
				System.out.println(user.getUserName());
			}
			System.out.println("All restaurants:");
			for(Restaurant r:Restaurant.getAllRestaurants())
			{
				System.out.println(r.getRestaurantName());
			}
		}
		else if(currentUser.getUsertype()==userType.CUSTOMER)
		{
			Customer currentCustomer=((Customer)currentUser);
			//show all restaurants
			System.out.println("Mr."+currentCustomer.getUserName()+"'s balance:"+currentCustomer.getBalance());
			System.out.println("All restaurants listed below:");
			for(Restaurant r:Restaurant.getAllRestaurants())
			{
				System.out.println(r.getRestaurantName());
			}
		}
		else if(currentUser.getUsertype()==userType.OWNER)
		{
			//show only its restaurant
			Owner currentOwner=((Owner)currentUser);
			if(currentOwner.getRestaurant()==null)
			{
				System.out.println("You need to define your restaurant.");
				//Restaurant temp=new Restaurant();
				System.out.println("Enter your restaurant's name:");
				scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				String rname=scan.nextLine();
				
				//temp.setRestaurantName(rname);
				//currentOwner.setRestaurant(temp);
			}
			System.out.println("Your restaurant:");
			Restaurant r=currentOwner.getRestaurant();
			System.out.println(r.getRestaurantName());
			System.out.println("And your restaurant's all products:");
			if(r.getAllProducts()==null)
			{
				System.out.println("You have no product.");
				System.out.println("If you want to display it.");
				System.out.println("First you should add it");
				System.out.println("Do you want to add product?(yes/no)");
				scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
				String p_answer=scan.next();
				while(p_answer.equals("yes"))
				{
					System.out.println("Please enter your product's name:");
					scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
					String pro_name=scan.nextLine();
					System.out.println("Please enter your product's price:");
					scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
					double pro_price=scan.nextDouble();
					Product product=new Product(pro_name,pro_price);
					r.addNewProduct(product);
					System.out.println("Do you want to add another one?(yes/no)");
					scan.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
					p_answer=scan.next();
				}
				System.out.println("Products added.");
			}
			if(r.getAllProducts()!=null)
			{
				for(Product product:r.getAllProducts())
				{
					if(product!=null)
					{
						System.out.println("name:"+product.getProductName()
						+" price:"+product.getProductPrice());
					}
				}
			}
		}
	}
}