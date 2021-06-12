package backend;

import java.awt.Graphics;
import java.io.File;
import java.net.MalformedURLException;

import database.DataHandler;
import database.WriteDefaults;
import frontend.MainPage;

public class Main 
{
	public static User currentUser=null;
	String path=getClass().getResource("/specialResources/").toString();
	public String getPath()
	{
		return path;
	}
	public static void main(String[] args) 
	{
		Main main=new Main();
		//admin
		Admin admin=Admin.createOrGetAdmin();
		//customers
		Customer c=new Customer("AdamBlack","7741abab52.",UserType.CUSTOMER,850,"New York");
		Customer c1=new Customer("fatihYenilmez","1987fatih,",UserType.CUSTOMER,200,"Ýstanbul");
		Customer c2=new Customer("Jonathan43","_JJJ43",UserType.CUSTOMER,1500,"London");
		Customer c3=new Customer("HakkýTastepe","hakký1234",UserType.CUSTOMER,50,"Ankara");
		Customer c4=new Customer("Meryem_bilen","19/03/2019",UserType.CUSTOMER,400,"Ýstanbul");
		//aboutOwners
		Restaurant mc=new Restaurant("McDonald’s");
		mc.setImageLink(main.getPath()+mc.getRestaurantName()+"/Restaurant Image.jpg");
		mc.addNewProduct(new Product("Double Quarter Pounder",main.getPath()+mc.getRestaurantName()+"/DoubleQuarterPounder.jpg",30.99));
		mc.addNewProduct(new Product("Double McChicken",main.getPath()+mc.getRestaurantName()+"/DoubleMcChicken.jpg",21.99));
		mc.addNewProduct(new Product("Big Mac™",main.getPath()+mc.getRestaurantName()+"/BigMac.jpg",21.99));
		mc.addNewProduct(new Product("Chicken McNuggets®",main.getPath()+mc.getRestaurantName()+"/Chicken McNuggets.jpg",12.99));
		mc.addNewProduct(new Product("Coca-Cola",main.getPath()+mc.getRestaurantName()+"/CocaCola.jpg",6.75));
		mc.setRestaurantLocation("Washington");
		Restaurant dessert=new Restaurant("Tatlý Yiyelim");
		dessert.setImageLink(main.getPath()+dessert.getRestaurantName()+"/Restaurant Image.jpg");
		dessert.addNewProduct(new Product("Kakao Bisküvili Mag",main.getPath()+dessert.getRestaurantName()+"/kakaolumag.jpeg",11.70));
		dessert.addNewProduct(new Product("Profiterol",main.getPath()+dessert.getRestaurantName()+"/profiterol.jpg",16));
		dessert.addNewProduct(new Product("Lotus Cup",main.getPath()+dessert.getRestaurantName()+"/lotuscup.jpg",12.65));
		dessert.addNewProduct(new Product("Orman Meyveli Cheesecake",main.getPath()+dessert.getRestaurantName()+"/Orman Meyveli Cheesecake.jpg",14.85));
		dessert.addNewProduct(new Product("Oreolu Trileçe",main.getPath()+dessert.getRestaurantName()+"/Oreolu Trileçe.jpg",10.45));
		dessert.addNewProduct(new Product("Naneli Limonata",main.getPath()+dessert.getRestaurantName()+"/Naneli Limonata.jpg",7.15));
		dessert.setRestaurantLocation("Ankara");
		Restaurant madisonRest=new Restaurant("Madison's Healthy Foods");
		madisonRest.setImageLink(main.getPath()+madisonRest.getRestaurantName()+"/Restaurant Image.png");
		madisonRest.addNewProduct(new Product("Pan-Fried Tilapia",main.getPath()+madisonRest.getRestaurantName()+"/Pan-Fried Tilapia.jpg",43.80));
		madisonRest.addNewProduct(new Product("Caprese Zoodles",main.getPath()+madisonRest.getRestaurantName()+"/Caprese Zoodles.jpg",18.00));
		madisonRest.addNewProduct(new Product("Tuscan Butter Roast Chicken",main.getPath()+madisonRest.getRestaurantName()+"/Tuscan Butter Roast Chicken.jpg",165));
		madisonRest.addNewProduct(new Product("Honey Garlic Glazed Salmon",main.getPath()+madisonRest.getRestaurantName()+"/Honey Garlic Glazed Salmon.jpg",75.50));
		madisonRest.addNewProduct(new Product("Zucchini Lattice Lasagna",main.getPath()+madisonRest.getRestaurantName()+"/Zucchini Lattice Lasagna.jpg",50));
		madisonRest.addNewProduct(new Product("Cauliflower Grilled Cheese",main.getPath()+madisonRest.getRestaurantName()+"/Cauliflower Grilled Cheese.jpg",26.75));
		madisonRest.addNewProduct(new Product("Baked Salmon",main.getPath()+madisonRest.getRestaurantName()+"/Baked Salmon.jpg",36.88));
		madisonRest.setRestaurantLocation("Michigan");
		Restaurant baranEv=new Restaurant("Baran Ev Yemekleri");
		baranEv.setImageLink(main.getPath()+baranEv.getRestaurantName()+"/Restaurant Image.jpg");
		baranEv.addNewProduct(new Product("Fýrýn Köfte",main.getPath()+baranEv.getRestaurantName()+"/Fýrýn Köfte.jpg",32.80));
		baranEv.addNewProduct(new Product("Lahana Sarmasý",main.getPath()+baranEv.getRestaurantName()+"/Lahana Sarmasý.jpg",23));
		baranEv.addNewProduct(new Product("Mantar Sote",main.getPath()+baranEv.getRestaurantName()+"/Mantar Sote.jpg",28.50));
		baranEv.addNewProduct(new Product("Karýsýk Menemen",main.getPath()+baranEv.getRestaurantName()+"/Karýsýk Menemen.jpg",23.75));
		baranEv.addNewProduct(new Product("Fanta (33 cl.)",main.getPath()+baranEv.getRestaurantName()+"/Fanta.jpg",5));
		baranEv.setRestaurantLocation("Ýstanbul");
		User.addNewUserToList(admin);
		Owner za=new Owner("JohnForbesNash","annaJohn1978",UserType.OWNER,mc,1285250);
		Owner xd=new Owner("asdasds","sad",UserType.OWNER);
		User.addNewUserToList(za);
		//User.addNewUserToList(new Owner("JohnForbesNash","annaJohn1978",UserType.OWNER,mc,1285250));
		User.addNewUserToList(new Owner("Tatlýcý Sefa","_-sefaSS23,",UserType.OWNER,dessert,86320));
		User.addNewUserToList(new Owner("BaranYenilmez","barki1982_ynlmz",UserType.OWNER,baranEv,128753.80));
		User.addNewUserToList(new Owner("Ms.Madison","madMadhealthy.,",UserType.OWNER,madisonRest,265804));
		User.addNewUserToList(c);
		User.addNewUserToList(c1);
		User.addNewUserToList(c2);
		User.addNewUserToList(c3);
		User.addNewUserToList(c4);
		Restaurant r=new Restaurant("ZAS");
		Owner s=new Owner("deneme","dadi",UserType.OWNER,null,0);
		User.addNewUserToList(s);
		//WriteDefaults.WriteDefaultUsers();
		//DataHandler.readDatasFromJSON();
		/*for(int i=0;i<User.getAllUsers().size();i++)
		{
			if(User.getAllUsers().get(i).getUsertype().equals(UserType.CUSTOMER))
			{
				currentUser=User.getAllUsers().get(i);
				break;
			}
			//System.out.println(User.getAllUsers().get(i).getUserName());
		}*/
		//admin,s,c3
		currentUser=admin;
		//MainPage.showMainPage(currentUser);
		//BigDeneme.main(args);
		MainPage.showMainPage();
		//LastMainPage ab=new LastMainPage();
		//Graphics a=(Graphics) new Object();
		//MainPage.main(args);
		//DataHandler.readDatasFromJSON();
		//DataHandler.readDatasFromJSON();
		//LoginPage l=new LoginPage();
		//GUIHandler.showMainPage();
		//LoginPage.showLoginPage();
		//tabi alttaki satirdan once currentuser in bir yerde
		//atamasinin yapilmasi gerek yani login islemi burada olmali
		/*if(currentUser.getUsertype().equals(userType.ADMIN))
		{
			//show admin panel
			System.out.println("ben adminim");
		}
		else if(currentUser.getUsertype().equals(userType.CUSTOMER))
		{
			//show customer panel
			System.out.println("ben customerim.");
		}
		else if(currentUser.getUsertype().equals(userType.OWNER))
		{
			//show owner panel
			System.out.println("ben ownerim");
		}
		else
		{
			
		}*/
		/*for(User u:User.getAllUsers())
		{
			System.out.println(u.getUserTypeAsString());
			if(u.getUserName().equals("admin"))
			{
				currentUser=u;
			}
		}
		System.out.println(currentUser.getUserTypeAsString());*/
	}
}