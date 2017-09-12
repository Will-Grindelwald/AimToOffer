package advanced.sort.o_n;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

// 桶排序可用于最大最小值相差较大的数据情况，比如 [9012,19702,39867,68957,83556,102456]。
// 但桶排序要求数据的分布必须均匀，否则可能导致数据都集中到一个桶中。比如 [104,150,123,132,20000], 这种数据会导致前 4 个数都集中到同一个桶中。导致桶排序失效。
// 1. 找出待排序数组中的最大值 max、最小值 min
// 2. 我们使用 动态数组 ArrayList 作为桶，桶里放的元素也用 ArrayList 存储。桶的数量为 (max-min)/arr.length+1
// 3. 遍历数组 arr，计算每个元素 arr[i] 放的桶
// 4. 每个桶各自排序
// 5. 遍历桶数组，把排序好的元素放进输出数组

// 首先定义桶，桶为一个数据容器，每个桶存储一个区间内的数。依然有一个待排序的整数序列 A，元素的最小值不小于 0，最大值不超过 K。假设我们有 M 个桶，第 i 个桶 Bucket[i] 存储 iK/M 至 (i+1)K/M 之间的数，有如下桶排序的一般方法：
// 扫描序列 A，根据每个元素的值所属的区间，放入指定的桶中 (顺序放置)。
// 对每个桶中的元素进行排序，什么排序算法都可以，例如快速排序。
// 依次收集每个桶中的元素，顺序放置到输出序列中。
// 对该算法简单分析，如果数据是期望平均分布的，则每个桶中的元素平均个数为 N/M。如果对每个桶中的元素排序使用的算法是快速排序，每次排序的时间复杂度为 O(N/Mlog(N/M))。则总的时间复杂度为 O(N)+O(M)O(N/Mlog(N/M)) = O(N+ Nlog(N/M)) = O(N + NlogN - NlogM)。当 M 接近于 N 是，桶排序的时间复杂度就可以近似认为是 O(N) 的。就是桶越多，时间效率就越高，而桶越多，空间却就越大，由此可见时间和空间是一个矛盾的两个方面。
// 桶中元素的顺序放入和顺序取出是有必要的，因为这样可以确定桶排序是一种稳定排序算法，配合基数排序是很好用的。
public class BucketSort {
	public static <T extends Pair> T[] bucketSort(T[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i].key);
			min = Math.min(min, arr[i].key);
		}

		// 初始化桶
		int bucketNum = arr.length; // 桶数
		List<LinkedList<T>> bucketArr = new ArrayList<>(bucketNum);
		for (int i = 0; i < bucketNum; i++) {
			bucketArr.add(new LinkedList<T>());
		}

		// 将每个元素放入桶
		int bucketLen = (max - min + 1) / bucketNum + 1;
		for (int i = 0; i < arr.length; i++) {
			if ((arr[i].key - min) / bucketLen == 7)
				System.out.println(arr[i].key);
			bucketArr.get((arr[i].key - min) / bucketLen).add(arr[i]);
		}

		// 对每个桶进行排序 约等于 o(n)
		for (int i = 0; i < bucketNum; i++) {
			Collections.sort(bucketArr.get(i), new Comparator<T>() {
				public int compare(T o1, T o2) {
					return o1.key - o2.key;
				}
			});
		}

		@SuppressWarnings("unchecked")
		T[] res = ((Object) arr.getClass() == (Object) Object[].class) ? (T[]) new Object[arr.length]
				: (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
		for (int i = 0, index = 0; i < bucketNum; i++) {
			while (!bucketArr.get(i).isEmpty()) {
				res[index++] = bucketArr.get(i).poll();
			}
		}
		return res;
	}

	public static void main(String[] args) {
		Pair[] arr = new Pair[7];
		arr[0] = new Pair(9012, 3);
		arr[1] = new Pair(19702, 3);
		arr[2] = new Pair(39867, 4);
		arr[3] = new Pair(68957, 5);
		arr[4] = new Pair(83556, 1);
		arr[5] = new Pair(102456, 1);
		arr[6] = new Pair(39867, 6);
		System.out.println(Arrays.toString(bucketSort(arr)));
	}

	private static class Pair {
		int key;
		int value;

		public Pair(int key, int value) {
			super();
			this.key = key;
			this.value = value;
		}

		@Override
		public String toString() {
			return "Pair [key=" + key + ", value=" + value + "]";
		}
	}
}
