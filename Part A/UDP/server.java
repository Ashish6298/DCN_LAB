import java.io.*;
import java.net.*;

class server {
	public static void main(String args[]) throws Exception {
		DatagramSocket serversocket = new DatagramSocket(9876);
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		byte[] receivedData = new byte[1024];
		byte[] sendData = new byte[1024];
		DatagramPacket receivePacket = new DatagramPacket(receivedData, receivedData.length);
		serversocket.receive(receivePacket);
		String sentence = new String(receivePacket.getData());
		System.out.println("RECIEVED :" + sentence);
		InetAddress IPaddress = receivePacket.getAddress();
		int port = receivePacket.getPort();
		System.out.println("enter the message");
		String data = br.readLine();
		sendData = data.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPaddress, port);
		serversocket.send(sendPacket);
		serversocket.close();

	}
}
