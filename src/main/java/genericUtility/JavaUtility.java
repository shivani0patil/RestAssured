package genericUtility;


import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
	
	
	public int random()
	{
		Random r=new Random();
		int num=r.nextInt(1000);
		return num ;
	}
	
	public String getSystemStartDate()
	{
		Date date=new Date();
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-mm-dd");
		String data=sim.format(date);
		
		return data;
	}
	public String getRequiredDate(int days)
	{
		SimpleDateFormat sim=new SimpleDateFormat("yyyy-mm-dd");
       Calendar cal=sim.getCalendar();
       cal.add(Calendar.DAY_OF_MONTH, days);
       String enddata=sim.format(cal.getTime());
       return enddata;
	}

}
