package in.action.day0914.qunar;

import java.util.Scanner;

/**
 * 
 * 部分和问题： 给定整数 {a1,a2…an}，判断是否可以从中挑选出若干数，使他们的和恰好为 k
 * 
 * 输入 首先，n 和 k，n 表示数的个数，k 表示数的和。 接着一行 n 个数。 （1<=n<=20, 保证不超 int 范围）
 * 
 * 输出 如果和恰好可以为 k，输出 “YES”，并按从小到大输入顺序依次输出是由哪几个数的和组成，否则 “NO”
 * 
 * 样例输入 4 13 1 2 4 7 样例输出 YES 2 4 7
 * 
 */
public class T1 {
	private int[] nums;
	private int k;
	private boolean[] mark;

	public static void main(String[] args) {
		T1 o = new T1();
		try (Scanner in = new Scanner(System.in)) {
			o.nums = new int[in.nextInt()];
			o.mark = new boolean[o.nums.length];
			o.k = in.nextInt();
			for (int i = 0; i < o.nums.length; i++) {
				o.nums[i] = in.nextInt();
			}
		}
		boolean res = o.dfs(0, 0);
		if (res) {
			System.out.println("YES");
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < o.mark.length; i++) {
				if (o.mark[i]) {
					sb.append(o.nums[i]).append(' ');
				}
			}
			System.out.println(sb.substring(0, sb.length() - 1));
		} else {
			System.out.println("NO");
		}
	}

	public boolean dfs(int i, int sum) {
		if (i == nums.length)
			return sum == k;
		mark[i] = false;
		if (dfs(i + 1, sum)) {
			return true;
		}
		mark[i] = true;
		if (dfs(i + 1, sum + nums[i])) {
			return true;
		}
		return false;
	}
}
