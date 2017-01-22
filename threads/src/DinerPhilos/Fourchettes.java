package DinerPhilos;

import java.util.ArrayList;
import java.util.List;

public class Fourchettes {
	
	private List<Boolean> listeFourchettes;

	public Fourchettes(int size){
		this.listeFourchettes = new ArrayList<Boolean>(size);
		for(int i=0 ; i<size ; i++){
			listeFourchettes.add(true); //libre
		}
	}

	public synchronized void prendre(int id) { 
		while(!(listeFourchettes.get(id) && listeFourchettes.get((id+1)%listeFourchettes.size()))){
			try{
				wait();
			} catch (InterruptedException e){}
		}
		System.out.println(id + " prend fourchettes " + id + " et " + (id+1)%listeFourchettes.size());
		listeFourchettes.set(id, false); //fourchette prise
		listeFourchettes.set((id+1)%listeFourchettes.size(), false);
	}

	public synchronized void deposer(int id) {
		System.out.println(id + " depose fourchettes " + id + " et " + (id+1)%listeFourchettes.size());
		listeFourchettes.set(id, true); //fourchette prise
		listeFourchettes.set((id+1)%listeFourchettes.size(), true);
		notifyAll();
	}
	
}
