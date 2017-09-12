package sword.to.offer.chapter5;

import java.util.Scanner;

/**
 * 
 * 把只包含因子 2、3 和 5 的数称作丑数（Ugly Number）。例如 6、8 都是丑数，但 14 不是，因为它包含因子 7。 习惯上我们把 1
 * 当做是第一个丑数。求按从小到大的顺序的第 N 个丑数。
 * 
 * 输入描述: 整数 N
 * 
 * 输出描述: 第 N 个丑数
 * 
 */
public class T34GetUglyNumber {
	// 其实题目描述不太清楚: 应该是素因子只有 2 3 5
	public int GetUglyNumber_Solution(int n) {
		if (n < 7)
			return n;
		int[] res = new int[n];
		res[0] = 1;
		int mod2 = 0, mod3 = 0, mod5 = 0;
		for (int i = 1; i < n; i++) {
			res[i] = Math.min(res[mod2] * 2, Math.min(res[mod3] * 3, res[mod5] * 5));
			if (res[i] == res[mod2] * 2)
				mod2++;
			if (res[i] == res[mod3] * 3)
				mod3++;
			if (res[i] == res[mod5] * 5)
				mod5++;
		}
		return res[n - 1];
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			System.out.println(new T34GetUglyNumber().GetUglyNumber_Solution(in.nextInt()));
		}
	}
}
