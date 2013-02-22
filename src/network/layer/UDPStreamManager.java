package network.layer;

import java.io.IOException; //erros de entrada de dados
import java.net.DatagramPacket; //UDP
import java.net.DatagramSocket; //UDP
import java.net.SocketException;

public class UDPStreamManager extends StreamManager{
	
	private byte[] msg;
	private DatagramSocket socket;
	
	public UDPStreamManager(DatagramSocket socket, int maxmsgSize){
		msg = new byte[maxmsgSize];
		this.socket = socket;
	}

	@Override
	public void run() {
		try {
			DatagramPacket packet = new DatagramPacket(msg, msg.length);
			
			socket.receive(packet);
			
			this.getMessageReceiver().messageReceived(
					Message.stringToMessage(packet.getData().toString()));
		} catch (SocketException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void openConnection() {
		// UDP n‹o tem necessidade de conex‹o
		
	}

	@Override
	public void sendMessage(Message message) {
		byte[] msg = message.toString().getBytes();;
		
		DatagramPacket packet = new DatagramPacket(msg, msg.length);
		
		try {
			socket.send(packet);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void closeConnection() {
		// UDP n‹o tem necessidade de conex‹o
		
	}

}
