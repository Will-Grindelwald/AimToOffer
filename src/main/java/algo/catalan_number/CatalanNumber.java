package algo.catalan_number;

public class CatalanNumber {
	public static void main(String[] args) {
		for (int i = 1; i < 30; i++) {
			System.out.println(catalan(i));
		}
	}

	private static long catalan(int n) {
		// 1 2 5 14 42 132 429 1430 4862 16796 58786 208012 742900 2674440
		double res = 1;
		for (int i = 1; i < n; i++) {
			res *= 2 * n + 1 - i;
			res /= i;
		}
		return (long) (res / n);
	}
}
