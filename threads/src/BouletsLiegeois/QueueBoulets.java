package BouletsLiegeois;

import java.util.ArrayList;
import java.util.List;

public class QueueBoulets {
	
	List<Integer> listeBoulets;
	private int tempsInit = 100;
	
	public QueueBoulets (int size) {
		this.listeBoulets = new ArrayList<Integer>(size);
		for(int i=0 ; i < size ; i++){
			listeBoulets.add(tempsInit);
		}
	}
	
	public synchronized int prendre() {
		while(listeBoulets.isEmpty()){
			try{
				wait();
			} catch (InterruptedException e) {}
		}
		int tempsRestant = listeBoulets.get(listeBoulets.size()-1); //prendre le top
		listeBoulets.remove(listeBoulets.size()-1);
		return tempsRestant;
	}
	
	public synchronized void deposer(int tempsRestant) {
		listeBoulets.add(tempsRestant); //déposer au top
		notifyAll();
	}
	
	public int size() {
		return listeBoulets.size();
	}

}
