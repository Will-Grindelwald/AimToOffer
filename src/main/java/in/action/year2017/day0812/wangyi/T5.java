package in.action.year2017.day0812.wangyi;

import java.util.Scanner;

/**
 * 
 * 小易为了向他的父母表现他已经长大独立了, 他决定搬出去自己居住一段时间。一个人生活增加了许多花费: 小易每天必须吃一个水果并且需要每天支付 x
 * 元的房屋租金。当前小易手中已经有 f 个水果和 d 元钱, 小易也能去商店购买一些水果, 商店每个水果售卖 p 元。小易为了表现他独立生活的能力,
 * 希望能独立生活的时间越长越好, 小易希望你来帮他计算一下他最多能独立生活多少天。
 * 
 * 输入描述: 输入包括一行, 四个整数 x, f, d, p(1 ≤ x,f,d,p ≤ 2 * 10^9), 以空格分割
 * 
 * 输出描述: 输出一个整数, 表示小易最多能独立生活多少天。
 * 
 * 输入例子 1: 3 5 100 10
 * 
 * 输出例子 1: 11
 *
 */
public class T5 {
	public static void main(String[] args) {
		int x = 0, f = 0, d = 0, p = 0;
		try (Scanner in = new Scanner(System.in)) {
			x = in.nextInt();
			f = in.nextInt();
			d = in.nextInt();
			p = in.nextInt();
		}
		long tmp = d + ((long) f) * p;
		int t = (int) (tmp / (x + p));
		if (t * x > d)
			t = d / x;
		System.out.println(t);
	}
}
