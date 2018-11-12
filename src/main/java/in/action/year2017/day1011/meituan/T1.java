package in.action.year2017.day1011.meituan;

import java.util.Scanner;

public class T1 {
	public static void main(String[] args) {
		int n;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
		}
		int count = n / 3;
		int flag = n % 3;
		int last = n - n / 3 * 3;
		if (flag == 1) {
			for (int i = 0; i < count; i++) {
				System.out.print("12");
			}
			System.out.println(1);
		} else {
			for (int i = 0; i < count; i++) {
				System.out.print("21");
			}
			if (last != 0) {
				System.out.println(2);
			}
		}
	}
}
