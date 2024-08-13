package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility {
	
	
	public String getDataProperty(String Key) throws Throwable
	{
		FileInputStream fs=new FileInputStream("./configure/data.properties");
        Properties op=new Properties();
        op.load(fs);
        String data =op.getProperty(Key);
        return data;
	}

}
