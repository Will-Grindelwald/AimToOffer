package in.action.day812.wangyi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * 小易将 n 个棋子摆放在一张无限大的棋盘上。第 i 个棋子放在第 x[i] 行 y[i]
 * 列。同一个格子允许放置多个棋子。每一次操作小易可以把一个棋子拿起并将其移动到原格子的上、下、左、右的任意一个格子中。小易想知道要让棋盘上出现有一个格子中至少有
 * i(1 ≤ i ≤ n) 个棋子所需要的最少操作次数.
 * 
 * 输入描述: 输入包括三行, 第一行一个整数 n(1 ≤ n ≤ 50), 表示棋子的个数, 第二行为 n 个棋子的横坐标 x[i](1 ≤ x[i] ≤
 * 10^9), 第三行为 n 个棋子的纵坐标 y[i](1 ≤ y[i] ≤ 10^9)
 * 
 * 输出描述: 输出 n 个整数, 第 i 个表示棋盘上有一个格子至少有 i 个棋子所需要的操作数, 以空格分割。行末无空格
 * 
 * 如样例所示: 对于1个棋子: 不需要操作, 对于2个棋子: 将前两个棋子放在(1, 1)中, 对于3个棋子: 将前三个棋子放在(2, 1)中,
 * 对于4个棋子: 将所有棋子都放在(3, 1)中.
 * 
 * 输入例子 1: 4 1 2 4 9 1 1 1 1
 * 
 * 输出例子 1: 0 1 3 10
 *
 */
public class T6TODO {
	// 我没做出来
	public static void main(String[] args) {
		int n = 0;
		int[] x_i = null, y_i = null;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			x_i = new int[n];
			y_i = new int[n];
			for (int i = 0; i < n; i++) {
				x_i[i] = in.nextInt();
			}
			for (int i = 0; i < n; i++) {
				y_i[i] = in.nextInt();
			}
		}
		System.out.println();
	}

	/*
	 * 
	 * 链接：https://www.nowcoder.com/questionTerminal/
	 * 27f3672f17f94a289f3de86b69f8a25b 来源：牛客网
	 * 
	 * xy 轴其实是独立的，先只考虑 x 坐标，采用反证法，假设把 k 个棋子堆到 x0(x0 不为任意一个棋子坐标) 格子所用的步骤最少。
	 * 
	 * a 个棋子初始在 x0 的左边，b 个棋子初始在 x0 的右边. 左边到 x0 的总距离为 A, 右边到 x0 的总距离为 B.
	 * 
	 * 1. 如果 a>b, 那么对于最靠近 x0 左边的棋子坐标 x[a] 来说 (假设 x[a] 与 x0 的距离为 da, 那么以 x[a]
	 * 坐标为基准现在的总距离为 [(A+B)-da*a+da*b]<A+B，这 k 个棋子到 x[a] 的步数会更少；
	 * 
	 * 2. 同理对于 b>a 的情况，那么对于最靠近 x0 右边的棋子坐标 x[b] 的目标将比 x0 更优，
	 * 
	 * 3. 如果 a=b，x[a]、x0、x[b] 的步数是一样的。
	 * 
	 * 因此，最终汇聚棋子的 x 坐标只要在棋子初始的 x 个坐标中考虑
	 * 
	 */
	public static void main0(String[] args) {
		Scanner scan = new Scanner(System.in);
		final int n = scan.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		int i, j, k, l;
		for (i = 0; i < n; i++)
			x[i] = scan.nextInt();
		for (j = 0; j < n; j++)
			y[j] = scan.nextInt();

		long[] result = new long[n];
		result[0] = 0;
		// (Xj,Yk)到第i个棋子的距离，(Xi,Yi)与(Xj,Yk)为相同坐标时也要计算，此时他们的距离为0.
		long[][][] distance = new long[n][n][n];

		for (i = 0; i < n; i++) {
			for (j = 0; j < n; j++) {
				for (k = 0; k < n; k++) {
					distance[j][k][i] = Math.abs(x[i] - x[j]) + Math.abs(y[i] - y[k]);
				}
			}
		}
		// (Xj,Yk)到所有棋子距离从小到大排序,计算k个棋子最小距离的关键步骤，要理解为什么排序
		for (j = 0; j < n; j++) {
			for (k = 0; k < n; k++) {
				Arrays.sort(distance[j][k], 0, n);
			}

		}
		// k个棋子放置一起所需要的最小距离
		for (i = 1; i < n; i++) {
			long min = Long.MAX_VALUE;
			for (j = 0; j < n; j++) {
				for (k = 0; k < n; k++) {
					long curLength = 0;
					for (l = 0; l < i + 1; l++) {
						curLength += distance[j][k][l];
					}
					min = Math.min(curLength, min);
				}

			}
			result[i] = min;
		}
		StringBuilder str = new StringBuilder();
		for (i = 0; i < n; i++)
			str.append(result[i] + " ");
		str.deleteCharAt(str.length() - 1);
		System.out.print(str);
	}

	public static void main1(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int[] x = new int[n];
		int[] y = new int[n];
		for (int i = 0; i < n; i++)
			x[i] = in.nextInt();
		for (int i = 0; i < n; i++)
			y[i] = in.nextInt();
		int[][][] dist = new int[n][n][n];
		for (int i = 0; i < n; i++)
			for (int p = 0; p < n; p++)
				for (int q = 0; q < n; q++)
					dist[p][q][i] = Math.abs(x[p] - x[i]) + Math.abs(y[q] - y[i]);
		for (int p = 0; p < n; p++)
			for (int q = 0; q < n; q++)
				Arrays.sort(dist[p][q]);
		System.out.print("0");
		if (n > 1) {
			for (int i = 1; i < n; i++) {
				long min = Long.MAX_VALUE;
				for (int p = 0; p < n; p++) {
					for (int q = 0; q < n; q++) {
						long d = 0;
						for (int k = 0; k <= i; k++)
							d += dist[p][q][k];
						min = Math.min(min, d);
					}
				}
				System.out.print(" " + min);
			}
		}
	}

	public static void main2(String[] args) {
		/*
		 * 输入数据
		 **/
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		long[] x = new long[n];
		long[] y = new long[n];
		for (int i = 0; i < n; i++) {
			x[i] = in.nextLong();
		}
		for (int i = 0; i < n; i++) {
			y[i] = in.nextLong();
		}
		List<Long> list = new ArrayList<>();
		/*
		 * 根据讨论区的论证，最终汇聚的x、y坐标一定来源于输入的x、y坐标，故利用
		 * 循环遍历，计算各点距坐标（i,j）的移动步数，并存入list后排序（从小到大， 可用Collections。sort（list））。
		 * 计算z个棋子聚集在同一格子里的步数，就是累加list表里前z项和的最小值。
		 **/
		long[] min = new long[n]; // min[i-1]存的是使i个棋子汇聚在一个格子里的最少步数。
		for (int i = 0; i < n; i++)
			min[i] = Long.MAX_VALUE;
		long sum;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				list.clear();
				for (int k = 0; k < n; k++) {
					list.add(Math.abs(x[k] - x[i]) + Math.abs(y[k] - y[j]));
				}
				Collections.sort(list);
				for (int z = 0; z < n; z++) {
					sum = 0;
					for (int t = 0; t <= z; t++)
						sum += list.get(t);
					if (sum < min[z])
						min[z] = sum;
				}
			}
		}

		for (int i = 0; i < n - 1; i++) {
			System.out.print(min[i] + " ");
		}
		System.out.print(min[n - 1]);
	}
}
