import java.util.Arrays;


public class Fourchettes {
	
	// tableau des fourchettes libres pour chaque philosophes
	private int num_fourchettes[] ;
	// nombre de philosophes mangeant
	private int philo_mangeant = 0 ;
	private boolean active[] ;
	
	// constructeur
	public Fourchettes(){
		num_fourchettes = new int [5] ;
		active = new boolean [5] ;
		for ( int id = 0 ; id < 5 ; id ++ ) {
			num_fourchettes[ id ] = 2 ; // au début toutes les fourchettes sont libres
			active[ id ] = false ; // et aucun philosophe mange
		}
	}
	
	// méthode prendre : un philosophe affamé doit disposer de deux fourchettes pour
	// pouvoir manger. Si une ou les deux fourchettes sont déjà prise le thread philosophe
	// se met en attente.
	public synchronized void prendre ( int id ) {
		while ( num_fourchettes[id] != 2) {
			try {
				wait(); 
			} catch( InterruptedException e ) {}
		}
		// lorsque les fourchettes sont libres (retire celles des voisins de gauche et droite)
		num_fourchettes[( id + 1 ) % 5 ] -- ;
		num_fourchettes[( id + 4 ) % 5 ] -- ;
		System.out.println("philosophe " + id + " eating ");
		philo_mangeant ++ ;
		active[ id ] = true ; 
	}
	
	// methode poser : lorsqu'un philosophe a fini de manger, il repose les fourchettes
	// puis notifie tous les autres threads en attente de fourchettes
	public synchronized void poser ( int id ) {
		philo_mangeant -- ;
		active[ id ] = false ;
		System.out.println( " philosophe " + id + " thinking" );
		num_fourchettes[( id + 1 ) % 5] ++;
		num_fourchettes[( id + 4 ) % 5] ++;
		notifyAll() ;
	}
	
	public void printNbrFourch() {
		System.out.println(Arrays.toString(num_fourchettes));
	}
	
}