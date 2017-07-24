package sort.elementary;

public class Insertion implements Sort {

	int compares = 0;
	int exchanges = 0;

	@Override
	public void sort(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
				exchange(a, j, j - 1);
			}
		}
	}

	@Override
	public void exchange(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		exchanges++;
	}

	@Override
	public boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1]))
				return false;
		}
		return true;
	}

	@Override
	public boolean less(Comparable v, Comparable w) {
		compares++;
		return v.compareTo(w) < 0;
	}

	@Override
	public void show(Comparable[] a) {
		for (int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println("");
	}

	public void stats(Comparable[] a) {
		System.out.println("n: " + a.length);
		System.out.println("Number of Compares: " + compares);
		System.out.println("Number of Exchanges: " + exchanges);
	}

}
