package Database;

import BackEnd.*;
import BackEnd.User.userType;

import java.io.File;
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
			File dataBaseFile=new File("RestaurantDatabase.json");
			FileReader fileReader=new FileReader(dataBaseFile);
			Object obj = parser.parse(fileReader);
			JSONArray users = (JSONArray) obj;
			for (Object object : users) 
			{
				JSONObject user = (JSONObject) object;
				if(((String)user.get("usertype")).equalsIgnoreCase("Admin"))
				{
					Admin admin=Admin.createOrGetAdmin();
					User.addNewUserToList(admin);
				}
				else if (((String)user.get("usertype")).equalsIgnoreCase("Customer")) 
				{
					String username=(String) user.get("username");
					String password=(String) user.get("password");
					double balance=(double) user.get("balance");
					String location=(String) user.get("location");
					User.addNewUserToList(new Customer(username,password,userType.CUSTOMER,balance,location));
				}
				else if (((String)user.get("usertype")).equalsIgnoreCase("Owner")) 
				{
					String username=(String) user.get("username");
					String password=(String) user.get("password");
					Owner currentOwner=new Owner(username,password,userType.OWNER);
					JSONObject restaurant = (JSONObject) user.get("restaurant");
					if (!restaurant.isEmpty()) 
					{
						String restaurantName=(String) restaurant.get("restaurantname");
						String restaurantLocation=(String)restaurant.get("restaurantlocation");
						Restaurant currentRestaurant=new Restaurant(restaurantName);
						currentOwner.setRestaurant(currentRestaurant);
						currentOwner.getRestaurant().setRestaurantLocation(restaurantLocation);
						JSONArray allProducts=(JSONArray) restaurant.get("products");
						if(allProducts!=null)
						{
							for(int i=0;i<allProducts.size();i++)
							{
								JSONObject currProduct=(JSONObject) allProducts.get(i);
								String productName=(String) currProduct.get("productname");
								double productPrice=(double) currProduct.get("price");
								Product currentProduct=new Product(productName,productPrice);
								currentRestaurant.addNewProduct(currentProduct);
							}
						}
						else
						{
							System.out.println("You don't have any products");
						}
						User.addNewUserToList(currentOwner);
					}
					else
					{
						System.out.println("You dont have any restaurant for now");
					}
				}
			}
		}
		catch (Exception e) 
		{
			System.out.println("An error has occured at reading files.");
			System.out.println("Returning to the defaults!!!");
			WriteDefaults.WriteDefaultUsers();
		}
	}
}