package model;
import java.io.Serializable;
/**
 * Packet is used for representing the super class
 * of Packet. It contains the necessary attributed 
 * for performance evaluation
 * 
 * @author seyhan
 *
 */
public class Packet implements Serializable,Transmittable 
{

	private static final long serialVersionUID = 1L;
	
	//Attributes
	private long transmitTime;
	private long receiveTime;
	private int sequenceNumber;
	private int packetType;
	
	/**
	 * Default Constructor
	 */
	public Packet() 
	{
	}
	
	/**
	 * Specialized Constructor
	 * 
	 * @param transmitTime
	 * @param receiveTime
	 * @param sequenceNumber
	 * @param packetType
	 */
	public Packet(long transmitTime, long receiveTime, int sequenceNumber, int packetType) 
	{
		super();
		this.transmitTime = transmitTime;
		this.receiveTime = receiveTime;
		this.sequenceNumber = sequenceNumber;
		this.packetType = packetType;
	}

	/**
	 * @param transmitTime the transmitTime to set
	 */
	public void setTransmitTime(long transmitTime) 
	{
		this.transmitTime = transmitTime;
	}

	/**
	 * @param receiveTime the receiveTime to set
	 */
	public void setReceiveTime(long receiveTime) 
	{
		this.receiveTime = receiveTime;
	}

	/**
	 * @param sequenceNumber the sequenceNumber to set
	 */
	public void setSequenceNumber(int sequenceNumber) 
	{
		this.sequenceNumber = sequenceNumber;
	}

	/**
	 * @param packetType the packetType to set
	 */
	public void setPacketType(int packetType) 
	{
		this.packetType = packetType;
	}

	@Override
	public long getTransmitTime() 
	{
		return transmitTime;
	}
	@Override
	public long getReceiveTime() 
	{
		return receiveTime;
	}
	@Override
	public int getSequenceNumber() 
	{
		return sequenceNumber;
	}
	@Override
	public int getPacketType() 
	{
		return packetType;
	}
	@Override
	public int getPacketSize() 
	{
		return 0;
	}
	


}
