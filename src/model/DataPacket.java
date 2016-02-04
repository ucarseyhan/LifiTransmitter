package model;

/**
 * 
 * DataPacket represent the packet sent over network
 * 
 * @author seyhan
 *
 */
public class DataPacket extends Packet  
{

	private static final long serialVersionUID = 1L;
	private String content;
	
	/**
	 * Default Constructor
	 */
	public DataPacket()
	{
		
	}
	/**
	 * Specialized Constructor
	 * 
	 * @param transmitTime
	 * @param receiveTime
	 * @param sequenceNumber
	 * @param packetType
	 * @param content
	 */
	public DataPacket(long transmitTime, long receiveTime, 
			int sequenceNumber, int packetType, String content) 
	{
		super(transmitTime, receiveTime, sequenceNumber, packetType);
		this.content = content;
	}

	/**
	 * @return the content
	 */
	public String getContent() 
	{
		return content;
	}

	/**
	 * @param content the content to set
	 */
	public void setContent(String content) 
	{
		this.content = content;
	}
	
	
	
	

}
