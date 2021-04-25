
import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;


public class Write_Data {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		
		JSONObject owner = new JSONObject();
		JSONObject customer = new JSONObject();			
		JSONObject restaurant = new JSONObject();
		

		JSONArray products = new JSONArray();
		JSONArray user_list = new JSONArray();
		JSONArray product_1 = new JSONArray();
		JSONArray product_2 = new JSONArray();
		
		
				
		Product product1 = new Product("McChicken",15.0);
		Product product2 = new Product("McRoyal",20.0);
		
		//owner
		owner.put("userName", "mert");
		owner.put("password", "123123");
		owner.put("userType", "owner");
		owner.put("restaurant", restaurant);
		
		product_1.add(product1.getProductName());
		product_1.add(product1.getProductPrice());
		products.add(product_1);
		
		product_2.add(product2.getProductName());
		product_2.add(product2.getProductPrice());
		products.add(product_2);
		
		restaurant.put("name", "MCDonald's");
		restaurant.put("balance", 200);
		restaurant.put("products", products);
		


		//customer
		customer.put("userName", "kagan");
		customer.put("password", "321321");
		customer.put("userType", "customer");
		customer.put("balance", 50);
		
		user_list.add(customer);
		user_list.add(owner);
		
		System.out.println(user_list);
		
		
		//json dosyasýný oluþturma ve yazma
		try(FileWriter file = new FileWriter("DataBase.json"))
		{
			file.write(user_list.toString());
			file.flush();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

		
		
	}

}
