package in.action.year2017.day0519.moni3;

import java.util.Scanner;

/**
 * 
 * 给出一个区间 [a, b]，计算区间内 “神奇数” 的个数。 神奇数的定义：存在不同位置的两个数位，组成一个两位数（且不含前导 0），且这个两位数为质数。
 * 比如：153，可以使用数字 3 和数字 1 组成 13，13 是质数，满足神奇数。同样 153 可以找到 31 和 53
 * 也为质数，只要找到一个质数即满足神奇数。
 * 
 * 输入描述: 输入为两个整数 a 和 b，代表[a, b]区间 (1 ≤ a ≤ b ≤ 1000000000)。
 * 
 * 输出描述: 输出为一个整数，表示区间内满足条件的整数个数
 * 
 * 输入例子: 11 20
 * 
 * 输出例子: 6
 * 
 * 测试用例: 97463 100000
 * 
 * 对应输出应该为:
 * 
 * 2436
 *
 */
public class T2 {
	public static void main(String[] args) {
		int a = 0, b = 0;
		try (Scanner in = new Scanner(System.in)) {
			a = in.nextInt();
			b = in.nextInt();
		}
		int[] num = new int[10];
		int len, tmp, count = 0;
		for (int i = a; i <= b; i++) {
			tmp = i;
			len = 0;
			while (tmp != 0) {
				num[len++] = tmp % 10;
				tmp /= 10;
			}
			Label: for (int j = 0; j < len; j++) {
				if (num[j] == 0)
					continue;
				for (int k = 0; k < len; k++) {
					if (k == j)
						continue;
					if (isPrime(num[j] * 10 + num[k])) {
						count++;
						break Label;
					}
				}
			}
		}
		System.out.println(count);
	}

	public static boolean isPrime(int num) {
		if ((num % 2 != 0) && (num % 3 != 0) && (num % 5 != 0) && (num % 7 != 0))
			return true;
		return false;
	}
}
