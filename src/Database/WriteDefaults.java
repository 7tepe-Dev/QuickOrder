package Database;


import BackEnd.*;
import BackEnd.User.userType;

public class WriteDefaults 
{
	public static void WriteDefaultUsers()
	{
		//admin
		Admin admin=Admin.createOrGetAdmin();
		//customers
		Customer c=new Customer("AdamBlack","7741abab52.",userType.CUSTOMER,850,"New York");
		Customer c1=new Customer("fatihYenilmez","1923fatih,",userType.CUSTOMER,200,"Ýstanbul");
		Customer c2=new Customer("Jonathan43","_JJJ43",userType.CUSTOMER,1500,"London");
		Customer c3=new Customer("HakkýTastepe","hakký1234",userType.CUSTOMER,50,"Ankara");
		Customer c4=new Customer("Meryem_bilen","19/03/2019",userType.CUSTOMER,400,"Ýstanbul");
		//aboutOwners
		Product pmc=new Product("Double Quarter Pounder",30.99);
		Product pmc1=new Product("Double McChicken",21.99);
		Product pmc2=new Product("Big Mac™",21.99);
		Product pmc3=new Product("Chicken McNuggets®",12.99);
		Product pmc4=new Product("Coca-Cola",6.75);
		Restaurant mc=new Restaurant("McDonald’s");
		mc.addNewProduct(pmc);
		mc.addNewProduct(pmc1);
		mc.addNewProduct(pmc2);
		mc.addNewProduct(pmc3);
		mc.addNewProduct(pmc4);
		mc.setRestaurantLocation("Washington");
		Owner o1=new Owner("JohnForbesNash","annaJohn1978",userType.OWNER,mc,185250);
		Product p1=new Product("Fýrýn Köfte",12);
		Product p2=new Product("Lahana Sarmasý",15);
		Product p3=new Product("Fanta (33 cl.)",5);
		Product p4=new Product("Mantar Sote",10);
		Product p5=new Product("Karýsýk Menemen",17);
		Restaurant evy=new Restaurant("Baran Ev Yemekleri");
		evy.addNewProduct(p1);
		evy.addNewProduct(p2);
		evy.addNewProduct(p3);
		evy.addNewProduct(p4);
		evy.addNewProduct(p5);
		evy.setRestaurantLocation("Istanbul");
		Owner o2=new Owner("BaranYýlmaz","baranYelda123",userType.OWNER,evy,45000);
		Restaurant xd=new Restaurant("Tatlý Yiyelim");
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
		Owner o3=new Owner("_selinIsbilen.","sseelliinn__",userType.OWNER,xd,80533);
		User.addNewUserToList(admin);
		User.addNewUserToList(c);
		User.addNewUserToList(c1);
		User.addNewUserToList(c2);
		User.addNewUserToList(c3);
		User.addNewUserToList(c4);
		User.addNewUserToList(o1);
		User.addNewUserToList(o2);
		User.addNewUserToList(o3);
		for(User user:User.getAllUsers())
		{
			DataHandler.WriteDataToJSON(user);
		}
	}
}