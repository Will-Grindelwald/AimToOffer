package day826.pm;

import java.util.Scanner;

/**
 * 
 * n 根彩色粉笔，m 根白色粉笔，可以 a 根彩色粉笔和 b 根白色粉笔，组成一盒卖 x 元，c 根白色粉笔一盒卖 y 元， d 根白色粉笔一盒卖 z
 * 元，问最多可以卖多少钱？不一定要全卖完。
 * 
 * 样例输入： 5 5 1 2 3 3 2 1 3
 * 
 * 样例输出：7
 * 
 * 样例输入2： 5 15 1 2 3 6 2 1 3
 * 
 * 样例输出2：11
 * 
 */
public class T1 {

	public static void main(String[] args) {
		int n = 0, m = 0, a = 0, b = 0, c = 0, d = 0, x = 0, y = 0, z = 0;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			m = in.nextInt();
			a = in.nextInt();
			b = in.nextInt();
			c = in.nextInt();
			d = in.nextInt();
			x = in.nextInt();
			y = in.nextInt();
			z = in.nextInt();
		}
		int sum = 0;
		if ((double) z / d * a + (double) y / c * b >= x) { // 选分着卖
			sum += n / d * z;
			n %= d;
			sum += m / c * y;
			m %= c;
			int tmp = n / a > m / b ? m / b : n / a;
			sum += tmp * x;
		} else { // 选合着卖
			int tmp = n / a > m / b ? m / b : n / a;
			sum += tmp * x;
			n -= tmp * a;
			m -= tmp * b;
			sum += n / d * z;
			sum += m / c * y;
		}
		System.out.println(sum);
	}
}
