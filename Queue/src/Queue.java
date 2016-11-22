
/**
 * Implement the Queue ADT using linked lists
 * 
 * @author PMARINA
 * @version 10/3/2016
 */
public class Queue {
	private Node[] a;
	private static int count;

	/**
	 * Default constructor. Only initializes array of nodes
	 */
	Queue() {
		this.a = new Node[0];
	}

	/**
	 * takes the preexisting linked list and uses it to continue
	 * 
	 * @param arr
	 *            the linked list to use
	 */
	Queue(Node[] arr) {
		this.a = arr;
	}

	/**
	 * Adds the given item to the linked list
	 * 
	 * @param s
	 *            the item to enqueue
	 */
	public void enqueue(String s) {
		Node[] copy = new Node[a.length + 1];
		for (int i = 0; i < a.length; i++) {
			copy[i] = a[i];
		}
		Node n = new Node(s, null);
		copy[copy.length - 1] = n;
		if (a.length != 0)
			copy[copy.length - 2].setNext(n);
		a = copy;
	}

	/**
	 * Removes the first element from the queue
	 * 
	 * @return the first element in the linked list
	 */
	public String dequeue() {
		String s = a[0].getItem();
		Node[] copy = new Node[a.length - 1];
		for (int i = 1; i < a.length; i++) {
			copy[i - 1] = a[i];
		}
		a = copy;
		return s;
	}

	/**
	 * @return the size of the queue
	 */
	public int size() {
		return a.length;
	}

	/**
	 * return whether or not the queue is empty
	 */
	public boolean isEmpty()
	{
		return a==null || a.length==0;
	}
}
