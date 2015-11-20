package model;
/*********************************
 * Transmittable is interface where
 * all transmittable packet.
 *
 ********************************/
public interface Transmittable 
{
	public long getTransmitTime();
	public long getReceiveTime();
	public int  getSequenceNumber();
	public int  getPacketType();
	public int  getPacketSize();
}
