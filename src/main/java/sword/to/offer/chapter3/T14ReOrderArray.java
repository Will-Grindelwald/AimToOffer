package sword.to.offer.chapter3;

import java.util.Arrays;

/**
 * 
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * 
 * 时间复杂度 O（n），空间复杂度 O（n）
 * 
 */
public class T14ReOrderArray {
	public void reOrderArray(int[] array) {
		if (array.length == 0 || array.length == 1)
			return;
		int evenCount = 0;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 0)
				evenCount++;
		}
		int[] evenArray = new int[evenCount];
		int odd = 0, even = 0;
		for (int i = 0; i < array.length; i++) {
			if ((array[i] & 1) == 0)
				evenArray[even++] = array[i];
			else
				array[odd++] = array[i];
		}
		System.arraycopy(evenArray, 0, array, array.length - evenCount, evenCount);
	}

	public static void main(String[] args) throws Exception {
		int[] a = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		new T14ReOrderArray().reOrderArray(a);
		System.out.println(Arrays.toString(a));
	}
}
