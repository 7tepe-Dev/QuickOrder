package Database;


import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import BackEnd.UserType;


public class WriteData 
{

	JSONObject customer;
	
	JSONObject owner;
	JSONObject restaurant;

	JSONArray products;
	JSONObject product;


	public JSONArray userList = new JSONArray();


	@SuppressWarnings("unchecked")
	public void writeCustomerData(String username, String password, double balance)
	{		
		customer = new JSONObject();

		customer.put("username", username );
		customer.put("password", password);
		customer.put("balance", balance);
		customer.put("userType", UserType.CUSTOMER.toString() );

		userList.add(customer);

	}

	@SuppressWarnings("unchecked")
	public void writeOwnerData(String username, String password)
	{
		owner = new JSONObject();
		restaurant = new JSONObject();

		owner.put("username", username );
		owner.put("password", password);
		owner.put("restaurant", restaurant);

		owner.put("userType", UserType.OWNER.toString());

		userList.add(owner);

	}

	@SuppressWarnings("unchecked")
	public void writeRestaurantForOwner(String username, String restaurantName, double balance)
	{

		products = new JSONArray();

		for (Object object : userList) 
		{

			JSONObject owner = (JSONObject) object;

			if (owner.get("username").toString().equals(username)) 
			{
				JSONObject restaurant = (JSONObject) owner.get("restaurant");

				restaurant.put("name", restaurantName);
				restaurant.put("products", products);
				restaurant.put("balance", balance);

			}			
		}

	}

	@SuppressWarnings("unchecked")
	public void writeProductForRestaurant(String username, String productName, double price)
	{

		for (Object object : userList) 
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
	
	public void writeToDB()
	{
		try(FileWriter file = new FileWriter("Database_test.json"))
		{
			file.write(userList.toString());
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}



}