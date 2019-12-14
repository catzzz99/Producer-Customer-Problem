package producerCustomer;

public class Buffer {

	boolean isEmpty = true;
	int product = 0;
	
	public synchronized void deposit(int product) {
		while(!isEmpty){
			try {
				System.out.println("Full, " + Thread.currentThread().getName() + " gonna wait");
				wait();
			} catch (InterruptedException e) {
				System.err.println("Interrupted deposit wait");
			}
		}
		
		
		this.product = product;
		isEmpty = false;
		System.out.println("Deposited product: " + this.product);
		notify();
		
	}
	
	public synchronized int take() {
		while(isEmpty){
			try {
				System.out.println("Empty, " + Thread.currentThread().getName() + " gonna wait");
				wait();
			} catch (InterruptedException e) {
				System.err.println("Interrupted take wait");
			}
		}
		
		isEmpty = true;
		notify();
		System.out.println("Taken product: " + product);
		return product;
		
	}
}
