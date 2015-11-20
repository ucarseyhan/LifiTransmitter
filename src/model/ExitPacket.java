package model;

public class ExitPacket  extends Packet 
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public ExitPacket()
	{
		super();
	}

	public ExitPacket(long transmitTime, long receiveTime, int sequenceNumber,int packetType) 
	{
		super(transmitTime, receiveTime, sequenceNumber, packetType);
	}

	
}
