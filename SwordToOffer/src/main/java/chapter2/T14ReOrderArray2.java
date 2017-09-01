package chapter2;

import java.util.Arrays;

/**
 * 
 * 简化：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分， 所有的偶数位于位于数组的后半部分。
 * 
 * 时间复杂度 O（n）
 * 
 */
public class T14ReOrderArray2 {
	public void reOrderArray(int[] array) {
		if (array.length == 0 || array.length == 1)
			return;
		int even = 0, odd = array.length - 1;
		while (even < odd) {
			while (even < odd && (array[even] & 1) == 1)
				even++;
			while (even < odd && (array[odd] & 1) == 0)
				odd--;
			if (even < odd) {
				array[even] += array[odd];
				array[odd] = array[even] - array[odd];
				array[even] -= array[odd];
			}
		}
	}

	public static void main(String[] args) throws Exception {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		new T14ReOrderArray2().reOrderArray(a);
		System.out.println(Arrays.toString(a));
	}
}
