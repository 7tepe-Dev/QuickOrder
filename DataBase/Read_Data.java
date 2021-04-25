import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class Read_Data {


	public static void main(String[] args) {

		
		JSONParser parser = new JSONParser();
		
		try
		{
			
			
			Object obj = parser.parse(new FileReader("DataBase.json"));
			//JSONObject jsonObject = (JSONObject) obj;
			JSONArray users = (JSONArray) obj;
			//JSONObject user1 = (JSONObject) users.get(0);
			//JSONObject user2 = (JSONObject) users.get(1);
			//JSONObject restaurant = (JSONObject) jsonObject.get("restaurant");
			//JSONArray products = (JSONArray) restaurant.get("products");
			
			
			//System.out.println("Restaurant Name: "+ restaurant.get("name"));
			//System.out.println("Restaurant Products: "+restaurant.get("products"));
			
			
			//JSONArray product = (JSONArray) products.get(1);
			//System.out.println("Product Name: "+product.get(0));
			//System.out.println("Product Price: "+product.get(1));
			
			for (Object object : users) {
				JSONObject user = (JSONObject) object;
				if (user.get("userType").equals("owner")) 
				{
					System.out.println("True");
				} 
				else 
				{
					System.out.println("False");	
				}
			}

			
			//çalýþmýyor
			//JSONArray test = (JSONArray) jsonObject.get("restaurant");
			//Iterator<String> iterator = test.iterator();
			
			//while(iterator.hasNext())
			//{
				//System.out.println("Products: "+ iterator.next());
			//}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		


				

		
		
	}

}
