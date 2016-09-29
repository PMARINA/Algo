import java.util.Iterator;

/**
 * Implement the ArrayStack ADT using arrays. Look at the API in the class
 * website. Design and implement a client to calculate the following postfix
 * expression: 8 4 -3 * 1 5 + / *
 * 
 * @author PMARINA
 * @version 9/28/2016
 */
public class ArrayStackOfIntegers {
	private Integer[] items;
	private int n;

	/**
	 * @param cap
	 *            capacity of the Stack
	 */
	public ArrayStackOfIntegers(int cap) {
		this.n = 0;
		this.items = new Integer[cap];
	}

	/**
	 * @return whether or not the stack is empty
	 */
	public boolean isEmpty() {
		return this.n == 0;
	}

	/**
	 * @return whether or not the stack is full
	 */
	public boolean isFull() {
		return this.n == this.items.length;
	}

	/**
	 * @param item
	 *            the Integer object to add to the array
	 */
	public void push(Integer item) {
		if (!this.isFull()) {
			items[n] = item;
			n++;
			return;
		}
		System.out.println("Unable to add " + item.toString()
				+ " to ArrayStackOfIntegers instance as it has reached its capacity.");
		return;
	}

	/**
	 * @return the popped value
	 */
	public Integer pop() {
		n--;
		return items[n];
	}

	/**
	 * @return a new iterator for this instance
	 */
	public Iterator<Integer> iterator() {
		return new ReverseArrayIterator();
	}

	/**
	 * Default methods implemented
	 * 
	 * @author PMARINA
	 * @version 9/28/2016
	 */
	private class ReverseArrayIterator implements Iterator<Integer> {
		int pos;

		/**
		 * Constructor - takes the "next place to input" and subtracts 1 to get
		 * the value at the top of the stack
		 */
		public ReverseArrayIterator() {
			pos = n - 1;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#hasNext()
		 */
		public boolean hasNext() {
			return pos != -1;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see java.util.Iterator#next()
		 */
		@Override
		public Integer next() {
			pos--;
			return items[pos + 1];
		}

	}
}
