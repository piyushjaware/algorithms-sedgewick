package fundamentals;

import util.PrintUtil;

public class QuickUnionWeightedUFwithPF {

	static class QuickUnionWithPathCompression {
		private int[] parent;
		private int[] size;
		private int count;

		public void init(int n) {
			parent = new int[n];
			size = new int[n];
			for (int i = 0; i < n; i++) {
				parent[i] = i;
				size[i] = 1;
			}
			count = n;
		}

		public void union(int p, int q) {
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

		public boolean connected(int p, int q) {
			return find(p) == find(q);
		}

		public int find(int p) {

			int pOrig = p;
			while (parent[p] != p) {
				p = parent[p];
			}
			int rootP = p;

			while (rootP != pOrig) {
				int temp = pOrig;
				pOrig = parent[pOrig];
				parent[temp] = rootP;
			}

			return p;
		}

		public void printParentAndSize() {
			PrintUtil.printArray(parent);
			System.out.printf(" | ");
			PrintUtil.printArray(size);
		}

		public int count() {
			return count;
		}

	}

	/*
	 * public static void main(String[] args) { In in = new
	 * In("algs4-data/tinyUF.txt"); int[] a = in.readAllInts(); in.close(); int
	 * n = a[0];
	 * 
	 * QuickUnionWithPathCompression uf = new QuickUnionWithPathCompression();
	 * 
	 * uf.init(n); for (int i = 1; i < a.length - 1; i += 2) { int p = a[i]; int
	 * q = a[i + 1]; System.out.printf("[%d %d] | ", p, q); if (uf.connected(p,
	 * q)) { uf.printParentAndSize(); System.out.println(); continue; }
	 * uf.union(p, q); uf.printParentAndSize(); System.out.println(); }
	 * 
	 * System.out.println("Connections : " + n);
	 * System.out.println("Number of components : " + uf.count()); }
	 */

	public static void main(String[] args) {


		String[][] a = { { "Y", "Y", "N", "N" }, { "Y", "Y", "Y", "N" }, { "N", "Y", "Y", "N" },
				{ "N", "N", "N", "Y" } };
		int n = a[0].length;
		QuickUnionWithPathCompression uf = new QuickUnionWithPathCompression();
		uf.init(n);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i != j && a[i][j] == "Y") {
					int p = i;
					int q = j;
					System.out.printf("[%d %d] | ", p, q);
					if (uf.connected(p, q)) {
						uf.printParentAndSize();
						System.out.println();
						continue;
					}
					uf.union(p, q);
					uf.printParentAndSize();
					System.out.println();
				}
			}

		}
		System.out.println("Connections : " + n);
		System.out.println("Number of components : " + uf.count());
	}

}