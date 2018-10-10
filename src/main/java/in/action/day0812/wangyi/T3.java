package in.action.day0812.wangyi;

import java.util.Scanner;

/**
 * 
 * 如果一个 01 串任意两个相邻位置的字符都是不一样的, 我们就叫这个 01 串为交错 01 串。例如: "1", "10101", "0101010"
 * 都是交错 01 串。 小易现在有一个 01 串 s, 小易想找出一个最长的连续子串, 并且这个子串是一个交错 01
 * 串。小易需要你帮帮忙求出最长的这样的子串的长度是多少。
 * 
 * 输入描述: 输入包括字符串 s, s 的长度 length(1 ≤ length ≤ 50), 字符串中只包含'0'和'1'
 * 
 * 输出描述: 输出一个整数, 表示最长的满足要求的子串长度。
 * 
 * 输入例子 1: 111101111
 * 
 * 输出例子 1: 3
 *
 */
public class T3 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.next();
		}
		char[] chars = s.toCharArray();
		char last = chars[0];
		int num = 1, max = 0;
		for (int i = 1; i < chars.length; i++) {
			if (last == '0') {
				if (chars[i] == '1')
					num++;
				else {
					if (max < num) max = num;
					num = 1;
				}
			} else {
				if (chars[i] == '0')
					num++;
				else {
					if (max < num) max = num;
					num = 1;
				}
			}
			last = chars[i];
		}
		if (max < num)
			max = num;
		System.out.println(max);
	}
}
