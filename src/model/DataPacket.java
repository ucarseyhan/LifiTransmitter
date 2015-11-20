package model;

public class DataPacket extends Packet  
{

	private static final long serialVersionUID = 1L;
	
	private String content;
	
	public DataPacket()
	{
		
	}

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
