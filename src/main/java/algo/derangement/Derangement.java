package algo.derangement;

import java.util.Scanner;

// 错排问题
// 原题: https://www.nowcoder.com/questionTerminal/95e35e7f6ad34821bc2958e37c08918b
/**
 * 
 * NowCoder 每天要给很多人发邮件。有一天他发现发错了邮件，把发给 A 的邮件发给了 B，把发给 B 的邮件发给了 A。于是他就思考，要给 n
 * 个人发邮件，在每个人仅收到 1 封邮件的情况下，有多少种情况是所有人都收到了错误的邮件？ 即没有人收到属于自己的邮件。
 * 
 * 输入描述:
 * 
 * 输入包含多组数据，每组数据包含一个正整数n（2≤n≤20）。
 * 
 * 输出描述:
 * 
 * 对应每一组数据，输出一个正整数，表示无人收到自己邮件的种数。
 * 
 */
/**
 * 
 * 当 n 个编号元素放在 n 个编号位置，错排的方法数记为 D(n).
 * 
 * 1. 把第 n 个元素放在一个位置，比如位置 k，一共有（n-1）种方法
 * 
 * 2. 放编号为 k 的元素，这时有两种情况：
 * 
 * 1° 把它放到位置 n，那么，对于剩下的（n-1）个元素，由于第 k 个元素放到了位置 n，剩下（n-2）个元素就有 D(n-2) 种方法
 * 
 * 2° 第 k 个元素不把它放到位置 n，这时，对于这（n-1）个元素，有 D(n-1) 种方法
 * 
 * 于是有：D(n) = (n-1) [D(n-2) + D(n-1)]
 * 
 */
public class Derangement {
	public static void main(String[] args) {
		long[] d = new long[22];
		d[2] = 1;
		d[3] = 2;
		for (int i = 4; i < 22; i++) {
			d[i] = (i - 1) * (d[i - 1] + d[i - 2]);
		}
		try (Scanner in = new Scanner(System.in)) {
			while (in.hasNext()) {
				int n = in.nextInt();
				System.out.println(d[n]);
			}
		}
	}
}
