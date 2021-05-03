public class DataHandler 
{
	static ReadData reader;
	static WriteData writer;
	
	public static void ReadDatasFromJSON()
	{
		reader=new ReadData();
		reader.readAllUserfromDB();
	}
	public static void WriteDataToJSON(User user)
	{
		writer=new WriteData();
		writer.WriteTheUserToDB(user);
	}
}