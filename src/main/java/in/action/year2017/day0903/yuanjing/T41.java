package in.action.year2017.day0903.yuanjing;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 原题: 有依赖的背包问题 http://love-oriented.com/pack/P07.html
// https://www.nowcoder.com/questionTerminal/f9c6f980eeec43ef85be20755ddbeaf4
public class T41 {
	// 一般空间优化
	private static int compute1(int n, int m, Item[] items) {
		// m 的背包, n 件物品, 耗费 c[], 效益 p[]
		int[] cur = new int[m + 1], next = new int[m + 1], tmp = null;
		for (int i = 1; i <= n; i++) {
			tmp = cur;
			cur = next;
			next = tmp;
			for (int j = m; j >= items[i].cost; j--) {
				next[j] = Math.max(cur[j], cur[j - items[i].cost] + items[i].value);
			}
		}
		return next[m];
	}

	// 极限空间优化 + 常数优化
	private static int compute2(int n, int m, Item[] items) {
		Arrays.sort(items, 1, n + 1, new Comparator<Item>() {
			public int compare(Item o1, Item o2) {
				if (o1.type != o2.type) {
					return o1.type - o2.type;
				} else {
					return o2.cost - o1.cost;
				}
			}
		});
		int[] dp = new int[m + 1];
		int sum = m;
		for (int i = 1; i <= n; i++) {
			sum -= items[i].cost;
		}
		for (int i = 1; i <= n; i++) {
			// 添加常数优化（背包九讲上写错了 ）
			int bound = Math.max(sum += items[i].cost, items[i].cost);
			for (int j = m; j >= bound; j--) {
				dp[j] = Math.max(dp[j], dp[j - items[i].cost] + items[i].value);
			}
		}
		return dp[m];
	}

	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = 0, m = 0;
			Item[] items = null;
			while (in.hasNextInt()) {
				n = in.nextInt();
				m = in.nextInt();
				items = new Item[n + 1];
				for (int i = 0; i <= n; i++) {
					items[i] = new Item();
				}
				for (int i = 1; i <= n; i++) {
					items[i].cost = in.nextInt();
					items[i].value = items[i].cost * in.nextInt();
					items[i].type = in.nextInt();
				}
				// System.out.println(compute1(m, n, items));
				System.out.println(compute2(m, n, items));
			}
		}
	}

	private static class Item {
		int cost;
		int value;
		int type;

		@Override
		public String toString() {
			return "Item [cost=" + cost + ", value=" + value + ", type=" + type + "]";
		}

	}
}
