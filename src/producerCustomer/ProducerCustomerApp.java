package producerCustomer;

public class ProducerCustomerApp {

	public static void main(String[] args) {
		System.out.println("Producer - customer problem");
		
		Buffer buffer = new Buffer();
		Person p = new Producer(2000, 3000, buffer);
		Person c = new Customer(1500, 1000, buffer);
		
		Thread producer = new Thread(p, "[PRODUCER]");
		Thread customer = new Thread(c, "[CUSTOMER]");
		
		producer.start();
		customer.start();
	}

}
