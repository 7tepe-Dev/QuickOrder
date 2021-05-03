public class Product 
{
	//name of product
	private String productName;
	//image of product
	private String productImage;
	//price of product
	private double productPrice;
	public Product(String productName, /*String productImage,*/ double productPrice) 
	{
		this.productName = productName;
		//this.productImage = productImage;
		this.productPrice = productPrice;
	}
	public String getProductName() 
	{
		return productName;
	}
	public void setProductName(String productName) 
	{
		this.productName = productName;
	}
	public String getProductImage() 
	{
		return productImage;
	}
	public void setProductImage(String productImage) 
	{
		this.productImage = productImage;
	}
	public double getProductPrice() 
	{
		return productPrice;
	}
	public void setProductPrice(double productPrice) 
	{
		this.productPrice = productPrice;
	}
}