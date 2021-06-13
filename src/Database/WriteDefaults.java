package database;


import backend.*;


public class WriteDefaults 
{
	String path=getClass().getResource("/specialResources/").toString();
	public String getPath()
	{
		return path;
	}
	
	public static void WriteDefaultUsers()
	{
		WriteData write = new WriteData();
		WriteDefaults writedef = new WriteDefaults();
		User.getAllUsers().clear();
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
		mc.setImageLink(writedef.getPath()+mc.getRestaurantName()+"/Restaurant Image.jpg");
		mc.addNewProduct(new Product("Double Quarter Pounder",writedef.getPath()+mc.getRestaurantName()+"/DoubleQuarterPounder.jpg",30.99));
		mc.addNewProduct(new Product("Double McChicken",writedef.getPath()+mc.getRestaurantName()+"/DoubleMcChicken.jpg",21.99));
		mc.addNewProduct(new Product("Big Mac™",writedef.getPath()+mc.getRestaurantName()+"/BigMac.jpg",21.99));
		mc.addNewProduct(new Product("Chicken McNuggets®",writedef.getPath()+mc.getRestaurantName()+"/Chicken McNuggets.jpg",12.99));
		mc.addNewProduct(new Product("Coca-Cola",writedef.getPath()+mc.getRestaurantName()+"/CocaCola.jpg",6.75));
		mc.setRestaurantLocation("Washington");
		Restaurant dessert=new Restaurant("Tatlý Yiyelim");
		dessert.setImageLink(writedef.getPath()+dessert.getRestaurantName()+"/Restaurant Image.jpg");
		dessert.addNewProduct(new Product("Kakao Bisküvili Mag",writedef.getPath()+dessert.getRestaurantName()+"/kakaolumag.jpeg",11.70));
		dessert.addNewProduct(new Product("Profiterol",writedef.getPath()+dessert.getRestaurantName()+"/profiterol.jpg",16));
		dessert.addNewProduct(new Product("Lotus Cup",writedef.getPath()+dessert.getRestaurantName()+"/lotuscup.jpg",12.65));
		dessert.addNewProduct(new Product("Orman Meyveli Cheesecake",writedef.getPath()+dessert.getRestaurantName()+"/Orman Meyveli Cheesecake.jpg",14.85));
		dessert.addNewProduct(new Product("Oreolu Trileçe",writedef.getPath()+dessert.getRestaurantName()+"/Oreolu Trileçe.jpg",10.45));
		dessert.addNewProduct(new Product("Naneli Limonata",writedef.getPath()+dessert.getRestaurantName()+"/Naneli Limonata.jpg",7.15));
		dessert.setRestaurantLocation("Ankara");
		Restaurant madisonRest=new Restaurant("Madison's Healthy Foods");
		madisonRest.setImageLink(writedef.getPath()+madisonRest.getRestaurantName()+"/Restaurant Image.png");
		madisonRest.addNewProduct(new Product("Pan-Fried Tilapia",writedef.getPath()+madisonRest.getRestaurantName()+"/Pan-Fried Tilapia.jpg",43.80));
		madisonRest.addNewProduct(new Product("Caprese Zoodles",writedef.getPath()+madisonRest.getRestaurantName()+"/Caprese Zoodles.jpg",18.00));
		madisonRest.addNewProduct(new Product("Tuscan Butter Roast Chicken",writedef.getPath()+madisonRest.getRestaurantName()+"/Tuscan Butter Roast Chicken.jpg",165));
		madisonRest.addNewProduct(new Product("Honey Garlic Glazed Salmon",writedef.getPath()+madisonRest.getRestaurantName()+"/Honey Garlic Glazed Salmon.jpg",75.50));
		madisonRest.addNewProduct(new Product("Zucchini Lattice Lasagna",writedef.getPath()+madisonRest.getRestaurantName()+"/Zucchini Lattice Lasagna.jpg",50));
		madisonRest.addNewProduct(new Product("Cauliflower Grilled Cheese",writedef.getPath()+madisonRest.getRestaurantName()+"/Cauliflower Grilled Cheese.jpg",26.75));
		madisonRest.addNewProduct(new Product("Baked Salmon",writedef.getPath()+madisonRest.getRestaurantName()+"/Baked Salmon.jpg",36.88));
		madisonRest.setRestaurantLocation("Michigan");
		Restaurant baranEv=new Restaurant("Baran Ev Yemekleri");
		baranEv.setImageLink(writedef.getPath()+baranEv.getRestaurantName()+"/Restaurant Image.jpg");
		baranEv.addNewProduct(new Product("Fýrýn Köfte",writedef.getPath()+baranEv.getRestaurantName()+"/Fýrýn Köfte.jpg",32.80));
		baranEv.addNewProduct(new Product("Lahana Sarmasý",writedef.getPath()+baranEv.getRestaurantName()+"/Lahana Sarmasý.jpg",23));
		baranEv.addNewProduct(new Product("Mantar Sote",writedef.getPath()+baranEv.getRestaurantName()+"/Mantar Sote.jpg",28.50));
		baranEv.addNewProduct(new Product("Karýsýk Menemen",writedef.getPath()+baranEv.getRestaurantName()+"/Karýsýk Menemen.jpg",23.75));
		baranEv.addNewProduct(new Product("Fanta (33 cl.)",writedef.getPath()+baranEv.getRestaurantName()+"/Fanta.jpg",5));
		baranEv.setRestaurantLocation("Ýstanbul");
		User.addNewUserToList(admin);
		User.addNewUserToList(new Owner("JohnForbesNash","annaJohn1978",UserType.OWNER,mc,1285250));
		User.addNewUserToList(new Owner("Tatlýcý Sefa","_-sefaSS23,",UserType.OWNER,dessert,86320));
		User.addNewUserToList(new Owner("BaranYenilmez","barki1982_ynlmz",UserType.OWNER,baranEv,128753.80));
		User.addNewUserToList(new Owner("Ms.Madison","madMadhealthy.,",UserType.OWNER,madisonRest,265804));
		User.addNewUserToList(c);
		User.addNewUserToList(c1);
		User.addNewUserToList(c2);
		User.addNewUserToList(c3);
		User.addNewUserToList(c4);
		write.writeAllUsers();
	}
}