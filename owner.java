public class owner extends user 
{
	Restaurant restaurant;
	double balance;
	public owner(String userName,String password,userType usertype
			,Restaurant restaurant,double balance)
	{
		this.userName=userName;
		this.password=password;
		this.usertype=usertype;
		this.restaurant=restaurant;
		this.balance=balance;
	}
}
