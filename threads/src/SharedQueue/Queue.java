package SharedQueue;

import java.util.ArrayList;
import java.util.List;

public class Queue {
	
	protected List<String> messages;
	
	public Queue() {
		messages = new ArrayList<String>();
	}
	
	synchronized public void add(String message) {
		System.out.println(message + " added");
		messages.add(message);
		notifyAll();
	}
	
	synchronized public String get() throws InterruptedException {
		// Attendre qu'il y ait au moins un message
		while (messages.size() <= 0) {
			this.wait();
		}	
		
		// Récupérer le message puis le retirer de la file d'attente
		String message = messages.get(0); // FIFO
		messages.remove(0);
		
		// Renvoyer le message
		return message;
	}
	
}
