import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class NewTester 
{
	@SuppressWarnings("unchecked")
	public static void main(String[] args) 
	{
		JSONObject d=new JSONObject();
		d.put("name","calky");
		d.put("surname","ozetci");
		d.put("age","20");
		JSONArray arr=new JSONArray();
		JSONObject addThis=new JSONObject();
		d.put("ALLPRODUCTS:",arr);
		addThis.put("kebabo",20);
		addThis.put("elmalýTurta",12);
		addThis.put("cola",5);
		arr.add(addThis);
		try(FileWriter file = new FileWriter("denemee.json"))
		{
			file.write(d.toJSONString());
			file.flush();
			file.close();
			System.out.println("Customer's data saved");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
}