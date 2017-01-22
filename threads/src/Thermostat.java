public  class Thermostat {

    private Chaudiere chaudiere ;

    // un thermostat s'adresse � une unique chaudiere
    public Thermostat(Chaudiere chaudiere) {
       this.chaudiere = chaudiere ;
   }

    public boolean plusChaud() {

    	// la temperature limite est de 25�
    	synchronized(chaudiere) {
    		if (chaudiere.getTemperature() <  25) {
		    	
		
		          // l'appel � cette m�thode indique simplement � la machine Java 
		          // qu'elle doit interrompre momentan�ment l'ex�cution de ce thread, 
		          // et passer la main au thread suivant
		         Thread.yield() ;
		         chaudiere.augmenteTemperature() ;
		         return true ;
    		}	
    	}
   
       return false ;
   }
}