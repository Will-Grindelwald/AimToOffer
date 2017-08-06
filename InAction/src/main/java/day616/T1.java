package day616;

import java.util.Scanner;

/**
 * 
 * 牛牛有 n 张卡片排成一个序列. 每张卡片一面是黑色的, 另一面是白色的。初始状态的时候有些卡片是黑色朝上,
 * 有些卡片是白色朝上。牛牛现在想要把一些卡片翻过来, 得到一种交替排列的形式,
 * 即每对相邻卡片的颜色都是不一样的。牛牛想知道最少需要翻转多少张卡片可以变成交替排列的形式。
 * 
 * 输入描述: 输入包括一个字符串 S,字符串长度 length(3 ≤ length ≤ 50), 其中只包含 'W' 和 'B' 两种字符串,
 * 分别表示白色和黑色。整个字符串表示卡片序列的初始状态。
 * 
 * 输出描述: 输出一个整数, 表示牛牛最多需要翻转的次数。
 * 
 * 输入例子: BBBW
 * 
 * 输出例子: 1
 *
 */
public class T1 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.next();
		}
		char[] chars = s.toCharArray();
		int num = 0;
		for (int i = 0; i < chars.length; i++) {
			if (i % 2 == 0) {
				if (chars[i] == 'W')
					num++;
			} else {
				if (chars[i] == 'B')
					num++;
			}
		}
		if (num > chars.length - num)
			num = chars.length - num;
		System.out.println(num);
	}
}
