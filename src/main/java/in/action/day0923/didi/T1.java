package in.action.day0923.didi;

import java.util.Scanner;

/**
 * 
 * 
 * 
 */
public class T1 {
	public static void main(String[] args) {
		String s = null;
		try (Scanner in = new Scanner(System.in)) {
			s = in.nextLine();
			compute(s.toCharArray());
		}
	}

	public static void compute(char[] cs) {
	}
}
