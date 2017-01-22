package SharedQueue;

public class Consumer extends Thread {
	
	protected String name;
	protected Queue queue;
	protected volatile boolean halt = false;
	
	public Consumer(String name, Queue queue) {
		this.name = name;
		this.queue = queue;
	}
	
	private void consume() throws InterruptedException {
		String message = this.queue.get();
		System.out.println(this.name + " : consume : " + message);
	}
	
	public void run() {
		while (!halt) {
			try {
				consume();
			} catch (InterruptedException e1) {
				e1.printStackTrace();
			}
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
