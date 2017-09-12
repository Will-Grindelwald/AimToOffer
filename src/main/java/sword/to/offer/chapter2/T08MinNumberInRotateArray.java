package sword.to.offer.chapter2;

/**
 * 
 * 旋转数组的最小数字
 * 
 * 题目描述: 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。 例如数组
 * {3,4,5,1,2} 为 {1,2,3,4,5} 的一个旋转，该数组的最小值为 1。 NOTE：给出的所有元素都大于 0，若数组大小为 0，请返回 0。
 * 
 * 1. 遍历
 * 
 * 2. 二分
 * 
 */
public class T08MinNumberInRotateArray {

	public int minNumberInRotateArray1(int[] array) {
		int min = array[0];
		for (int i = 1; i < array.length; i++) {
			if (array[i] < min)
				min = array[i];
		}
		return min;
	}

	/*
	 * 只能和 high 比，和 low 比解决不了原序的情况
	 * 只是最简洁的代码了
	 */
	public int minNumberInRotateArray(int[] array) {
		int low = 0, high = array.length - 1, mid = 0;
		while (low < high) {
			mid = low + (high - low) / 2;
			if (array[mid] < array[high]) {
				high = mid;
			} else if (array[mid] > array[high]) {
				low = mid + 1;
			} else {
				high = high - 1; // 只能确定 high 可以被去掉，退化成顺序遍历
			}
		}
		return array[low];
	}

	public static void main(String[] args) {
		int[] a = { 3, 3, 1, 2, 3 };
		System.out.println(new T08MinNumberInRotateArray().minNumberInRotateArray(a));
	}
}
