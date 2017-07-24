package fundamentals;

public class Josephus {

	public static void main(String args[]) {
		System.out.println("j" + " | " + "k" + " | " + "n" + " | " + "r");
		int r = josephus(5, 2);
		System.out.println(r);
	}

	public static int josephus(int n, int k) {
		if (n == 1)
			return 1;
		else {
			/*
			 * The position returned by josephus(n - 1, k) is adjusted because
			 * the recursive call josephus(n - 1, k) considers the original
			 * position k%n + 1 as position 1
			 */
			int j = josephus(n - 1, k);
			int r = (j + k - 1) % n + 1;
			System.out.println(j + " | " + k + " | " + n + " | " + r);
			return r;
		}
	}

}
