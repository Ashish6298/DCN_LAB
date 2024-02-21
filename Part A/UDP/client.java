import java.io.*;
import java.net.*;

class client {
	public static void main(String args[]) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		DatagramSocket clientsocket = new DatagramSocket();
		InetAddress IPaddress = InetAddress.getByName("localhost");
		byte[] sendData = new byte[1024];
		byte[] recieveData = new byte[1024];
		String sentence = "hello server";
		sendData = sentence.getBytes();
		DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPaddress, 9876);
		clientsocket.send(sendPacket);
		DatagramPacket receivePacket = new DatagramPacket(recieveData, recieveData.length);
		clientsocket.receive(receivePacket);
		String modifiedsentence = new String(receivePacket.getData());
		System.out.println("from server " + modifiedsentence);
		clientsocket.close();
	}
}