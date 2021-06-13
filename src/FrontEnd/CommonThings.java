package frontend;

import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JComponent;

public abstract class CommonThings 
{
	protected void addToContainer(Container container,JComponent component)
	{
		container.add(component);
		repaintANDrevalidate(container);
	}
	protected void repaintANDrevalidate(Component component)
	{
		component.repaint();
		component.revalidate();
	}
	protected void removeFromContainer(Container container,Component deleteMe)
	{
		container.remove(deleteMe);
		repaintANDrevalidate(container);
	}
	protected ImageIcon resizeImage(String imageLink,int width,int height) throws MalformedURLException
	{
		if(imageLink==null || imageLink.substring(imageLink.length()-4).equals("null"))
		{
			imageLink=getClass().getResource("/generalResources/noImageAvailable.jpg").toString();
		}
		URL imageURL=new URL(imageLink);
		ImageIcon image=new ImageIcon(imageURL);
		Image resizedImage=image.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
}