package fundamentals;

import edu.princeton.cs.introcs.In;
import util.PrintUtil;

public class QuickUnionWeightedUF {

	static int[] parent;
	static int[] size;
	static int count;

	public static void main(String[] args) {
		In in = new In("algs4-data/tinyUF.txt");
		int[] a = in.readAllInts();
		in.close();
		int n = a[0];

		init(n);
		for (int i = 1; i < a.length - 1; i += 2) {
			int p = a[i];
			int q = a[i + 1];
			System.out.printf("[%d %d] | ", p, q);
			if (connected(p, q)) {
				printParentAndSize();
				System.out.println();
				continue;
			}
			union(p, q);
			printParentAndSize();
			System.out.println();
		}

		System.out.println("Connections : " + n);
		System.out.println("Number of components : " + count);
		PrintUtil.printArray(size);
	}

	private static void printParentAndSize() {
		PrintUtil.printArray(parent);
		System.out.printf(" | ");
		PrintUtil.printArray(size);
	}

	private static void init(int n) {
		parent = new int[n];
		size = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
			size[i] = 1;
		}
		count = n;
	}

	private static void union(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		if (rootP == rootQ)
			return;

		// make smaller root point to larger one
		if (size[rootP] < size[rootQ]) {
			parent[rootP] = rootQ;
			size[rootQ] += size[rootP];
		} else {
			parent[rootQ] = rootP;
			size[rootP] += size[rootQ];
		}
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