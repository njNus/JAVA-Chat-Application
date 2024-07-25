package twinky;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.ArrayList;



public class ClientHandler implements Runnable{

	public static ArrayList<ClientHandler>c = new ArrayList<>();
	private Socket socket;
	private BufferedReader bufferedReader;
	private BufferedWriter bufferedWriter;
	private String client;
	
	public ClientHandler(Socket socket) {
		try {
			this.socket = socket;
			this.bufferedWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			this.bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			this.client = bufferedReader.readLine();
			c.add(this);
			broadcastMessage("new client has joined the chat");
			
			
		}catch(IOException e) {
			closeEverything(socket,bufferedReader,bufferedWriter);
		}
	}
	public void run() {
		String msgFrmClnt;
		
		while(socket.isConnected()) {
			try {
				msgFrmClnt = bufferedReader.readLine();
				broadcastMessage(msgFrmClnt);
			}catch(IOException e) {
				closeEverything(socket,bufferedReader,bufferedWriter);
				break;
				
			}
		}
	}
	public void broadcastMessage(String msgToSend) {
		for(ClientHandler c:c) {
			try {
				if(!c.client.equals(client)) {
					c.bufferedWriter.write(msgToSend+"\n");
					c.bufferedWriter.flush();
				}
			}catch(IOException e) {
				closeEverything(socket,bufferedReader,bufferedWriter);
			}
		}
	}
	
	public void removeClientHandler() {
		c.remove(this); 
		//broadcastMessage("Server: "+client+" has left the chat");
	}
	public void closeEverything(Socket s, BufferedReader b,BufferedWriter w) {
		removeClientHandler();
		try {
			if(b != null) {
				b.close();
			}
			if(w!= null) {
				w.close();
			}
			if(s!= null) {
				s.close();
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}


