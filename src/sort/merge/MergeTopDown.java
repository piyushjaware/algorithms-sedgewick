package sort.merge;

import sort.elementary.Sortable;

public class MergeTopDown implements Sortable {

	private Comparable[] aux;
	private int compares;

	@Override
	public void sort(Comparable[] a) {
		aux = new Comparable[a.length];
		sort(a, 0, a.length - 1);
	}

	private void sort(Comparable[] a, int lo, int hi) {
		if (hi <= lo)
			return;
		int mid = lo + (hi - lo) / 2;
		sort(a, lo, mid);
		sort(a, mid + 1, hi);
		merge(a, lo, mid, hi);
	}

	private void merge(Comparable[] a, int lo, int mid, int hi) {
		int i = lo, j = mid + 1;

		for (int k = lo; k <= hi; k++) {
			aux[k] = a[k];
		}

		for (int k = lo; k <= hi; k++) {
			if (i > mid)
				a[k] = aux[j++];
			else if (j > hi)
				a[k] = aux[i++];
			else if (less(a[j], a[i]))
				a[k] = aux[j++];
			else
				a[k] = aux[i++];
		}
	}

	@Override
	public boolean less(Comparable v, Comparable w) {
		compares++;
		return v.compareTo(w) < 0;
	}

	@Override
	public void exchange(Comparable[] a, int i, int j) {

	}

	@Override
	public boolean isSorted(Comparable[] a) {
		for (int i = 1; i < a.length; i++) {
			if (less(a[i], a[i - 1])) {
				return false;
			}
		}
		return true;
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
		// System.out.println("Number of Exchanges: " + exchanges);
	}

}
