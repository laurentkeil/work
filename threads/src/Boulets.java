

/*
 * Objet stack de boulets
 */
public class Boulets {

    private int stack []; //la stack de boulets
    private int index; 
    private int tempsPourChauffer = 100;
	
	public Boulets(int size) {
		this.index = 0;
		this.stack = new int[15];
		for(index=0 ; index < size ; index++){
			stack[index] = tempsPourChauffer;
		}
	}
	
	
    //dépile et renvoie le temps qu'il reste à chauffer
	public synchronized int prendre () {
		while (isEmpty()){ //si il n y a pas de boulets on laisse un autre thread travailler
			try{
				wait();
			} catch (InterruptedException e) {}
		} 
        int tpsRestant = stack[--index];
        return tpsRestant;
	}
	
	//empile avec le temps qu'il reste a chauffer
	public synchronized void deposer (int tempsRestant) {
		stack[index++] = tempsRestant;
		notifyAll();
	}
	
    /** Renvoie true si la pile est vide */
    public synchronized boolean isEmpty() { return index == 0; }
	
}
