package backend;


import java.math.BigDecimal;
import java.util.HashMap;


public class Order 
{
	
	private static HashMap<Product,Integer> allOrders=new HashMap<Product,Integer>();
	public void addNewOrder(Product product)
	{
		if(allOrders.containsKey(product))
		{
			allOrders.replace(product,allOrders.get(product)+1);
		}
		else
		{
			allOrders.put(product,1);
		}
	}
	public void deleteOneOrder(Product product)
	{
		if(allOrders.get(product)>0)
		{
			allOrders.replace(product,allOrders.get(product)-1);
		}
		else
		{
			allOrders.remove(product);
		}
	}
	public double calculateTotalPrice()
	{
		BigDecimal totalPrice=BigDecimal.ZERO;
		BigDecimal addThis=BigDecimal.ZERO;
		for(Product product:allOrders.keySet())
		{
			System.out.println(allOrders.get(product)+" tane "+product.getProductName());
			Double temp=allOrders.get(product)*product.getProductPrice();
			addThis=BigDecimal.valueOf(temp);
			totalPrice=totalPrice.add(addThis);
		}
		return totalPrice.doubleValue();
	}
}	