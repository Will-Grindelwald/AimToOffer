package in.action.day0519.moni3;

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
public class T5HARD {
	// 我的答案
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int nember = in.nextInt();
			boolean isdescend = true, newSubsequence = true;
			int index = 1, first, next = in.nextInt(), count = 1;
			while (index < nember) {
				if (newSubsequence) {
					do {
						first = next;
						next = in.nextInt();
						if (first > next)
							isdescend = true; // 递减
						else if (first < next)
							isdescend = false; // 递增
						index++;
					} while ((first == next) && (index < nember));
					newSubsequence = false;
				} else {
					do {
						first = next;
						next = in.nextInt();
						index++;
					} while (index < nember && (!isdescend || first >= next) && (isdescend || first <= next));
					if (isdescend && first < next || !isdescend && first > next)
						count++;
					newSubsequence = true;
				}
			}
			System.out.println(count);
		}
	}

	// 代码最好理解
	public static void main2(String[] args) {
		int number;
		int[] data;
		try (Scanner in = new Scanner(System.in)) {
			number = in.nextInt();
			data = new int[number];
			for (int i = 0; i < number; i++) {
				data[i] = in.nextInt();
			}
		}
		int flag = 0;
		int count = 1;
		for (int i = 1; i < number; i++) {
			if (data[i] > data[i - 1]) {
				if (flag == 0) {
					flag = 1;
				}
				if (flag == -1) {
					flag = 0;
					count++;
				}
			} else if (data[i] < data[i - 1]) {
				if (flag == 0) {
					flag = -1;
				}
				if (flag == 1) {
					flag = 0;
					count++;
				}
			}
		}
		System.out.println(count);
	}

	// 这个解法好短啊
	// 从 a[1] 到 a[n-2],
	// 统计非相邻的极值(a[i]>a[i-1]&&a[i]>a[i+1]||a[i]<a[i-1]&&a[i]<a[i+1])的个数 count,
	// 注意: 当a[n-3]为极值时, 需要判断a[n-2]是否为极值, 如果是 count++
	public static void main3(String[] args) {
		int number;
		int[] date;
		try (Scanner in = new Scanner(System.in)) {
			number = in.nextInt();
			date = new int[number];
			for (int i = 0; i < number; i++) {
				date[i] = in.nextInt();
			}
		}
		int count = 1;
		for (int i = 1; i < number - 1; i++) {
			if (date[i] > date[i - 1] && date[i] > date[i + 1] || date[i] < date[i - 1] && date[i] < date[i + 1]) {
				count++;
				if (i != number - 3) {
					i++;
				}
			}
		}
		System.out.println(count);
	}
}
