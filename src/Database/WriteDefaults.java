package Database;


import BackEnd.*;
import BackEnd.User.userType;

public class WriteDefaults 
{
	public static void WriteDefaultUsers()
	{
		WriteData write = new WriteData();
		WriteData.userList.clear();
		
//admin
		Admin admin=Admin.createOrGetAdmin();
		
//customers
		Customer c=new Customer("AdamBlack","7741abab52.",userType.CUSTOMER,850,"New York");
		write.writeCustomerData("AdamBlack", "7741abab52.", 850);
		
		Customer c1=new Customer("fatihYenilmez","1923fatih,",userType.CUSTOMER,200,"Ýstanbul");
		write.writeCustomerData("fatihYenilmez", "1923fatih.", 200);
		
		Customer c2=new Customer("Jonathan43","_JJJ43",userType.CUSTOMER,1500,"London");
		write.writeCustomerData("Jonathan43", "_JJJ43.", 1500);
		
		Customer c3=new Customer("HakkýTastepe","hakký1234",userType.CUSTOMER,50,"Ankara");
		write.writeCustomerData("HakkýTastepe", "hakký1234.", 50);
		
		Customer c4=new Customer("Meryem_bilen","19/03/2019",userType.CUSTOMER,400,"Ýstanbul");
		write.writeCustomerData("Meryem_bilen", "19/03/2019", 400);
		
//Owners
		Restaurant evy=new Restaurant("Baran Ev Yemekleri");
		Owner o1=new Owner("BaranYýlmaz","baranYelda123",userType.OWNER,evy,45000);
		evy.setRestaurantLocation("Istanbul");
		write.writeOwnerData("JohnForbesNash", "annaJohn1978");
		write.writeRestaurantForOwner("JohnForbesNash", "Baran Ev Yemekleri", 185250);
		
		Product p1=new Product("Fýrýn Köfte",12);		
		write.writeProductForRestaurant("BaranYýlmaz", "Fýrýn Köfte", 12);
		Product p2=new Product("Lahana Sarmasý",15);		
		write.writeProductForRestaurant("BaranYýlmaz", "Fýrýn Köfte", 12);
		Product p3=new Product("Fanta (33 cl.)",5);		
		write.writeProductForRestaurant("BaranYýlmaz", "Fýrýn Köfte", 12);
		Product p4=new Product("Mantar Sote",10);	
		write.writeProductForRestaurant("BaranYýlmaz", "Fýrýn Köfte", 12);
		Product p5=new Product("Karýsýk Menemen",17);
		
		evy.addNewProduct(p1);
		evy.addNewProduct(p2);
		evy.addNewProduct(p3);
		evy.addNewProduct(p4);
		evy.addNewProduct(p5);
		
//************************************************************************************************************		
		Restaurant mc=new Restaurant("McDonald’s");
		Owner o2=new Owner("JohnForbesNash","annaJohn1978",userType.OWNER,mc,45000);
		mc.setRestaurantLocation("Washington");
		write.writeOwnerData("JohnForbesNash", "annaJohn1978");
		write.writeRestaurantForOwner("JohnForbesNash", "McDonald’s", 45000);
		
		Product pmc=new Product("Double Quarter Pounder",30.99);
		write.writeProductForRestaurant("JohnForbesNash", "Double Quarter Pounder", 12);
		Product pmc1=new Product("Double McChicken",21.99);
		write.writeProductForRestaurant("JohnForbesNash", "Double McChicken", 12);
		Product pmc2=new Product("Big Mac™",21.99);
		write.writeProductForRestaurant("JohnForbesNash", "Big Mac™", 12);
		Product pmc3=new Product("Chicken McNuggets®",12.99);
		write.writeProductForRestaurant("JohnForbesNash", "Chicken McNuggets®", 12);
		Product pmc4=new Product("Coca-Cola",6.75);		
		write.writeProductForRestaurant("JohnForbesNash", "Coca-Cola", 12);
		
		mc.addNewProduct(pmc);
		mc.addNewProduct(pmc1);
		mc.addNewProduct(pmc2);
		mc.addNewProduct(pmc3);
		mc.addNewProduct(pmc4);
		

//************************************************************************************************************		
		Restaurant xd=new Restaurant("Tatlý Yiyelim");
		Owner o3=new Owner("_selinIsbilen.","sseelliinn__",userType.OWNER,xd,80533);
		xd.setRestaurantLocation("Ankara");
		write.writeOwnerData("_selinIsbilen.", "sseelliinn__");
		write.writeRestaurantForOwner("_selinIsbilen.", "Tatlý Yiyelim", 80533);
		
		Product p10=new Product("Kakao Bisküvili Mag",11.70);
		write.writeProductForRestaurant("_selinIsbilen.", "Kakao Bisküvili Mag", 11.70);
		Product p11=new Product("Profiterol",16);
		write.writeProductForRestaurant("_selinIsbilen.", "Profiterol", 16);
		Product p12=new Product("Lotus Cup",12.65);
		write.writeProductForRestaurant("_selinIsbilen.", "Lotus Cup", 12.65);
		Product p13=new Product("Orman Meyveli Cheesecake",14.85);
		write.writeProductForRestaurant("_selinIsbilen.", "Orman Meyveli Cheesecake", 14.85);
		Product p14=new Product("Oreolu Trileçe",10.45);
		write.writeProductForRestaurant("_selinIsbilen.", "Oreolu Trileçe", 10.45);
		Product p15=new Product("Naneli Limonata",7.15);
		write.writeProductForRestaurant("_selinIsbilen.", "Naneli Limonata", 7.15);
		
		xd.addNewProduct(p10);
		xd.addNewProduct(p11);
		xd.addNewProduct(p12);
		xd.addNewProduct(p13);
		xd.addNewProduct(p14);
		xd.addNewProduct(p15);
		
//************************************************************************************************************		
		User.addNewUserToList(admin);
		User.addNewUserToList(c);
		User.addNewUserToList(c1);
		User.addNewUserToList(c2);
		User.addNewUserToList(c3);
		User.addNewUserToList(c4);
		User.addNewUserToList(o1);
		User.addNewUserToList(o2);
		User.addNewUserToList(o3);
		
		DataHandler.writeDataToJSON();

	}
}