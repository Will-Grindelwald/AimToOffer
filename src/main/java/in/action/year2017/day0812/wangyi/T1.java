package in.action.year2017.day0812.wangyi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 
 * 小易有一些彩色的砖块。每种颜色由一个大写字母表示。各个颜色砖块看起来都完全一样。现在有一个给定的字符串 s, s
 * 中每个字符代表小易的某个砖块的颜色。小易想把他所有的砖块排成一行。如果最多存在一对不同颜色的相邻砖块,
 * 那么这行砖块就很漂亮的。请你帮助小易计算有多少种方式将他所有砖块排成漂亮的一行。(如果两种方式所对应的砖块颜色序列是相同的,
 * 那么认为这两种方式是一样的。) 例如: s = "ABAB", 那么小易有六种排列的结果:
 * "AABB","ABAB","ABBA","BAAB","BABA","BBAA" 其中只有 "AABB" 和 "BBAA"
 * 满足最多只有一对不同颜色的相邻砖块。
 * 
 * 输入描述: 输入包括一个字符串 s, 字符串 s 的长度 length(1 ≤ length ≤ 50), s 中的每一个字符都为一个大写字母(A 到
 * Z)。
 * 
 * 输出描述: 输出一个整数, 表示小易可以有多少种方式。
 * 
 * 输入例子 1: ABAB
 * 
 * 输出例子 1: 2
 *
 */
public class T1 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.next();
		}
		char[] chars = s.toCharArray();
		Set<Character> characters = new HashSet<>(); // 字母去重
		for (char c : chars) {
			characters.add(c);
		}
		if (characters.size() == 2) {
			System.out.println(2);
		} else if (characters.size() == 1) {
			System.out.println(1);
		} else
			System.out.println(0);
	}
}
