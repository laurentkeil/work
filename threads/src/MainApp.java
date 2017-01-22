
public class MainApp {
	public static void main(String args[]){
		Synchro synchro = new Synchro();
		Runner t1 = new Runner(synchro, 100);
		Runner t2 = new Runner(synchro, 99);
		Runner t3 = new Runner(synchro, 300);
		t1.start();
		t2.start();
		t3.start();
		Runner winner = synchro.waitWinner();
		System.out.println(String.format("Winner is : %d", winner.getSleepingTime()));
		t1.stopPlease();
		t2.stopPlease();
		t3.stopPlease();
	}
}
