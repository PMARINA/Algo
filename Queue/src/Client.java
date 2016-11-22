
/**
 * Implement the Queue ADT using a linked list
 * 
 * @author PMARINA
 * @version 10/3/2016
 */
public class Client {
	public static void main(String[] args) {
		QueueNoArray n = new QueueNoArray(); // Switch to Queue if you would
												// like to test the
												// implementation with arrays
		n.enqueue("First(0)");
		n.enqueue("In");
		n.enqueue("First(1)");
		n.enqueue("out");
		System.out.println("Queue is empty? " + n.isEmpty() + "\nQueue size? " + n.size()+"\nContents:");
		for (int i = 0; i < 4; i++) {
			System.out.println(n.dequeue());
		}
	}
}
