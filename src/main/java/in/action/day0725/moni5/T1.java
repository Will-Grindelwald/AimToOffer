package in.action.day0725.moni5;

import java.util.Scanner;

/**
 * 
 * 牛牛喜欢彩色的东西, 尤其是彩色的瓷砖。牛牛的房间内铺有 L 块正方形瓷砖。每块砖的颜色有四种可能: 红、绿、蓝、黄。给定一个字符串 S, 如果 S 的第
 * i 个字符是'R', 'G', 'B'或'Y', 那么第 i 块瓷砖的颜色就分别是红、绿、蓝或者黄。 牛牛决定换掉一些瓷砖的颜色,
 * 使得相邻两块瓷砖的颜色均不相同。请帮牛牛计算他最少需要换掉的瓷砖数量。
 * 
 * 输入描述: 输入包括一行, 一个字符串S, 字符串长度 length(1 ≤ length ≤ 10), 字符串中每个字符串都是 'R', 'G',
 * 'B'或者'Y'。
 * 
 * 输出描述: 输出一个整数, 表示牛牛最少需要换掉的瓷砖数量
 * 
 * 输入例子: RRRRRR
 * 
 * 输出例子: 3
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
		for (int i = 1; i < chars.length; i++) {
			if(chars[i] == chars[i - 1]) {
				num++;
				if (i == chars.length - 1) {
					if ('R' != chars[i - 1]) chars[i] = 'R';
					else
						chars[i] = 'G';
				} else if ('R' != chars[i - 1] && 'R' != chars[i + 1])
					chars[i] = 'R';
				else if ('G' != chars[i - 1] && 'G' != chars[i + 1])
					chars[i] = 'G';
				else
					chars[i] = 'B';
				i++;
			}
		}
		System.out.println(num);
	}
}
