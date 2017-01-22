
public class UnRun implements Runnable {
	
	private volatile boolean halt = false;
	
	public  void run() {
	      try {
	          while (!halt){
	        	  // traitements
	              System.out.println("Ligne affichée par le thread unRun");
	              // petite sieste
	              Thread.sleep(2000) ;
	          }
	       }  catch (InterruptedException e) {
	          // nous avons été interrompu
	          // on remet interrupted à false par l'appel à cette méthode
	    	   Thread.currentThread().interrupted() ;
	       }
	}
	
	public  void cancel() {
	       // interruption du thread courant, c'est-à-dire le nôtre
	      halt = true ;
	}
}
