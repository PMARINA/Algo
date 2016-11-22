
/**
 * A Node
 * 
 * @author PMARINA
 * @version 10/3/2016
 */
public class Node {
	private String item; /// The item represented by the node
	private Node next; // The next node in the queue

	/**
	 * @param item
	 *            the item held in the Node (String)
	 * @param n
	 *            the next node
	 */
	Node(String item, Node n) {
		setItem(item);
		setNext(n);
	}

	/**
	 * @param item
	 *            the item to set the item in the node to
	 */
	public void setItem(String item) {
		this.item = item;
	}

	/**
	 * @param next
	 *            the Node to set the next node as
	 */
	public void setNext(Node next) {
		this.next = next;
	}

	/**
	 * @return the item represented by the node
	 */
	public String getItem() {
		return item;
	}

	/**
	 * @return the next node
	 */
	public Node getNext() {
		return next;
	}

	/**
	 * @return whether or not this node has another node as part of the next
	 *         node
	 */
	public boolean hasNext() {
		return next != null;
	}
}
