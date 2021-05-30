package backend;

import java.awt.Graphics;

import database.DataHandler;
import database.WriteDefaults;
import frontend.MainPage;

public class Main 
{
	public static User currentUser=null;
	public static void main(String[] args) 
	{
		
		//admin
		Admin admin=Admin.createOrGetAdmin();
		//customers
		Customer c=new Customer("AdamBlack","7741abab52.",UserType.CUSTOMER,850,"New York");
		Customer c1=new Customer("fatihYenilmez","1923fatih,",UserType.CUSTOMER,200,"Ýstanbul");
		Customer c2=new Customer("Jonathan43","_JJJ43",UserType.CUSTOMER,1500,"London");
		Customer c3=new Customer("HakkýTastepe","hakký1234",UserType.CUSTOMER,50,"Ankara");
		Customer c4=new Customer("Meryem_bilen","19/03/2019",UserType.CUSTOMER,400,"Ýstanbul");
		//aboutOwners
		Product pmc=new Product("Double Quarter Pounder","C:\\Users\\Calky\\Desktop\\DoubleQuarterPounder.jpg",30.99);
		Product pmc1=new Product("Double McChicken","C:\\Users\\Calky\\Desktop\\DoubleMcChicken.jpg",21.99);
		Product pmc2=new Product("Big Mac™","C:\\Users\\Calky\\Desktop\\BigMac.jpg",21.99);
		Product pmc3=new Product("Chicken McNuggets®","C:\\Users\\Calky\\Desktop\\Chicken McNuggets.jpg",12.99);
		Product pmc4=new Product("Coca-Cola","C:\\Users\\Calky\\Desktop\\CocaCola.jpg",6.75);
		Restaurant mc=new Restaurant("McDonald’s");
		mc.addNewProduct(pmc);
		mc.addNewProduct(pmc1);
		mc.addNewProduct(pmc2);
		mc.addNewProduct(pmc3);
		mc.addNewProduct(pmc4);
		mc.setRestaurantLocation("Washington");
		mc.setImageLink("55.png");
		Owner o1=new Owner("JohnForbesNash","annaJohn1978",UserType.OWNER,mc,185250);
		Product p1=new Product("Fýrýn Köfte",12);
		Product p2=new Product("Lahana Sarmasý",15);
		Product p3=new Product("Fanta (33 cl.)",5);
		Product p4=new Product("Mantar Sote",10);
		Product p5=new Product("Karýsýk Menemen",17);
		Restaurant evy=new Restaurant("Baran Ev Yemekleri");
		Restaurant asdsa=new Restaurant("SADASDSADASD");
		Restaurant asdsaQQ=new Restaurant("SELAMMM");
		Restaurant asdsaSADSD=new Restaurant("SELAM KIZLAR");
		Owner o2=new Owner("BaranYýlmazi","baranYelda123",UserType.OWNER,null,45000);;
		evy.addNewProduct(p1);
		User.addNewUserToList(o2);
		evy.addNewProduct(p2);
		evy.addNewProduct(p3);
		evy.addNewProduct(p4);
		evy.addNewProduct(p5);
		evy.setRestaurantLocation("Istanbul");
		evy.setImageLink("56.png");
		Owner o5=new Owner("BaranYýlmaz","baranYelda123",UserType.OWNER,evy,45000);
		Restaurant xd=new Restaurant("Tatlý Yiyelim");
		Restaurant a=new Restaurant("Ozkebap's Salonu");
		Restaurant b=new Restaurant("Hosgeldiniz.");
		//Restaurant cee=new Restaurant("Hoscakal.");

		xd.setRestaurantLocation("Ankara");
		Product p10=new Product("Kakao Bisküvili Mag",11.70);
		Product p11=new Product("Profiterol",16);
		Product p12=new Product("Lotus Cup",12.65);
		Product p13=new Product("Orman Meyveli Cheesecake",14.85);
		Product p14=new Product("Oreolu Trileçe",10.45);
		Product p15=new Product("Naneli Limonata",7.15);
		xd.addNewProduct(p10);
		xd.addNewProduct(p11);
		xd.addNewProduct(p12);
		xd.addNewProduct(p13);
		xd.addNewProduct(p14);
		xd.addNewProduct(p15);
		xd.setImageLink("55.png");
		Owner o3=new Owner("_selinIsbilen.","sseelliinn__",UserType.OWNER,xd,80533);
		User.addNewUserToList(admin);
		User.addNewUserToList(c);
		User.addNewUserToList(c1);
		User.addNewUserToList(c2);
		User.addNewUserToList(c3);
		User.addNewUserToList(c4);
		User.addNewUserToList(o1);
		User.addNewUserToList(o3);
		User.addNewUserToList(o5);
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
		currentUser=c4;
		MainPage.showMainPage(currentUser);
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