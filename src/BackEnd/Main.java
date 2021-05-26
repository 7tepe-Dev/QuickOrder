package BackEnd;

import Database.DataHandler;

public class Main 
{
	public static User currentUser=null;
	public static void main(String[] args) 
	{
		DataHandler.ReadDatasFromJSON();
		//tabi alttaki satirdan once currentuser in bir yerde
		//atamasinin yapilmasi gerek yani login islemi burada olmali
		/*if(currentUser.getUsertype().equals(userType.ADMIN))
		{
			//show admin panel
			System.out.println("ben adminim");
		}
		else if(currentUser.getUsertype().equals(userType.CUSTOMER))
		{
			//show customer panel
			System.out.println("ben customerim.");
		}
		else if(currentUser.getUsertype().equals(userType.OWNER))
		{
			//show owner panel
			System.out.println("ben ownerim");
		}
		else
		{
			
		}*/
		for(User u:User.getAllUsers())
		{
			System.out.println(u.getUserTypeAsString());
			if(u.getUserName().equals("admin"))
			{
				currentUser=u;
			}
		}
		System.out.println(currentUser.getUserTypeAsString());
	}
}