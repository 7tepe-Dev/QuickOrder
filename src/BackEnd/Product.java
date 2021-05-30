package backend;

import java.awt.Image;

import javax.swing.ImageIcon;

public class Product 
{
	
	//name of product
	private String productName;
	//image of product
	private String productImage;
	//price of product
	private double productPrice;
	public Product(String productName, double productPrice) 
	{
		this.productName = productName;
		this.productPrice = productPrice;
		this.productImage="C:\\Users\\Calky\\Desktop\\noImageAvailable.jpg";
	}
	public Product(String productName, String productImage, double productPrice) 
	{
		this.productName = productName;
		this.productImage = productImage;
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
	public ImageIcon getDirectImage()
	{
		ImageIcon image=new ImageIcon(this.productImage);
		Image changedImage=image.getImage().getScaledInstance(90,90,java.awt.Image.SCALE_SMOOTH);
		image=new ImageIcon(changedImage);
		return image;
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