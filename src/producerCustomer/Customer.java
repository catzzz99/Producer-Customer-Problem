package producerCustomer;

public class Customer extends Person implements Runnable {
	
	public Customer(int basicNapTime, int napTimeMaxOffset, Buffer buffer) {
		super(basicNapTime, napTimeMaxOffset, buffer);
	}
	
	
	@Override
	public void run() {
		while(true) {
			takeNap();
			takeProduct();
		}
		
	}

	private void takeProduct() {
		product = buffer.take();
		System.out.println(Thread.currentThread().getName() + " has taken " + product);
	}
	
}
