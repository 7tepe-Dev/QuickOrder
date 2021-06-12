package database;


import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import backend.Customer;
import backend.Owner;
import backend.User;
import backend.UserType;


public class WriteData 
{
	
	JSONObject customer;
	
	JSONObject owner;
	JSONObject restaurant;

	JSONArray products;
	JSONObject product;


	@SuppressWarnings("unchecked")
	public void writeAdminData(String username, String password, double balance, String location)
	{	

		for (JSONObject user : DataHandler.database) 
		{
			if (user.get("username").equals(username)) 
			{
				DataHandler.database.remove(user);
				break;
			}
		}
	
		customer = new JSONObject();
				
		customer.put("username", username );
		customer.put("password", password);
		customer.put("balance", balance);
		customer.put("location", location);
		customer.put("usertype", UserType.CUSTOMER.toString() );
		
		DataHandler.database.add(customer);
		//userList(customer);
	}
	
	@SuppressWarnings("unchecked")
	public void writeCustomerData(String username, String password, double balance, String location)
	{	

		for (JSONObject user : DataHandler.database) 
		{
			if (user.get("username").equals(username)) 
			{
				DataHandler.database.remove(user);
				break;
			}
		}
	
		customer = new JSONObject();
				
		customer.put("username", username );
		customer.put("password", password);
		customer.put("balance", balance);
		customer.put("location", location);
		customer.put("usertype", UserType.CUSTOMER.toString() );
		
		DataHandler.database.add(customer);
		//userList(customer);
	}

	@SuppressWarnings("unchecked")
	public void writeOwnerData(String username, String password, double balance)
	{
		for (JSONObject user : DataHandler.database) 
		{
			if (user.get("username").equals(username)) 
			{
				DataHandler.database.remove(user);
				break;
			}
		}
		
		owner = new JSONObject();
		restaurant = new JSONObject();

		owner.put("username", username );
		owner.put("password", password);
		owner.put("balance", balance);
		owner.put("restaurant", restaurant);

		owner.put("usertype", UserType.OWNER.toString());

		DataHandler.database.add(owner);

	}

	@SuppressWarnings("static-access")
	public void writeDefaultsData()
	{
		WriteDefaults writeDefaults = new WriteDefaults();
		writeDefaults.WriteDefaultUsers();
	}
	
	@SuppressWarnings("unchecked")
	public void writeRestaurantForOwner(String username, String restaurantName, String restaurantLocation)
	{

		products = new JSONArray();

		for (Object object : DataHandler.database) 
		{

			JSONObject owner = (JSONObject) object;

			if (owner.get("username").toString().equals(username)) 
			{
				JSONObject restaurant = (JSONObject) owner.get("restaurant");

				restaurant.put("name", restaurantName);
				restaurant.put("products", products);
				restaurant.put("restaurantLocation", restaurantLocation);

			}			
		}

	}

	@SuppressWarnings("unchecked")
	public void writeProductForRestaurant(String username, String productName, double price)
	{

		for (Object object : DataHandler.database) 
		{

			JSONObject owner = (JSONObject) object;

			if (owner.get("username").toString().equals(String.valueOf(username))) 
			{
				JSONObject restaurant = (JSONObject) owner.get("restaurant");	
				JSONArray products = (JSONArray) restaurant.get("products");

				product = new JSONObject();
				product.put("productname", productName);
				product.put("price", price);
				products.add(product);

			}			
		}

	}
	
	public void writeAllUsers()
	{

		DataHandler.database.clear();
		for (User user : User.getAllUsers()) 
		{
			
			if (user.getUsertype().equals(UserType.CUSTOMER)) 
			{
				writeCustomerData(user.getUserName(), user.getPassword(), ((Customer)user).getBalance(), ((Customer)user).getLocation());
			}
			else if (user.getUsertype().equals(UserType.OWNER)) 
			{
				writeOwnerData(user.getUserName(), user.getPassword(), ((Owner)user).getBalance());
				if (((Owner)user).getRestaurant() != null) 
				{
					writeRestaurantForOwner(user.getUserName(), ((Owner)user).getRestaurant().getRestaurantName(), ((Owner)user).getRestaurant().getRestaurantLocation());
					if (((Owner)user).getRestaurant().getAllProducts() != null) 
					{
						for (int i = 0; i < ((Owner)user).getRestaurant().getAllProducts().size(); i++) 
						{							
							writeProductForRestaurant(user.getUserName(), ((Owner)user).getRestaurant().getAllProducts().get(i).getProductName(), ((Owner)user).getRestaurant().getAllProducts().get(i).getProductPrice());
						}

					}
					
				}

			}
			
			writeToDB();
		}
		
	}
	
	public void writeToDB()
	{
		try(FileWriter file = new FileWriter("Database.json"))
		{
			file.write(DataHandler.database.toString());
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
		
	}



}