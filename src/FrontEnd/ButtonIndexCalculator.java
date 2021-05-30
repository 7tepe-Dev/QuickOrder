package frontend;

import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JFrame;

public abstract class ButtonIndexCalculator 
{
	
	public int calculateButtonIndex(String source,int startY,int diffBetweenButtons)
	{
		int startIndex=0;
		int finishIndex=0;
		int count=0;
		int tester=0;
		for(int i=0;i<source.length();i++)
		{
			if(source.charAt(i)==',')
			{
				count++;
			}
			if(count==2 && tester==0)
			{
				startIndex=i+1;
				tester=5;
			}
			if(count==3)
			{
				finishIndex=i-1;
				break;
			}
		}
		int num=Integer.parseInt(source.substring(startIndex,finishIndex+1));
		int buttonIndex=0;
		int temp=startY;
		if(num==temp)
		{
			return buttonIndex;
		}
		while(temp<num)
		{
			temp+=diffBetweenButtons;
			buttonIndex++;
		}
		return buttonIndex;
	}
	protected ImageIcon resizeImage(String imageLink,int width,int height)
	{
		ImageIcon image=new ImageIcon(imageLink);
		Image resizedImage=image.getImage().getScaledInstance(width,height,Image.SCALE_SMOOTH);
		return new ImageIcon(resizedImage);
	}
	
}