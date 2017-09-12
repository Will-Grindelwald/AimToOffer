package in.action.day831.meituan;

import java.util.Scanner;

/**
 * 
 * 序列中任意个连续的元素组成的子序列称为该序列的子串。 现在给你一个序列 P 和一个整数 K，询问元素和是 K 的倍数的子串的最大长度。
 * 比如序列【1,2,3,4,5】，给定的整数 K 为 5，其中满足条件的子串为 {5}、{2,3}、{1,2,3,4}、{1,2,3,4,5}，
 * 那么答案就为 5，因为最长的子串为 {1,2,3,4,5}；如果满足条件的子串不存在，就输出 0。
 * 
 * 输入 第一行包含一个整数 N, 1 ≤ 𝑁 ≤ 105 。 第二行包含 N 个整数𝑝𝑖 ，𝑝𝑖 表示序列 P 第 i 个元素的值。0 ≤
 * 𝑝𝑖 ≤ 105 。 第三行包含一个整数 K， 1 ≤ 𝐾 ≤ 105 。
 * 
 * 输出 输出一个整数 ANS，表示答案。
 * 
 */
// 样例输入
// Input Sample 1
// 5
// 1 2 3 4 5
// 5
// Input Sample 2
// 6
// 3 1 2 7 7 7
// 4
// 样例输出
// Output Sample 1
// 5
// Output Sample 2
// 5
public class T1HARD {
	public static void main(String[] args) {
		int n = 0, k = 0;
		int[] arr = null;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
			k = in.nextInt();
		}

		// 暴力解法
		// 感觉会有更优的解法
		int sum = 0, max = 0;
		for (int i = 0; i < arr.length; i++) {
			if (arr.length - i < max) { // 优化点，不优化则有用例时间超限
				break;
			}
			sum = 0;
			for (int j = i; j < arr.length; j++) {
				sum += arr[j];
				if (sum % k == 0 && max < (j - i + 1)) {
					max = j - i + 1;
					sum = 0;
				}
			}
		}
		System.out.println(max);
	}
}
