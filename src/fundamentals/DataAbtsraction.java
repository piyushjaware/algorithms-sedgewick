package fundamentals;

public class DataAbtsraction {

	private static int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
	private static int num = 4;

	public static void main(String[] args) {

		// System.out.println(isCircularShift());
		// binarySearch();
		// testRational();
	}


	/**
	 * 1.2.16 Rational numbers
	 */
	public static void testRational() {
		Rational r1 = new Rational(2, 4);
		Rational r2 = new Rational(3, 6);
		System.out.println(r1 + " | " + r2);
		System.out.println(r1.equals(r2));
		System.out.println(r1.plus(r2));
	}

	/**
	 * 1.2.6 Circular Shift
	 */
	public static boolean isCircularShift() {
		String s = "ACTGACG";
		String t = "TGACGAC";

		if (s.equals(t) || s.length() != t.length()) {
			return false;
		}

		for (int i = 1; i < s.length(); i++) {
			String temp = s.substring(i) + s.substring(0, i);
			System.out.println(temp);
			if (t.equals(temp)) {
				return true;
			}
		}
		return false;
	}

	public static void binarySearch() {
		int[] arr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
		boolean result = indexOf(0, arr.length - 1);
		System.out.println(result);
	}

	public static boolean indexOf(int low, int hi) {
		boolean result = false;
		int mid = (hi - low) / 2 + low;
		System.out.println(low + " " + mid + " " + hi);

		if (arr[mid] == num) {
			result = true;
			return result;
		}

		if (arr[mid] > num) {
			indexOf(low, mid);
		} else {
			indexOf(mid, hi);
		}
		return result;
	}

}
