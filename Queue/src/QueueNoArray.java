
/**
 * Implement the Queue ADT using linked lists
 * 
 * @author PMARINA
 * @version 10/3/2016
 */
public class QueueNoArray {
	Node a;
	int i;

	/**
	 * Set the node to null, if no input is given
	 */
	public QueueNoArray() {
		a = null;
	}

	/**
	 * A contructor to use if a linked list has already been implemented
	 * 
	 * @param s
	 *            the queue to use
	 */
	public QueueNoArray(Node s) {
		a = s;
	}

	/**
	 * @param s
	 *            the item to be added to the queue
	 */
	public void enqueue(String s) {
		if (a != null) {
			Node n = new Node(s, null);
			Node ac = new Node(a.getItem(), a.getNext());
			enqueue(n, ac);
			a = ac;
		} else
			a = new Node(s, null);
	}

	/**
	 * remove the first item from the queue
	 * 
	 * @return the item in the node
	 */
	public String dequeue() {
		String s = a.getItem();
		Node as = null;
		if (a.hasNext()) {
			as = new Node(a.getNext().getItem(), a.getNext().getNext());
		}
		a = as;
		return s;
	}

	/**
	 * Uses recursion to add the item to the queue
	 * 
	 * @param n
	 *            the item to be added
	 * @param ac
	 *            the node that is at least 0 levels down from the node held in
	 *            the QueueNoArray object
	 */
	private void enqueue(Node n, Node ac) {
		if (ac.hasNext()) {
			Node bc = ac.getNext();
			enqueue(n, bc);
		} else {
			ac.setNext(n);
		}
	}

	/**
	 * @return whether or not the queue is empty
	 */
	public boolean isEmpty() {
		return a == null;
	}

	/**
	 * @return the size of the queue
	 */
	public int size() {
		Node as = new Node(a.getItem(), a.getNext());
		size(as);
		int a = getCount();
		reset();
		return a;
	}

	/**
	 * @param a
	 *            the current size of the queue
	 * @param as
	 *            the node that is at least 0 nodes down from the current node
	 * @return the size of the queue from the level it is at and further down
	 */
	private void size(Node as) {
		if (a != null) {
			increment();
		}
		if (as.hasNext()) {
			as = as.getNext();
			size(as);
		}
	}

	/**
	 * Increment a count
	 */
	private void increment() {
		i++;
	}

	/**
	 * Reset the count
	 */
	private void reset() {
		i = 0;
	}

	/**
	 * @return the value of the count
	 */
	private int getCount() {
		return i;
	}
}
