package chapter2;

import java.util.Arrays;

public class T3FindIn2DArray {

	// 法一: 暴力遍历 O(n^2)
	public boolean Find1(int target, int[][] array) {
		for (int[] i : array) {
			for (int j : i) {
				if (j == target)
					return true;
			}
		}
		return false;
	}

	// 法二: 对每行二分查找 O(n*log(n))
	public boolean Find2(int target, int[][] array) {
		for (int[] i : array) {
			int pos = Arrays.binarySearch(i, target);
			if (pos >= 0)
				return true;
		}
		return false;
	}

	// 法三: 沿对角线遍历，切分，递归 应该是 O(n^2)，但应该很快(用了分治策略)
	public boolean Find3(int target, int[][] array) {
		return recursion(target, array, 0, 0, array.length, array[0].length);
	}

	public boolean recursion(int target, int[][] array, int rowStart, int colStart, int rowEnd, int colEnd) {
		if (rowStart == rowEnd || colStart == colEnd)
			return false;
		int i = rowStart, j = colStart;
		while (i < rowEnd && j < colEnd) {
			if (array[i][j] == target)
				return true;
			if (array[i][j] > target)
				break;
			i++;
			j++;
		}
		if (i < rowEnd && j < colEnd) {// 右上块 & 左下块
			return recursion(target, array, rowStart, j, i, colEnd) || recursion(target, array, i, colStart, rowEnd, j);
		} else if (i == rowEnd && j == colEnd) {
			return false;
		} else if (i == rowEnd) { // 右上块
			return recursion(target, array, rowStart, j, i, colEnd);
		} else { // 左下块
			return recursion(target, array, i, colStart, rowEnd, j);
		}
	}

	// 法四: 最优解，从左下角开始，大了向上，小了向右 O(n)
	public boolean Find(int target, int[][] array) {
		int rowNum = array.length, colNum = array[0].length;
		int i = rowNum - 1, j = 0;
		while (i >= 0 && j < colNum) {
			if (array[i][j] == target) {
				return true;
			} else if (array[i][j] > target) {
				i--;
			} else if (array[i][j] < target) {
				j++;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		System.out.println(new T3FindIn2DArray().Find(7,
				new int[][] { { 1, 2, 8, 9 }, { 2, 4, 9, 12 }, { 4, 7, 10, 13 }, { 6, 8, 11, 15 } }));
	}
}
