
public class Bubanj  extends Thread{

	
	private Generator generator;
	private boolean jeGen = false;
	private int br;
	public Bubanj(int min, int max) {
		generator = new Generator(min, max);
	}
	
	public void pokreni() {
		start();
	}
	
	public void zaustavi() {
		interrupt();
	}
	
	
	
	public void run() {
		try {
			while(!interrupted()) {
				synchronized (this) {
				while(jeGen) wait();
				 sleep((int)(Math.random()*100));

				br =generator.sledeci();
				
				jeGen = true;
				notify();
			}
		}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public synchronized int sledeci() throws InterruptedException {
		while(!jeGen) {
			wait();
		}
		int b = br; 
		
		jeGen = false;
		notify();
		return b;
	}

	
	
	

	
	public synchronized boolean status() {
		return jeGen;
	}
	
}
