package in.action.day0913.qq;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * 
 * 
 */
public class T1 {
	private static int[][] m;
	private static boolean[] marked;

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int k = in.nextInt();
		m = new int[n][n];
		for (int i = 0; i < n; i++) {
			char[] cs = in.nextLine().toCharArray();
			for (int j = 0; j < cs.length; j++) {
				m[i][j] = cs[j] - '0';
			}
		}
		System.out.println(compute(m, k));
	}

	public static int compute(int[][] m, int k) {
		List<PriorityQueue<Integer>> ress = new ArrayList<>();
		PriorityQueue<Integer> res = null;
		marked = new boolean[m.length];
		marked[0] = true;
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < marked.length; j++) {
				marked[j] = false;
			}
			res = new PriorityQueue<>();
			
			ress.add(res);
		}
		return 0;
	}
}
