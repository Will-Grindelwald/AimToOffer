package in.action.day0917.souhu;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 回文数组
 * 
 * 对于一个给定的正整数组成的数组 a[] ，如果将 a 倒序后数字的排列与 a 完全相同，我们称这个数组为 “回文” 的。 例如， [1, 2, 3, 2,
 * 1] 的倒序是他自己，所以是一个回文的数组；而 [1, 2, 3, 1, 2] 的倒序是 [2, 1, 3, 2, 1] ，所以不是一个回文的数组。
 * 对于任意一个正整数数组，如果我们向其中某些特定的位置插入一些正整数，那么我们总是能构造出一个回文的数组。
 * 
 * 输入一个正整数组成的数组，要求你插入一些数字，使其变为回文的数组，且数组中所有数字的和尽可能小。输出这个插入后数组中元素的和。
 * 
 * 例如，对于数组 [1, 2, 3, 1, 2] 我们可以插入两个 1 将其变为回文的数组 [1, 2, 1, 3, 1, 2, 1]
 * ，这种变换方式数组的总和最小，为 11 ，所以输出为 11 。
 * 
 * 输入描述: 输入数据由两行组成： 第一行包含一个正整数 L ，表示数组 a 的长度。 第二行包含 L 个正整数，表示数组 a 。 对于 40% 的数据：
 * 1 < L <= 100 达成条件时需要插入的数字数量不多于 2 个。 对于 100% 的数据： 1 < L <= 1,000 0 < a[i] <=
 * 1,000,000 达成条件时需要插入的数字数量没有限制。
 * 
 * 输出描述: 输出一个整数，表示通过插入若干个正整数使数组 a 回文后，数组 a 的数字和的最小值。
 * 
 * 示例 1 输入 8 51 23 52 97 97 76 23 51
 * 
 * 输出 598
 * 
 */
public class T2HARD {
	public static void main(String[] args) {
		List<Integer> arr = new ArrayList<>();
		try (Scanner in = new Scanner(System.in)) {
			int len = Integer.valueOf(in.nextLine());
			for (int i = 0; i < len; i++) {
				arr.add(in.nextInt());
			}
		}
		System.out.println(compute(arr));
	}

	public static int compute(List<Integer> arr) {
		int sum = 0;
		int i = 0, j = arr.size() - 1;
		while (i < j) {
			sum += arr.get(i) + arr.get(j);
			if (arr.get(i) != arr.get(j)) {
				if (arr.get(i + 1) == arr.get(j - 1)) {
					sum += arr.get(i) + arr.get(j);
				} else if (arr.get(i + 1) == arr.get(j)) {
					sum += arr.get(i);
					j++;
				} else if (arr.get(i) == arr.get(j - 1)) {
					sum += arr.get(j);
					i--;
				}
			}
			i++;
			j--;
		}
		if (arr.size() % 2 == 1) {
			sum += arr.get(arr.size() / 2);
		}
		return sum;
	}

	// 运行错误的用例：2 1 2 3 4
	public static int compute2(List<Integer> arr) {
		int i = 0, j = arr.size() - 1;
		while (i < j) {
			int left = arr.get(i);
			int right = arr.get(j);
			if (left == right) {
				i++;
				j--;
			} else {
				int ni = i + 1;
				int nj = j - 1;
				if (ni < nj && nj >= 0 && left == arr.get(nj) || left > right) {
					arr.add(i, right);
					i++;
				} else if (ni < nj && ni < arr.size() && right == arr.get(ni) || left < right) {
					arr.add(j + 1, left);
					i++;
				}
			}
		}
		int sum = 0;
		for (Integer ii : arr)
			sum += ii;
		return sum;
	}
}
