package network.layer;

import java.io.Serializable; //indica que os objetos da classe podem vem de um fluxo de dados (rede, no caso)

public class Message implements Serializable{
	
	private char actor; //ator que enviou a mensagem
	private String command; //comando contido na mensagem
	private String[] params; //par‰metros passados com o comando
	
	//construtor
	public Message(char actor, String command, String...params){
		this.actor = actor;
		this.command = command;
		this.params = params;
	}
	
	public String getCommand() {
		return command;
	}

	public String[] getParams(){
		return params;
	}
	
	public void setCommand(String command) {
		this.command = command;
	}
	
	public static Message stringToMessage(String string){//transforma um string em um objeto mensagem
		String[] split = string.split(":");
		
		String actor  = split[0];
		String command  = split[1];
		String[] params = new String[split.length-2];
		
		for(int i=2; i < split.length; i++){
			 params [i-2]= split[i];
		}
			
		return new Message(actor.charAt(0), command, params);
		
	}

	public String toString(){ //transforma um objeto mensagem em um string
		String msg = command;
		
		for (String p: params){
			msg +=  ":" + p;
		}
		
		return msg;
	}
	
}
