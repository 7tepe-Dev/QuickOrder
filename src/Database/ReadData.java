package database;

import backend.*;

import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;


public class ReadData 
{
	 JSONParser parser = new JSONParser();
	 ArrayList<JSONObject>  AllUser = new ArrayList<JSONObject>();
	 
	 @SuppressWarnings("unlikely-arg-type")
	 public ArrayList<JSONObject> readAllUserfromDB()
	 {

		try 
		{
			
			File dataBaseFile=new File("DataBase.json");
			FileReader fileReader=new FileReader(dataBaseFile);
			Object obj = parser.parse(fileReader);
			@SuppressWarnings("unchecked")
			ArrayList<JSONObject> users = (ArrayList<JSONObject>) obj;
			for (JSONObject user : users) 
			{

				if(((String)user.get("usertype")).equalsIgnoreCase("Admin"))
				{
					Admin admin=Admin.createOrGetAdmin();
					User.addNewUserToList(admin);
				}
				else if (((String)user.get("usertype")).equals(UserType.CUSTOMER.toString())) 
				{
					String username=(String) user.get("username");
					String password=(String) user.get("password");
					double balance=(double) user.get("balance");
					String location=(String) user.get("location");
					User.addNewUserToList(new Customer(username,password,UserType.CUSTOMER, balance, location));
				}
				else if (((String)user.get("usertype")).equals(UserType.OWNER.toString())) 
				{
					String username=(String) user.get("username");
					String password=(String) user.get("password");
					double restaurantBalance= (double)user.get("balance");
					Owner currentOwner=new Owner(username,password,UserType.OWNER);
					JSONObject restaurant = (JSONObject) user.get("restaurant");
					currentOwner.setBalance(restaurantBalance);
					if (!restaurant.isEmpty()) 
					{
						String restaurantImageURL=(String)restaurant.get("restaurantImageURL");	
						String restaurantName=(String) restaurant.get("restaurantname");
						String restaurantLocation=(String)restaurant.get("restaurantLocation");						
						Restaurant currentRestaurant=new Restaurant(restaurantName);
						currentOwner.setRestaurant(currentRestaurant);
						currentOwner.getRestaurant().setRestaurantLocation(restaurantLocation);
						currentOwner.getRestaurant().setImageLink(restaurantImageURL);
						JSONArray allProducts=(JSONArray) restaurant.get("products");
						if(allProducts!=null)
						{
							for(int i=0;i<allProducts.size();i++)
							{
								JSONObject currProduct=(JSONObject) allProducts.get(i);
								String productName=(String) currProduct.get("productname");
								double productPrice=(double) currProduct.get("price");
								String productImageURL=(String) currProduct.get("productImageURL");
								Product currentProduct=new Product(productName,productImageURL,productPrice);
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
						currentOwner.setRestaurant(null);
						System.out.println("You dont have any restaurant for now");
					}
					
				}
				AllUser.add(user);
			}
		
			
		}
		catch (Exception e) 
		{
			System.out.println("An error has occured at reading files.");
			System.out.println("Returning to the defaults!!!");
			WriteDefaults.WriteDefaultUsers();
		}
		
		return AllUser;
	}
	 
}