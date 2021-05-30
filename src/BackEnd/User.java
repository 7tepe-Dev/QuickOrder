package backend;

import java.util.ArrayList;

public abstract class User 
{
	//public enum userType{ADMIN,OWNER,CUSTOMER};
	private String userName;
	private String password;
	private UserType usertype;
	private static ArrayList<User> allUsers=new ArrayList<User>();
	protected User(String userName,String password,UserType usertype)
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
	public UserType getUsertype() 
	{
		return this.usertype;
	}
	public void setUsertype(UserType usertype) 
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