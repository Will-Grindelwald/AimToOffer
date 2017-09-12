package in.action.模板;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MB {
	public static void main(String[] args) {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		try {
			int points = Integer.valueOf(bf.readLine());
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

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
