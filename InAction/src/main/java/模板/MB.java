package 模板;

import java.util.Scanner;

public class MB {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.next();
		}

		int n = 0;
		int[] arr = null;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++) {
				arr[i] = in.nextInt();
			}
		}

		System.out.println(s);
	}
}
