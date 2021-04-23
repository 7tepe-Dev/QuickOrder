import java.util.ArrayList;

enum userType{ADMIN,OWNER,CUSTOMER};

public abstract class User 
{
	protected String userName;
	protected String password;
	protected userType usertype;
	private static ArrayList<User> allUsers=new ArrayList<User>();
	public void addNewUserToList()
	{
		allUsers.add(this);
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