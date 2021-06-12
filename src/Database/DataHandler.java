package database;

import java.util.ArrayList;

import org.json.simple.JSONObject;

public class DataHandler 
{
	public static ArrayList<JSONObject> database = new ArrayList<JSONObject>();
	
	static ReadData reader;
	static WriteData writer;
	
	
	public static void ReadDatasFromJSON()
	{
		reader=new ReadData();
		database = reader.readAllUserfromDB();
	}
	
	public static void WriteDataToJSON()
	{
		writer=new WriteData();
		writer.writeToDB();
	}

}