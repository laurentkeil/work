package BouletsLiegeois;

import java.util.List;

public class Philo implements Runnable {
	
	private List<QueueBoulets> queuesBoulets;
	private int id;
	private int tempsManger = 50;
	private int tempsRechauffer = 10;
	private volatile boolean halte = false;
	
	public Philo (int id, List<QueueBoulets> queuesBoulets) {
		this.id = id;
		this.queuesBoulets = queuesBoulets;
	}
	
	public void run() {
		while(!halte) {
			System.out.println("Taille stock " + id + " : " + queuesBoulets.get(id).size());
			int tempsRestant = queuesBoulets.get(id).prendre(); //prendre un boulet = consume
			System.out.println("boulet pris dans stock " + id);
			if(tempsRestant == 0) {
				System.out.println("mange le boulet " + id);
				try{
					Thread.sleep(tempsManger);
				} catch (InterruptedException e) {}
			} else {
				System.out.println("r�chauffe le boulet " + id);
				try{
					Thread.sleep(tempsRechauffer);
				} catch (InterruptedException e) {}
				tempsRestant = tempsRestant - tempsRechauffer;
				if(tempsRestant < 0) tempsRestant = 0;
				queuesBoulets.get((id+1)%queuesBoulets.size()).deposer(tempsRestant); //d�poser un boulet = produce
				System.out.println("boulet depos� dans stock " + (id+1)%queuesBoulets.size());
			}
		}
	}
	
	public void stopAll(){
		this.halte = true; 
	}

}
