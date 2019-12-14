package producerCustomer;

public abstract class Person implements Runnable{
	
	protected int basicNapTime = 0;
	protected int napTimeMaxOffset = 0;
	protected int product = 0;
	
	protected Buffer buffer;
	
	public Person(int basicNapTime, int napTimeMaxOffset, Buffer buffer) {
		this.basicNapTime = basicNapTime;
		this.napTimeMaxOffset = napTimeMaxOffset;
		this.buffer = buffer;

	}

	protected void takeNap() {
		try {
			int totalNapTime = basicNapTime + (int)(Math.random()*napTimeMaxOffset);
			System.out.println(Thread.currentThread().getName() + " naps for " + totalNapTime + "ms");
			Thread.sleep(totalNapTime);
		} catch (InterruptedException e) {
			System.err.println("Interrupted producer nap");
		}
	}
}
