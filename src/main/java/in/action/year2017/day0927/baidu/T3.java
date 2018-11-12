package in.action.year2017.day0927.baidu;

/**
 * 
 * 
 */
public class T3 {
	static int findMaxMolecules(int a, int b, int c, int d, int x) {
		int[] items = { 0, a, b, c * 2, d * 2 };
		int[] dp = new int[x + 1];
		for (int i = 1; i <= x; i++) {
			dp[i] = Integer.MIN_VALUE;
		}
		for (int i = 1; i <= 4; i++) {
			for (int j = items[i]; j <= x; j++) {
				dp[j] = Math.max(dp[j], dp[j - items[i]] + 1);
			}
		}
		if (dp[x] < 0)
			return 0;
		return dp[x];
	}

	public static void main(String[] args) {
		System.out.println(findMaxMolecules(5, 8, 5, 3, 23));
	}
}
