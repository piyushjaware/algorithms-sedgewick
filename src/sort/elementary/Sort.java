package sort.elementary;

public interface Sort {

	void sort(Comparable[] a);

	boolean less(Comparable v, Comparable w);

	void exchange(Comparable[] a, int i, int j);

	boolean isSorted(Comparable[] a);

	void show(Comparable[] a);

	void stats(Comparable[] a);

}
