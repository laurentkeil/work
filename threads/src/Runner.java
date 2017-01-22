
public class Runner extends Thread {
	private final Synchro synchro;
	private final long sleeping;
	private volatile boolean halt = false;
	
	public Runner (Synchro synchro, long sleeping){
		assert synchro != null;
		assert sleeping > 0;
		
		this.synchro = synchro;
		this.sleeping = sleeping;
	}
	
	public void run() {
		int i = 10;
		while (!halt && i > 0) {
				i--;
				try {
					sleep(sleeping);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
		}
		synchro.setWinner(this);
		
		System.out.println(String.format(Thread.currentThread().getName() +" stopped at iteration %d", i));
	}/*
	public void run() {
		int i = 10;
		while (!halt) {
			if (i > 0) {
				i--;
				try {
					sleep(sleeping);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		synchro.setWinner(this);
		System.out.println(String.format("Thread stopped at iteration %d", i));
	}
	*/
	long getSleepingTime(){
		return sleeping;
	}
	
	void stopPlease() {
		halt = true;
	}
}
