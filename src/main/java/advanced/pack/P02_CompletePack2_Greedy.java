package advanced.pack;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 
 * 用贪心法解，性能更高
 * 
 * 但极端情况下得不到最优解：2 5 2 3 10 11 -- 最优解为：21(10+11)，贪心法解为 20(10+10)
 * 
 */
public class P02_CompletePack2_Greedy {

	private static int compute(int n, int m, Item[] items) {
		Arrays.sort(items, 1, n + 1, new Comparator<Item>() {
			public int compare(Item o1, Item o2) {
				if (o2.pricePerformanceRatio == o1.pricePerformanceRatio) {
					return o1.cost - o2.cost;
				} else {
					return (o2.pricePerformanceRatio - o1.pricePerformanceRatio) > 0 ? 1 : -1;
				}
			}
		});
		int res = 0;
		for (int i = 1; i <= n; i++) {
			if (m == 0) {
				break;
			}
			while (m >= items[i].cost) {
				res += items[i].value;
				m -= items[i].cost;
			}
		}
		return res;
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
				// 输入形式一
				// 4 5 1 10 2 10 6 12 9 18 -- 50
				// 5 12 3 4 5 4 2 3 6 5 4 3 -- 18
				// 5 10 3 6 4 8 6 7 2 5 5 9 -- 25
				// int tmp;
				// for (int i = 1; i <= n; i++) {
				// tmp = in.nextInt();
				// if (tmp > m) {
				// // 过滤掉 cost > m 的物品
				// n--;
				// in.nextInt();
				// continue;
				// }
				// items[i].cost = tmp;
				// items[i].value = in.nextInt();
				// items[i].pricePerformanceRatio = (double) items[i].value /
				// items[i].cost;
				// }

				// 输入形式二
				// 4 5 1 2 6 9 10 10 12 18 -- 50
				// 5 12 3 5 2 6 4 4 4 3 5 3 -- 18
				// 5 10 3 4 6 2 5 6 8 7 5 9 -- 25
				for (int i = 1; i <= n; i++) {
					items[i].cost = in.nextInt();
				}
				for (int i = 1; i <= n; i++) {
					items[i].value = in.nextInt();
				}
				for (int i = 1; i <= n; i++) {
					items[i].pricePerformanceRatio = (double) items[i].value / items[i].cost;
				}
				for (int i = 1, j = 1; i <= n; i++) {
					if (items[i].cost <= m) {
						items[j++] = items[i];
					} else {
						n--;
					}
				}
				System.out.println(compute(n, m, items));
			}
		}
	}

	private static class Item {
		int cost;
		int value;
		double pricePerformanceRatio;

		@Override
		public String toString() {
			return "Item [cost=" + cost + ", value=" + value + ", pricePerformanceRatio=" + pricePerformanceRatio + "]";
		}
	}
}
