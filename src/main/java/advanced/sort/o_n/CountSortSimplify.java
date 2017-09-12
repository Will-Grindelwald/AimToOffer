package advanced.sort.o_n;

import java.util.Arrays;

// 简化的计数排序 即是 桶排序的一种特殊情况，不稳定，甚至说只能用于纯 int[]
// 但 映射后计数 的思想 很有用
public class CountSortSimplify {
	public static int[] countSortsimplify(int[] arr) {
		if (arr == null || arr.length == 0) {
			return arr;
		}

		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;

		// 找出数组中的最大最小值
		for (int i = 0; i < arr.length; i++) {
			max = Math.max(max, arr[i]);
			min = Math.min(min, arr[i]);
		}

		int help[] = new int[max - min + 1];

		// 找出每个数字出现的次数
		for (int i = 0; i < arr.length; i++) {
			help[arr[i] - min]++;
		}

		int index = 0;
		for (int i = 0; i < help.length; i++) {
			while (help[i]-- > 0) {
				arr[index++] = i + min;
			}
		}

		return arr;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 5, 3, 7, 3, 5, 7, 7 };
		System.out.println(Arrays.toString(countSortsimplify(arr)));
	}
}
