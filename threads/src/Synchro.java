
public class Synchro {
	private Runner winner =  null;
	
	public synchronized void setWinner (Runner win){
		assert win != null;
		
		if(winner == null){
			winner = win;
			System.out.println("winner trouvé");
			notifyAll();
		}
	}
	
	public synchronized Runner waitWinner(){
		while (winner == null) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return winner;
	}
}