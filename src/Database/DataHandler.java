package Database;


public class DataHandler 
{
	static ReadData reader;
	static WriteData writer;
	
	public static void ReadDatasFromJSON()
	{
		reader=new ReadData();
		reader.readAllUserfromDB();
	}
	
	public static void writeDataToJSON()
	{
		writer=new WriteData();
		writer.writeToDB();
	}

}