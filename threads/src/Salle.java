
public class Salle {
	private int place_libre = 4 ;
	private int philo_en_attente = 0 ;
	
	// un philosophe avant de manger doit "entrer dans la salle" : si il y a déjà 4 philosophes
	// qui tentent de manger, celui ci doit attendre que l'un des quatre autre "quitte la salle"
	public synchronized void entrer ( int id ) {
		if ( place_libre <= 0 || philo_en_attente > 0 ) {
			philo_en_attente ++ ;
			try {
				wait() ;}
			catch( InterruptedException e) {}
			philo_en_attente --;
		}
		place_libre -- ;
	}
		
	// lorsque un philosophe a fini de manger il "quitte la salle" et notifie un des threads qui
	// attend pour entrer
	public synchronized void quitter( int id ) {
		place_libre ++;
		notify();
	}
}