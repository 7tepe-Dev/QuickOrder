package backend;
import javax.swing.JOptionPane;

public class UserFactory 
{
	public static boolean createNewUser(String username,String password,String usertype)
	{
		boolean returnThis=false;
		if(canICreate(username,password,usertype))
		{
			User newUser=null;
			if(usertype.equals("Admin"))
			{
				newUser=(Admin) Admin.createOrGetAdmin();
			}
			else if(usertype.equals("Customer"))
			{
				newUser=new Customer(username,password,UserType.CUSTOMER);
			}
			else if(usertype.equals("Owner"))
			{
				newUser=new Owner(username,password,UserType.OWNER);
			}
			else
			{
				JOptionPane.showMessageDialog(null, "An error occured");
			}
			returnThis=true;
			User.setCurentUser(newUser);
			User.getAllUsers().add(newUser);
		}
		return returnThis;
	}
	private static boolean canICreate(String username,String password,String usertype)
	{
		if(username==null || password==null || usertype==null|| username.isEmpty() || password.isEmpty() || usertype.isEmpty())
		{
			JOptionPane.showMessageDialog(null, "You have to input everything that you see!");
			return false;
		}
		for(User user:User.getAllUsers())
		{
			if(user.getUserName().equals(username))
			{
				JOptionPane.showMessageDialog(null, "User already exist!");
				return false;
			}
		}
		return true;
	}
}