package BouletsLiegeois;

import java.util.ArrayList;
import java.util.List;

public class Table {

	public static void main(String[] args){
		
		int nbrPhilos = 5;
		int nbrBoulets = 3;
		
		List<QueueBoulets> queuesBoulets = new ArrayList<QueueBoulets>();
		for(int i = 0 ; i < nbrPhilos ; i++){
			QueueBoulets q = new QueueBoulets(nbrBoulets);
			queuesBoulets.add(q);
		}
		
		List<Thread> philos = new ArrayList<Thread>();
		
		for(int i = 0 ; i < nbrPhilos ; i++){
			Philo p = new Philo(i, queuesBoulets);
			Thread ph = new Thread(p);
			ph.start();
			philos.add(ph);
			System.out.println(ph.getName() + " created");
		}
		
		for(int i = 0 ; i < nbrPhilos ; i++){
			try {
				philos.get(i).join();
				System.out.println(i + " stop");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("fin");
		
	}
	
}
