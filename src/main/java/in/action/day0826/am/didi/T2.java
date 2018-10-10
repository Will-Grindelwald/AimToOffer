package in.action.day0826.am.didi;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * 
 * 输出 无序序列 中第 k 大的数，如：45 67 33 21 中第 2 大的数
 * 
 */
// 最优算法: BFPRT(见advanced.sort.BFPRT) o(n)，其次就是大根堆取 topK(若 K > length/2, 则小根堆
// top(length-k)) o(nlogk)
// 然而机试的测试用例不严格
public class T2 {
	public static void main(String[] args) {
		String[] numstr = null;
		int k = 0;
		try (Scanner in = new Scanner(System.in)) {
			numstr = in.nextLine().split(" ");
			k = in.nextInt();
		}

		PriorityQueue<Integer> heap = null;
		if (k <= numstr.length / 2) {
			heap = new PriorityQueue<>(new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
		} else {
			heap = new PriorityQueue<>();
			k = numstr.length - k + 1;
		}
		for (int i = 0; i < numstr.length; i++) {
			heap.add(Integer.valueOf(numstr[i]));
		}

		for (int i = 1; i < k; i++) {
			heap.poll();
		}
		System.out.println(heap.poll());
	}
}
