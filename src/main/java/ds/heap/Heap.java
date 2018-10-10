package ds.heap;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<T>> {

	// 堆选择排序
	public static void heapSort(int[] arr) {
		int len = arr.length;
		List<Integer> heap = initIntegerHeap(arr, len - 1); // 建 Integer 堆
		for (int i = 0; i < len - 1; i++) {
			swap(heap, 0, len - 1 - i); // 交换堆顶和最后一个元素 -> 将最大的移到堆的末尾
			adjustDown(heap, len - 2 - i, 0); // 向下调整
		}
		System.out.println(heap);
	}

	// 对 heap 数组从 0 到 lastIndex 建大顶堆
	public static List<Integer> initIntegerHeap(int[] arr, int lastIndex) {
		List<Integer> heap = new ArrayList<>(arr.length);
		for (int i = 0; i < arr.length; i++) {
			heap.add((Integer) arr[i]);
		}
		// 从 lastIndex 节点（最后一个节点）的父节点 ~ 0, 反复向下调整堆
		for (int i = (lastIndex - 1) / 2; i >= 0; i--) {
			adjustDown(heap, lastIndex, i);
		}
		return heap;
	}

	public static <T extends Comparable<T>> void adjustDown(List<T> heap, int lastIndex, int cur) {
		// 从 cur 向下调整
		int bigger;
		while (cur * 2 + 1 <= lastIndex) { // 如果当前 cur 节点的子节点存在
			bigger = 2 * cur + 1; // cur 节点的左子节点的索引
			// 如果 biggerIndex 小于 lastIndex，即 biggerIndex + 1 代表的 cur 节点的右子节点
			// 且右子节点的值较大
			if (bigger < lastIndex && heap.get(bigger).compareTo(heap.get(bigger + 1)) < 0) {
				bigger++;
			}
			// 如果 cur 节点的值小于其较大的子节点的值
			if (heap.get(cur).compareTo(heap.get(bigger)) < 0) {
				swap(heap, cur, bigger);
				cur = bigger;
			} else {
				break;
			}
		}
	}

	public static <T extends Comparable<T>> void adjustUp(List<T> heap, int cur) {
		int parent = (cur - 1) / 2;
		T temp = heap.get(cur);
		while (parent >= 0 && heap.get(parent).compareTo(temp) < 0) {
			heap.set(cur, heap.get(parent));
			cur = parent;
			parent = (cur - 1) / 2;
		}
		heap.set(cur, temp);
	}

	// 交换
	private static <T extends Comparable<T>> void swap(List<T> heap, int i, int j) {
		heap.set(j, heap.set(i, heap.get(j)));
	}

	public boolean add(T e) {
		return offer(e);
	}

	private boolean offer(T e) {
		return false;
	}

	public static void main(String[] args) {
		int arr[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62, 99, 98, 54, 56, 17, 18, 23, 34, 15, 35,
				25, 53, 51 };
		heapSort(arr);
	}

	public static boolean juage(int[] arr) {
		for (int i = 1; i < arr.length; i++) {
			if (arr[i] < arr[i - 1]) {
				return false;
			}
		}
		return true;
	}
}
