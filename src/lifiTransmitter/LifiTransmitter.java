package lifiTransmitter;

import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import model.Constant;
import model.ExitPacket;
import model.HelloPacket;
import model.Packet;

public class LifiTransmitter
{

	public LifiTransmitter()
	{

	}

	public void start() 
	{
		DatagramSocket Socket;
		for (int i = 0; i < 1000; i++) 
		{
			try 
			{
				Socket = new DatagramSocket();
				InetAddress IPAddress = InetAddress.getByName(Constant.RECEIVER_IP);
				Packet packet = null;
				if(i == 1000) packet = new ExitPacket();
				else packet =  new HelloPacket(System.currentTimeMillis(), 0, i, Constant.HELLO_PACKET);
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				ObjectOutputStream os = new ObjectOutputStream(outputStream);
				os.writeObject(packet);
				byte[] data = outputStream.toByteArray();
				DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 5004);
				Socket.send(sendPacket);
				System.out.println("Message sent from client");

				Thread.sleep(Constant.PERIOD);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}


	}

}
