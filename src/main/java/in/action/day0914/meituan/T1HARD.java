package in.action.day0914.meituan;

import java.util.Scanner;

/**
 * 
 * 题目描述：小萌非常喜欢能被 7 整除的数字，比如 7,21,121996，等等。有一天他得到了 n 个正整数，她想用这些数制造出更多的能够被 7
 * 整除的数。于是她从这 n 个数中选出两个数，然后将一个数写在另一个数的前面，以此得到一个新的数。按这种方法她一共可以得到 2 * C 2 n
 * 个数，她想知道在这些数中，有多少个是能被 7 整除的。
 * 
 * 输入 第一行包含一个整数 n。2 ≤ n ≤ 10^5 第二行包含 n 个正整数 ai。1 ≤ ai ≤10^9
 * 
 * 样例输入 3 127 1996 12
 * 
 * 输出 4
 * 
 */
/**
 * 
 * 算法正确，但处理不了大数据，只过了70%
 * 
 */
public class T1HARD {
	public static void main(String[] args) {
		String[] data = null;
		try (Scanner in = new Scanner(System.in)) {
			data = new String[in.nextInt()];
			for (int i = 0; i < data.length; i++) {
				data[i] = in.next();
			}
		}
		System.out.println(compute(data));
	}

	public static int compute(String[] data) {
		int count = 0;
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data.length; j++) {
				if (i == j)
					continue;
				StringBuffer s = new StringBuffer();
				s.append(data[i]).append(data[j]);
				String tmp = s.toString();
				int a1 = Integer.parseInt(tmp.substring(tmp.length() - 2, tmp.length()));
				long a2 = Long.parseLong(s.substring(0, s.length() - 2));
				if ((a1 + 2 * a2) % 7 == 0) {
					count++;
				}
			}
		}
		return count;
	}
}
