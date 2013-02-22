package network.layer;

public abstract class StreamManager implements Runnable{ //abstract pois nunca ser‡ instanciado e runnable devido a concorrencia

	public abstract void openConnection(); 
	public abstract void sendMessage(Message message);
	public abstract void closeConnection();
	
	private MessageReceiver messageReceiver;
	
	public MessageReceiver getMessageReceiver() {
		return messageReceiver;
	}
	
	public void setMessageReceiver(MessageReceiver messageReceiver) {
		this.messageReceiver = messageReceiver;
	}
	
}
