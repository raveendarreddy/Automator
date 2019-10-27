package utility;

public class Utils 
{
	public static String getDirPath(String path) 
	{
		String value;
		String CurDir = System.getProperty("user.dir");
		value = CurDir+ path;
		System.out.println("User Dir Path: ---"+value);
		return value;
	}

}
