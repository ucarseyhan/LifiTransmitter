package model;

public class HelloPacket extends Packet 
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Default COnstructor.
	 */
	public HelloPacket()
	{
		super();
	}

	/**
	 * Parameterized COnstructor
	 * @param transmitTime
	 * @param receiveTime
	 * @param sequenceNumber
	 * @param packetType
	 */
	public HelloPacket(long transmitTime, long receiveTime, int sequenceNumber, int packetType) 
	{
		super(transmitTime, receiveTime, sequenceNumber, packetType);
	}
	
	

}
