import java.util.ArrayList;

public class Restaurant 
{
	String restaurantName;
	String imageLink;
	ArrayList<Product> allProducts;
	
	
	public void addNewProduct(Product product)
	{
		allProducts.add(product);
	}
	
}
