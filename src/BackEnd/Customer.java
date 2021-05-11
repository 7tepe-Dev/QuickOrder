package backend;

public class Customer extends User 
{
	private String location;
	private double balance;
	//Constructor for new added Customers
	public Customer(String userName,String password,
			UserType usertype)
	{
		super(userName, password, usertype);
	}
	//Constructor for default Customers
	public Customer(String userName,String password,
			UserType usertype,double balance,String location)
	{
		super(userName, password, usertype);
		this.balance=balance;
		this.location=location;
	}
	//temporary constructor
	public Customer(String userName,String password,
			UserType usertype,double balance)
	{
		super(userName, password, usertype);
		this.balance=balance;
		/*this.userName=userName;
		this.password=password;
		this.usertype=usertype;
		this.balance=balance;*/
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