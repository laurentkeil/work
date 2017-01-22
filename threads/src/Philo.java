
public class Philo implements Runnable {
	
	private final int id;
    /** La pile partagée par tous nos threads */
	private Table table;
	private int tempsRechauffer = 35;
	private int tempsManger = 50;
	private int nbrPhilos;
	
	public Philo (int id, int nbrPhilos, Table table){
		this.id = id;
		this.table = table;
		this.nbrPhilos = nbrPhilos;
	}
	
	public void run(){
		while(!table.isEmptyAll()){
			int tempsRestant = table.prendre(id);
			
			if(tempsRestant == 0) { //si au bout d un moment il a su en prendre un, false si c'est gelé, true sinon			
				try {
					Thread.sleep(tempsManger);
				} catch (InterruptedException e) {}
				
			} else {
				try {
					Thread.sleep(tempsRechauffer);
				} catch (InterruptedException e) {}

				tempsRestant = tempsRestant - tempsRechauffer ;
				if (tempsRestant < 0) tempsRestant = 0;
				
				table.deposer((id + 1)%nbrPhilos, tempsRestant );
			}
		}

		System.out.println("runfin");
	}
}
