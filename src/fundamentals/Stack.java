package fundamentals;

import java.util.Iterator;

public class Stack<Item> implements Iterable<Item> {

	Node first;
	int n;

	class Node {
		Item item;
		Node next;
	}

	public void push(Item item) {
		Node temp = new Node();
		temp.item = item;
		temp.next = first;
		first = temp;
		n++;
	}

	public Item pop() {
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
		return new StackIterator();
	}

	private class StackIterator implements Iterator<Item> {

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
}
