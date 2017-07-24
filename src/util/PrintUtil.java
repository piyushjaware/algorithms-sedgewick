package util;

public class PrintUtil {

	public static void printArray(int[] row) {
		for (int i : row) {
			System.out.print(i);
			System.out.print("  ");
		}
//		System.out.println();
	}

	public static void printArray(int[][] a) {
		for (int i = 0; i < a.length; i++) {
			printArray(a[i]);
		}
	}

}
