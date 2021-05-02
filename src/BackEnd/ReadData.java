package BackEnd;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;




public class ReadData 
{
	 JSONParser parser = new JSONParser();
	 public void readAllUserfromDB()
	{
		try 
		{
			Object obj = parser.parse(new FileReader("DataBase.json"));
			
			JSONArray users = (JSONArray) obj;
			
			
			for (Object object : users) 
			{
				
				JSONObject user = (JSONObject) object;
				
				if (user.get("userType").equals(userType.CUSTOMER.toString())) 
				{
					System.out.println("User Name: "+ user.get("userName"));
					System.out.println("User Type: "+ user.get("userType"));
					System.out.println("Balance: "+ user.get("balance"));
					System.out.println("**************************************");
				}
				else if (user.get("userType").equals(userType.OWNER.toString())) 
				{
					System.out.println("User Name: "+ user.get("userName"));
					System.out.println("User Type: "+ user.get("userType"));
					
					JSONObject restaurant = (JSONObject) user.get("restaurant");
					if (restaurant.isEmpty() == false) 
					{
						System.out.println("Restaurant Name: "+ restaurant.get("name"));
					}
					System.out.println("**************************************");
					
				}
							
				
			}
		}
		
		catch (Exception e) 
		{
			e.printStackTrace();
		}

	}
	
		
		


				

		
		


}
