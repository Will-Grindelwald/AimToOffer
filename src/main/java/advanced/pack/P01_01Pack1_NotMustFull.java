package advanced.pack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// http://love-oriented.com/pack/P01.html
/**
 * 
 * 01背包: 有 n 件物品和一个容量为 m 的背包。第 i 件物品的体积消耗是 c[i]，效益是 p[i]。
 * 每种物品仅有一件，可以选择放或不放。求解将哪些物品装入背包可使价值总和最大。
 * 
 */
/**
 * 
 * 其状态转移方程便是： f[i][v]=max{f[i-1][v],f[i-1][v-c[i]]+w[i]}
 * 
 * 详细解释一下：“将前 i 件物品放入容量为 m 的背包中” 这个子问题，若只考虑第 i 件物品的策略（放或不放），那么就可以转化为一个只牵扯前 i-1
 * 件物品的问题。如果不放第 i 件物品，那么问题就转化为 “前 i-1 件物品放入容量为 m 的背包中”，价值为 f[i-1][m]；如果放第 i
 * 件物品，那么问题就转化为 “前 i-1 件物品放入剩下的容量为 m-c[i] 的背包中”，此时能获得的最大价值就是 f[i-1][m-c[i]]
 * 再加上通过放入第 i 件物品获得的价值 p[i]。
 *
 */
public class P01_01Pack1_NotMustFull {

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

	// 极限空间优化 + 常数级性能优化
	private static int compute2(int n, int m, Item[] items) {
		Arrays.sort(items, 1, n + 1, new Comparator<Item>() {
			public int compare(Item o1, Item o2) {
				return o2.cost - o1.cost;
			}
		});
		int[] dp = new int[m + 1];
		int sum = m;
		for (int i = 1; i <= n; i++) {
			sum -= items[i].cost;
		}
		for (int i = 1; i <= n; i++) {
			// 添加常数级性能优化（背包九讲上公式错了 ）
			int bound = Math.max(sum += items[i].cost, items[i].cost);
			for (int j = m; j >= bound; j--) {
				dp[j] = Math.max(dp[j], dp[j - items[i].cost] + items[i].value);
			}
		}
		return dp[m];
	}

	public static void main(String[] args) {
		// 4 5 1 2 6 9 10 10 12 18 -- 38
		// 5 12 3 5 2 6 4 4 4 3 5 3 -- 12
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
				}
				for (int i = 1; i <= n; i++) {
					items[i].value = in.nextInt();
				}
				// System.out.println(compute1(n, m, items));
				System.out.println(compute2(n, m, items));
			}
		}
	}

	private static class Item {
		int cost;
		int value;

		@Override
		public String toString() {
			return "Item [cost=" + cost + ", value=" + value + "]";
		}
	}
}
