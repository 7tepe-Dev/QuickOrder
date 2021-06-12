package backend;


import java.util.ArrayList;
public class Restaurant
{
	private String restaurantName;
	private String imageLink;
	private String restaurantLocation;
	private ArrayList<Product> allProducts=null;
	private static ArrayList<Restaurant> allRestaurants;
	
	public Restaurant(String restaurantName)
	{
		this.restaurantName=restaurantName;		
		if(allRestaurants==null)
		{
			allRestaurants=new ArrayList<Restaurant>();
		}
		if(allProducts==null)
		{
			allProducts=new ArrayList<Product>();
		}
		imageLink=getClass().getResource("/generalResources/noImageAvailable.jpg").toString();
		allRestaurants.add(this);
	}
	public Restaurant(String restaurantName,ArrayList<Product> allProducts,String restaurantLocation,String imageLink)
	{
		this.restaurantName=restaurantName;
		this.restaurantLocation=restaurantLocation;
		this.allProducts=allProducts;
		this.imageLink=imageLink;
	}
	public String getRestaurantName() {
		return restaurantName;
	}
	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
	public String getRestaurantLocation() {
		return this.restaurantLocation;
	}
	public void setRestaurantLocation(String restaurantLocation) {
		this.restaurantLocation = restaurantLocation;
	}
	public String getImageLink() {
		return imageLink;
	}
	public void setImageLink(String imageLink){
		this.imageLink = imageLink;
	}
	public static ArrayList<Restaurant> getAllRestaurants()
	{
		return allRestaurants;
	}
	public void addNewProduct(Product product)
	{
		allProducts.add(product);
	}
	public void removeProduct(int index)
	{
		allProducts.remove(index);
	}
	public ArrayList<Product> getAllProducts()
	{
		return this.allProducts;
	}
}