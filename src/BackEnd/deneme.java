import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.json.simple.JSONObject;
public class deneme 
{
	static String path=System.getProperty("user.dir");
	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		JSONObject h=new JSONObject();
		String k=null;
		h.put("sads","selamke");
		h.put("kopkevarmi",k);
		try(FileWriter file = new FileWriter("deneme.json"))
		{
			file.write(h.toString());
			file.flush();
			System.out.println("Customer's data saved");
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}

	}
}