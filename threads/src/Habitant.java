

public class Habitant implements Runnable {
	
	// construction de notre unique chaudiere
	final Chaudiere chaudiere =  new Chaudiere() ;
	 
	public  void run() {
		   
	       // chaque habitant possède son propre thermostat
	      Thermostat thermostat =  new Thermostat(chaudiere) ;

	       int nTry =  0 ;
	       do {
	         
	          // il demande a monter la temperature
	         thermostat.plusChaud() ;
	         nTry++ ;
	         
	          // on lui donne le droit de le faire 5 fois
	      }  while (nTry <  5) ;
	       
	}
	
    public  int getTemperature() {
	       return  this.chaudiere.getTemperature() ;
	}
}
