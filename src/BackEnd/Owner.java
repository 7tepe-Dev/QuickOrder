package backend;

public class Owner extends User 
{
	private Restaurant restaurant;
	private double balance;
	//Constructor for added new Owners
	public Owner(String userName,String password,UserType usertype)
	{
		super(userName, password, usertype);
	}
	//Constructor for default
	public Owner(String userName,String password,UserType usertype,
			Restaurant restaurant,double balance)
	{
		super(userName, password, usertype);
		this.restaurant=restaurant;
		this.balance=balance;
	}
	public Restaurant getRestaurant() 
	{
		return this.restaurant;
	}
	public void setRestaurant(Restaurant restaurant) 
	{
		this.restaurant = restaurant;
	}
	public double getBalance() 
	{
		return balance;
	}
	public void setBalance(double balance) 
	{
		this.balance = balance;
	}
}