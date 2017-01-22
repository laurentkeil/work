package SharedQueue;

import java.util.ArrayList;
import java.util.List;


public final class Application {

	public static void main(String[] args) throws InterruptedException {
		
		Queue queue = new Queue();
		
		List<Consumer> consumers = new ArrayList<Consumer>();
		List<Producer> producers = new ArrayList<Producer>();
		
		for (int i = 0; i < 10; i++) {
			Consumer c = new Consumer("C"+i, queue);
			c.start();
			consumers.add(c);
			System.out.println(c.name + " created");
			Producer p = new Producer("P"+i, queue);
			p.start();
			producers.add(p);
			System.out.println(p.name + " created");
		}
		
	}
	
}