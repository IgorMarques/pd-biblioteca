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
	
	
}
