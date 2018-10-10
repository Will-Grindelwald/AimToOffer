package in.action.day0910.night.aiqiyi;

import java.util.Scanner;

/**
 * 
 * 对于任意两个正整数 x 和 k, 我们定义 repeat(x, k) 为将 x 重复写 k 次形成的数, 例如 repeat(1234, 3) =
 * 123412341234, repeat(20,2) = 2020. 牛牛现在给出 4 个整数 x1, k1, x2, k2, 其中 v1 = (x1,
 * k1), v2 = (x2, k2), 请你来比较 v1 和 v2 的大小。
 * 
 * 输入描述: 输入包括一行, 一行中有 4 个正整数 x1, k1, x2, k2(1 ≤ x1,x2 ≤ 10^9, 1 ≤ k1,k2 ≤ 50),
 * 以空格分割
 * 
 * 输出描述: 如果 v1 小于 v2 输出 "Less", v1 等于 v2 输出 "Equal", v1 大于 v2 输出 "Greater".
 * 
 * 示例 1 输入: 1010 3 101010 2
 * 
 * 输出: Equal
 * 
 */
public class T1 {
	public static void main(String[] args) {
		String stringx1, stringx2;
		int k1 = 0, k2 = 0;
		try (Scanner in = new Scanner(System.in)) {
			stringx1 = in.next();
			k1 = in.nextInt();
			stringx2 = in.next();
			k2 = in.nextInt();
		}
		System.out.println(compare(stringx1.toCharArray(), stringx2.toCharArray(), k1, k2));
	}

	private static String compare(char[] cs1, char[] cs2, int k1, int k2) {
		int len1 = cs1.length * k1;
		int len2 = cs2.length * k2;
		if (len1 > len2) {
			return "Greater";
		} else if (len1 < len2) {
			return "Less";
		} else {
			for (int i = 0, len = Math.max(len1, len2); i < len; i++) {
				if (cs1[i % cs1.length] > cs2[i % cs2.length]) {
					return "Greater";
				} else if (cs1[i % cs1.length] < cs2[i % cs2.length]) {
					return "Less";
				}
			}
			return "Equal";
		}
	}
}
