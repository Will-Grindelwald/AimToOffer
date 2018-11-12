package in.action.year2017.day0725.moni5;

import java.util.Scanner;

/**
 * 
 * 牛牛从生物科研工作者那里获得一段字符串数据 s, 牛牛需要帮助科研工作者从中找出最长的 DNA 序列。DNA
 * 序列指的是序列中只包括'A','T','C','G'。牛牛觉得这个问题太简单了, 就把问题交给你来解决。 例如: s = "ABCBOATER"
 * 中包含最长的 DNA 片段是 "AT", 所以最长的长度是 2。
 * 
 * 输入描述: 输入包括一个字符串 s, 字符串长度 length(1 ≤ length ≤ 50), 字符串中只包括大写字母('A'~'Z')。
 * 
 * 输出描述: 输出一个整数, 表示最长的 DNA 片段
 * 
 * 输入例子: ABCBOATER
 * 
 * 输出例子: 2
 *
 */
public class T2 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.next();
		}
		char[] chars = s.toCharArray();
		int max = 0, cur = 0;
		for (char c : chars) {
			if (c == 'A' || c == 'T' || c == 'C' || c == 'G') {
				cur++;
			} else {
				if (max < cur) 
					max = cur;
				cur = 0;
			}
		}
		if (max < cur) 
			max = cur;
		System.out.println(max);
	}
}
