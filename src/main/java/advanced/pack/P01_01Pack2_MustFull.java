package advanced.pack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * 我们看到的求最优解的背包问题题目中，事实上有两种不太相同的问法。有的题目要求 “恰好装满背包” 时的最优解，
 * 
 * 有的题目则并没有要求必须把背包装满。一种区别这两种问法的实现方法是在初始化的时候有所不同。
 * 
 * 如果是第一种问法，要求恰好装满背包，那么在初始化时除了 f[0] 为 0 其它 f[1..V] 均设为 -∞，
 * 
 * 这样就可以保证最终得到的 f[N] 是一种恰好装满背包的最优解。
 * 
 * 如果并没有要求必须把背包装满，而是只希望价格尽量大，初始化时应该将 f[0..V] 全部设为 0。
 * 
 * 为什么呢？可以这样理解：初始化的 f 数组事实上就是在没有任何物品可以放入背包时的合法状态。
 * 
 * 如果要求背包恰好装满，那么此时只有容量为 0 的背包可能被价值为 0 的 nothing“恰好装满”，
 * 
 * 其它容量的背包均没有合法的解，属于未定义的状态，它们的值就都应该是 -∞了。如果背包并非必须被装满，
 * 
 * 那么任何容量的背包都有一个合法解 “什么都不装”，这个解的价值为 0，所以初始时状态的值也就全部为 0 了。
 * 
 * 这个小技巧完全可以推广到其它类型的背包问题，后面也就不再对进行状态转移之前的初始化进行讲解。
 *
 */
public class P01_01Pack2_MustFull {

	// 一般空间优化
	private static int compute1(int n, int m, Item[] items) {
		// m 的背包, n 件物品, 耗费 c[], 效益 p[]
		int[] cur = new int[m + 1], next = new int[m + 1], tmp = null;
		for (int i = 1; i <= m; i++) { // 必装满则 next[0]=0, next[1...m] 都初始化为无穷小
			next[i] = Integer.MIN_VALUE;
		}
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
		for (int i = 1; i <= m; i++) { // 必装满则 dp[0]=0, dp[1...m] 都初始化为无穷小
			dp[i] = Integer.MIN_VALUE;
		}
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
		// 4 5 1 2 6 9 10 10 12 18 -- 无解
		// 5 12 3 5 2 6 4 4 4 3 5 3 -- 11
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
				int res;
				// if ((res = compute1(n, m, items)) < 0) {
				if ((res = compute2(n, m, items)) < 0) {
					System.out.println("无解");
				} else {
					System.out.println(res);
				}
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
