package fundamentals;

import java.util.Arrays;
import java.util.HashMap;

import edu.princeton.cs.introcs.In;
import edu.princeton.cs.introcs.Stopwatch;

public class TwoSumThreeSum {

	public static void main(String[] args) {

		// testTime();

		int[] a = { 12, -1, 4, 11 };
		System.out.println(farthestPairLinear(a));

	}

	/**
	 * 1.4.17 O(n)
	 */
	public static String farthestPairLinear(int[] a) {

		int min = a[0];
		int max = a[1];

		for (int i = 0; i < a.length; i++) {
			if (a[i] < min)
				min = a[i];
			else if (a[i] > max)
				max = a[i];
		}

		int[] pair = new int[2];
		pair[0] = min;
		pair[1] = max;

		return String.format("Farthest pair is (%d, %d)", pair[0], pair[1]);
	}

	/**
	 * 1.4.16 O(nlog+n) = O(nlogn)
	 */
	public static String closestPairLinearithmic(int[] a) {

		Arrays.sort(a);// nlogn

		int[] pair = new int[2];
		pair[0] = a[0];
		pair[1] = a[1];

		int n = a.length;
		for (int i = 1; i < n - 1; i++) {// n

			int prev = a[i] - a[i - 1];
			int next = a[i + 1] - a[i];
			int min = Math.abs(pair[1] - pair[0]);

			if (prev < min || next < min) {
				if (prev <= next) {
					pair[0] = a[i - 1];
					pair[1] = a[i];
				} else {
					pair[0] = a[i];
					pair[1] = a[i + 1];
				}
			}

		}

		return String.format("Closest pair is (%d, %d)", pair[0], pair[1]);
	}

	public static String closestPairQuadratic(int[] a) {
		int[] pair = new int[2];
		pair[0] = a[0];
		pair[1] = a[1];

		int n = a.length;
		System.out.println(n);
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1; j < n; j++) {
				System.out.printf("%d %d\n", a[i], a[j]);
				int diff = Math.abs(a[i] - a[j]);
				if (diff < Math.abs(pair[0] - pair[1])) {
					pair[0] = a[i];
					pair[1] = a[j];
				}
			}
		}

		return String.format("Closest pair is (%d, %d)", pair[0], pair[1]);
	}

	public static int twoSumLinearithmic(int[] a, int sum) {

		Arrays.sort(a);

		int n = a.length;
		int count = 0;

		// for (int i = 0; i < n; i++) {
		// if (BinarySearch.indexOf(a, sum - a[i]) > i) {
		// count++;
		// }
		// }
		return count;
	}

	public static int twoSumLinear(int[] a, int sum) {

		Arrays.sort(a);

		int n = a.length;
		int start = 0;
		int end = n - 1;
		int count = 0;

		while (start < end) {
			if (a[start] + a[end] > sum) {
				end--;
			} else if (a[start] + a[end] == sum) {
				count++;
				start++;
			} else {
				start++;
			}
		}

		return count;
	}

	/**
	 * O(n^2). The one given in the chapter was O(n^2*logn)
	 */
	public static int threeSumQuadratic(int[] a, int sum) {

		Arrays.sort(a);// nlogn

		int n = a.length;
		int count = 0;
		int start;
		int end;
		for (int i = 0; i < n - 2; i++) {
			start = i + 1;
			end = n - 1;
			while (start < end) {
				if (a[start] + a[end] + a[i] > sum) {
					end--;
				} else if (a[start] + a[end] + a[i] == sum) {
					count++;
					start++;
				} else {
					start++;
				}
			}
		}

		return count;
	}

	/**
	 * This would only work if all the numbers are unique as keyset will not
	 * allow duplicate keys
	 */
	public static int twoSumLinearUsingMap(int[] a, int sum) {

		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < a.length; i++) {
			map.put(a[i], i);
		}

		int n = a.length;
		int count = 0;

		for (int i = 0; i < n; i++) {
			int complement = sum - a[i];
			if (map.containsKey(complement)) {
				if (map.get(complement) != i) {
					count++;
				}
			}
		}

		return count / 2;
	}

	public static void testTime() {
		In in = new In("algs4-data/largeT.txt");
		int[] a = in.readAllInts();
		double time = 0.0;
		for (int i = 0; i < 100; i++) {
			Stopwatch timer = new Stopwatch();
			twoSumLinearUsingMap(a, 495799);
			time += timer.elapsedTime();
		}
		System.out.printf("%7d %5.4f", a.length, time / 100);
	}

}
