package in.action.day909.wangyi;

import java.util.Scanner;

/**
 * 
 * 小易有一个长度为 N 的正整数数列 A = {A[1], A[2], A[3]..., A[N]}。 牛博士给小易出了一个难题: 对数列 A
 * 进行重新排列, 使数列 A 满足所有的 A[i] * A[i + 1](1 ≤ i ≤ N - 1) 都是 4 的倍数。
 * 小易现在需要判断一个数列是否可以重排之后满足牛博士的要求。
 * 
 * 输入描述: 输入的第一行为数列的个数 t(1 ≤ t ≤ 10), 接下来每两行描述一个数列 A, 第一行为数列长度 n(1 ≤ n ≤ 10^5)
 * 第二行为 n 个正整数 A[i](1 ≤ A[i] ≤ 10^9)
 * 
 * 输出描述: 对于每个数列输出一行表示是否可以满足牛博士要求, 如果可以输出 Yes, 否则输出 No。
 * 
 * 示例 1 输入: 2 3 1 10 100 4 1 2 3 4
 * 
 * 输出: Yes No
 * 
 */
// https://www.nowcoder.com/discuss/39219
public class T1 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int t = in.nextInt();
			int c4 = 0, c1 = 0, len, tmp;
			for (int i = 0; i < t; i++) {
				c4 = 0;
				c1 = 0;
				len = in.nextInt();
				// 本题可以不缓存数据，直接计算
				for (int j = 0; j < len; j++) {
					tmp = in.nextInt();
					if (tmp % 4 == 0) {
						c4++;
					} else if (tmp % 2 != 0) {
						c1++;
					}
				}
				if (c1 > c4) {
					System.out.println("No");
				} else {
					System.out.println("Yes");
				}
			}
		}
	}
}
