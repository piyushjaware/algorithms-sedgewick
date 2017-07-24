package fundamentals;

import java.util.Iterator;

/**
 * FIFO
 */
public class DoubleLinkedList<Item> implements Iterable<Item> {

	int n;
	Node first;
	Node last;

	class Node {
		Node next;
		Node previous;
		Item item;

		@Override
		public String toString() {
			String val = item == null ? "" : String.valueOf(item);
			return val;
		}
	}

	void add(Item item) {
		Node node = new Node();
		node.item = item;
		node.previous = last;
		if (last != null) {
			last.next = node;
		}
		last = node;
		n++;
		if (n == 1) {
			first = last;
		}
	}

	public Item get() {
		throwExceptionIfListIsEmpty();
		Item item = first.item;
		first.previous = last;
		first = first.next;
		n--;
		return item;
	}

	public boolean isEmpty() {
		return first == null || last == null;
	}

	public int size() {
		return n;
	}

	public void insertAtStart(Item item) {
		if (first == null) {
			add(item);
			return;
		}

		Node node = new Node();
		node.item = item;
		node.next = first;
		node.previous = first.previous;
		first = node;
		n++;
	}

	public void insertAtEnd(Item item) {
		if (first == null) {
			add(item);
			return;
		}
		Node node = new Node();
		node.item = item;
		node.previous = last;
		last.next = node;
		last = node;
		n++;
	}

	public void removeFromStart() {
		throwExceptionIfListIsEmpty();
		first = first.next;
		first.previous = null;
		n--;
	}

	public void removeFromEnd() {
		throwExceptionIfListIsEmpty();
		last = last.previous;
		last.next = null;
		n--;
	}

	private void throwExceptionIfListIsEmpty() {
		if (first == null) {
			throw new RuntimeException("List empty");
		}
	}

	public void insertAfter(Item item, int index) {
		throwExceptionIfListIsEmpty();
		if (index == n - 1) {
			insertAtEnd(item);
			return;
		}
		Node currentNode = node(index);
		Node node = new Node();
		node.item = item;
		node.next = currentNode.next;
		node.previous = currentNode;
		currentNode.next.previous = node;
		currentNode.next = node;
		n++;
	}

	public void insertBefore(Item item, int index) {
		throwExceptionIfListIsEmpty();
		if (index == 0) {
			insertAtStart(item);
			return;
		}
		Node currentNode = node(index);
		Node node = new Node();
		node.item = item;
		node.previous = currentNode.previous;
		node.next = currentNode;
		currentNode.previous.next = node;
		currentNode.previous = node;
		n++;
	}

	public void remove(int index) {
		throwExceptionIfListIsEmpty();
		if (index == 0) {
			removeFromStart();
		} else if (index == n - 1) {
			removeFromEnd();
		} else {
			Node currentNode = node(index);
			currentNode.previous.next = currentNode.next;
			currentNode.next.previous = currentNode.previous;
		}
	}

	/**
	 * Returns node at the input index.
	 */
	private Node node(int index) {
		if (index < -1 || index >= n) {
			throw new RuntimeException("List index out of bounds");
		}
		if (index == n - 1) {
			return last;
		}

		Node current = first;
		for (int i = 0; i < index; i++) {
			current = current.next;
		}
		return current;
	}

	@Override
	public Iterator<Item> iterator() {
		return new DoubleLinkedIterator();
	}

	class DoubleLinkedIterator implements Iterator<Item> {

		Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item item = current.item;
			current = current.next;
			return item;
		}

	}

}
