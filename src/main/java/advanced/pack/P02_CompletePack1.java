package advanced.pack;

import java.util.Scanner;

/**
 * 
 * 完全背包: 有n 种物品和一个容量为 m 的背包，每种物品都有无限件可用。第 i 种物品的费用是 c[i]，价值是 p[i]。
 * 求解将哪些物品装入背包可使这些物品的费用总和不超过背包容量，且价值总和最大。
 * 
 */
/**
 * 
 * O(VN) 的算法： 将完全背包转化为 01 背包
 * 
 * 你会发现，这个代码与 P01 的代码只有 v 的循环次序不同而已。为什么这样一改就可行呢？首先想想为什么 P01 中要按照 v=V..items[i].cost
 * 的序来循环。这是因为要保证第 i 次循环中的状态 f[i][v] 是由状态 f[i-1][v-c[i]]
 * 递推而来。换句话说，这正是为了保证每件物品只选一次，保证在考虑 “选入第 i 件物品” 这件策略时，依据的是一个绝无已经选入第 i 件物品的子结果
 * f[i-1][v-c[i]]。而现在完全背包的特点恰是每种物品可选无限件，所以在考虑 “加选一件第 i 种物品” 这种策略时，却正需要一个可能已选入第 i
 * 种物品的子结果 f[i][v-c[i]]，所以就可以并且必须采用 v=items[i].cost..V 的顺序循环。这就是这个简单的程序为何成立的道理。
 * 
 */
public class P02_CompletePack1 {

	private static int compute(int n, int m, Item[] items) {
		// 对于 用例 4 5 1 2 6 9 10 10 12 18
		// 6, 9 > m(=5), 第二重 for 根本没进行 == 过滤了 c > m 的物品
		int[] dp = new int[m + 1];
		for (int i = 1; i <= n; i++) {
			for (int j = items[i].cost; j <= m; j++) {
				dp[j] = Math.max(dp[j], dp[j - items[i].cost] + items[i].value);
			}
		}
		return dp[m];
	}

	public static void main(String[] args) {
		// 4 5 1 2 6 9 10 10 12 18 -- 50
		// 5 12 3 5 2 6 4 4 4 3 5 3 -- 18
		// 5 10 3 4 6 2 5 6 8 7 5 9 -- 25
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
				System.out.println(compute(n, m, items));
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
