package fundamentals;

import util.PrintUtil;

public class BasicArrayImpls {

	public static void main(String[] args) {

		reverseArray();
		multiplyNonSquareMatrices();
		multiplySquareMatrices();

	}

	private static void multiplyNonSquareMatrices() {

		int a[][] = { { 1, 2 }, { 2, 2 } };
		int b[][] = { { 1, 2 }, { 2, 2 } };
		int c[][] = new int[a.length][b[0].length];

		int c_rows = a.length;
		int c_cols = b[0].length;

		for (int i = 0; i < c_rows; i++) {
			for (int j = 0; j < c_cols; j++) {
				for (int k = 0; k < a[0].length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		for (int i = 0; i < c_rows; i++) {
			for (int j = 0; j < c_cols; j++)
				System.out.print(c[i][j] + " ");
			System.out.println();
		}
	}

	public static void reverseArray() {
		int[] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };
		int n = a.length;
		for (int i = 0; i < n / 2; i++) {
			int temp = a[i];
			a[i] = a[n - 1 - i];
			a[n - 1 - i] = temp;
		}
		PrintUtil.printArray(a);
	}

	private static void multiplySquareMatrices() {
		int a[][] = { { 1 } };
		int b[][] = { { 1 }, { 2 }, { 3 }, { 4 }, { 5 } };
		int c[][] = new int[2][2];

		for (int i = 0; i < a.length; i++) {
			for (int j = 0; j < b.length; j++) {
				for (int k = 0; k < c.length; k++) {
					c[i][j] += a[i][k] * b[k][j];
				}
			}
		}

		PrintUtil.printArray(c);
	}
}
