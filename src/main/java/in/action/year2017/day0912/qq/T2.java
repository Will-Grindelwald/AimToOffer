package in.action.year2017.day0912.qq;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class T2 {
	public static void main(String[] args) {
		try (Scanner in = new Scanner(System.in)) {
			int n = in.nextInt();
			PriorityQueue<Integer> heap = new PriorityQueue<>(n, new Comparator<Integer>() {
				public int compare(Integer o1, Integer o2) {
					return o2 - o1;
				}
			});
			for (int i = 0; i < n; i++) {
				heap.add(in.nextInt());
			}
			System.out.println(compute(heap));
		}
	}

	private static int compute(PriorityQueue<Integer> heap) {
		int a, b;
		int sum = 0;
		while (heap.size() != 1) {
			a = heap.poll();
			b = heap.poll();
			sum += a * b;
			heap.add(a + b);
		}
		return sum;
	}
}
