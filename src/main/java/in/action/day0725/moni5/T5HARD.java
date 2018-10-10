package in.action.day0725.moni5;

import java.util.Scanner;

/**
 * 
 * 牛牛和羊羊在玩一个有趣的猜数游戏。在这个游戏中, 牛牛玩家选择一个正整数, 羊羊根据已给的提示猜这个数字。第 i 个提示是 "Y" 或者 "N",
 * 表示牛牛选择的数是否是 i 的倍数。 例如, 如果提示是 "YYNYY", 它表示这个数使 1,2,4,5 的倍数, 但不是 3 的倍数。
 * 注意到一些提示会出现错误。例如: 提示 "NYYY" 是错误的, 因为所有的整数都是 1 的倍数, 所以起始元素肯定不会是 "N"。此外, 例如
 * "YNNY" 的提示也是错误的, 因为结果不可能是 4 的倍数但不是 2 的倍数。 现在给出一个整数 n, 表示已给的提示的长度。请计算出长度为 n
 * 的合法的提示的个数。 例如 n = 5: 合法的提示有: YNNNN YNNNY YNYNN YNYNY YYNNN YYNNY YYNYN YYNYY
 * YYYNN YYYNY YYYYN YYYYY 所以输出 12
 * 
 * 输入描述: 输入包括一个整数n(1 ≤ n ≤ 10^6), 表示已给提示的长度。
 * 
 * 输出描述: 输出一个整数, 表示合法的提示个数。因为答案可能会很大, 所以输出对于 1000000007 的模
 * 
 * 输入例子: 5
 * 
 * 输出例子: 12
 *
 */
public class T5HARD {
	public static void main(String[] args) {
		int n = 0;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
		}

		boolean include[] = new boolean[n + 1];
		long num = 1;
		for (int i = 2; i <= n; i++) {
			if (!include[i]) { // 仅考虑素数
				// 筛法求素数
				for (int j = i + i; j <= n; j += i) {
					include[j] = true;
				}

				// 对 n 以内的素数 i 的幂次
				int count = 1;
				for (long j = i; j <= n; j *= i)
					count++;
				// num = count(2) + count(3) + count(5) + count(7) + ...
				num = num * count % 1000000007;
			}
		}

		System.out.println(num);
	}
}
