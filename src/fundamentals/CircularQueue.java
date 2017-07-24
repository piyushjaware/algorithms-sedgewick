package fundamentals;

public class CircularQueue<Item> {

	Node last;
	int n;

	class Node {
		Item item;
		Node next;

		public String toString() {
			String val = item == null ? "" : item.toString();
			return val;
		}
	}

	public void enqueue(Item item) {

		Node temp = new Node();
		temp.item = item;

		if (last == null) {
		} else {
			temp.next = last.next;
			last.next = temp;
		}
		last = temp;
		n++;
	}

	public Item dequeue() {
		Item item;
		if (last.next == null) {
			item = last.item;
			last = null;
		} else {
			item = last.next.item;
			Node temp = last.next.next;
			last.next = temp;
		}
		n--;
		return item;
	}

	public boolean isEmpty() {
		return n == 0;
	}

	public int size() {
		return n;
	}

}