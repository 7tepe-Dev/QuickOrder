package backend;

public class Admin extends User
{
	private static Admin admin;
	private Admin()
	{
		super("admin","admin1234",UserType.ADMIN);
	}
	public static Admin createOrGetAdmin()
	{
		if(admin==null)
		{
			admin=new Admin();
		}
		return admin;
	}
	protected void removeUser(User user)
	{
		user=null;
	}
}