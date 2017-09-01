package day825.pm;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 
 * 小猴子下山，沿着下山的路有一排桃树，每棵树都结了一些桃子。小猴子想摘桃子，但是有一些条件需要遵守，
 * 小猴子只能沿着下山的方向走，不能回头，每颗树最多摘一个，而且一旦摘了一棵树的桃子，
 * 就不能再摘比这棵树结的桃子少的树上的桃子。那么小猴子最多能摘到几颗桃子呢？ 举例说明，比如有 5 棵树，分别结了 10，4，5，12，8
 * 颗桃子，那么小猴子最多能摘 3 颗桃子，来自于结了 4，5，8 颗桃子的桃树。
 *
 * https://www.nowcoder.com/discuss/33702
 *
 */
public class 模拟测试 {
	static int pick(int[] peaches) {
		LinkedList<Pair> list = new LinkedList<>();
		list.add(new Pair(0, 0));
		for (int i = 0; i < peaches.length; i++) {
			// 分支
			for (Pair pair : list) {
				if (pair.max <= peaches[i])
					list.add(new Pair(pair.num + 1, peaches[i]));
			}
			// 限界
			Collections.sort(list, new Comparator<Pair>() {
				public int compare(Pair o1, Pair o2) {
					if (o1.num > o2.num) {
						return 1;
					} else if (o1.num == o2.num) {
						if (o1.max > o2.max)
							return 1;
						else
							return 0;
					} else
						return 0;
				}
			});

		}
		for (Pair pair : list) {

		}
		return 0;
	}

	// 最长递增子序列
	static int pick2(int[] peaches) {
		int MaxP[] = new int[peaches.length];
		for (int j = 0; j < peaches.length; j++) {
			MaxP[j] = 1;
			for (int m = 0; m < j; m++) {
				if (MaxP[m] + 1 > MaxP[j] && peaches[j] > peaches[m]) {
					MaxP[j] = MaxP[m] + 1;
				}
			}
		}

		int maxPeach = 1;
		for (int k = 0; k < peaches.length; k++) {
			if (maxPeach < MaxP[k]) {
				maxPeach = MaxP[k];
			}
		}
		return maxPeach;
	}

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] peaches = new int[n];
		for (int i = 0; i < n; i++) {
			peaches[i] = in.nextInt();
		}
		System.out.println(pick(peaches));
		System.out.println(pick2(peaches));
	}

}

class Pair {
	int num = 0;
	int max = 0;

	public Pair(int num, int max) {
		super();
		this.num = num;
		this.max = max;
	}
}
