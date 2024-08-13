package genericUtility;

import java.sql.*;

import com.mysql.jdbc.Driver;

public class DatabaseUtility {
	
	FileUtility f=new FileUtility();
	ResultSet result=null;
	Connection con;
	
	
	
	public void getdbConnection() throws Throwable
	{
		try {
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			con=DriverManager.getConnection(f.getDataProperty("DBUrl"),f.getDataProperty("DB_Username"),f.getDataProperty("DB_Pass"));
			
		}catch(Exception e) {}
	}
	
	
	public void getCloseConnection()
	{
		try {
			con.close();
			
		}catch(Exception e) {}
	}
	
	
	public ResultSet getExcuteQuery(String query)
	{
		//ResultSet result=null;
		try {
			Statement stmt=con.createStatement();
			result=stmt.executeQuery(query);
			
		}catch(Exception e) {}
		return result;
	}
	
	
	public boolean verifyTheData(String query, int column, String expectedresult) throws SQLException
	{
		boolean flag=false;
		result=con.createStatement().executeQuery(query);
		while(result.next())
		{
			if(result.getString(column).equals(expectedresult))
			{
				flag=true;
				break;
			}
		}
		if(flag)
		{
			System.out.println(expectedresult+"=========== verified");
			return true;
			
		}else
		{
			System.out.println(expectedresult+"=========== not verified");
			return false;
		}
	
		
	}

}
