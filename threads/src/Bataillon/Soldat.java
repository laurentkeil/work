package Bataillon;

import java.util.List;

import BouletsLiegeois.QueueBoulets;

public class Soldat extends Thread {

	private QueuePoints queuePoints;
	private int id;
	private int tempsMove = 300;
	private volatile boolean halte = false;
	private Double[] dist;
	
	public Soldat (int id, QueuePoints queuePoints) {
		this.id = id;
		this.queuePoints = queuePoints;
		dist = new Double[2];
		this.dist[0] = 1.5; 
		this.dist[1] = 2.0; 
	}
	
	public void run() {
		while(!halte) {
			queuePoints.move(dist, id); //se déplace d'une distance dist = produce
			System.out.println(id + "move");
			try{
				sleep(tempsMove);
			} catch (InterruptedException e) {}
		}
	}
	
	public void move(Double[] dist){
		this.dist[0] = dist[0]; 
		this.dist[1] = dist[1]; 
	}
}
