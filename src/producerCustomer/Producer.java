package producerCustomer;

public class Producer extends Person{

	public Producer(int basicNapTime, int napTimeMaxOffset, Buffer buffer) {
		super(basicNapTime, napTimeMaxOffset, buffer);
	}
	
	
	@Override
	public void run() {
		while(true) {
			takeNap();
			depositNewProduct();
		}
		
	}

	private void depositNewProduct() {
		product = (int)(Math.random()*100);
		System.out.println(Thread.currentThread().getName() + " has produced " + product);
		buffer.deposit(product);
	}
}
