package advanced.sort.o_n;

import java.lang.reflect.Array;
import java.util.Arrays;

// 完整的 计数排序：是稳定的
public class CountSort {
	public static <T extends Pair> T[] countSort(T[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}

		// 找出数组中的最大最小值
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i].key);
			min = Math.min(min, arr[i].key);
		}

		// 找出每个数字出现的次数
		int help[] = new int[max - min + 1];
		for (int i = 0; i < arr.length; i++) {
			help[arr[i].key - min]++;
		}

		// 计算每个数字应该在排序后数组中应该处于的位置
		for (int i = 1; i < help.length; i++) {
			help[i] += help[i - 1];
		}
		System.out.println(Arrays.toString(help));

		// 反向填充保证稳定性
		@SuppressWarnings("unchecked")
		T[] res = ((Object) arr.getClass() == (Object) Object[].class) ? (T[]) new Object[arr.length]
				: (T[]) Array.newInstance(arr.getClass().getComponentType(), arr.length);
		for (int i = arr.length - 1; i >= 0; i--) {
			res[--help[arr[i].key - min]] = arr[i];
		}
		return res;
	}

	public static void main(String[] args) {
		Pair[] arr = new Pair[7];
		arr[0] = new Pair(5, 3);
		arr[1] = new Pair(3, 3);
		arr[2] = new Pair(7, 4);
		arr[3] = new Pair(3, 5);
		arr[4] = new Pair(5, 1);
		arr[5] = new Pair(7, 1);
		arr[6] = new Pair(7, 6);
		System.out.println(Arrays.toString(countSort(arr)));
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
