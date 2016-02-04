package lifiTransmitter;

import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import model.Constant;
import model.ExitPacket;
import model.HelloPacket;
import model.NTPDate;
import model.Packet;
/**
 * LifiTransmitter is the class that represents the 
 * pure Lifi Li-1st device. It has start method which 
 * starts the communication process.
 * 
 * @author seyhan
 *
 */
public class LifiTransmitter
{
	/**
	 * Default Constructor
	 */
	public LifiTransmitter()
	{

	}
	///////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * 
	 */
	public void start() 
	{
		DatagramSocket Socket;
		/**
		 * Change dimming level before packet transmission
		 */
		changeDimming();
		////////////////////////////////////////////////////
		for (int i = 0; i < Constant.NUMBER_OF_PACKET; i++) 
		{
			try 
			{
				Socket = new DatagramSocket();
				InetAddress IPAddress = InetAddress.getByName(Constant.RECEIVER_IP);
				Packet packet = null;
				/////////////////////////////////////////////////////////////////////////////////////////
				//Get center PC date
				//Disable on CENTER PC !!! IMPORTANT
				long centerPCDate = new NTPDate().getNTPDate();
				//long centerPCDate = System.currentTimeMillis();
				//////////////////////////////////////////////////////////////
				if(i == Constant.NUMBER_OF_PACKET) packet = new ExitPacket();
				//Set transmit time
				else packet =  new HelloPacket(centerPCDate, 0, i, Constant.HELLO_PACKET);
				////////////////////////////////////////////////////////////////////////////////////////////
				ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
				ObjectOutputStream os = new ObjectOutputStream(outputStream);
				os.writeObject(packet);
				byte[] data = outputStream.toByteArray();
				DatagramPacket sendPacket = new DatagramPacket(data, data.length, IPAddress, 5004);
				Socket.send(sendPacket);
				System.out.println("Message Number:"+i+" sent to client");
				Thread.sleep(1000);
			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}
	}
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	/**
	 * changeDimming is used for connecting the Ceiling Unit and change
	 * the dim level to static value.
	 */
	public  void changeDimming() 
	{
		try 
		{
			/**
			 * Important point to mention
			 */
			/**Absolute path is needed.*/ //For error: 2 no file found exception.
			/**If any chmod u+x lifictl*/ //For error: 13 permission denied.
			/**lifictl -l5 192.168.0.1 : set dimming level to 5 on 192.168.0.1*/
			String dimLevel = "-l1";
			String[] command = new String[]{"/home/seyhan/workspaceEE/Transmitter/lifictl",dimLevel, Constant.LOCAL_IP};
			Runtime rt = Runtime.getRuntime();
			Process process = rt.exec(command);
			BufferedReader br = new BufferedReader(new InputStreamReader(process.getInputStream()));
			String line;
			try 
			{
				while ((line = br.readLine()) != null) 
				{
					System.out.println(line);
				}
			} catch (Exception ex) 
			{
				ex.printStackTrace();
			}
			br.close();
			System.out.println("Li-1st Device dimming level is set to: "+dimLevel);
			
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

}
