package fundamentals;

import java.util.Iterator;

import fundamentals.Stack.Node;

public class QueueLinked<Item> implements Iterable<Item> {

	Node first;
	Node last;
	int n;

	class Node {
		Item item;
		Node next;
	}

	public void enqueue(Item item) {
		Node temp = new Node();
		temp.item = item;

		if (first == null) {
			last = temp;
			first = last;
		} else {
			last.next = temp;
			last = last.next;
		}

		n++;
	}

	public Item dequeue() {
		Item item = first.item;
		first = first.next;
		n--;
		return item;
	}

	public boolean isEmpty() {
		return first == null;
	}

	public int size() {
		return n;
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	private class QueueIterator implements Iterator<Item> {

		Node current = first;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public Item next() {
			Item temp = current.item;
			current = current.next;
			return temp;
		}

	}

	// ---------------Exercise methods---------------//
	/**
	 * 1.3.20
	 */
	public void delete(int k) {
		if (k > n || k < 1) {
			System.out.println("Invalid deletion");
			return;
		}

		Node current = first;
		n--;
		if (k == 1) {
			// delete first
			first = first.next;
		} else {
			for (int i = 1; i < k; i++) {
				if (i == k - 1) {
					current.next = current.next.next;
				}
				current = current.next;
			}
		}

	}

	/**
	 * 1.3.21
	 */
	public boolean find(String query) {
		for (Node i = first; i != null; i = i.next) {
			if (i.item.equals(query)) {
				return true;
			}
		}

		return false;
	}

}
