import java.io.FileReader;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class ReadData 
{
	 JSONParser parser = new JSONParser();
	 public void readAllUserfromDB()
	 {
		try 
		{
			User currentUser=null;
			Object obj = parser.parse(new FileReader("DataBase.json"));
			JSONArray users = (JSONArray) obj;
			for (Object object : users) 
			{
				JSONObject user = (JSONObject) object;
				if(((String)user.get("userType")).equalsIgnoreCase("Admin"))
				{
					Admin admin;
					currentUser=Admin.createOrGetAdmin();
					admin=((Admin)currentUser);
					User.addNewUserToList(admin);
				}
				else if (((String)user.get("userType")).equalsIgnoreCase("Customer")) 
				{
					String username=(String) user.get("userName");
					String password=(String) user.get("password");
					double balance=(double) user.get("balance");
					//String location=(String) user.get("location");
					currentUser=new Customer(username,password,userType.CUSTOMER,balance);
					User.addNewUserToList(currentUser);
					/*System.out.println("User Name: "+ user.get("userName"));
					System.out.println("User Type: "+ user.get("userType"));
					System.out.println("Balance: "+ user.get("balance"));
					System.out.println("**************************************");*/
				}
				else if (((String)user.get("userType")).equalsIgnoreCase("Owner")) 
				{
					String username=(String) user.get("userName");
					String password=(String) user.get("password");
					Owner currentOwner=new Owner(username,password,userType.OWNER);
					/*System.out.println("User Name: "+ user.get("userName"));
					System.out.println("User Type: "+ user.get("userType"));*/
					JSONObject restaurant = (JSONObject) user.get("restaurant");
					if (!restaurant.isEmpty()) 
					{
						String restaurantName=(String) restaurant.get("name");
						Restaurant currentRestaurant=new Restaurant(restaurantName);
						currentOwner.setRestaurant(currentRestaurant);
						//System.out.println("Restaurant Name: "+restaurantName);
						JSONArray allProducts=(JSONArray) restaurant.get("products");
						if(allProducts!=null)
						{
							for(int i=0;i<allProducts.size();i++)
							{
								JSONArray specialForProduct=(JSONArray) allProducts.get(i);
								Product currentProduct=new Product((String)specialForProduct.get(0),(double)specialForProduct.get(1));
								currentRestaurant.addNewProduct(currentProduct);
							}
						}
						else
						{
							System.out.println("You don't have any products");
						}
					}
					else
					{
						System.out.println("You dont have any restaurant for now");
					}
					User.addNewUserToList(currentOwner);
					//System.out.println("**************************************");
				}
			}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
}