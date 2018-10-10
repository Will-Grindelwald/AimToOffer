package in.action.day0616.moni4;

import java.util.Scanner;

/**
 * 
 * 牛牛在农场饲养了 n 只奶牛, 依次编号为 0 到 n-1, 牛牛的好朋友羊羊帮牛牛照看着农场. 有一天羊羊看到农场中逃走了 k 只奶牛,
 * 但是他只会告诉牛牛逃走的 k 只奶牛的编号之和能被 n 整除。你现在需要帮牛牛计算有多少种不同的逃走的奶牛群。因为结果可能很大, 输出结果对
 * 1,000,000,007 取模。 例如 n = 7 k = 4: 7 只奶牛依次编号为 0 到 6, 逃走了 4 只 编号和为 7 的有:{0, 1,
 * 2, 4} 编号和为 14 的有:{0, 3, 5, 6}, {1, 2, 5, 6}, {1, 3, 4, 6},{2, 3, 4, 5} 4
 * 只牛的编号和不会大于 18, 所以输出 5.
 * 
 * 输入描述: 输入包括一行, 两个整数 n 和 k(1 ≤ n ≤ 1000), (1 ≤ k ≤ 50), 以空格分割。
 * 
 * 输出描述: 输出一个整数表示题设所求的种数。
 * 
 * 输入例子: 7 4
 * 
 * 输出例子: 5
 *
 */
public class T8TODO {
	private static long caseNum = 0;
	private static int n = 0, k = 0;

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			k = in.nextInt();
		}
		int[] tmp = new int[k];
		for (int i = 0; i <= n - k; i++) {
			countCaseNum(tmp, 0, 0, i);
		}
		System.out.println(caseNum % 1000000007);
	}

	// 通过暴力枚举解空间
	public static void countCaseNum(int[] tmp, int sum, int num, int index) {
		sum += index;
		tmp[num] = index;
		num++;
		if (num == k) {
			if (sum % n == 0) {
				caseNum++;
				// System.out.println(Arrays.toString(tmp));
			}
			return;
		}
		for (int i = index + 1; i < n; i++) {
			countCaseNum(tmp, sum, num, i);
		}
	}
}
