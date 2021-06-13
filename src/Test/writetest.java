package Test;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;

import backend.Customer;
import backend.Owner;
import backend.User;
import backend.UserType;
import database.*;

public class writetest {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		

		WriteData write = new WriteData();
				
		
		//write.writeDefaultsData();
		
		Owner za=new Owner("JohnForbesNash","annaJohn1978",UserType.OWNER,null,1285250);
		User.addNewUserToList(za);
		write.writeAllUsers();
						
		
		DataHandler.ReadDatasFromJSON();
		for (User user : User.getAllUsers()) 
		{
			System.out.println(((Owner)user).getRestaurant());
		}
		
		
	}

}
