package in.action.year2017.day0519.moni3;

import java.util.Scanner;

/**
 * 
 * 牛牛手里有一个字符串 A，羊羊的手里有一个字符串 B，B 的长度大于等于 A，所以牛牛想把 A 串变得和 B 串一样长，这样羊羊就愿意和牛牛一起玩了。
 * 而且 A 的长度增加到和 B 串一样长的时候，对应的每一位相等的越多，羊羊就越喜欢。比如 "abc" 和 "abd" 对应相等的位数为 2，为前两位。
 * 牛牛可以在 A 的开头或者结尾添加任意字符，使得长度和 B 一样。现在问牛牛对 A 串添加完字符之后，不相等的位数最少有多少位？
 * 
 * 输入描述: 第一行为字符串 A，第二行为字符串 B，A 的场地小于等于 B 的长度，B 的长度小于等于 50.字符均为小写字母。
 * 
 * 输出描述: 输出一个整数表示 A 串添加完字符之后，不相等的位数最少有多少位？
 * 
 * 输入例子: abe cabc
 * 
 * 输出例子: 1
 *
 */
public class T3 {
	public static void main(String[] args) {
		char[] a = null, b = null;
		try (Scanner in = new Scanner(System.in)) {
			a = in.nextLine().toCharArray();
			b = in.nextLine().toCharArray();
		}
		int min = Integer.MAX_VALUE, notEquals = 0;
		for (int i = 0; i <= b.length - a.length; i++) {
			notEquals = 0;
			for (int j = 0; j < a.length; j++) {
				if (a[j] != b[i + j])
					notEquals++;
			}
			min = min < notEquals ? min : notEquals;
		}
		System.out.println(min);
	}
}
