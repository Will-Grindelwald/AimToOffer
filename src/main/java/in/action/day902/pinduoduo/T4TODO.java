package in.action.day902.pinduoduo;

import java.util.Scanner;

/**
 * 
 * 
 * 
 */
// 做得不对
public class T4TODO {
	public static void main(String[] args) {
		int n = 0, m = 0, k = 0, l = 0, r = 0;
		int[] arr = new int[201];
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			m = in.nextInt();
			k = in.nextInt();
			l = in.nextInt();
			r = in.nextInt();
			for (int i = 0; i < n; i++) {
				arr[in.nextInt() + 100] = 1;
			}
		}
		int count = 0;
		for (int i = l; i <= r; i++) {
			if (arr[i + 100] == 1) {
				count++;
			}
		}
		if (count < k) {
			System.out.println(0);
			return;
		}
		long res = 1;
		int k2 = k > count / 2 ? count - k : k;
		for (int i = count; i > count - k2; i--) {
			res *= i;
		}
		int k3 = k > m / 2 ? m - k : k;
		for (int i = m; i > m - k3; i--) {
			res *= i;
		}
		for (int i = 2; i <= k; i++) {
			res /= i * i;
		}
		System.out.println(res % 10007);
	}
}