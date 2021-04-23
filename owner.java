public class Owner extends User 
{
	private Restaurant restaurant;
	private double balance;
	public Owner(String userName,String password,userType usertype,
			Restaurant restaurant,double balance)
	{
		this.userName=userName;
		this.password=password;
		this.usertype=usertype;
		this.restaurant=restaurant;
		this.balance=balance;
	}
	
	public Restaurant getRestaurant() 
	{
		return restaurant;
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