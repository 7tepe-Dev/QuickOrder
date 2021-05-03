public class Admin extends User
{
	static Admin admin;
	private Admin()
	{
		this.userName="admin";
		this.password="admin1234";
		this.usertype=userType.ADMIN;
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