package database;


import backend.*;


public class WriteDefaults 
{
	public static void WriteDefaultUsers()
	{
		WriteData write = new WriteData();
		
		//admin
		Admin admin=Admin.createOrGetAdmin();
		
		//customers
		write.writeCustomerData("AdamBlack", "7741abab52.", 850, "New York");
		
		write.writeCustomerData("fatihYenilmez", "1987fatih,", 200, "İstanbul");
		
		write.writeCustomerData("Jonathan43", "_JJJ43", 1500, "London");

		write.writeCustomerData("HakkıTastepe", "hakkı1234", 50, "Ankara");

		write.writeCustomerData("Meryem_bilen", "19/03/2019", 400, "İstanbul");
		
		write.writeToDB();

	}
}