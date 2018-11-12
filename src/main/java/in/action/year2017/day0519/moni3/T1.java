package in.action.year2017.day0519.moni3;

import java.util.Scanner;

/**
 * 
 * 牛牛想对一个数做若干次变换，直到这个数只剩下一位数字。 变换的规则是：将这个数变成 所有位数上的数字的乘积。比如 285 经过一次变换后转化成
 * 2*8*5=80. 问题是，要做多少次变换，使得这个数变成个位数。
 * 
 * 输入描述: 输入一个整数。小于等 于2,000,000,000。
 * 
 * 输出描述: 输出一个整数，表示变换次数。
 * 
 * 输入例子: 285
 * 
 * 输出例子: 2
 *
 */
public class T1 {
	public static void main(String[] args) {
		int count = 0, number = 0, multiplyTmp = 1;
		try (Scanner in = new Scanner(System.in)) {
			number = in.nextInt();
		}
		while (number >= 10) {
			while (number != 0) {
				multiplyTmp *= number % 10;
				number /= 10;
			}
			number = multiplyTmp;
			multiplyTmp = 1;
			count++;
		}
		System.out.println(count);
	}
}
