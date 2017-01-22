
public class Philosophe extends Thread {
	
	private int id ; // identificateur
	private Salle s;
	private Fourchettes f;
	private int tempsPense = 100;
	private int tempsMange = 300;
	
	// Constructeur
	public Philosophe( int id , Fourchettes f , Salle s) {
		this.id = id ;
		this.f = f ;
		this.s = s ;
	}
		
	// code exécuter par le thread
	public void run() {
		int nTry = 0;
		while( nTry < 3 ) {
			try {
				sleep( tempsPense ) ; 
			} catch( InterruptedException e) {}
			s.entrer( id ) ;
			f.prendre( id ) ;
			try {
				sleep( tempsMange ) ; 
			} catch( InterruptedException e) {}
				nTry ++;
				System.out.println(this.getName() + " a mangé pour la " + nTry + " e fois.");
				f.printNbrFourch();
			f.poser ( id ) ;
			s.quitter( id ) ;
		}
	}
}