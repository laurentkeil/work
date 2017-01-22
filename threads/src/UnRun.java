
public class UnRun implements Runnable {
	
	private volatile boolean halt = false;
	
	public  void run() {
	      try {
	          while (!halt){
	        	  // traitements
	              System.out.println("Ligne affich�e par le thread unRun");
	              // petite sieste
	              Thread.sleep(2000) ;
	          }
	       }  catch (InterruptedException e) {
	          // nous avons �t� interrompu
	          // on remet interrupted � false par l'appel � cette m�thode
	    	   Thread.currentThread().interrupted() ;
	       }
	}
	
	public  void cancel() {
	       // interruption du thread courant, c'est-�-dire le n�tre
	      halt = true ;
	}
}
