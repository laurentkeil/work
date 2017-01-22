package DinerPhilos;

import java.util.ArrayList;
import java.util.List;

public class Table {

	public static void main (String[] args){
		
		int nbrPhilos = 5;
		Fourchettes listeFourchettes = new Fourchettes(nbrPhilos);
		List<Philo> listePhilos = new ArrayList<Philo>();
		
		for(int i=0 ; i < nbrPhilos ; i++){
			Philo ph = new Philo(i, listeFourchettes);
			ph.start();
			listePhilos.add(ph);
			System.out.println(ph.getName() + " created");
		}
		
		for(int i = 0 ; i < nbrPhilos ; i++){
			try {
				listePhilos.get(i).join();
				System.out.println(i + " stop");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("fin");
		
	}
	
}
