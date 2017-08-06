package day616;

import java.util.Scanner;

/**
 * 
 * 牛牛以草料为食。牛牛有一天依次遇到 n 堆被施展了魔法的草料, 牛牛只要遇到一堆跟他当前相同大小的草料, 它就会把草料吃完,
 * 而使自己的大小膨胀一倍。一开始牛牛的大小的是 A, 然后给出牛牛依次遇到的 n 堆草料的大小。请计算牛牛最后的大小。
 * 
 * 输入描述: 输入包括两行, 第一行包含两个整数 n 和 A(1 ≤ n ≤ 200, 1 ≤ A ≤ 1,000,000,000), 第二行包括n个整数,
 * 表示牛牛依次遇到的草料堆大小 a_i(1 ≤ a_i ≤ 1,000,000,000)
 * 
 * 输出描述: 输出一个整数, 表示牛牛最后的大小。
 * 
 * 输入例子: 5 1 2 1 3 1 2
 * 
 * 输出例子: 4
 *
 */
public class T3 {
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
