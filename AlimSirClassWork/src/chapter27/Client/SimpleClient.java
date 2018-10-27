package chapter27.Client;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class SimpleClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("127.0.0.1", 1254);
		InputStream socketIn= socket.getInputStream();
		DataInputStream dis= new DataInputStream(socketIn);
		String str= new String(dis.readUTF());
		System.out.println(str);
		dis.close();
		socketIn.close();
		socket.close();
		
	}
}
