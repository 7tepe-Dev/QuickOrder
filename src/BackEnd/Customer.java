public class Customer extends User 
{
	private String location;
	private double balance;
	//Constructor for new added Customers
	public Customer(String userName,String password,
			userType usertype,double balance)
	{
		this.userName=userName;
		this.password=password;
		this.usertype=usertype;
		this.balance=balance;
	}
	//Constructor for default Customers
	public Customer(String userName,String password,
			userType usertype,double balance,String location)
	{
		this.userName=userName;
		this.password=password;
		this.usertype=usertype;
		this.balance=balance;
		this.location=location;
	}
	public String getLocation() 
	{
		return location;
	}
	public void setLocation(String location) 
	{
		this.location = location;
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