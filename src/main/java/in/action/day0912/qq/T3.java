package in.action.day0912.qq;

import java.util.Scanner;

public class T3 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			int[] x = new int[4];
			int[] y = new int[4];
			for (int i = 0; i < n; i++) {
				for (int j = 0; j < 4; j++) {
					x[i] = in.nextInt();
				}
				for (int j = 0; j < 4; j++) {
					y[i] = in.nextInt();
				}
				System.out.println(compute(x, y));
			}
		}
	}

	private static String compute(int[] x, int[] y) {
		Square s1 = new Square(x[0], y[0]);
		Square s2 = new Square(x[1], y[1]);
		Square s3 = new Square(x[2], y[2]);
		Square s4 = new Square(x[3], y[3]);
		if (s1.distance(s2) == s1.distance(s4) && s1.distance(s4) == s3.distance(s4)
				&& s3.distance(s4) == s3.distance(s2) && s1.distance(s3) == s2.distance(s4))
			return "YES";
		else
			return "NO";
	}
}

class Square {
	int x, y;

	public Square(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distance(Square s) {
		return Math.pow((x - s.x), 2) + Math.pow((y - s.y), 2);
	}
}
