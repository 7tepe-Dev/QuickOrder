package Test;

import java.io.FileReader;


import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import Database.ReadData;



public class ReadDataTest {


	public static void main(String[] args) {

		
		ReadData test = new ReadData();
		
		test.readAllUserfromDB();
		

		
		
	}

}
