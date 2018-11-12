package in.action.year2017.day0616.moni4;

import java.util.Scanner;

/**
 * 
 * 牛牛变得黑化了, 想要摧毁掉地球。但他忘记了开启地球毁灭器的密码。牛牛手里有一个字符串 S, 牛牛还记得从 S 中去掉一个字符就恰好是正确的密码,
 * 请你帮牛牛求出他最多需要尝试多少次密码。 如样例所示 S = "ABA",3 个可能的密码是 "BA", "AA", "AB". 当 S = "A",
 * 牛牛唯一可以尝试的密码是一个空的密码, 所以输出 1.
 * 
 * 输入描述: 输入包括一个字符串 S, 字符串长度 length(1 ≤ length ≤ 50), 其中都是从 'A' 到 'Z' 的大写字母。
 * 
 * 输出描述: 输出一个整数, 表示牛牛最多需要尝试的密码次数。
 * 
 * 输入例子: ABA
 * 
 * 输出例子: 3
 *
 */
public class T2 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.next();
		}
		char[] chars = s.toCharArray();
		int num = 1;
		for (int i = 1; i < chars.length; i++) {
			if (chars[i] != chars[i - 1])
				num++;
		}
		System.out.println(num);
	}
}
