public class Customer extends User 
{
	private String location;
	private double balance;
	
	public Customer(String userName,String password,
			userType usertype,double balance)
	{
		this.userName=userName;
		this.password=password;
		this.usertype=usertype;
		this.balance=balance;
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