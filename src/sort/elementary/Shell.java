package sort.elementary;

public class Shell implements Sort {

	int compares = 0;
	int exchanges = 0;

	@Override
	public void sort(Comparable[] a) {
		int n = a.length;
		int h = 1;
		while (h < n / 3)
			h = 3 * h + 1;
		while (h >= 1) {
			for (int i = h; i < n; i++) {
				for (int j = i; j >= h && less(a[j], a[j - h]); j = j - h) {
					exchange(a, j, j - h);
				}
			}
			h /= 3;
		}
	}

	@Override
	public void exchange(Comparable[] a, int i, int j) {
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
		// show(a);
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
