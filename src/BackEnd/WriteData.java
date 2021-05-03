import java.io.FileWriter;
import java.io.IOException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class WriteData 
{
	JSONObject admin;
	JSONObject customer;
	JSONObject owner;
	JSONObject restaurant;
	JSONArray allProducts;
	JSONArray product;
	
	public static JSONArray userList = new JSONArray();
	@SuppressWarnings("unchecked")
	public void WriteTheUserToDB(User user)
	{
		if(user.usertype.equals(userType.ADMIN))
		{
			admin=new JSONObject();
			Admin currentAdmin=((Admin)user);
			admin.put("username",currentAdmin.userName);
			admin.put("password",currentAdmin.password);
			admin.put("usertype","Admin");
			userList.add(admin);
		}
		else if(user.usertype.equals(userType.CUSTOMER))
		{
			customer=new JSONObject();
			Customer currentCustomer=((Customer)user);
			customer.put("username",currentCustomer.userName);
			customer.put("password",currentCustomer.password);
			customer.put("usertype","Customer");
			customer.put("balance",currentCustomer.getBalance());
			customer.put("location",currentCustomer.getLocation());
			userList.add(customer);
		}
		else if(user.usertype.equals(userType.OWNER))
		{
			owner=new JSONObject();
			Owner currentOwner=((Owner)user);
			owner.put("username",currentOwner.userName);
			owner.put("password",currentOwner.password);
			owner.put("usertype","Owner");
			owner.put("balance",currentOwner.getBalance());
			restaurant=new JSONObject();
			restaurant.put("restaurantname",currentOwner.getRestaurant().getRestaurantName());
			restaurant.put("restaurantlocation",currentOwner.getRestaurant().getRestaurantLocation());
			owner.put("restaurant",restaurant);
			allProducts=new JSONArray();
			restaurant.put("products",allProducts);
			JSONObject currentObject=null;
			for(Product p:currentOwner.getRestaurant().getAllProducts())
			{
				currentObject=new JSONObject();
				currentObject.put("productname",p.getProductName());
				currentObject.put("price",p.getProductPrice());
				allProducts.add(currentObject);
			}
			
			userList.add(owner);
		}
		else
		{
			System.out.println("An error ocurred at write data.");
		}
		try(FileWriter file = new FileWriter("RestaurantDatabase.json"))
		{
			file.write(userList.toString());
			file.flush();
			System.out.println("Customer's data saved");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}