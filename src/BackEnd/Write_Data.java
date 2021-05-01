package BackEnd;

import java.io.FileWriter;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;




public class Write_Data {

	
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		
		
		JSONObject owner;
		JSONObject customer;			
		JSONObject restaurant;
		

		JSONArray products = new JSONArray();
		JSONArray product = new JSONArray();
		JSONArray user_list = new JSONArray();

		

		//customer
			//customer oluþturma
		customer = new JSONObject();
		customer.put("userName", Tester.c1.getUserName());
		customer.put("password", "1234");
		customer.put("userType", "customer");
		customer.put("balance", 50);	
		user_list.add(customer);

			//customer oluþturma
		customer = new JSONObject();	
		customer.put("userName", "emirhan");
		customer.put("password", "341526");
		customer.put("userType", "customer");
		customer.put("balance", 30);	
		user_list.add(customer);
		

		
		//owner
		owner = new JSONObject();
		owner.put("userName", "mert");
		owner.put("password", "123123");
		owner.put("userType", "owner");
		user_list.add(owner);
		
			//restaurant oluþturma
		restaurant = new JSONObject(); 
		owner.put("restaurant", restaurant); // restaurant.isEmpty()
		//restaurant.put("name", "MCDonald's");
		//restaurant.put("balance", 200);
		
		

		
			//ürün oluþturma
		//product = new JSONArray();
		//product.add(product1.getProductName());
		//product.add(product1.getProductPrice());
		//products.add(product);
			//ürün oluþturma
		//product = new JSONArray();
		//product.add(product2.getProductName());
		//product.add(product2.getProductPrice());
		//products.add(product);
		
			//ürünleri restauranta ekleme
		//restaurant.put("products", products);
		
		
		
		

		
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
