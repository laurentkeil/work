import java.io.IOException;


public class Main {

	 
	 public static void main(String[] args) {
		 
/*exo 4 : diner des philo */

		    Salle salle = new Salle();
		    Philosophe[] philos = new Philosophe[5];
		    
		    // cr�ation de nos philo
		    for (int i =  0 ; i < philos.length ; i++) {
			    philos[i] = new Philosophe(i, new Fourchettes(), salle);
		   }

		    // lancement de nos philo
		    for (int i =  0 ; i < philos.length ; i++) {
		      philos[i].start() ;
		   }
		    
		    // on attend que chaque thread ait fini son ex�cution
		    for (int i =  0 ; i < philos.length ; i++) {
		       // jette InterruptedException
		    	try {
		    		philos[i].join() ;
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   }

		    // on affiche la temp�rature de notre chaudi�re
		   System.out.println("fin") ;

/*exo1*/
				// cr�ation d'une instance du thread
			    Unthread thread = new Unthread();
			    // Activation du thread
			    thread.start();
			    // tant que le thread est en vie...
			    while( thread.isAlive() ) {
			      // faire un traitement...
			      System.out.println("Ligne affich�e par le main");
			      try {
			        // et faire une pause
			        thread.sleep(800);
			      }
			      catch (InterruptedException ex) {}
			    }

/*exo 2*/
			    UnRun r = new UnRun();
			    Thread t = new Thread(r);
			    t.start();
			    System.out.println("run lanc�");
			    try {
					System.in.read();				// STOP (instruction d'apres) seulement si on appuie sur entr�e
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			    r.cancel();
			    System.out.println("stop");
			    
			    
/*exo3*/
			    Habitant h = new Habitant();
			    Thread[] habitants = new Thread[20];
			    
			    // cr�ation de nos habitants
			    for (int i =  0 ; i < habitants.length ; i++) {
			      habitants[i] =  new Thread(h) ;
			   }

			    // lancement de nos habitants
			    for (int i =  0 ; i < habitants.length ; i++) {
			      habitants[i].start() ;
			   }
			    
			    // on attend que chaque thread ait fini son ex�cution
			    for (int i =  0 ; i < habitants.length ; i++) {
			       // jette InterruptedException
			    	try {
			    		habitants[i].join() ;
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			   }

			    // on affiche la temp�rature de notre chaudi�re
			   System.out.println("Temperature finale = " + h.getTemperature()) ;
			    
	}
	 
}
