package fundamentals;

public class ResizeableQueue {

	private String[] arr = new String[1];
	int head;
	int tail;
	int n;

	public void enQueue(String item) {
		if (isFull()) {
			resize(2 * arr.length);
		}
		arr[tail++] = item;
		n++;
	}

	public String deQueue() {
		String temp = arr[head++];
		n--;
		if (n > 0 && n == arr.length / 4) {
			resize(arr.length / 2);
		}
		return temp;
	}

	public boolean isEmpty() {
		return head == tail;
	}

	public boolean isFull() {
		return tail == arr.length - 1;
	}

	private void resize(int size) {
//		System.out.println("Resize to " + size);
		String[] temp = new String[size];
		for (int i = 0; i < n; i++) {
			temp[i] = arr[head + i];
		}
		head = 0;
		tail = n;
		arr = temp;
	}

}
