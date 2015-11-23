package model;
/**
 * Exit Packet represents the exit packet when 
 * the termination occurs.
 * 
 * @author seyhan
 *
 */
public class ExitPacket  extends Packet 
{
	private static final long serialVersionUID = 1L;
	/**
	 * Default Constructor
	 */
	public ExitPacket()
	{
		super();
	}
	/**
	 * Specified Constructor
	 * 
	 * @param transmitTime
	 * @param receiveTime
	 * @param sequenceNumber
	 * @param packetType
	 */
	public ExitPacket(long transmitTime, long receiveTime, int sequenceNumber,int packetType) 
	{
		super(transmitTime, receiveTime, sequenceNumber, packetType);
	}

	
	
}
