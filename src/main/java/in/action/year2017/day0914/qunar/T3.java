package in.action.year2017.day0914.qunar;

import java.util.Scanner;

/**
 * 
 * 为了防止期末考试有同学作弊，已知在一个 M 行 N 列 (1<=N,M<=10) 的教室中，坐在 (x,y) 位置的学生可以偷窥到
 * (x-1,y),（x+1,y）(x-1,y-1),(x+1,y-1) 四个位置的同学的答卷。另外，教室中有一些座位是不能坐的 (好的座椅用.
 * 表示，坏的座椅用 x 表示)，要求给出在给定的教室中能够安排多少学生参加考试。
 * 
 * 第一行输入两个数，分别代表行数和列数（以空格隔开），第 2~1+M 行为座椅。输出的唯一一行为最大能容纳的同学人数
 * 
 * 输入 第一行输入两个数，分别代表行数和列数（以空格隔开），第 2~1+M 行为座椅
 * 
 * 输出 输出的唯一一行为最大能容纳的同学人数
 * 
 * 样例输入 2 3 … …
 * 
 * 样例输出 4
 * 
 */
/**
 * 
 * 这个解法有问题：虽然当时 ac 了
 * 
 * 不能通过的用例：
 * 
 * <pre>
 * 3 2
 * .x
 * xx
 * x.
 * </pre>
 * 答案应为 2
 * 
 */
public class T3 {
	public static boolean[][] m;

	public static int compute(int index) {
		int cnt = 0;
		int row = m.length;
		int col = m[0].length;
		if (col <= index) {
			return 0;
		}
		for (int i = index; i < col; i += 2) {
			for (int j = 0; j < row; j++) {
				cnt += (m[j][i] ? 1 : 0);
			}
		}
		return cnt;
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			String[] strs = in.nextLine().split("\\s+");
			int r = Integer.parseInt(strs[0]);
			int c = Integer.parseInt(strs[1]);
			m = new boolean[r][c];
			for (int i = 0; i < r; i++) {
				String str = in.nextLine();
				for (int j = 0; j < c; j++) {
					m[i][j] = (str.charAt(j) == '.' ? true : false);
				}
			}
			System.out.println(Math.max(compute(0), compute(1)));
		}
	}
}
