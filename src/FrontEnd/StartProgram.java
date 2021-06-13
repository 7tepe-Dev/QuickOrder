package frontend;

import database.DataHandler;
import database.WriteDefaults;


public class StartProgram 
{
	public static void main(String [] args)
	{
		WriteDefaults.WriteDefaultUsers();
		/*DataHandler.ReadDatasFromJSON();
		FirstPage.createLoginPage();*/
	}
}
