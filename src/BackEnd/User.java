import java.util.ArrayList;

enum userType{ADMIN,OWNER,CUSTOMER};

public abstract class User 
{
	protected String userName;
	protected String password;
	protected userType usertype;
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public userType getUsertype() {
		return usertype;
	}
	public void setUsertype(userType usertype) {
		this.usertype = usertype;
	}
	private static ArrayList<User> allUsers=new ArrayList<User>();
	public static void addNewUserToList(User user)
	{
		allUsers.add(user);
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