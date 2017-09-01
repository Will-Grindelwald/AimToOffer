package day826.pm;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 给定两个序列 a、b，可以任意交换两个序列的两个元素，最多交换两次，问两个序列的和的差值的绝对值最小是多少？|SumA-SumB|
 * 
 */
// 样例输入：
// 4
// 1 3 7 9
// 3
// 2 10 12
// 样例输出：0
public class T3 {

	public static void main(String[] args) {
		int n = 0;
		int m = 0;
		int[] a = null;
		int[] b = null;
		int sumA = 0, sumB = 0;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			a = new int[n];
			for (int i = 0; i < n; i++) {
				sumA += a[i] = in.nextInt();
			}
			m = in.nextInt();
			b = new int[m];
			for (int i = 0; i < m; i++) {
				sumB += b[i] = in.nextInt();
			}
		}
		List<Integer> listA = new ArrayList<>();
		List<Integer> listB = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			listA.add(a[i]);
			for (int j = i + 1; j < n; j++) {
				listA.add(a[i] + a[j]);
			}
		}
		for (int i = 0; i < m; i++) {
			listB.add(b[i]);
			for (int j = i + 1; j < m; j++) {
				listB.add(b[i] + b[j]);
			}
		}
		Collections.sort(listA);
		Collections.sort(listB);
		int det = Math.abs(sumA - sumB);
		int max = 0, sur = 0;

		System.out.println(det - max);
	}

}
