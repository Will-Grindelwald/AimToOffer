package in.action.year2017.day0906.huawei;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

/**
 * 
 * 酒馆里有 m 个龙头可供顾客们接啤酒，每个龙头每秒的出酒量相等，都是 1。现有 n 名顾客准备接酒，他们初始的接酒顺序已经确定。将这些顾客按接酒顺序从 1
 * 到 n 编号，i 号顾客的接酒量为 w_i。接酒开始时，1 到 m 号顾客各占一个酒龙头，并同时打开龙头接酒。当其中某个顾客 j 完成其接酒量要求 wj
 * 后，下一名排队等候接酒的顾客 k 马上接替 j 顾客的位置开始接酒。这个换人的过程是瞬间完成的，且没有任何酒的浪费。即 j 顾客第 x
 * 秒结束时完成接酒，则 k 顾客第 x+1 秒立刻开始接酒。若当前接酒人数 n’不足 m，则只有 n’个龙头供酒，其它 m-n’个龙头关闭。 现在给出 n
 * 名顾客的接酒量，按照上述规则，问所有顾客都接完酒需要多少秒？
 * 
 * 输入描述: 输入包括两行, 第一行为以空格分割的两个数 n 和 m, 分别表示接酒的人数和酒龙头个数, 均为正整数。
 * 
 * 第二行 n 个整数 w_i(1 <= w_i <= 100) 表示每个顾客接酒量
 * 
 * 输出描述: 如果输入合法输出酒所需总时间(秒)。
 * 
 * 注意：最终交付的函数代码中不要向控制台打印输出任何无关信息。
 * 
 * 示例 1 输入 5 3 4 4 1 2 1
 * 
 * 输出 4
 * 
 */
public class T3 {
	public static void main(String[] args) {
		int n, m;
		int[] arr = null;
		try (Scanner in = new Scanner(System.in)) {
			n = in.nextInt();
			m = in.nextInt();
			arr = new int[n];
			for (int i = 0; i < n; i++)
				arr[i] = in.nextInt();
		}
		System.out.println(compute(n, m, arr));
	}

	public static int compute(int n, int m, int[] arr) {
		if (n <= 0 || m <= 0)
			return -1;
		if (m > n) {
			int max = arr[0];
			for (int j = 1; j < n; j++) {
				if (max < arr[j])
					max = arr[j];
			}
			return max;
		}
		Queue<Integer> queue = new PriorityQueue<>(m);
		for (int i = 0; i < m; i++) {
			queue.offer(arr[i]);
		}
		for (int i = m; i < n; i++) {
			int min = queue.poll();
			min += arr[i];
			queue.add(min);
		}
		for (int j = 1; j < m; j++) {
			queue.poll();
		}
		return queue.poll();
	}
}
