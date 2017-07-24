package sort.elementary;

public class Tester {

	public static void main(String[] args) {

		String[] a = { "4", "3", "2", "1" };// worst case
		// String[] a = { "a", "b", "c", "d", "e", "f" };// best case
		// String[] a = { "a", "a", "a", "a", "a", "a" };// identical keys
		sort(a, new Insertion());

		String[] b = { "4", "3", "2", "1" };// worst case
		// String[] b = { "a", "b", "c", "d", "e", "f" };// best case
		// String[] b = { "3", "3", "2", "2", "1", "1" };// identical keys
		sort(b, new InsertionWithoutExchange());

	}

	public static void sort(String[] a, Sort sorter) {

		sorter.show(a);
		// Sort
		sorter.sort(a);

		assert sorter.isSorted(a);

		sorter.show(a);
		sorter.stats(a);
	}

}
