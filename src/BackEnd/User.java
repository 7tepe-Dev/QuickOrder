import java.util.ArrayList;

enum userType{ADMIN,OWNER,CUSTOMER};

public abstract class User 
{
	private String userName;
	private String password;
	private userType usertype;
	private static ArrayList<User> allUsers=new ArrayList<User>();
	protected User(String userName,String password,userType usertype)
	{
		this.userName=userName;
		this.password=password;
		this.usertype=usertype;
	}
	public String getUserName() 
	{
		return userName;
	}
	public void setUserName(String userName) 
	{
		this.userName = userName;
	}
	public String getPassword() 
	{
		return password;
	}
	public void setPassword(String password) 
	{
		this.password = password;
	}
	public userType getUsertype() 
	{
		return usertype;
	}
	public void setUsertype(userType usertype) 
	{
		this.usertype = usertype;
	}
	public static void addNewUserToList(User user)
	{
		allUsers.add(user);
	}
	public static void removeUserFromList(User user)
	{
		for(int i=0;i<allUsers.size();i++)
		{
			if(user.userName.equalsIgnoreCase(allUsers.get(i).userName))
			{
				allUsers.remove(i);
			}
		}
	}
	public static void removeUserFromList(String userName)
	{
		for(int i=0;i<allUsers.size();i++)
		{
			if(userName.equals(allUsers.get(i).userName))
			{
				allUsers.remove(i);
			}
		}
	}
	public static ArrayList<User> getAllUsers()
	{
		return allUsers;
	}
	public String getUserTypeAsString()
	{
		return this.usertype.toString();
	}
}