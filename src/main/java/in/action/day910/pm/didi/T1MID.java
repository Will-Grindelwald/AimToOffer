package in.action.day910.pm.didi;

import java.util.Scanner;

/**
 * 
 * 给出 n 个数字 a_1,...,a_n，问最多有多少不重叠的非空区间，使得每个区间内数字的 xor 都等于 0。 即找出最大的 k，使得存在 k 个区间
 * (l[i], r[i])，满足 1<=l[i]<=r[i]<=n (1<=i<=k), r[i]<l[i+1](1<=i<k), 且 a[l[i]]
 * xor a[l[i]+1] xor... xor a[r[i]] = 0 (1<=i<=k)
 * 
 * 输入描述: 第一行一个整数 n； 第二行ｎ个整数 a_1,...,a_n； 对于30%的数据，n<=20； 对于100%的数据，n<=100000,
 * a_i<=100000；
 * 
 * 输出描述: 一个整数表示最多的区间个数；
 * 
 * 示例 1
 * 
 * 输入: 4 3 0 2 2
 * 
 * 输出: 2
 * 
 * 说明: [0] xor = 0，[2,2] 2 xor 2 = 0，所以总共是2个不重叠的非空区间
 * 
 */
public class T1MID {
	public static void main(String[] args) {
		int[] a = null;
		try (Scanner in = new Scanner(System.in)) {
			a = new int[in.nextInt()];
			for (int i = 0; i < a.length; i++) {
				a[i] = in.nextInt();
			}
		}
		System.out.println(compute(a));
	}

	// 用了贪心的思想
	private static int compute(int[] a) {
		int count = 0;
		for (int i = 0, lim = 0; i < a.length; i++) {
			if (a[i] == 0) {
				count++;
				lim = i + 1;
				continue;
			}
			for (int j = lim; j < i; j++) {
				if ((a[j] ^= a[i]) == 0) { // 原地修改即可
					count++;
					lim = i + 1;
					break;
				}
			}
		}
		return count;
	}
}
