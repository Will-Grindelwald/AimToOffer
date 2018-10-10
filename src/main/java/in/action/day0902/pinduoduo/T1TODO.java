package in.action.day0902.pinduoduo;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * 
 * 
 */
// 只过了 30%？？？？
public class T1TODO {
	public static void main(String[] args) {
		int n = 0, m = 0;
		int[] candy = null;
		int[][] beers = null;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			m = in.nextInt();
			candy = new int[m];
			for (int i = 0; i < m; i++) {
				candy[i] = in.nextInt();
			}
			beers = new int[n][3];
			for (int i = 0; i < n; i++) {
				// 战斗力
				beers[i][0] = in.nextInt();
				// 饥饿值
				beers[i][1] = in.nextInt();
				beers[i][2] = i + 1;
			}
		}
		Arrays.sort(beers, new Comparator<int[]>() {
			// 战力递减
			public int compare(int[] o1, int[] o2) {
				return o2[0] - o1[0];
			}
		});
		Arrays.sort(candy);
		for (int i = 0; i < n; i++) {
			for (int j = m - 1; j >= 0; j--) {
				if (candy[j] != 0 && candy[j] <= beers[i][1]) {
					if ((beers[i][1] -= candy[j]) == 0) {
						break;
					}
				}
			}
		}
		Arrays.sort(beers, new Comparator<int[]>() {
			// id 递增
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < n; i++) {
			System.out.println(beers[i][1]);
		}
	}
}
