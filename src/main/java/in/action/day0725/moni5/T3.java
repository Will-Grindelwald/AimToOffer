package in.action.day0725.moni5;

import java.util.Scanner;

/**
 * 
 * 如果一个字符串由两个相同字符串连接而成, 就称这个字符串是偶串。例如 "xyzxyz" 和 "aaaaaa" 是偶串, 但是 "ababab" 和
 * "xyzxy" 却不是。 牛牛现在给你一个只包含小写字母的偶串 s, 你可以从字符串 s 的末尾删除 1 和或者多个字符,
 * 保证删除之后的字符串还是一个偶串, 牛牛想知道删除之后得到最长偶串长度是多少。
 * 
 * 输入描述: 输入包括一个字符串 s, 字符串长度 length(2 ≤length ≤ 200), 保证 s 是一个偶串且由小写字母构成
 * 
 * 输出描述: 输出一个整数, 表示删除之后能得到的最长偶串长度是多少。保证测试数据有非零解
 * 
 * 输入例子: abaababaab
 * 
 * 输出例子: 6
 *
 */
public class T3 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.next();
		}
		char[] chars = s.toCharArray();
		int i = 0, j = 0, k = 0;
		for (i = chars.length - 2; i > 0; i -= 2) {
			for (j = i / 2, k = 0; j < i; j++, k++) {
				if (chars[k] != chars[j])
					break;
			}
			if (j != i)
				continue;
			else
				break;
		}
		System.out.println(i);
	}
}
