package in.action.year2017.day0826.am.didi;

// 剑指offer 第 31 题
public class T1 {
	public int FindGreatestSumOfSubArray(int[] array) {
		if (array == null || array.length == 0) {
			return 0;
		}
		int sum = array[0], max = array[0];
		for (int i = 1; i < array.length; i++) {
			if (sum < 0) {
				sum = array[i];
			} else {
				sum += array[i];
			}
			if (max < sum) {
				max = sum;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		int[] arr = new int[] { 1, -2, 3, 10, -4, 7, 2, -5 };
		System.out.println(new T1().FindGreatestSumOfSubArray(arr));
	}
}
