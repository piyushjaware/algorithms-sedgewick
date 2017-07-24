package fundamentals;

import edu.princeton.cs.introcs.In;

public class QuickFindUF {

	static int[] id;
	static int count;
	static int aa;

	public static void main(String[] args) {
		In in = new In("algs4-data/tinyUF.txt");
		int[] a = in.readAllInts();
		in.close();
		int n = a[0];

		init(n);

		for (int i = 1; i < a.length - 1; i += 2) {
			int p = a[i];
			int q = a[i + 1];
			if (connected(p, q))
				continue;
			union(p, q);
		}

		System.out.println("Connections : " + n);
		System.out.println("Number of components : " + count);
		System.out.println("Number of array accesses : " + aa);
	}

	private static void init(int n) {
		id = new int[n];
		for (int i = 0; i < n; i++) {
			id[i] = i;
		}
		count = n;
		aa = 0;
	}

	private static void union(int p, int q) {
		int pid = find(p);
		int qid = find(q);

		if (pid == qid)
			return;

		for (int i = 0; i < id.length; i++) {
			if (id[i] == pid) {
				id[i] = qid;
				aa += 2;
			}
			aa++;
		}
		count--;
	}

	private static boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private static int find(int p) {
		aa++;
		return id[p];
	}
}