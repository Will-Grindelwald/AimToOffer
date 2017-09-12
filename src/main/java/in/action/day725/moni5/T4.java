package in.action.day725.moni5;

import java.util.Scanner;

/**
 * 
 * 牛牛有一些字母卡片, 每张卡片上都有一个小写字母, 所有卡片组成一个字符串 s。牛牛一直认为回文这种性质十分优雅,
 * 于是牛牛希望用这些卡片拼凑出一些回文串, 但是有以下要求: 1、每张卡片只能使用一次 2、要求构成的回文串的数量最少 牛牛想知道用这些字母卡片,
 * 最少能拼凑出多少个回文串。 例如: s = "abbaa", 输出 1, 因为最少可以拼凑出 "ababa" 这一个回文串 s = "abc", 输出
 * 3, 因为最少只能拼凑出 "a","b","c" 这三个回文串
 * 
 * 输入描述: 输入包括一行, 一个字符串 s, 字符串 s 长度 length(1 ≤ length ≤ 1000). s 中每个字符都是小写字母
 * 
 * 输出描述: 输出一个整数, 即最少的回文串个数。
 * 
 * 输入例子 1: abc
 * 
 * 输出例子 1: 3
 *
 */
public class T4 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.next();
		}
		char[] chars = s.toCharArray();
		int[] map = new int[26];
		for (int i = 0; i < chars.length; i++) {
			map[chars[i] - 'a']++;
		}
		int num = 0;
		for (int i = 0; i < 26; i++) {
			if (map[i] % 2 != 0)
				num++;
		}
		System.out.println(num);
	}
}
