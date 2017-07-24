package fundamentals;

import edu.princeton.cs.introcs.In;

public class QuickUnionUF {

	static int[] parent;
	static int count;

	public static void main(String[] args) {
		In in = new In("algs4-data/mediumUF.txt");
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
	}

	private static void init(int n) {
		parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		count = n;
	}

	private static void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);

		if (rootP == rootQ)
			return;

		parent[rootP] = rootQ;
		count--;
	}

	private static boolean connected(int p, int q) {
		return find(p) == find(q);
	}

	private static int find(int p) {
		while (parent[p] != p) {
			p = parent[p];
		}
		return p;
	}
}