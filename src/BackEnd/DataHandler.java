package BackEnd;


import org.json.simple.JSONArray;


public class DataHandler 
{

	public static WriteData wd = new WriteData();
	public JSONArray user_list = new JSONArray();
	
	public static boolean ReadDatasFromJSON()
	{
		//burada has next gibi bir method olmasý lazým
		//while döngüsüne sokabilmek için
		//ve burada user oluþturulmasý lazým ki bunu listeye ekleyebilelim
		//User current= dosyadan alýnan verilerle yeni user oluþturulmasý
		User current=null;//=new User(get json username,get json password,get json usertype);
		userType currentType;
		String usertypes="";//mesela usertype için çektiðimiz string usertypes olsun
		if(usertypes.equals("Owner"))
		{
			currentType=userType.OWNER;
		}
		else if(usertypes.equals("Customer"))
		{
			currentType=userType.CUSTOMER;
		}
		//TAM BURADA USER NEW USER DENEREK OLUÞTURULMALI
		//User a=new User(); üstte ayarladýðýmýz currentType kullanýlarak
		if(current.usertype.equals(userType.ADMIN))
		{
			Admin admin=Admin.createOrGetAdmin();
			User.addNewUserToList(admin);
			//burada database iþlemi yok çünkü admin zaten bir tane
			//username ve passwordu sabit
		}
		if(current.usertype.equals(userType.CUSTOMER))
		{
			Customer currentCus=((Customer)current);
			//artýk json dakalan verileri currentCus ýn üzerine yazacaðýz
			User.addNewUserToList(currentCus);//üretilen customer ýn
			//listeye customerýn eklenmesi
		}
		else if(current.usertype.equals(userType.OWNER))
		{
			Owner currentOwner=((Owner)current);
			//artýk json da kalan verileri currentOwner ýn üzerine yazacaðýz.
			User.addNewUserToList(currentOwner);
			//listeye owner ýn eklenmesi
		}
		return false;//öylesine
	}
	public static boolean WriteDataToJSON(User user)
	{
		if(user.usertype.equals(userType.CUSTOMER))
		{
			Customer current=((Customer)user);
			wd.write_customer_data(current.getUserName(), current.getPassword(), current.getBalance());
		}
		else if(user.usertype.equals(userType.OWNER))
		{
			Owner current=((Owner)user);
			wd.write_owner_data(current.getUserName(), current.getPassword());
		}
		else
		{
			System.out.println("An error has occurred!!");
		}
		return false;//þimdilik öylesine yazdým
	}
}