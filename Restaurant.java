import java.util.ArrayList;


public class Restaurant 
{
	//restaurant's name
	protected String restaurantName;
	//restaurant's logo
	protected String imageLink;
	//restaurant's all products 
	protected ArrayList<Product> allProducts;
	private ArrayList<Restaurant> allRestaurants;
	
	public Restaurant()
	{
		//buraya restaurant name ve image link eklenecek tabi
		allRestaurants.add(this);
	}
	//User bununla birlikte tüm restoranlarý listeler
	public ArrayList<Restaurant> getAllRestaurants()
	{
		return this.allRestaurants;
	}
	//Owner bunu çaðýrarak kendi restoranýný görüntüler.(elde eder).
	public Restaurant giveMyRestaurant()
	{
		return this;
	}
	public void addNewProduct(Product product)
	{
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