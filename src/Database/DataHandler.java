package database;

import backend.User;

public class DataHandler 
{
	static ReadData reader;
	static WriteData writer;
	
	public static void readDatasFromJSON()
	{
		reader=new ReadData();
		reader.readAllUserfromDB();
	}
	public static void writeDataToJSON(User user)
	{
		writer=new WriteData();
		writer.writeTheUserToDB(user);
	}
}