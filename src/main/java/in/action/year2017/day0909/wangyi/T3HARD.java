package in.action.year2017.day0909.wangyi;

import static java.lang.StrictMath.abs;

import java.util.Scanner;

/**
 * 
 * 小 Q 和牛博士合唱一首歌曲, 这首歌曲由 n 个音调组成, 每个音调由一个正整数表示。 对于每个音调要么由小 Q 演唱要么由牛博士演唱,
 * 对于一系列音调演唱的难度等于所有相邻音调变化幅度之和, 例如一个音调序列是 8, 8, 13, 12, 那么它的难度等于 | 8 - 8| + |13 -
 * 8| + |12 - 13| = 6(其中 || 表示绝对值)。 现在要对把这 n 个音调分配给小 Q 或牛博士, 让他们演唱的难度之和最小,
 * 请你算算最小的难度和是多少。 如样例所示: 小 Q 选择演唱 {5, 6} 难度为 1, 牛博士选择演唱 {1, 2, 1} 难度为 2, 难度之和为
 * 3, 这一个是最小难度和的方案了。
 * 
 * 输入描述: 输入包括两行, 第一行一个正整数 n(1 ≤ n ≤ 2000) 第二行 n 个整数 v[i](1 ≤ v[i] ≤ 10^6),
 * 表示每个音调。
 * 
 * 输出描述: 输出一个整数, 表示小 Q 和牛博士演唱最小的难度和是多少。
 * 
 * 示例 1 输入: 5 1 5 6 2 1
 * 
 * 输出: 3
 * 
 */
// https://www.nowcoder.com/discuss/39219
public class T3HARD {
	static int maxn = 2000 + 5;
	static int[] v = new int[maxn];
	static int[][] dp = new int[maxn][maxn];
	static int n;

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			v[0] = -1;
			for (int i = 1; i <= n; i++)
				v[i] = in.nextInt();
		}
		for (int i = 0; i < maxn; i++)
			for (int j = 0; j < maxn; j++)
				dp[i][j] = -1;
		System.out.println(solve(0, 0));
	}

	// 动态规划。
	// dp[i][j] 表示小 Q 上一个演唱的音符是 v[i], 牛博士上一个演唱的音符是 v[j] 的最小难度和。
	// 记忆化搜索一下就好了
	public static int solve(int la, int lb) {
		int now = max(la, lb) + 1;
		if (now == n + 1)
			return 0;
		if (dp[la][lb] != -1)
			return dp[la][lb];
		return dp[la][lb] = min(solve(now, lb) + (la > 0 ? abs(v[now] - v[la]) : 0),
				solve(la, now) + (lb > 0 ? abs(v[now] - v[lb]) : 0));
	}

	public static int max(int a, int b) {
		return (a > b) ? a : b;
	}

	public static int min(int a, int b) {
		return (a < b) ? a : b;
	}
}
