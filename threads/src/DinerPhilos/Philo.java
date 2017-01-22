package DinerPhilos;

public class Philo extends Thread {
	
	private int id;
	private Fourchettes listeFourchettes;
	private volatile boolean halte = false;
	private int tempsPenser = 100;
	private int tempsManger = 450;
	private int tempsPourFinir = 1500;
	
	public Philo(int id, Fourchettes listeFourchettes){
		this.id = id;
		this.listeFourchettes = listeFourchettes;
	}
	
	public void run() {
		int ntry = 0;
		while(tempsPourFinir >= 0) {
			
			try {
				sleep(tempsPenser);
			} catch (InterruptedException e){}
			listeFourchettes.prendre(id);
			try {
				sleep(tempsManger);
				ntry++;
				System.out.println(id + " a mangé pour la " + ntry + "e fois");
				tempsPourFinir = tempsPourFinir - tempsManger;
			} catch (InterruptedException e){}
			listeFourchettes.deposer(id);
			
		}
	}
	
	public void die(){
		this.halte = tempsPourFinir == 0; 
	}

}
