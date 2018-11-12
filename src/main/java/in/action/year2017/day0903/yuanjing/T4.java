package in.action.year2017.day0903.yuanjing;

import java.util.Scanner;

// 原题: 有依赖的背包问题 -> 转换为 分组背包问题  http://love-oriented.com/pack/P07.html http://love-oriented.com/pack/P06.html
// https://www.nowcoder.com/questionTerminal/f9c6f980eeec43ef85be20755ddbeaf4
public class T4 {
	public static int getMaxValue(int[] val, int[] weight, int[] q, int n, int w) {
		int[][] dp = new int[n + 1][w + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= w; j++) {
				if (q[i - 1] == 0) { // 主件
					if (weight[i - 1] <= j) // 用j这么多钱去买 i 件商品 可以获得最大价值
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + val[i - 1]);
				} else { // 附件
					if (weight[i - 1] + weight[q[i - 1]] <= j) // 附件的话 加上主件一起算
						dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - weight[i - 1]] + val[i - 1]);
				}
			}
		}
		return dp[n][w];
	}

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		while (input.hasNextInt()) {
			int n = input.nextInt(); // 总钱数
			int m = input.nextInt(); // 商品个数
			int[] p = new int[m];
			int[] v = new int[m];
			int[] q = new int[m];
			for (int i = 0; i < m; i++) {
				p[i] = input.nextInt(); // 价格
				v[i] = input.nextInt() * p[i]; // 价值
				q[i] = input.nextInt(); // 主or附件
			}
			System.out.println(getMaxValue(v, p, q, m, n));
		}
	}
}
