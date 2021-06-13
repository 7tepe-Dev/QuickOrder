package backend;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.net.MalformedURLException;

import database.DataHandler;
import database.WriteData;
import database.WriteDefaults;
import frontend.LoginPage;
import frontend.MainPage;

public class Main 
{
	public static User currentUser=null;

	public static void main(String[] args) 
	{
		//defaults data
		//WriteData write = new WriteData();
		//write.writeDefaultsData();

		DataHandler.ReadDatasFromJSON();
		
		LoginPage login = new LoginPage();
		login.setTitle("QUICK ORDER");
		login.setLocationRelativeTo(null);
		login.setResizable(false);
		login.setVisible(true);



		

		
	}
}