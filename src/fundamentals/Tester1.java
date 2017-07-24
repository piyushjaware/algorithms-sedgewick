package fundamentals;

import java.util.PriorityQueue;

import edu.princeton.cs.algorithms.Counter;
import fundamentals.CircularQueue.Node;

public class Tester1 {

	public static void main(String[] args) {

		String temp = "YNNN";
		
		int[] a = {1,2,3,4,5};
		
		/*
		 * DoubleLinkedList<Integer> list = new DoubleLinkedList<Integer>();
		 * 
		 * list.add(1); list.add(2); list.add(3);
		 * 
		 * list.remove(1);
		 * 
		 * System.out.println("Size : " + list.size());
		 * 
		 * for (Integer s : list) { System.out.println(s); }
		 */
	}

	/**
	 * 1.4.12 O(n)
	 */
	public static void sortAndPrint(int[] a, int[] b) {

		int n = a.length;

		PriorityQueue<Integer> r = new PriorityQueue<Integer>(); // need dynamic
																	// list to
																	// not have
																	// to track
																	// the
																	// current
																	// index

		int index = 0;
		int indexA = 0;
		int indexB = 0;
		while (index < 2 * n) {
			if (indexB == n || (indexA < n && a[indexA] <= b[indexB])) {
				r.add(a[indexA++]);
				index++;
			} else {
				r.add(b[indexB++]);
				index++;
			}
		}

		System.out.println(r);
	}

	/**
	 * Binary Search 1.4.10 O(log(n))
	 */
	private static int leastIndexOf(int[] arr, int num) {
		int lo = 0;
		int hi = arr.length - 1;

		int found = -1;
		while (lo <= hi) {
			int mid = (hi - lo) / 2 + lo;
			if (num > arr[mid]) {
				lo = mid + 1;
			} else if (num < arr[mid]) {
				hi = mid - 1;
			} else {
				// return mid;
				found = mid;
				hi = mid - 1;
			}
		}

		int r = found > -1 ? found : -1;
		return r;
	}

	/**
	 * 1.3.37
	 * 
	 * @throws CloneNotSupportedException
	 */
	/*
	 * private static void josephus(int n, int m) { CircularQueue<String> dead =
	 * new CircularQueue<String>(); CircularQueue<Integer> alive = new
	 * CircularQueue<Integer>(); // populate the q with values for (int i = 1; i
	 * <= n; i++) { alive.enqueue(i); } Node current = alive.last; // point to
	 * one node before first while (dead.size() != n - 1) { current =
	 * incrementQueue(current, m - 1); // increment by m - 1 // times
	 * dead.enqueue(current.next.item.toString()); // save dead person to //
	 * another queue alive.deleteAfter(current); // delete the dead from alive
	 * queue }
	 * 
	 * System.out.print("Dead persons :\t"); int i = 0; for (Node currentDead =
	 * dead.last.next; i < dead.size(); currentDead = currentDead.next) {
	 * System.out.print(currentDead.item + "\t"); i++; }
	 * System.out.println("\nPosition to stay alive: " + current); }
	 */

	private static Node incrementQueue(Node current, int m) {
		for (int i = 0; i < m; i++) {
			current = current.next;
		}
		return current;
	}

	/**
	 * Binary Search
	 */
	private static int indexOf(int[] arr, int num) {
		Counter counter = new Counter("binarySearch");
		int lo = 0;
		int hi = arr.length - 1;
		while (lo <= hi) {
			counter.increment();
			int mid = (hi - lo) / 2 + lo;
			if (num > arr[mid]) {
				lo = mid + 1;
			} else if (num < arr[mid]) {
				hi = mid - 1;
			} else {
				// System.out.println(counter);
				return mid;
			}
		}
		// System.out.println(counter);
		return -1;
	}

}
