package network.layer;

import java.io.IOException; //erros de entrada de dados
import java.io.ObjectOutputStream; //streaming de dados 
import java.net.Socket; //socket

public class TCPStreamManager extends StreamManager{
	
	private ObjectOutputStream outStream;
	private Socket socket;
	
	public TCPStreamManager(Socket socket) throws IOException{
		this.socket = socket;
	}

	@Override
	public void run() {
		//falta fazer
	}

	@Override
	public void openConnection() {
		try {
			outStream = new ObjectOutputStream(socket.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void sendMessage(Message message) {
		try {
			outStream.writeObject(message); //escreve objeto msg	
			outStream.flush(); //envia o objeto
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	@Override
	public void closeConnection() {
		try {
			outStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

}
