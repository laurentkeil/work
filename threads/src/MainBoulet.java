
public class MainBoulet {

	public static void main (String[] args) {
		
		int nbrPhilos = 5;
		int nbrBoulets = 3;
		
		Table table = new Table(nbrBoulets);
		
		Thread[] philos = new Thread[nbrPhilos];
	    
		for(int i=0 ; i < philos.length ; i++ ){
			philos[i] = new Thread (new Philo(i, nbrPhilos, table));
			philos[i].start();
		}

		for(int i=0 ; i < philos.length ; i++ ){
			try {
				philos[i].join();	
			} catch (InterruptedException e){
				e.printStackTrace();
			}
		}
		
		System.out.println("fin");
		
	}
	
}
