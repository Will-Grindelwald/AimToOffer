package day519;

import java.util.Scanner;

/**
 * 
 * 定义: 排序子序列 为一个数组中一段连续的子序列, 并且这段子序列是非递增或者非递减排序的.
 * 
 * 现有一个长度为 n 的整数数组 A, 要把数组 A 分为若干段排序子序列, 想知道最少可以把这个数组分为几段 排序子序列. 如样例所示, 牛牛可以把数组
 * A 划分为[1,2,3]和[2,2,1]两个排序子序列, 至少需要划分为 2 个排序子序列, 所以输出 2.
 * 
 * 输入描述: 输入的第一行为一个正整数 n(1 ≤ n ≤ 10^5),第二行包括 n 个整数 A_i(1 ≤ A_i ≤ 10^9),表示数组 A
 * 的每个数字.
 * 
 * 输出描述: 输出一个整数表示牛牛可以将 A 最少划分为多少段排序子序列
 * 
 * 输入例子: <br>
 * 6 <br>
 * 1 2 3 2 2 1
 * 
 * 输出例子: 2
 *
 */
public class T5 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int nember = in.nextInt();
			int count = 1;
			boolean flag1 = true, flag2 = false;
			int first, next;
			int index = 1;
			next = in.nextInt();
			do {
				first = next;
				next = in.nextInt();
				if (first > next)
					flag1 = true; // 递减
				else if (first < next)
					flag1 = false; // 递增
				index++;
			} while ((first == next) && (index < nember));
			for (; index < nember; index++) {
				if (flag2) {
					do {
						first = next;
						next = in.nextInt();
						if (first > next)
							flag1 = true; // 递减
						else if (first < next)
							flag1 = false; // 递增
						index++;
					} while ((first == next) && (index < nember));
					flag2 = false;
					index--;
				} else {
					first = next;
					next = in.nextInt();
					if (flag1) {
						if (first < next) {
							count++;
							flag2 = true;
						}
					} else {
						if (first > next) {
							count++;
							flag2 = true;
						}
					}
				}
			}
			System.out.println(count);
		}
	}

}
