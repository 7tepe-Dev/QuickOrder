package BackEnd;

import java.util.ArrayList;


public class Restaurant 
{
	//restaurant's name
	private String restaurantName;
	//restaurant's logo
	private String imageLink;
	//restaurant's all products 
	private ArrayList<Product> allProducts=null;
	private static ArrayList<Restaurant> allRestaurants;
	
	//for not default restaurants empty constructor 
	public Restaurant()
	{
		//buraya restaurant name ve image link eklenecek tabi
		if(allRestaurants==null)
		{
			allRestaurants=new ArrayList<Restaurant>();
		}
		allRestaurants.add(this);
	}
	//for default restaurants
	public Restaurant(String restaurantName,ArrayList<Product> allProducts)
	{
		this.restaurantName=restaurantName;
		this.allProducts=allProducts;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink) {
		this.imageLink = imageLink;
	}
	//User bununla birlikte tüm restoranlarý listeler
	public static ArrayList<Restaurant> getAllRestaurants()
	{
		return allRestaurants;
	}
	//Owner bunu çaðýrarak kendi restoranýný görüntüler.(elde eder).
	/*public Restaurant giveMyRestaurant()
	{
		return this;
	}*/
	public void addNewProduct(Product product)
	{
		if(allProducts==null)
		{
			allProducts=new ArrayList<Product>();
		}
		allProducts.add(product);
		//we need to display products after adding or removing products
	}
	public void removeProduct(int index)
	{
		allProducts.remove(index);
		//we need to display products after adding or removing products
	}
	//we will use this for displaying all products in this restaurant
	public ArrayList<Product> getAllProducts()
	{
		return this.allProducts;
	}
}