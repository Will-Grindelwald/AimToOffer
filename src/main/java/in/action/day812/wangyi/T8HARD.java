package in.action.day812.wangyi;

import java.util.Scanner;

/**
 * 
 * 小易非常喜欢拥有以下性质的数列: 1、数列的长度为 n 2、数列中的每个数都在 1 到 k 之间 (包括 1 和 k) 3、对于位置相邻的两个数 A 和
 * B(A 在 B 前), 都满足 (A <= B) 或 (A mod B != 0)(满足其一即可) 例如, 当 n = 4, k = 7 那么
 * {1,7,7,2}, 它的长度是 4, 所有数字也在 1 到 7 范围内, 并且满足第三条性质, 所以小易是喜欢这个数列的 但是小易不喜欢
 * {4,4,4,2} 这个数列。小易给出 n 和 k, 希望你能帮他求出有多少个是他会喜欢的数列。
 * 
 * 输入描述: 输入包括两个整数 n 和 k(1 ≤ n ≤ 10, 1 ≤ k ≤ 10^5)
 * 
 * 输出描述: 输出一个整数, 即满足要求的数列个数, 因为答案可能很大, 输出对 1,000,000,007 取模的结果。
 * 
 * 输入例子 1: 2 2
 * 
 * 输出例子 1: 3
 *
 */
public class T8HARD {
	public static void main(String[] args) {
		int n = 0, k = 0;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			k = in.nextInt();
		}
		if (n == 1) {
			System.out.println(n);
			return;
		}
		int[] a = new int[k + 1], a2 = new int[k + 1], swap = null;
		int[] b = new int[k + 1];
		for (int i = 1; i <= k; i++) {
			a[i] = 1;
			b[i] = k / i - 1;
		}
		for (int i = 2; i <= n; i++) {
			int c = 0;
			for (int j = 1; j <= k; j++) {
				if ((c += a[j]) > 1_000_000_007)
					c %= 1_000_000_007;
			}
			for (int j = 1; j <= k; j++) {
				a2[j] = c;
				for (int l = 2 * j; l <= k; l += j) {
					if ((a2[j] -= a[l]) < 0)
						a2[j] = (a2[j] + 1_000_000_007) % 1_000_000_007;
				}
			}
			swap = a2;
			a2 = a;
			a = swap;
		}
		long sum = 0;
		for (int i = 1; i <= k; i++) {
			if ((sum += a[i]) > 1_000_000_007)
				sum %= 1_000_000_007;
		}
		System.out.println(sum);
	}
}
