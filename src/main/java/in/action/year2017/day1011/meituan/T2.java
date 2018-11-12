package in.action.year2017.day1011.meituan;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class T2 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n, m;
			n = in.nextInt();
			m = in.nextInt();
			int[] a = new int[n + 1], b = new int[m + 1];
			for (int i = 1; i <= m; i++) {
				b[i] = in.nextInt();
				a[b[i]] = -1;
			}
			Set<Integer> set = new HashSet<>();
			for (int i = m; i >= 1; i--) {
				if (set.contains(b[i])) {
					continue;
				} else {
					set.add(b[i]);
					System.out.println(b[i]);
				}
			}
			for (int i = 1; i <= n; i++) {
				if (a[i] != -1) {
					System.out.println(i);
				}
			}
		}
	}
}
