package utility;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ElementControl 
{
	public static Properties OR; 
	
	public String getObjects(String string)   
	{	
		
		OR = new Properties();
		
		String ORPath = "";
		
		String propValue = "";
		
		try
		{
			ORPath = Utils.getDirPath("/src/main/java/repository/");			
			
			File file = new File(ORPath);

			File[] files = file.listFiles();
			for (int i = 0; i < files.length; i++) 
			{
				FileInputStream fs = new FileInputStream(files[i].getPath());
				OR.load(fs);
			}
			
			propValue = OR.getProperty(string);
			System.out.println("Retrived: --"+propValue);
			
		}catch(Exception e)
		{			
			System.out.println(e.getMessage());
			
		}
		return propValue;
		
		
	}
	

}
