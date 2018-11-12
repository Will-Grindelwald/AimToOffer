package in.action.year2017.day0916.cvte;

import java.util.Scanner;

/**
 * 
 * 
 * 
 */
// 后来又遇到（2017.10.12 王玉忠 商汤 在牛客上 过 90%）
public class T1 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.nextLine();
		}
		System.out.println(compute(s.toCharArray()));
	}

	public static int compute(char[] cs) {
		int[] a = new int[cs.length], b = new int[cs.length];
		a[0] = 1;
		for (int i = 1; i < cs.length; i++) {
			if (cs[i] == '0') {
				a[i] = 0;
			} else {
				a[i] = a[i - 1] + b[i - 1];
			}
			if (cs[i - 1] == '1' || (cs[i - 1] == '2' && (cs[i] >= '0' && cs[i] <= '6'))) {
				if (i == 1) {
					b[i] = 1;
				} else {
					b[i] = a[i - 2] + b[i - 2];
				}
			}
		}
		return a[a.length - 1] + b[b.length - 1];
	}
}
