package in.action.year2017.day0908.night.jd;

import java.util.Scanner;

/**
 * 
 * 题目见图
 * 
 */
// https://www.nowcoder.com/discuss/38889
public class T1HARD {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.nextLine();
		}
		System.out.println(compute(s.toCharArray()));
	}

	// 注意: 这种 "(()())" 是 4 种
	// 挨着累计'('的个数, 遇到')'就完成一次匹配, 把情况数乘进答案
	private static int compute(char[] cs) {
		int sum = 1;
		for (int i = 0, count = 0; i < cs.length; i++) {
			if (cs[i] == '(') {
				count++;
			} else {
				sum *= count--;
			}
		}
		return sum;
	}
}
