package sort.merge;

import sort.elementary.Sortable;

public class Tester {

	public static void main(String[] args) {

		String[] a = { "4", "3", "2", "1" };// worst case
		// String[] a = { "a", "b", "c", "d", "e", "f" };// best case
		// String[] a = { "a", "a", "a", "a", "a", "a" };// identical keys
		sort(a, new MergeTopDown());

	}

	public static void sort(String[] a, Sortable sorter) {

		// Sort
		sorter.sort(a);
		assert sorter.isSorted(a);
		sorter.show(a);
		sorter.stats(a);
	}

}
