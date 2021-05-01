package BackEnd;

import java.io.FileReader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Write_Data {

	

	public static void main(String[] args) {
		
		
		DataHandler test = new DataHandler();
			
		test.write_customer_data("mert", "3213", 150);
		test.write_customer_data("merve", "3243", 350);
		test.write_customer_data("kaðan", "3213", 650);
		
		test.write_owner_data("yusuf", "4212");
		test.write_owner_data("emirhan", "4212");
		test.write_owner_data("berk", "4212");
		
		test.write_restaurant_to_owner(1003, "yusufkebap", 500);
		
		
		//test.write_restaurant_to_owner(868, "yusufkebap", 200);
		

		
		
	}

}
