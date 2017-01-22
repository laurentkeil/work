


public class Table {

	private int nbrPhilos = 5;
	Boulets[] stock_boulets = new Boulets[nbrPhilos];

	public Table (int nbrBoulets) {
		for(int i=0 ; i < stock_boulets.length ; i++ ){
			this.stock_boulets[i] = new Boulets(nbrBoulets);
		}
	}
	
	public int prendre (int id) {
		return stock_boulets[id].prendre();
	}

	public void deposer (int id, int tempsRestant) {
		stock_boulets[id].deposer(tempsRestant);
	}
	
	public boolean isEmptyAll() {

		for(int i=0 ; i < stock_boulets.length ; i++ ){
			System.out.println("la stack " + i + " vide ? " + stock_boulets[i].isEmpty());
			if(!stock_boulets[i].isEmpty()) return false;
		}
		return true;
	}
	
}
