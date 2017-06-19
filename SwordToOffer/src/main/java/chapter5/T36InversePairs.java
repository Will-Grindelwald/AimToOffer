package chapter5;

import java.util.Arrays;

public class T36InversePairs {

	public int conutInversePairs(int[] array) {
		int[] sortArray = new int[array.length];
		sortArray[0] = array[0];
		int sum = 0, pos = 0;
		for (int i = 1; i < array.length; i++) {
			pos = -Arrays.binarySearch(sortArray, 0, i, array[i]) - 1;
			sum += i - pos;
			int j;
			for (j = i; j > pos; j--) {
				sortArray[j] = sortArray[j - 1];
			}
			sortArray[j] = array[i];
		}
		return sum % 1000000007;
	}

	public static void main(String[] args) {
		int[] testDate = { 7, 5, 6, 4 };
		System.out.println(new T36InversePairs().conutInversePairs(testDate));
	}
}
