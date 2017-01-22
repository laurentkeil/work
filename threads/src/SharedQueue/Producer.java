package SharedQueue;

public class Producer extends Thread {

	protected String name;
	protected Queue queue;
	protected volatile boolean halt = false;
	
	public Producer(String name, Queue queue) {
		this.name = name;
		this.queue = queue;
	}
	
	private void produce() {
			this.queue.add("Product from " + this.name);
	}
	
	public void run() {
		while (!halt) {
			produce();
			try {
				sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public void halt() {
		this.halt = true;
	}
	
}