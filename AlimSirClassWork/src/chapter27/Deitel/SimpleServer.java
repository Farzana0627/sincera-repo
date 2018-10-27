package chapter27.Deitel;

import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class SimpleServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server= new ServerSocket(1254);
		Socket socket= server.accept();
		OutputStream socketOut= socket.getOutputStream();
		DataOutputStream dos = new DataOutputStream(socketOut);
		dos.writeUTF("Hello!");
		dos.close();
		socketOut.close();
		socket.close();
	}
		
}
