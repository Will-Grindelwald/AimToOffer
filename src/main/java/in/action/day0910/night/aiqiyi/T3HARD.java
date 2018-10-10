package in.action.day0910.night.aiqiyi;

import java.util.Scanner;

/**
 * 
 * 考虑定义在两正整数上的函数 SSR(平方根之和的平方): SSR(A, B) = (sqrt(A) +
 * sqrt(B))^2。牛牛对函数值为整数的情况很感兴趣。现在给定整数 n 和 m, 请帮助牛牛计算有序对 (A, B) 的数量, 满足 1 ≤ A ≤
 * n, 1 ≤ B ≤ m 而且 SSR(A, B) 是一个整数。
 * 
 * 输入描述: 输入包括两个整数 n 和 m (1 ≤ n ≤ 10^5, 1 ≤ m ≤ 10^5)
 * 
 * 输出描述: 输出一个整数, 表示满足条件的有序对对数。
 * 
 * 示例 1 输入: 3 8
 * 
 * 输出: 5
 * 
 */
public class T3HARD {
	public static void main(String[] args) {
		int n, m;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			m = in.nextInt();
			// System.out.println(compute(n, m));
			System.out.println(compute2(n, m));
		}
	}

	// 暴力 60%
	private static int compute(int n, int m) {
		int count = 0;
		long tmp = 0, a = 0; // tmp 最大为 10^5*10^5 超 int 了
		for (int i = 1; i <= n; i++) {
			tmp = 0;
			for (int j = 1; j <= m; j++) {
				tmp += i;
				a = (int) Math.sqrt(tmp);
				if (a * a == tmp) {
					count++;
				}
			}
		}
		return count;
	}

	// 正确解法
	private static int compute2(int n, int m) {
		if (n > m) {
			n += m;
			m = n - m;
			n -= m;
		}
		int count = 0;
		for (int a = 1, t = 1; a <= n; t = ++a) {
			for (int x = 2, lim = (int) Math.sqrt(a); x <= lim; x++) {
				if (a % (x * x) == 0) { // 找到最大的 x, 让 a 是 x*x 的倍数: O(sqrt(N))
					t = a / x / x;
				}
			}
			// a * t 是一个完全平方数, 要让 a * b 是一个平方数, 则 b = t * c, c 为一个完全平方数
			count += Math.sqrt(m / t); // 与下面 for 等价
			// int lim2 = m / t;
			// for (int y = 1; y * y <= lim2; y++) {
			// count++;
			// }
		}
		return count;
	}
}
