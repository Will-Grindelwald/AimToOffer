package advanced.pack;

import java.util.Scanner;

/**
 * 
 * n 根彩色粉笔，m 根白色粉笔，可以 a 根彩色粉笔和 b 根白色粉笔，组成一盒卖 x 元，c 根白色粉笔一盒卖 y 元， d 根彩色粉笔一盒卖 z
 * 元，问最多可以卖多少钱？不一定要全卖完。
 * 
 * 样例1： 5 5 1 2 3 3 2 1 3 -> 7
 * 
 * 样例2： 5 15 1 2 3 6 2 1 3 -> 11
 * 
 * 样例3： 3 3 3 2 1 2 9 2 4 -> 11
 * 
 */
/**
 * 
 * 是二维背包问题
 * 
 */
public class P05_TwoDimensionalPack {
	public static void main(String[] args) {
		int n = 0, m = 0, a = 0, b = 0, c = 0, d = 0, x = 0, y = 0, z = 0;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			m = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			d = in.nextInt();
			x = in.nextInt();
			y = in.nextInt();
			z = in.nextInt();
		}
		System.out.println(compute(n, m, a, b, c, d, x, y, z));
		System.out.println(compute2(n, m, a, b, c, d, x, y, z));
	}

	private static int compute(int n, int m, int a, int b, int c, int d, int x, int y, int z) {
		// 动规，必是最优解
		int[][] dp = new int[n + 1][m + 1];
		int[][] limit = new int[][] { { a, b, x }, { 0, c, y }, { d, 0, z } };
		for (int k = 0; k < 3; k++) {
			// 三种物品：套装一 二三
			for (int i = limit[k][0]; i <= n; i++) {
				for (int j = limit[k][1]; j <= m; j++) {
					dp[i][j] = Math.max(dp[i][j], dp[i - limit[k][0]][j - limit[k][1]] + limit[k][2]);
				}
			}
		}
		return dp[n][m];
	}

	private static int compute2(int n, int m, int a, int b, int c, int d, int x, int y, int z) {
		// 贪心，极端情况不是最优解：3 3 3 2 1 2 9 2 4
		int sum = 0;
		if ((double) z / d * a + (double) y / c * b >= x) { // 选分着卖
			sum += n / d * z;
			n %= d;
			sum += m / c * y;
			m %= c;
			int tmp = n / a > m / b ? m / b : n / a;
			sum += tmp * x;
		} else { // 选合着卖
			int tmp = n / a > m / b ? m / b : n / a;
			sum += tmp * x;
			n -= tmp * a;
			m -= tmp * b;
			sum += n / d * z;
			sum += m / c * y;
		}
		return sum;
	}
}
