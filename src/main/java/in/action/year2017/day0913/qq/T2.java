package in.action.year2017.day0913.qq;

import java.util.Scanner;

public class T2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		int A = sc.nextInt();
		int B = sc.nextInt();
		sc.close();
		System.out.println(compute(a, b, A, B));
	}

	public static int compute(int a, int b, int A, int B) {
		int sum = 0;
		int tmp = A;
		while (tmp / 2 >= a) {
			sum++;
			tmp = tmp / 2;
		}
		if (sum == 0) {
			sum += (A - a);
		}
		if (sum < 0) {
			return -1;
		}
		tmp = A % a;
		if (tmp % 2 == 0) {
			sum += (tmp / 2);
		} else {
			sum += (tmp / 2 + 1);
		}
		return sum;
	}
}
