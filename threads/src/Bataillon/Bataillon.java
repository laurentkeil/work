package Bataillon;

import java.util.ArrayList;
import java.util.List;

public class Bataillon {

	public static void main(String[] args){
		
		int nbrSoldats = 5;
		
		QueuePoints queuePoints = new QueuePoints(nbrSoldats);
		
		List<Soldat> soldats = new ArrayList<Soldat>();
		
		for(int i = 0 ; i < nbrSoldats ; i++){
			Soldat s = new Soldat(i, queuePoints);
			s.start();
			soldats.add(s);
			System.out.println(s.getName() + " created");
		}
		
		for(int i = 0 ; i < nbrSoldats ; i++){
			try {
				soldats.get(i).join();
				System.out.println(i + " stop");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		System.out.println("fin");
		
	}
}
