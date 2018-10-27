package chapter27.Deitel;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;


public class ServerClientUDP {
	private DatagramSocket socket;
		public ServerClientUDP() throws IOException
		{
			socket= new DatagramSocket(2000);
			
		}
		public void sendPacketToClient(DatagramPacket receivePacket) throws IOException
		{
			DatagramPacket sendPacket= new DatagramPacket(receivePacket.getData(), receivePacket.getLength(), receivePacket.getAddress(), receivePacket.getPort());
			socket.send(sendPacket);
		}
		public void receivePacketFromClient() throws IOException
		{
			byte[] data= new byte[100];
			DatagramPacket receivePacket= new DatagramPacket(data, data.length);
			socket.receive(receivePacket);
			sendPacketToClient(receivePacket);
		}
		
		

}
