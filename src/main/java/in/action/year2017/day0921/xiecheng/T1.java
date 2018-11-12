package in.action.year2017.day0921.xiecheng;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * 
 * <pre>
 * 题目描述：
给定一个英文字符串，将其中的重复字符删除，保证每个字符仅出现一次。返回结果中字符出现的先后顺序与原字符串需保持一致。
Example1:
输入："Hello World!"
输出："Helo Wrd!"
Example2:
输入："cbacdcbc"
输出："cbad"
输入
英文字符串
输出
删除重复字符的字符串，字符先后顺序与原字符串需保持一致

样例输入
Hello World!
样例输出
Helo Wrd!
 * </pre>
 * 
 */
public class T1 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.nextLine();
			compute(s.toCharArray());
		}
	}

	public static void compute(char[] cs) {
		Set<Character> charSet = new HashSet<>();
		for (int i = 0; i < cs.length; i++) {
			if (!charSet.contains(cs[i])) {
				charSet.add(cs[i]);
				System.out.print(cs[i]);
			}
		}
	}
}
