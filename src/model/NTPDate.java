package model;

import java.net.InetAddress;
import org.apache.commons.net.ntp.NTPUDPClient;
import org.apache.commons.net.ntp.TimeInfo;

/**
 * 
 * @author seyhan
 * NTPDate class is used for synchronizing the time difference 
 * between the computers. The center computer time is used for 
 * time comparison.
 * 
 */
public class NTPDate 
{
	//Attribute
	private long currentDate;
	
	/**
	 * Default Constructor
	 */
	public NTPDate()
	{
		
	}
	////////////////////////////////////////////////////////////////////////////////
	/**
	 * getNTPDate is used for getting the center PC
	 * date and synchronize current PC time.
	 * @return center PC date
	 */
	public long getNTPDate()
	{
		try 
		{
	        NTPUDPClient timeClient = new NTPUDPClient();
	        InetAddress inetAddress = InetAddress.getByName(Constant.CENTER_PC_IP);
	        TimeInfo timeInfo = timeClient.getTime(inetAddress);
	        currentDate = timeInfo.getReturnTime();
	      
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		return currentDate;
	}
	/////////////////////////////////////////////////////////////////////////////
	
	
}
